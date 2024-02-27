package com.ntust.application.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class GetMember2Dto implements Serializable {
    private static final long serialVersionUID = 4383737901231114539L;

    @ApiModelProperty(value="id", example = "1")
    @JsonProperty("id")
    @SerializedName("id")
    private Long id;

    @ApiModelProperty(value="Chinese Name", example = "tom")
    @JsonProperty("name")
    @SerializedName("name")
    private String name;

    @ApiModelProperty(value="email", example = "tom.lai@gmail.com")
    @JsonProperty("email")
    @SerializedName("email")
    private String email;
}
