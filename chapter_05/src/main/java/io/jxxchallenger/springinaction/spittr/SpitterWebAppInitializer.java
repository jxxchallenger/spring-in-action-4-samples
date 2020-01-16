package io.jxxchallenger.springinaction.spittr;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import io.jxxchallenger.springinaction.spittr.config.RootConfig;
import io.jxxchallenger.springinaction.spittr.web.config.WebConfig;

public class SpitterWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

}
