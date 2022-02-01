package com.t3b.msinventory.rest.api.controller;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.t3b.msinventory.rest.api.entities.custom.Response;
import com.t3b.msinventory.rest.api.utils.Constants;

@ControllerAdvice
public class ControllerExceptionHandler {
    protected static final Logger logger = LogManager.getLogger(ControllerExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    Response<Object> ExceptionHandler(Exception e) {
        String idFailure = UUID.randomUUID().toString();

        System.setProperty("idRequest", idFailure);

        Response<Object> response = new Response<>();
        response.setMessage(String.format(Constants.ErrorInesperado, idFailure));
        response.setIsWarning(false);
        response.setIsSuccess(false);

       logger.error(e.getMessage(), e);

        return response;

    }
}
