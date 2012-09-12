package com.taobao.tools.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户登录的Controller
 * @author jing.yue
 * @version 2012/09/09 1.0.0
 */
public class SecurityInterceptor implements HandlerInterceptor {

	private static final Logger logger = Logger.getLogger(SecurityInterceptor.class);

	//首页的URL
	private String indexUrl;

	//登录的URL
	private String loginUrl;

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		// TODO Auto-generated method stub
		logger.info("视图已处理完后执行的方法, 通常用于释放资源!");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		logger.info("控制器的方法已经执行完毕, 转换成视图之前的处理!");
	}

	/**
	 * 在Controller方法前进行拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub

		logger.info("拦截器的前端, 执行控制器之前所要处理的方法, 通常用于权限控制/日志, 其中, Object handler表示下一个拦截器!");
		/*UserInfo userInfo = (UserInfo) request.getSession().getAttribute(BaseController.SESSION_USER_KEY);
		String uri = request.getRequestURI();
		if(userInfo == null && !uri.contains(loginUrl)) {
			response.sendRedirect(request.getContextPath() + indexUrl);
			return false;
		}*/
		return true;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getIndexUrl() {
		return indexUrl;
	}

	public void setIndexUrl(String indexUrl) {
		this.indexUrl = indexUrl;
	}
}