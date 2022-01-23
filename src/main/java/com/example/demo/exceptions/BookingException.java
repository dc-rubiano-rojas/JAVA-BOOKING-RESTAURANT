package com.example.demo.exceptions;

import com.example.demo.dtos.ErrorDto;

import java.util.ArrayList;
import java.util.List;

public class BookingException extends Exception{
    private static final long serialVersionUID = 1L;

    private String code;

    private int responseCode;

    private List<ErrorDto> errorList = new ArrayList<>();


    public BookingException(String message, String code, int responseCode, List<ErrorDto> errorList) {
        super(message);
        this.code = code;
        this.responseCode = responseCode;
        this.errorList.addAll(errorList);
    }

    public BookingException(String code, int responseCode, List<ErrorDto> errorList) {
        this.code = code;
        this.responseCode = responseCode;
        this.errorList = errorList;
    }

    public BookingException(String message, int value, String code) {
    }

    public BookingException(String message, int value, String code, List<ErrorDto> errorList) {
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }


    public List<ErrorDto> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<ErrorDto> errorList) {
        this.errorList = errorList;
    }

}
