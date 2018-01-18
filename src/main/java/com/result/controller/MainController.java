package com.result.controller;

import java.io.IOException;









import java.util.List;











import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.result.businessLayer.PurchaseData;
import com.result.businessLayer.SupplierDetails;
import com.result.businessLayer.user.User;
import com.result.dataaccesslayer.purchase.PurchaseDataImpl;
import com.result.dataaccesslayer.supplier.SupplierImpl;
import com.result.dataaccesslayer.user.UserDAOImpl;
@Controller
public class MainController {
	@RequestMapping("/")
	public String home(){
		return "Login.html";
	} 

	@RequestMapping(value = "/authuser", method = RequestMethod.POST)
	   public String  redirect2(@RequestParam("username") String username,@RequestParam("pwd") String pwd) throws IOException {
		System.out.println("auth user"+username);
		UserDAOImpl userObj=new UserDAOImpl();
		List<User> userById = userObj.getUserById(username);
		if(!userById.isEmpty()){
			User user = userById.get(0);
			if(user.getPwd().equals(pwd))
		      return "homePage.html";
			else
				return "error.html";
		}else
			return "error.html";
		
	   }
	
	@RequestMapping(value="/jsonData",method = RequestMethod.GET)
	public @ResponseBody List<PurchaseData> getPurchaseData(){
		PurchaseDataImpl objPurchase=new PurchaseDataImpl();
		return objPurchase.getAllPurchase();
	}
	
	@RequestMapping(value="/jsonSupplierDetails",method = RequestMethod.GET)
	public @ResponseBody List<SupplierDetails> getSupplierDetails(){
		SupplierImpl objSupplier=new SupplierImpl();
		return objSupplier.getSuppliers();
	}
	
	@RequestMapping(value="/addSupplierPurchase",method=RequestMethod.POST)
	@ResponseBody
	public String addsupplierDetails(@RequestBody PurchaseData data){
		System.out.println("INSIDE ADD SUPPLIER!!!!!!!!!!!");
		System.out.println(data);
		System.out.println(data.getItemName());
		PurchaseDataImpl purchaseData=new PurchaseDataImpl();
		purchaseData.savePurchaseData(data);
		return "done";
	}
	@RequestMapping(value="deleteInventory",method=RequestMethod.POST)
	@ResponseBody
	public String deletePurchaseInventory(@RequestBody PurchaseData data){
		PurchaseDataImpl purchaseData=new PurchaseDataImpl();
		if(purchaseData.deletePurchaseData(data.getItemID())>0)
		return "row deleted";
		else
			return"no data found";
	}
}
