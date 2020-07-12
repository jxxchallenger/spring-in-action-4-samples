package io.jxxchallenger.springinaction.spittr;

import java.nio.charset.StandardCharsets;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import io.jxxchallenger.springinaction.spittr.config.RootConfig;
import io.jxxchallenger.springinaction.spittr.web.config.WebConfig;

public class SpitterWebAppInitializer /*
                                       * extends
                                       * AbstractAnnotationConfigDispatcherServletInitializer
                                       */ {

    //@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }

    //@Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    //@Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    //@Override
    protected Filter[] getServletFilters() {
        return new Filter[] { new CharacterEncodingFilter(StandardCharsets.UTF_8.displayName(), true), new HiddenHttpMethodFilter() };
    }

    //@Override
    protected void customizeRegistration(Dynamic registration) {
        // TODO Auto-generated method stub
        registration.setInitParameter("enableLoggingRequestDetails", "true");
    }

}
