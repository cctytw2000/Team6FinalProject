package com.eeit109team6.finalproject.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("WebAppInitializer : DispatcherServlet : getRootConfigClasses");
		return new Class[] { RootAppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("WebAppInitializer : DispatcherServlet : getServletConfigClasses");
		return new Class[] { WebAppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("WebAppInitializer : DispatcherServlet : getServletMappings");
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return new Filter[] { characterEncodingFilter };
	}

}
