package com.example.controller;




import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Admin;
import com.example.model.ExchangeValue;
import com.example.model.User;
import com.example.repository.ExchangeValueRepository;
import com.example.repository.UserRepository;
import com.example.service.ListService;
 

@Controller   
public class CurrencyExchangecontroller 
{  

 
@Autowired  
private ExchangeValueRepository repository; 
@Autowired
private ListService userService;









//@GetMapping("/currency-exchange/airport/{airport}/from/{from}/to/{to}")       //where {from} and {to} are path variable  
//public ExchangeValue retrieveExchangeValue(@PathVariable String airport, @PathVariable String from, @PathVariable String to)   //from map to USD and to map to INR  
//{         
//ExchangeValue exchangeValue = repository.findByAirportAndFromAndTo(airport,from,to);  
//setting the port  
//return exchangeValue; 
//}



@RequestMapping(value = "/welcome" ,method = RequestMethod.GET)
public String welcome(HttpServletRequest request){
	request.setAttribute("mode", "MODE_HOME");
	return "welcome";
}
@RequestMapping(value = "/Start Exchange" ,method = RequestMethod.GET)
public String Startexchange(HttpServletRequest request){
	request.setAttribute("mode", "MODE_HOME");
	return "redirect:/login";
}
@RequestMapping(value = "/New User" ,method = RequestMethod.GET)
public String NewUser(HttpServletRequest request){
	request.setAttribute("mode", "MODE_HOME");
	return "redirect:/newregister";
}
@RequestMapping(value = "/show-request" ,method = RequestMethod.GET)
public String showrequest(HttpServletRequest request){
	request.setAttribute("mode", "MODE_ALL_REQUESTS");
	return "redirect:/register";
}
@RequestMapping(value = "/ShowRequest" ,method = RequestMethod.GET)
public String ShowRequest(HttpServletRequest request){
	request.setAttribute("mode", "MODE_ALL_REQUESTS");
	return "redirect:/show-users";
}

@RequestMapping(value = "/register" ,method = RequestMethod.GET)
public String register(HttpServletRequest request){
	request.setAttribute("mode", "MODE_REGISTER");
	return "welcome";
}
@PostMapping(value="/save-user")
public String saverequest(@Valid @ModelAttribute ExchangeValue exchangevalue,Errors errors,Model model,BindingResult bindingResult,HttpServletRequest request) {
	if(!errors.hasErrors()) {
		userService.save(exchangevalue);
		return "redirect:/show-users";

	}else {
		request.setAttribute("error", "Enter the valid Details");
		request.setAttribute("mode", "MODE_REGISTER");
		return "welcome";
	}
}

@PostMapping(value="/save-user1")
public String saveuser(@Valid @ModelAttribute  User user,Errors errors,Model model,BindingResult bindingResult,HttpServletRequest request) {
	if(!errors.hasErrors()) {
		userService.save1(user);		
		return "redirect:/login";

    }
	else {
		request.setAttribute("error", "Enter the valid Details");
		request.setAttribute("mode", "MODE_NEWREGISTER");
		return "welcome";
	}
	
}
@RequestMapping(value="/show-users")
public String allrequest(@Param("keyword") String keyword,HttpServletRequest request) {
	request.setAttribute("mode", "ALL_REQUESTS");
	request.setAttribute("exchangevalues", userService.showAllRequest(keyword));

	return "welcome";
}
@RequestMapping(value="/adminrequest")
public String Adminallrequest(@Param("keyword") String keyword,HttpServletRequest request) {
	request.setAttribute("mode", "ADMIN_ALL_REQUESTS");
	request.setAttribute("exchangevalues", userService.showAllRequest(keyword));

	return "welcome";
}
@RequestMapping("/delete-user")
public String deleteUser(@RequestParam long id, HttpServletRequest request) {
	userService.deleterequest((long) id);
	request.setAttribute("mode", "ADMIN_ALL_REQUESTS");
	request.setAttribute("exchangevalues", userService.showAllRequest(null));
	return "welcome";
}
@RequestMapping("/login")
public String login(HttpServletRequest request) {
	request.setAttribute("mode", "MODE_LOGIN");
	return "welcome";
	}

@RequestMapping("/admin")
public String Adminlogin(HttpServletRequest request) {
	request.setAttribute("mode", "ADMIN_LOGIN");
	return "welcome";
}
@RequestMapping ("/login-admin")
public String AdminloginUser(@ModelAttribute Admin admin, HttpServletRequest request) {
	if(userService.findByUsernameAndPasswords(admin.getUsername(), admin.getPasswords())!=null) {
		return "redirect:/adminrequest";
	}
	else {
		request.setAttribute("error", "Invalid Username or Password");
		request.setAttribute("mode", "ADMIN_LOGIN");
		return "welcome";
		
	}
}
@RequestMapping ("/login-user")
public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
	if(userService.findByUsernameAndPassword(user.getUsername(), user.getPassword())!=null) {
		if(user.getPassword()== null) {
			request.setAttribute("error", "Invalid Username or Password");
			request.setAttribute("mode", "ADMIN_LOGIN");
			return "welcome";	
		}
		return "redirect:/show-users";
	}
	else {
		request.setAttribute("error", "Invalid Username or Password");
		request.setAttribute("mode", "MODE_LOGIN");
		return "welcome";
		
	}
}

@RequestMapping("/newregister")
public String newregister(HttpServletRequest request) {
	request.setAttribute("mode", "MODE_NEWREGISTER");
	return "welcome";
}
//@GetMapping(path="/all")
//public @ResponseBody Iterable<ExchangeValue> getAllUsers() {
 //This returns a JSON or XML with the users
//return repository.findAll();

//}

//@RequestMapping(value="/show-users")
//public String allrequest(HttpServletRequest request) {
//	request.setAttribute("mode", "ALL_REQUESTS");
//	request.setAttribute("exchangevalues", userService.showAllRequest());

//	return "welcome";
//}	
	
    

}

