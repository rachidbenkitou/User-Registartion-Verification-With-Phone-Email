package com.bokito.exception;

import lombok.Data;

import java.util.Date;
@Data
public class MessageError {
    private int status;
    private String error;
    private String message;
    private Date timestamp;
}
