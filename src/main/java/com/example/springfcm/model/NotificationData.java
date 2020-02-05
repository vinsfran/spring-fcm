package com.example.springfcm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author vinsfran
 */
@Data
public class NotificationData {

    @JsonProperty("detail")
    @SerializedName("detail")
    private String mDetail;

    @JsonProperty("title")
    @SerializedName("title")
    private String mTitle;
}
