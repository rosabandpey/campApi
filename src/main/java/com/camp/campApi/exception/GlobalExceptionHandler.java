package com.camp.campApi.exception;

import com.camp.campApi.entity.ErrorMessage;
import com.camp.campApi.entity.ResponseApi;
import com.camp.campApi.service.ResponseService;


import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private ResponseService responseService;


    @ExceptionHandler(ApiException.class)
    public ResponseApi apiException(ApiException exception,WebRequest request)
    {
        String stackTrace= ExceptionUtils.getStackTrace(exception);
        ErrorMessage errorMessage=new ErrorMessage(exception.getMessage(),request.getDescription(false),stackTrace,new Date().toString());
        responseService.saveResponse(errorMessage);
        ResponseApi responseApi=new ResponseApi(false,exception.getMessage(),new Date().toString(),null);
        return responseApi;
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseApi notFoundException(NotFoundException exception, WebRequest request)
    {
        String stackTrace= ExceptionUtils.getStackTrace(exception);
        ErrorMessage errorMessage=new ErrorMessage(exception.getMessage(),request.getDescription(false),stackTrace,new Date().toString());
        responseService.saveResponse(errorMessage);
        ResponseApi responseApi=new ResponseApi(false,exception.getMessage(),new Date().toString(),null);
        return responseApi;
    }


}
