package com.lzy.firstpsringgradle.authr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lzy.firstpsringgradle.annotation.authrAnnotation;


@Component
public class AccessTokenVerifyInterceptor extends HandlerInterceptorAdapter {

	// @Autowired
	// ValidationService validationService;

	private final static Logger LOG = LoggerFactory.getLogger(AccessTokenVerifyInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		LOG.info("AccessToken executing ...");

		HandlerMethod handlerMethod = (HandlerMethod) handler;  
		authrAnnotation myAnnotation = handlerMethod.getMethod().getAnnotation(authrAnnotation.class);
	    System.out.println(myAnnotation.role()+"#############################################"+myAnnotation.identity());
	  
		boolean flag = false;
		
 
		// token

		String accessToken = request.getParameter("token");

		if ("123".equals(accessToken)) {
			flag = true;
		}

		/*
		 * if (StringUtils.isNotBlank(accessToken)) { // 验证 ValidationModel v =
		 * validationService.verifyAccessToken(accessToken);
		 * 
		 * // 时间过期
		 * 
		 * // 用户验证 if (v != null) { User user =
		 * userService.findById(v.getUid()); if(user != null) {
		 * request.setAttribute(CommonConst.PARAM_USER, user);
		 * LOG.info("AccessToken SUCCESS ...  user:" + user.getUserName() +
		 * " - " + accessToken); flag = true; } }
		 */

		if (!flag) {

			response.setStatus(HttpStatus.FORBIDDEN.value());

			response.getWriter().print("AccessToken ERROR");

		}

		return flag;

	}

}
