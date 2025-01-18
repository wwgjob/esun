package com.esun.application.controller.userVote.dio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CreateUserVoteDio implements Serializable {
    private static final long serialVersionUID = 2611304784231732132L;

    @JsonProperty("votingItemId")
    @SerializedName("votingItemId")
    private List<Long> votingItemId;
}
