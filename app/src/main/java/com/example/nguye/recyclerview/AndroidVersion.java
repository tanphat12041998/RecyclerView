package com.example.nguye.recyclerview;

public class AndroidVersion {
    private String name;//tên biến phải trùng với json
    private String ver;
    private String api;

    public AndroidVersion(){}

    public AndroidVersion(String name, String version, String api) {
        this.name = name;
        this.ver = version;
        this.api = api;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return ver;
    }

    public void setVersion(String version) {
        this.ver = version;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
