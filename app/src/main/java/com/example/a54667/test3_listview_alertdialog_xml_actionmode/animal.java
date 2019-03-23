package com.example.a54667.test3_listview_alertdialog_xml_actionmode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class animal extends AppCompatActivity {
    //存放动物名称和照片
    private String[] names = new String[]{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] image=new int[]{R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.animal_listview);
        List<Map<String, Object>> ListItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("header", names[i]);
            listItem.put("images", image[i]);
            ListItems.add(listItem);
        }
        //创建SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, ListItems, R.layout.animal, new String[]{"header", "images"}, new int[]{R.id.header, R.id.images});
        final ListView list = (ListView) findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);
        //点击事件,点击弹出动物名称
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast .makeText(animal.this, names[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}