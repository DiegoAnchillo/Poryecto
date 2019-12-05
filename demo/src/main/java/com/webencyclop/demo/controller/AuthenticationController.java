package com.webencyclop.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.webencyclop.demo.model.User;
import com.webencyclop.demo.model.Food;
import com.webencyclop.demo.service.FoodService;
import com.webencyclop.demo.service.UserService;

@RestController

@Controller
public class AuthenticationController {

	@Autowired
	UserService userService;
	@Autowired
	FoodService foodService;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value = { "/about" }, method = RequestMethod.GET)
	public ModelAndView about() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("about");
		return modelAndView;
	}

	@RequestMapping(value = { "/contact" }, method = RequestMethod.GET)
	public ModelAndView contact() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contact");
		return modelAndView;
	}

	@RequestMapping(value = { "/menu" }, method = RequestMethod.GET)
	public ModelAndView menu() {
		final ModelAndView modelAndView = new ModelAndView();
		// modelAndView.addObject("foodList", foodService.getAllFood());
		modelAndView.setViewName("menu"); 
		return modelAndView;
	}


	@RequestMapping(value = { "/pedidos" }, method = RequestMethod.GET)
	public ModelAndView pedidos() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("pedidos"); 
		return modelAndView;
	}



	@RequestMapping(value = { "/single" }, method = RequestMethod.GET)
	public ModelAndView single() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("single");
		return modelAndView;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		final ModelAndView modelAndView = new ModelAndView();
		final User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("register");
		return modelAndView;
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView registerUser(@Valid final User user, final BindingResult bindingResult, final ModelMap modelMap) {
		final ModelAndView modelAndView = new ModelAndView();
		// Check for the validations
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the errors in form!");
			modelMap.addAttribute("bindingResult", bindingResult);
		}
		else if(userService.isUserAlreadyPresent(user)){
			modelAndView.addObject("successMessage", "El usuario ya existe!");			
		}
		// we will save the user if, no binding errors
		else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "El usuario se ha registrado correctamente!");
		}
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	@RequestMapping(value = "/newfood", method = RequestMethod.GET)
	public ModelAndView registerfood() {
		final ModelAndView modelAndView = new ModelAndView();
		final Food food = new Food();
		modelAndView.addObject("food", food);
		modelAndView.setViewName("newfood");
		return modelAndView;
	}

	@RequestMapping(value="/registerfood", method=RequestMethod.POST)
	public ModelAndView registerFood(@Valid final Food food, final BindingResult bindingResult, final ModelMap modelMap) {
		final ModelAndView modelAndView = new ModelAndView();
		// Check for the validations
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the errors in form!");
			modelMap.addAttribute("bindingResult", bindingResult);
		}
		else if(foodService.isFoodAlreadyPresent(food)){
			modelAndView.addObject("successMessage", "La comida ya existe!");			
		}
		// we will save the user if, no binding errors
		else {
			foodService.saveFood(food);
			modelAndView.addObject("successMessage", "La comida se ha registrado correctamente!");
		}
		modelAndView.addObject("food", new Food());
		modelAndView.setViewName("newfood");
		return modelAndView;
	}


	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView home() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index"); 
		return modelAndView;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)

	public ModelAndView adminHome() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userList", userService.getAllUsers());
		modelAndView.setViewName("admin");
		return modelAndView;
	}

	@RequestMapping(value = "/chef", method = RequestMethod.GET)

	public ModelAndView chef() {
		final ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("foodList", foodService.getAllFood());
		modelAndView.setViewName("chef");
		return modelAndView;
	}



	//APis de clientes y comida
	@GetMapping("/api/users")
	public List<User> findAllUser() {
		return userService.findAll();
	}

	@GetMapping("/api/users/{id}")
	public User getUserById(@PathVariable(value = "id") Integer id){
		return userService.findById(id);
	}


	@GetMapping("/api/food")
	public List<Food> findAllFood(){
		return foodService.findAll();
	}

	@GetMapping("api/food/{id}")
	public Food getFoodById(@PathVariable(value = "id") Integer id){
		return foodService.findById(id);
	}

}










