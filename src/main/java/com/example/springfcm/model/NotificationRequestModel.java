package com.example.springfcm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author vinsfran
 */
@Data
public class NotificationRequestModel {

    @JsonProperty("data")
    @SerializedName("data")
    private NotificationData mData;

    @JsonProperty("to")
    @SerializedName("to")
    private String mTo;

}
