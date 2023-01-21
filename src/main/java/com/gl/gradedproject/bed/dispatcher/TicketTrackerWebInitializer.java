package com.gl.gradedproject.bed.dispatcher;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.gl.gradedproject.bed.config.TicketTrackerConfig;
import com.gl.gradedproject.bed.config.TicketTrackerContext;

public class TicketTrackerWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { TicketTrackerContext.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { TicketTrackerConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
