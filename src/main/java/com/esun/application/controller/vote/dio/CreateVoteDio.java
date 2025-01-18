package com.esun.application.controller.vote.dio;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CreateVoteDio implements Serializable {
    private static final long serialVersionUID = -5359247640680097110L;

    @ApiModelProperty(value="項目名稱", example = "project")
    @JsonProperty("project")
    @SerializedName("project")
    private String project;
}
