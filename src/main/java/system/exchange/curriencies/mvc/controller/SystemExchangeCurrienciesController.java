package system.exchange.curriencies.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import system.exchange.curriencies.mvc.dao.ExchangeCurrienciesDAOInterface;
import system.exchange.curriencies.mvc.model.UserFormModel;
import system.exchange.curriencies.mvc.validator.UserFormValidator;

@Controller
public class SystemExchangeCurrienciesController {

	@Autowired
	private ExchangeCurrienciesDAOInterface dao;

	@Autowired
	private UserFormValidator userFormValidator;

	@InitBinder("userForm")
	protected void initShipperFormValidator(WebDataBinder binder) {
		binder.setValidator(userFormValidator);
	}

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView("register");
		return modelAndView;
	}
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView registerUserGet(UserFormModel userFormModelOrNull, Integer messageCodeOrNull)
	{
		ModelAndView modelAndView = new ModelAndView("register");
		if(userFormModelOrNull==null)
		{
			userFormModelOrNull = new UserFormModel(null,null,null,null,null,null,null);
		}
		if (messageCodeOrNull != null) {
			switch (messageCodeOrNull) {
			case 1:
				modelAndView.addObject("wiadomosc", "èle wype≥ni≥eú pola");
				break;
			case 2:
				modelAndView.addObject("wiadomosc", "Rejestracja przebieg≥a pomyúlnie");
				break;
			default:
				break;
			}
		}
		modelAndView.addObject("userForm", userFormModelOrNull);
		return modelAndView;
	}
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public ModelAndView registerUserPost(@ModelAttribute("userForm") @Validated UserFormModel userFormModel,
			BindingResult result)
	{
		if(result.hasErrors())
		{
			return registerUserGet(userFormModel,1);
		}	
		else
		{
			dao.addUser(userFormModel);
			return registerUserGet(userFormModel,2);
		}
			
	}
	@RequestMapping("/about")
	public ModelAndView about() {
		ModelAndView modelAndView = new ModelAndView("about");
		return modelAndView;
	}
	
	@RequestMapping("/menu")
	public ModelAndView menu() {
		ModelAndView modelAndView = new ModelAndView("menu");
		return modelAndView;
	}
	
}
