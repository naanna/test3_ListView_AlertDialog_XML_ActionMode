package com.example.a54667.test3_listview_alertdialog_xml_actionmode;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class alertdialog extends AppCompatActivity {
     @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       AlertDialog.Builder builder = new AlertDialog.Builder(this);
       // 实例化布局
         View view2 = View.inflate(alertdialog.this, R.layout.alertdialog, null);
         // 设置参数，alertdialog中用了图片做标题
         builder//.setTitle("ANDROID APP")
                 .setView(view2);
        //设置按钮
         builder.setPositiveButton("Sign in", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialogInterface, int i) {
                 Toast.makeText(alertdialog.this,"确定", Toast.LENGTH_LONG).show();
             }
         });
         builder.setNeutralButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialogInterface, int i) {
                 Toast.makeText(alertdialog.this,"取消", Toast.LENGTH_LONG).show();
             }
         });
         final AlertDialog alertDialog = builder.create();
         alertDialog.show();
         //设置按钮颜色
         alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.BLACK);
         alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(Color.BLACK);
    }
}