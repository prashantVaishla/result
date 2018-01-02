package result;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import business.UserTO;
import service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView redirect() {
		// return "/views/employeeNew.html";
		return new ModelAndView("login.jsp", "command", new UserTO());
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView redirect3(@ModelAttribute("command") UserTO userTO, BindingResult bindingResult,
			ModelMap modelMap) throws IOException {
		System.out.println("auth user" + userTO.getUsername());
		ModelAndView modelAndView = new ModelAndView();
		// check for validations which I dont have as of now
		if (bindingResult.hasErrors()) {
			modelAndView = new ModelAndView("login.jsp", "command", userTO);
		} else {	
			try {
				loginService.authenticate(userTO);
				modelAndView = new ModelAndView("login.jsp", "command", new UserTO());
				modelAndView.addObject("userName", userTO.getUsername());
				//useful when redirecting to another page and have to transfer this information to other page
				modelAndView.addObject("message", "yaeee");
				// and also if redirecting to same page
			} catch (Exception e) {
				e.printStackTrace();
				modelAndView = new ModelAndView("login.jsp", "command", userTO);
				modelAndView.addObject("message", e.getMessage());
			}
		}
		return modelAndView;

	}

}
