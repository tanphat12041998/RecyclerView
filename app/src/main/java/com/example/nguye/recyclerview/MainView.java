package com.example.nguye.recyclerview;

import java.util.List;

public interface MainView {
    void loadJSONSuccess(List<AndroidVersion> list);//kết quả trả về của presenter là 1 list Androidversion
    void loadJSONFail(String error);//nhận về 1 cái thông báo lỗi
}
