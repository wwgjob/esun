package com.ntust.application.controller.dio;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CreateMemberDio implements Serializable {
    private static final long serialVersionUID = -5359247640680097110L;
    @ApiModelProperty(value="Chinese Name", example = "tom")
    @JsonProperty("name")
    @SerializedName("name")
    private String name;

    @ApiModelProperty(value="email", example = "tom.lai@gmail.com")
    @JsonProperty("email")
    @SerializedName("email")
    private String email;
}
