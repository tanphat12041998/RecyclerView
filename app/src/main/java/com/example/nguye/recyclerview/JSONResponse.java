package com.example.nguye.recyclerview;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class JSONResponse {//có chỗ nào khó hiểu hk
    @SerializedName("android")
    private List<AndroidVersion> androidVersions;

    public  List<AndroidVersion> getAndroidVersions() {
        return androidVersions;
    }
}
