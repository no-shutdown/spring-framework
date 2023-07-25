package mvc.config;

import mvc.interceptors.MvcInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xinLin.huang
 * @date 2023/7/24 14:54
 */
@Configuration
@ComponentScan({"mvc.controller"})
@EnableWebMvc
public class MvcConfig {

	@Bean
	public WebMvcConfigurer webMvcConfigurer() {
		return new WebMvcConfig();
	}

	static class WebMvcConfig implements WebMvcConfigurer {
		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(new MvcInterceptor());
		}
	}




	//这种方式单纯只用springMvc的话是不会自动配置到servlet容器中的，但是springBoot可以自动配置
	@Bean
	public WebMvcConfigurationSupport webMvcConfigurationSupport() {
		return new WebMvcConfigurationSupport() {
			@Override
			protected void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(new HandlerInterceptor() {
					@Override
					public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
						System.out.println("webMvcConfigurationSupport");
						return HandlerInterceptor.super.preHandle(request, response, handler);
					}
				});
			}
		};
	}
	//这种方式单纯只用springMvc的话是不会自动配置到servlet容器中的，但是springBoot可以自动配置
	@Bean
	public Filter filter() {
		return new Filter() {
			@Override
			public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
				System.out.println("myFilter");
				chain.doFilter(request, response);
			}
		};
	}


}
