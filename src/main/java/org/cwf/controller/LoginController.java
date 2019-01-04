package org.cwf.controller;

import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.cwf.model.Admin;
import org.cwf.service.AdminService;
import org.cwf.util.ImageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
	
	@Resource
	private AdminService adminService;
	
	/**
	 * 图片验证码
	 * 
	 * @param response HttpServletResponse
	 * @param time     随机时间
	 * @throws Exception 图片异常
	 */
	@GetMapping("/image_code")
	public void imageCode(HttpServletRequest request, HttpServletResponse response, String time) throws Exception {
		Random ran = new Random();
		String allCode = "3456789ABCDEFGHJKMNPQRSTUVWXY";
		
		String s = "";
		for (int i = 0; i < 4; i++) {
			int index = ran.nextInt(allCode.length());
			s += allCode.charAt(index);
		}
		request.getSession().setAttribute("code", s);
		ImageIO.write(ImageUtils.newImgCode(105, 32, s), "jpg", response.getOutputStream()); // 将图片验证码输出
	}
	
	/**
	 * 
	 * @param admin 登陆信息
	 * @param session 储存登陆状态
	 * @return
	 */
	@PostMapping("/adminLogin")
	public String adminLogin(@Valid Admin admin,String authcode,HttpSession session,Map<String,Object> map,BindingResult result) {
		if (result.hasErrors()) {
			map.put("msg", "不能为空");
			return "login";
		}
		String auth = (String) session.getAttribute("code");
		if (!auth.equals(authcode)) {
			map.put("msg", "验证码错误");
			return "login";
		}
		admin = adminService.selectByLogin(admin);
		if (admin == null) {
			map.put("msg", "账号密码错误");
			return "login";
		}
		session.setAttribute("admin", admin);
		return "safemaege";
	}
	
	@PostMapping("/admina")
	public String admina(Admin admin) {
		return "login";
	}
}
