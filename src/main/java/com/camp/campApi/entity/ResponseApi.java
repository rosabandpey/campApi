package com.camp.campApi.entity;

import javax.persistence.*;
import java.io.Serializable;


public class ResponseApi implements Serializable{

    private boolean isSuccessfull;
    private String message;
    private String Date;
    private Object data;




    public ResponseApi() {
    }

    public ResponseApi(boolean isSuccessfull, String message, String date, Object data) {
        this.isSuccessfull = isSuccessfull;
        this.message = message;
        Date = date;
        this.data = data;
    }



   public boolean isSuccessfull() {
        return isSuccessfull;
    }

    public void setSuccessfull(boolean successfull) {
        isSuccessfull = successfull;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String error) {
        this.message = error;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    
}
