package com.camp.campApi.exception;

import com.camp.campApi.entity.ErrorMessage;
import com.camp.campApi.entity.ResponseApi;
import com.camp.campApi.service.ResponseService;
import javassist.NotFoundException;


import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ResponseService responseService;


    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> apiException(ApiException exception,WebRequest request)
    {
        String stackTrace= ExceptionUtils.getStackTrace(exception);
        ErrorMessage errorMessage=new ErrorMessage(exception.getMessage(),request.getDescription(false),stackTrace,new Date().toString());
        responseService.saveResponse(errorMessage);
        ResponseApi responseApi=new ResponseApi(false,exception.getMessage(),new Date().toString(),null);
        return new ResponseEntity<>(responseApi,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> apiException(Exception exception,WebRequest request)
    {
        String stackTrace= ExceptionUtils.getStackTrace(exception);
        ErrorMessage errorMessage=new ErrorMessage(exception.getMessage(),request.getDescription(false),stackTrace,new Date().toString());
        responseService.saveResponse(errorMessage);
        ResponseApi responseApi=new ResponseApi(false,exception.getMessage(),new Date().toString(),null);
        return new ResponseEntity<>(responseApi,HttpStatus.NOT_FOUND);
    }




}
