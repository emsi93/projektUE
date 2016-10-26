package system.exchange.curriencies.mvc.controller;

import java.util.Collections;
import java.util.List;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import system.exchange.curriencies.mvc.model.BankAccountModel;
import system.exchange.curriencies.mvc.model.NewBankAccountModel;
import system.exchange.curriencies.mvc.model.UserModel;
import system.exchange.curriencies.mvc.validator.BankAccountFormValidator;
import system.exchange.curriencies.mvc.validator.UserFormValidator;

@Controller
public class SystemExchangeCurrienciesController {

	@Autowired
	private ExchangeCurrienciesDAOInterface dao;

	@Autowired
	private UserFormValidator userFormValidator;

	@InitBinder("userForm")
	protected void initUserFormValidator(WebDataBinder binder) {
		binder.setValidator(userFormValidator);
	}

	@Autowired
	private BankAccountFormValidator bankAccountFormValidator;

	@InitBinder("bankAccountForm")
	protected void initBankAccountFormValidator(WebDataBinder binder) {
		binder.setValidator(bankAccountFormValidator);
	}

	@RequestMapping(value={"/","index"})
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerUserGet(UserModel userFormModelOrNull,
			Integer messageCodeOrNull) {
		ModelAndView modelAndView = new ModelAndView("register");
		if (userFormModelOrNull == null) {
			userFormModelOrNull = new UserModel(null, null, null, null, null,
					null, null);
		}
		if (messageCodeOrNull != null) {
			switch (messageCodeOrNull) {
			case 1:
				modelAndView.addObject("wiadomosc", "èle wype≥ni≥eú pola");
				break;
			case 2:
				modelAndView.addObject("wiadomosc",
						"Rejestracja przebieg≥a pomyúlnie");
				break;
			default:
				break;
			}
		}
		modelAndView.addObject("userForm", userFormModelOrNull);
		return modelAndView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUserPost(
			@ModelAttribute("userForm") @Validated UserModel userFormModel,
			BindingResult result) {
		if (result.hasErrors()) {
			return registerUserGet(userFormModel, 1);
		} else {
			dao.addUser(userFormModel);
			return registerUserGet(userFormModel, 2);
		}

	}


	@RequestMapping("/errorLogin")
	public ModelAndView errorLogin() {
		ModelAndView modelAndView = new ModelAndView("errorLogin");
		return modelAndView;
	}

	@RequestMapping("/listAccounts")
	public ModelAndView listAccounts() {
		ModelAndView modelAndView = new ModelAndView("listAccounts");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		int loginID = dao.getLoginIDByLogin(auth.getName());
		List<BankAccountModel> bankAccountModel = dao.getListBankAccounts(loginID);
		modelAndView.addObject("bankAccountModels",bankAccountModel);
		return modelAndView;
	}
	
	@RequestMapping("/menu2")
	public ModelAndView menu() {
		ModelAndView modelAndView = new ModelAndView("menu2");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    modelAndView.addObject("username", auth.getName());
	    Object[] role = auth.getAuthorities().toArray();
	    modelAndView.addObject("role",role[0].toString());
		return modelAndView;
	}

	@RequestMapping(value = "/newAccount", method = RequestMethod.GET)
	public ModelAndView addAcountGet(
			NewBankAccountModel newBankAccountModelOrNull,
			Integer messageCodeOrNull) {
		ModelAndView modelAndView = new ModelAndView("newAccount");
		List<String> carrienciesISO = dao.getListCurriencies();
		carrienciesISO.add("");
		Collections.sort(carrienciesISO);
		modelAndView.addObject("carrienciesISO", carrienciesISO);
		List<String> countries = dao.getListCountries();
		countries.add("");
		Collections.sort(countries);
		modelAndView.addObject("countries", countries);


		if (newBankAccountModelOrNull == null) {
			newBankAccountModelOrNull = new NewBankAccountModel(null, null,
					null);
		}

		if (messageCodeOrNull != null) {
			switch (messageCodeOrNull) {
			case 1:
				modelAndView.addObject("wiadomosc", "èle wype≥ni≥eú pola");
				break;
			case 2:
				modelAndView.addObject("wiadomosc",
						"Dodanie konta przebieg≥o pomyúlnie");
				break;
			default:
				break;
			}
		}
		modelAndView.addObject("bankAccountForm", newBankAccountModelOrNull);
		return modelAndView;
	}

	@RequestMapping(value = "/newAccount", method = RequestMethod.POST)
	public ModelAndView addAcountPost(
			@ModelAttribute("bankAccountForm") @Validated NewBankAccountModel newBankAccountModel,
			BindingResult result) {
		if (result.hasErrors())
			return addAcountGet(newBankAccountModel, 1);
		else {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			int userID = dao.getLoginIDByLogin(auth.getName());
			dao.addBankAccount(newBankAccountModel, userID);
			return addAcountGet(newBankAccountModel, 2);
		}

	}
}
