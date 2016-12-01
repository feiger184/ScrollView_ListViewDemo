package com.feicui.scrollview_listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    private ListView mlistview;
    private List<String> list;
    private ArrayAdapter<String> adapter;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mlistview = (ListView) findViewById(R.id.secondlistview);
        list = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            list.add("第" + i + "条数据");
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        mlistview.setAdapter(adapter);


    }
}
