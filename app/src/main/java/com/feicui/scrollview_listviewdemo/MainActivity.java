package com.feicui.scrollview_listviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView mlistview;
    private List<String> list;
    private ArrayAdapter<String> adapter;

    private TextView textView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.txt);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        mlistview = (ListView) findViewById(R.id.mlistview);
        list = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            list.add("第" + i + "条数据");
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        mlistview.setAdapter(adapter);
        setListViewHeight(mlistview);

    }


    public void setListViewHeight(ListView listview) {
        ListAdapter listAdapter = listview.getAdapter();

        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View itemView = listAdapter.getView(i, null, listview);
            itemView.measure(0, 0);

            totalHeight += itemView.getMeasuredHeight();

        }
        ViewGroup.LayoutParams layoutParams = listview.getLayoutParams();

        int dividerHeight = (listview.getDividerHeight() * (listAdapter.getCount() - 1));
        layoutParams.height = totalHeight + dividerHeight;
        listview.setLayoutParams(layoutParams);
    }
}
