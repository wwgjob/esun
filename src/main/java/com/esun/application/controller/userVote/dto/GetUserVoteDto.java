package com.esun.application.controller.userVote.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class GetUserVoteDto implements Serializable {
    private static final long serialVersionUID = 4383737901231114539L;

    @ApiModelProperty(value="id", example = "id")
    @JsonProperty("id")
    @SerializedName("id")
    private Long id;

    @ApiModelProperty(value="項目名稱", example = "project")
    @JsonProperty("project")
    @SerializedName("project")
    private String project;

    @ApiModelProperty(value="數量", example = "")
    @JsonProperty("count")
    @SerializedName("count")
    private Integer count;
}
