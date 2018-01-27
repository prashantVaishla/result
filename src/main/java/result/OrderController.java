package result;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import business.OrderConfirmation;
import business.OrderSummary;
import business.Product;
import business.ProductListContainer;

@Controller
public class OrderController {

	@RequestMapping("/order")
	public String index(ModelMap map, HttpSession session, HttpServletRequest request,
			@RequestParam(value = "f", required = false) String flush,
			@RequestParam(value = "message", required = false) String message) {

		if (flush != null)
			session.setAttribute("personListContainer", getDummyPersonListContainer());
		if (session.getAttribute("personListContainer") == null)
			session.setAttribute("personListContainer", getDummyPersonListContainer());
		map.addAttribute("personListContainer", (ProductListContainer) session.getAttribute("personListContainer"));
		if (message != null)
			map.addAttribute("message", message);
		map.addAttribute("cp", request.getContextPath());

		return "order.jsp";
	}

	@RequestMapping(value = "/editpersonlistcontainer", method = RequestMethod.POST)
	public ModelAndView editpersonListContainer(@ModelAttribute ProductListContainer personListContainer,
			BindingResult bindingResult, ModelMap modelMap, HttpServletRequest httpServletRequest,
			HttpSession httpSession, final RedirectAttributes redirectAttributes) {
		/*System.out.println("--- Model data ---");
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
		}*/
		int qty = 0;
		double price = 0.0;
		double total = 0;
		ModelAndView andView = new  ModelAndView();
		for (Product p : personListContainer.getProductList()) {
			if (p.getQuantity() > p.getMaxQuantity()) {
				andView.setViewName("order.jsp");
				andView.addObject("personListContainer", personListContainer);
				andView.addObject("errorMessage", p.getProductName() + "  exceeded inventory size");
				return andView;
			}
				
			total += p.getPrice() * p.getQuantity();
			System.out.println("Name: " + p.getProductName());
			// System.out.println("Age: " + p.getAge());
		}
		OrderConfirmation confirmation = new OrderConfirmation(personListContainer, total);
		httpSession.setAttribute("personListContainer", personListContainer);
		//redirectAttributes.addFlashAttribute("orderConfirmation", confirmation);
		
		andView.setViewName("orderConfirmation.jsp");
		andView.addObject("orderConfirmation", confirmation);
		return andView;
		/*return "redirect:orderConfirmation";*/
	
		/*
		 * "redirect:orderConfirmation/?message=Form Submitted Ok. Number of rows is: ["
		 * + personListContainer.getProductList().size() + "]"
		 */
	}

	private ProductListContainer getDummyPersonListContainer() {
		List<Product> personList = new ArrayList<Product>();
		for (int i = 0; i < 1; i++) {
			personList.add(new Product("Person Name [" + i + "]", String.valueOf(i), i, i, i));
		}
		return new ProductListContainer(personList);
	}
}
