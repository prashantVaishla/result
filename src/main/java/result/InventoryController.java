package result;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import business.Product;
import dataaccesslayer.InventoryDAO;

@Controller
public class InventoryController {
	@Autowired
	InventoryDAO inventoryDAO;

	@RequestMapping("/getProductNames")
	public ResponseEntity<List<String>> getProductNames(@RequestParam("term") String query) {
		return new ResponseEntity<List<String>>(inventoryDAO.getProductNames(query), HttpStatus.OK);

	}

	@RequestMapping("/getProductDetails")
	public ResponseEntity<List<Product>> getProductDetails(
			@RequestParam(value = "term") String query) {
		return new ResponseEntity<List<Product>>(inventoryDAO.getProductDetails(query), HttpStatus.OK);

	}

}
