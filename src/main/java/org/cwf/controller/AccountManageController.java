package org.cwf.controller;

import javax.annotation.Resource;

import org.cwf.model.JsonUser;
import org.cwf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountManageController {

	@Resource
	private UserService userService;
	
	/**
	 * 显示用户查询页面
	 * 
	 * @return
	 */
	@GetMapping("/userQuery")
	public String userQuery() {
		return "userQuery";
	}
	
	/**
	 * 显示用户查询页面
	 * 
	 * @return
	 */
	@RequestMapping("/userGet")
	public String userGet() {
		return "userGet";
	}
	
	/**
	 * 显示用户管控页面
	 * 
	 * @return
	 */
	@GetMapping("/userManage")
	public String userManage() {
		return "userManage";
	}
	
	@GetMapping("/showUserData")
	@ResponseBody
	public JsonUser showUserData(JsonUser jsonUser) {
		System.out.println(jsonUser.getSex());
		jsonUser.setPageList(userService.getUserData(jsonUser));
		return jsonUser;
	}
	
	@PostMapping("/bearUser")
	@ResponseBody
	public int bearUser(int id) throws Exception {
		int a = userService.updateUserBearByPrimaryKey(id);
		if (a>1) {
			throw new Exception();
		}
		return 1;
	}
	
	@PostMapping("/startUser")
	@ResponseBody
	public int startUser(int id) throws Exception {
		int a = userService.updateUserBearByPrimaryKey(id);
		if (a>1) {
			throw new Exception();
		}
		return 1;
	}
}
