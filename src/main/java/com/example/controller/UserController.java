//package com.example.controller;
//
//import java.util.List;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.model.User;
//import com.example.service.UserService;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//	
//	private UserService userService;
//	
//	public UserController(UserService userService) {
//		this.userService=userService;
//	}
//	
//	@PostMapping
//	public ResponseEntity<User> createUser(@RequestBody User user) {
//		User ur=userService.createUser(user);
//		return new ResponseEntity<User>(ur,HttpStatus.CREATED);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<User> getUserById(@PathVariable Long id) {
//		User user=userService.getById(id);
//		return ResponseEntity.ok(user);
//	}
//	
//	@GetMapping
//	public ResponseEntity<List<User>>  getAll(){
//		return  ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
//	}
//	
//	@DeleteMapping("/{id}")
//	public void deleteById(@PathVariable Long id) {
//		userService.deleteById(id);
//	}
//	
//	@PutMapping("/{id}")
//	public User updateUserById(@PathVariable Long id,@RequestBody User us) {
//		User us2=userService.updateById(id, us);
//		return us2;
//	}
//}


package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Role;
import com.example.model.User;
import com.example.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	
	public UserController(UserService userService) {
		this.userService=userService;
	}
	
	@GetMapping("/login")
	public String loginmethod() {
		return "login";
	}
	@GetMapping("/register")
	public String registermethod() {
		return "register";
	}
	@GetMapping("/admin-dashboard")
	public String admindashboardmethod() {
		return "admin-dashboard";
	}
	@GetMapping("/menu")
	public String menumethod() {
		return "menu";
	}
	
	@GetMapping("/logout")
	public String logoutmethod(HttpServletRequest req) {
		HttpSession httpSession=req.getSession(false);
		if(httpSession!=null) {
			httpSession.invalidate();
		}
		
		return "redirect:/user/login";
	}
	
	@PostMapping("/register")
	public ModelAndView createUser(@ModelAttribute User user) {
		User ur=userService.createUser(user);
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg", "User Added successfully");
		mav.setViewName("register"); // instead of pass normal name try to pass with redirect where url will be change , if we pass normal name then it wouldn't hit url just normally render a jsp page but if we use redirect then we will loose model data  
		return mav;
	}
	
	@PostMapping("/login")
	public ModelAndView getUserById(@RequestParam("email") String email,@RequestParam("password") String password,HttpServletRequest req,HttpServletResponse resp,HttpSession httpSession) {
		User user=userService.getById(email,password);
		
		ModelAndView mav=new ModelAndView();
		if(user!=null) {
			
			httpSession.setAttribute("loggedInUser", user);
			if(user.getRole().equals(Role.ADMIN)) {
				mav.setViewName("redirect:/order-page/admin-dashboard");
				return mav;
			}else {
				mav.setViewName("redirect:/food/menu");
				return mav;
			}
			
		}else {
			mav.addObject("error","User Doesn't exists");
			mav.setViewName("login");
			return mav;
		}
		
	}
	
	
	
	
	@GetMapping
	public List<User>  getAll(){
		return  userService.getAll();
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		userService.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public User updateUserById(@PathVariable Long id,@RequestBody User us) {
		User us2=userService.updateById(id, us);
		return us2;
	}
}
