package com.controller;

import java.util.List;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.User;
import com.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
       @Autowired
        private UserService userService;
		@RequestMapping("/save")
		@ResponseBody
		public Boolean save(User user,HttpServletResponse response){
			boolean flag=true;
			response.setHeader("Access-Control-Allow-Origin", "*");
			try {
				this.userService.save(user);
			} catch (Exception e) {
				flag=false;
				e.printStackTrace();
			}
			return flag;
		}
      @RequestMapping("/listAll")
      @ResponseBody
      public List<User>listAll(HttpServletResponse response){
    	  response.setHeader("Access-Control-Allow-Origin", "*");
    	  List<User>list=this.userService.listAll();
    	  return list;    	 
      }
      @RequestMapping("/update")
		@ResponseBody
		public Boolean update(User user,HttpServletResponse response){
			boolean flag=true;
			response.setHeader("Access-Control-Allow-Origin", "*");
			try {
				this.userService.update(user);
			} catch (Exception e) {
				flag=false;
				e.printStackTrace();
			}
			return flag;
		}
      @RequestMapping("/delete/{id}")
  	@ResponseBody
  	public boolean deleteUser(@PathVariable("id") int id, HttpServletResponse response) {
  		response.setHeader("Access-Control-Allow-Origin", "*");
  		boolean flag = true;
  		try {
  			userService.delete(id);
  		} catch (Exception e) {
  			flag = false;
  			e.printStackTrace();
  		}
  		return flag;
      }
}
