package com.esun.application.controller.userVote.dto;

import com.esun.application.base.dto.PaginationDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SearchUserVoteListDto implements Serializable {
    private static final long serialVersionUID = 671617976149480969L;

    @ApiModelProperty(value="items")
    @JsonProperty("items")
    @SerializedName("items")
    private List<GetUserVoteDto> items;

    @JsonProperty("pagination")
    @SerializedName("pagination")
    private PaginationDto pagination;
}
