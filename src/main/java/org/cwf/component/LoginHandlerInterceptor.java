package org.cwf.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cwf.model.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
   * <p>Title : LoginHandlerInterceptor</p>
   * <p>Description : 登陆拦截器</p>
   * <p>DevelopTools : Eclipse_x64</p>
   * <p>DevelopSystem : Window7_x64</p>
   * <p>Company : org.cwf</p>
   * @author : cwf
   * @date : 2018年12月25日 下午9:24:03
   * @version : 12.0.0
 */
public class LoginHandlerInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		if (admin == null) {
			//未登陆
			request.setAttribute("msg", "请登录");
			request.getRequestDispatcher("/login.html").forward(request, response);
			return false;
		}else {
			//已登陆
			return true;
		}
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
	}

}
