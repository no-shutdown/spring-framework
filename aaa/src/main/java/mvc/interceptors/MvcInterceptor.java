package mvc.interceptors;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xinLin.huang
 * @date 2023/7/25 17:44
 */
public class MvcInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("webMvcConfigurer");
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}
