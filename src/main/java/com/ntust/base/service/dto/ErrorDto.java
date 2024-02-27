package com.ntust.base.service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ErrorDto implements Serializable {
    private String errorMessage;
    private String errorCode;
}
