package com.ntust.application.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SearchMemberListDto implements Serializable {

    @ApiModelProperty(value="list")
    @JsonProperty("list")
    @SerializedName("list")
    private List<GetMemberDto> list;
}
