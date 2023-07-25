package mvc.initializer;

import mvc.config.MvcConfig;
import mvc.config.RootConfig;
import mvc.filters.ServletFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @author xinLin.huang
 * @date 2023/7/24 17:27
 */
public class MyAbstractAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{MvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/springmvc/*"};
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[]{new ServletFilter()};
	}
}
