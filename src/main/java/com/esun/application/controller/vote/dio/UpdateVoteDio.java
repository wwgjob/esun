package com.esun.application.controller.vote.dio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpdateVoteDio implements Serializable {
    private static final long serialVersionUID = -1895651461285539609L;

    @JsonIgnore
    private Long id;

    @ApiModelProperty(value="項目名稱", example = "project")
    @JsonProperty("project")
    @SerializedName("project")
    private String project;
}
