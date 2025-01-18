package com.esun.base.service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseDto<T> implements Serializable {
    private boolean success;
    private T data;
    private ErrorDto error;
}
