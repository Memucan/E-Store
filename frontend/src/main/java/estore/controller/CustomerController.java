package estore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import estore.model.Customer;
import estore.dao.CustomerDao;
@Controller
public class CustomerController {
	@Autowired
	private CustomerDao customerDao;
	@RequestMapping("/all/registrationform")
	public ModelAndView getRegistrationForm() {
		return new ModelAndView("registrationform","customer",new Customer());
}
	@RequestMapping("/all/registercustomer")
	public String registerCustomer(@Valid @ModelAttribute Customer customer,BindingResult result,Model model) {
		if(result.hasErrors())//hibernate validation
			return "registrationform";
		
		if(!customerDao.isUsernameValid(customer.getUser().getUsername())){//duplicate username
			model.addAttribute("duplicateUsername","Username already exists.. please enter different username");
			return "registrationform";
		}
		if(!customerDao.isEmailValid(customer.getEmail())){//duplicate email address
			model.addAttribute("duplicateEmail","Email Id already exists.. Please enter different email address");
			return "registrationform";
		}
		customerDao.registerCustomer(customer);
		return"login";
}
}