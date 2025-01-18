package com.esun.application.controller.vote.dio;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SearchVoteListDio implements Serializable {
    private static final long serialVersionUID = -5359247640680097110L;

    @ApiModelProperty(value="keyword", example = "")
    @JsonProperty("keyword")
    @SerializedName("keyword")
    private String keyword;

    @ApiModelProperty(value="pageSize", example = "")
    @JsonProperty("pageSize")
    @SerializedName("pageSize")
    private Integer pageSize;

    @ApiModelProperty(value="pageIndex", example = "")
    @JsonProperty("pageIndex")
    @SerializedName("pageIndex")
    private Integer pageIndex;
}
