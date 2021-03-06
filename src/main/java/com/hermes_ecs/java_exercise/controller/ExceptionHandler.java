package com.hermes_ecs.java_exercise.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

class ExceptionHandler {
    static final String EXCEPTION_ATTRIBUTE = "exception";
    private ModelAndView response;
    private ModelMap model;

    public ExceptionHandler(Throwable exception) {
        response = new ModelAndView();
        model = response.getModelMap();
        model.put(EXCEPTION_ATTRIBUTE, exception);
    }

    public ModelMap getModel() {
        return model;
    }

    public void setViewName(String viewName) {
        response.setViewName(viewName);
    }

    public ModelAndView getResponse() {
        return response;
    }
}
