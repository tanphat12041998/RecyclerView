package com.example.nguye.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements MainView{

    private InfoAndroidApdater adapter;
    private ArrayList<AndroidVersion> data;
    RecyclerView recyclerView;
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    public void initView(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        data = new ArrayList<>();
        adapter = new InfoAndroidApdater(data);
        recyclerView.setAdapter(adapter);//gán dữ liệu rỗng tránh dữ liệu nhận về là null :v, hôm qua ổng nói t haha
        presenter = new Presenter(MainActivity.this);//t nghĩ để đây không hợp lý lắm, mà kệ đi :v
        presenter.loadInfoAndroid();
    }

    @Override
    public void loadJSONSuccess(List<AndroidVersion> list) {
        if(list != null){
            data.addAll(list);
            adapter.notifyDataSetChanged();//nhận dữ liệu load về và thêm vào adapter;
        }
    }

    @Override
    public void loadJSONFail(String error) {
        Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();//có vẻ như là xong :v, oke chưa, m còn ở đó k phát
    }
}
