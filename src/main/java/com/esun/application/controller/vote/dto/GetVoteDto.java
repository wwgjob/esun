package com.esun.application.controller.vote.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class GetVoteDto implements Serializable {
    private static final long serialVersionUID = 4383737901231114539L;

    @ApiModelProperty(value="id", example = "1")
    @JsonProperty("id")
    @SerializedName("id")
    private Long id;

    @ApiModelProperty(value="項目名稱", example = "project")
    @JsonProperty("project")
    @SerializedName("project")
    private String project;
}
