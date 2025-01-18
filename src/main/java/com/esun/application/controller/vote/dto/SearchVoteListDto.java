package com.esun.application.controller.vote.dto;

import com.esun.application.base.dto.PaginationDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SearchVoteListDto implements Serializable {

    @ApiModelProperty(value="items")
    @JsonProperty("items")
    @SerializedName("items")
    private List<GetVoteDto> items;

    @JsonProperty("pagination")
    @SerializedName("pagination")
    private PaginationDto pagination;
}
