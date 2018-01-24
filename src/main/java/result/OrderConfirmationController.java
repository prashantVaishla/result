package result;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import business.ConfirmationTO;
import business.OrderConfirmation;
import business.OrderSummary;
import business.ProductListContainer;
import service.OrderConfirmationServiceImpl;

@Controller
public class OrderConfirmationController {
	String message = "Please submit to confirm your order";

	@Autowired
	OrderConfirmationServiceImpl orderConfirmationService;

	/*@RequestMapping(value = "/orderConfirmation", method = RequestMethod.GET)
	public ModelAndView orderConfirmation(
			 BindingResult bindingResult, @ModelAttribute OrderConfirmation orderConfirmation, ModelMap modelMap,
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

		System.out.println("*** Session data ***");
		Enumeration<String> e = httpSession.getAttributeNames();
		while (e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s);
			System.out.println("**" + httpSession.getAttribute(s));
		}
		modelMap.addAttribute("welcomeMessage", message);
		return new ModelAndView("orderConfirmation.jsp", "command", orderConfirmation);
	}*/

	@RequestMapping(value = "/confirmOrder", method = RequestMethod.POST)
	public ModelAndView confirmOrder(@ModelAttribute OrderConfirmation orderConfirmation, BindingResult bindingResult, ModelMap modelMap,
			HttpSession httpSession, HttpServletRequest httpServletRequest) throws IOException {
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
		 
		  System.out.println("*** Session data ***");
		  Enumeration<String> e = httpSession.getAttributeNames();
		  while (e.hasMoreElements()){
			String s = e.nextElement();
			System.out.println(s);
			System.out.println("**" + httpSession.getAttribute(s));}
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView = new ModelAndView("orderConfirmation.jsp", "command", orderConfirmation);
		} else {
			try {
				orderConfirmationService.saveOrder(orderConfirmation);
				modelAndView.setViewName("orderSummary.jsp");
				modelAndView.addObject("orderConfirmation", orderConfirmation);
				//modelAndView = new ModelAndView("orderSummary.jsp", "command", orderConfirmation);
				// and also if redirecting to same page
			} catch (Exception e1) {
				e1.printStackTrace();
				modelAndView = new ModelAndView("orderConfirmation.jsp", "command", orderConfirmation);
				modelAndView.addObject("message", e1.getMessage());
			}
		}
		return modelAndView;

	}
}
