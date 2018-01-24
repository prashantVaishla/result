package result;

import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import business.PurchaseData;
import business.User;
import business.UserTO;
import dataaccesslayer.PurchaseDataImpl;
import dataaccesslayer.UserDAOImpl;

@Controller
public class EmpController {
	@RequestMapping("/")
	public String home() {
		return "Login.html";
	}

	@RequestMapping(value = "/empformNew", method = RequestMethod.GET)
	public String redirect() {
		// return "/views/employeeNew.html";
		return "empformNew.html";
	}

	@RequestMapping(value = "/authuser", method = RequestMethod.POST)
	public String redirect2(@RequestParam("username") String username, @RequestParam("pwd") String pwd)
			throws IOException {
		System.out.println("auth user" + username);
		UserDAOImpl userObj = new UserDAOImpl();
		List<User> userById = userObj.getUserById(username);
		if (!userById.isEmpty()) {
			User user = userById.get(0);
			if (user.getPwd().equals(pwd))
				return "homePage.html";
			// return "redirect:/jsonData";
			else
				return "error.html";
		} else
			return "error.html";

	}
	
	@RequestMapping(value = "/jsonData", method = RequestMethod.GET)
	public @ResponseBody List<PurchaseData> getPurchaseData() {
		PurchaseDataImpl objPurchase = new PurchaseDataImpl();
		return objPurchase.getAllPurchase();
	}

	/*
	 * @RequestMapping(value="/addSupplierPurchase",method=RequestMethod.GET)
	 * public void addsupplierDetails(@RequestParam("itemId") String
	 * itemId,@RequestParam("itemName") String itemName,
	 * 
	 * @RequestParam("supplierId") String
	 * supplierId,@RequestParam("supplierName") String
	 * supplierName,@RequestParam("qty") float qty){
	 * System.out.println("addSupplierPurchase"+ itemName); }
	 */
	@RequestMapping(value = "/addSupplierPurchase", method = RequestMethod.POST)
	public void addsupplierDetails(@RequestBody PurchaseData data) {
		System.out.println();
	}
}
