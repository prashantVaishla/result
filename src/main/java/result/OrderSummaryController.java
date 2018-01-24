package result;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import business.ConfirmationTO;
import business.OrderConfirmation;

@Controller
public class OrderSummaryController {

	/*@RequestMapping(value = "/orderSummary", method = RequestMethod.GET)
	public ModelAndView orderConfirmation(@ModelAttribute OrderConfirmation orderConfirmation, ModelMap modelMap,
			HttpSession httpSession, HttpServletRequest httpServletRequest) {
		System.out.println("--- Model data ---");
		for (Object modelKey : modelMap.keySet()) {
			Object modelValue = modelMap.get(modelKey);
			System.out.println(modelKey + " -- " + modelValue);
		}

		System.out.println("=== Request data ===");
		java.util.Enumeration<String> reqEnum = httpServletRequest.getAttributeNames();
		while (reqEnum.hasMoreElements()) {
			String s = reqEnum.nextElement();
			System.out.println(s);
			System.out.println("==" + httpServletRequest.getAttribute(s));
		}
		return new ModelAndView("orderSummary.jsp", "command", new ConfirmationTO());
	}*/

	@RequestMapping(value = "/downloadPDF", method = RequestMethod.POST)
	ModelAndView generatePdf(@ModelAttribute OrderConfirmation orderConfirmation, HttpServletRequest httpServletRequest,
			HttpServletResponse response, ModelMap modelMap) throws Exception {
		System.out.println("--- Model data ---");
		for (Object modelKey : modelMap.keySet()) {
			Object modelValue = modelMap.get(modelKey);
			System.out.println(modelKey + " -- " + modelValue);
		}

		System.out.println("=== Request data ===");
		java.util.Enumeration<String> reqEnum = httpServletRequest.getAttributeNames();
		while (reqEnum.hasMoreElements()) {
			String s = reqEnum.nextElement();
			System.out.println(s);
			System.out.println("==" + httpServletRequest.getAttribute(s));
		}
		List<ConfirmationTO> listConfirmationTOs = new ArrayList<ConfirmationTO>();
		listConfirmationTOs
				.add(new ConfirmationTO("Spring in Action", "Craig Walls", "1935182358", "June 29th 2011", 31.98F));
		listConfirmationTOs.add(new ConfirmationTO("Spring in Practice", "Willie Wheeler, Joshua White", "1935182056",
				"May 16th 2013", 31.95F));
		listConfirmationTOs.add(
				new ConfirmationTO("Pro Spring 3", "Clarence Ho, Rob Harrop", "1430241071", "April 18th 2012", 31.85F));
		listConfirmationTOs.add(new ConfirmationTO("Spring Integration in Action", "Mark Fisher", "1935182439",
				"September 26th 2012", 28.73F));
		System.out.println("Calling generatePdf()...");
		// return a view which will be resolved by an excel view resolver
		return new ModelAndView("pdfView", "listConfirmationTOs", orderConfirmation.getPersonListContainer().getProductList());
	}
}
