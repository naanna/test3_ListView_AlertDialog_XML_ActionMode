package com.example.a54667.test3_listview_alertdialog_xml_actionmode;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class xml_menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_show);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.xml_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //绑定文本框
        TextView txt;
        txt = (TextView)findViewById(R.id.textview);
        //点击事件
        switch (item.getItemId()){
            case R.id.font_10:
                txt.setTextSize(10);
                break;
            case R.id.font_16:
                txt.setTextSize(16);
                break;
            case R.id.font_20:
                txt.setTextSize(20);
                break;
            case R.id.font_red:
                txt.setTextColor(Color.RED);
                break;
            case R.id.font_black:
                txt.setTextColor(Color.BLACK);
                break;
            case R.id.plain_item:
                Toast toast =Toast.makeText(xml_menu.this,"这是普通单击项",Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
        return true;
    }
}