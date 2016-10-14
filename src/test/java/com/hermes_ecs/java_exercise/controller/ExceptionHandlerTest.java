package com.hermes_ecs.java_exercise.controller;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExceptionHandlerTest {
    @Test
    public void handlerAddsExceptionToModel() {
        // given
        final Exception exception = new IllegalArgumentException();

        // when
        final ExceptionHandler handler = new ExceptionHandler(exception);


        // then
        assertThat(handler.getModel().get(ExceptionHandler.EXCEPTION_ATTRIBUTE), is(equalTo((Object) exception)));
    }
}
