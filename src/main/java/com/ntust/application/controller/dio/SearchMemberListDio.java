package com.ntust.application.controller.dio;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SearchMemberListDio implements Serializable {
    private static final long serialVersionUID = -5359247640680097110L;
    @ApiModelProperty(value="keyword", example = "tom")
    @JsonProperty("keyword")
    @SerializedName("keyword")
    private String keyword;
}
