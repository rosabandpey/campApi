package com.camp.campApi.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity()
@Table(name="responseerror")
public class ErrorMessage implements Serializable {

    private static final long serialVersionUID = -121838495708416141L;

    @Column(columnDefinition="LONGTEXT")
    private String message;

    @Column(columnDefinition="LONGTEXT")
    private String stackTrace;
    private String url;
    private String date;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;

    public ErrorMessage() {
    }

    public ErrorMessage(String message,String url,String stackTrace, String date) {

        this.message = message;
        this.url=url;
        this.stackTrace=stackTrace;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
