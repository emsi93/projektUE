package system.exchange.curriencies.mvc.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
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

import system.exchange.curriencies.modules.ExchangeRate;
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
	public ModelAndView registerUserGet(UserModel userFormModelOrNull, Integer messageCodeOrNull)
	{
		ModelAndView modelAndView = new ModelAndView("register");
		if(userFormModelOrNull==null)
		{
			userFormModelOrNull = new UserModel(null,null,null,null,null,null,null);
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
	public ModelAndView registerUserPost(@ModelAttribute("userForm") @Validated UserModel userFormModel,
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
	public ModelAndView menu() throws IOException {
		ModelAndView modelAndView = new ModelAndView("menu");
		
		return modelAndView;
	}
	@RequestMapping(value="/menu", method = RequestMethod.GET)
	public ModelAndView addAcountGet(NewBankAccountModel newBankAccountModelOrNull, Integer messageCodeOrNull)
	{
		ModelAndView modelAndView = new ModelAndView("menu");
		List<String> carrienciesISO = dao.getListCurriencies();
		carrienciesISO.add("");
		Collections.sort(carrienciesISO);
		modelAndView.addObject("carrienciesISO",carrienciesISO);
		List<String> countries = dao.getListCountries();
		countries.add("");
		Collections.sort(countries);
		modelAndView.addObject("countries",countries);
		List<BankAccountModel> bankAccountsList = dao.getListBankAccounts(2);
		modelAndView.addObject("bankAccountsList",bankAccountsList);
		JSONArray jsonArray = new JSONArray();
		for(int i=0;i<bankAccountsList.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("numberAccount", bankAccountsList.get(i).getNumberAccount());
			jsonObject.put("country", bankAccountsList.get(i).getCountry());
			jsonObject.put("carrency", bankAccountsList.get(i).getCarrency());
			jsonArray.put(jsonObject);
		}
		modelAndView.addObject("bankAccountsJSON",jsonArray);	
		
		if(newBankAccountModelOrNull == null)
		{
			newBankAccountModelOrNull = new NewBankAccountModel(null,null,null);
		}
		
		if (messageCodeOrNull != null) {
			switch (messageCodeOrNull) {
			case 1:
				modelAndView.addObject("wiadomosc", "èle wype≥ni≥eú pola");
				break;
			case 2:
				modelAndView.addObject("wiadomosc", "Dodanie konta przebieg≥o pomyúlnie");
				break;
			default:
				break;
			}
		}
		modelAndView.addObject("bankAccountForm", newBankAccountModelOrNull);
		return modelAndView;
	}
	@RequestMapping(value="/menu", method = RequestMethod.POST)
	public ModelAndView addAcountPost(@ModelAttribute("bankAccountForm") @Validated NewBankAccountModel newBankAccountModel,
			BindingResult result)
	{
		if(result.hasErrors())
			return addAcountGet(newBankAccountModel,1);
		else
		{
			dao.addBankAccount(newBankAccountModel);
			return addAcountGet(newBankAccountModel,2);
		}
			
	}
}
