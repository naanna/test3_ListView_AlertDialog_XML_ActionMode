package com.example.a54667.test3_listview_alertdialog_xml_actionmode;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.HashMap;

public class actionMode extends ListActivity {
    private String[] Datas = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten"};
    private SelectionAdapter sAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actionmode_main);
        sAdapter = new SelectionAdapter(this,R.layout.actionmode_list, R.id.textView1, Datas);
        setListAdapter(sAdapter);
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        getListView().setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            private int number = 0;
            //设置完多选模式监听器之后，需实现下面的方法
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }
            @Override       //响应删除
            public void onDestroyActionMode(ActionMode mode) {
                sAdapter.clearSelection();
 /*               TextView txta;
                txta = (TextView)findViewById(R.id.textView1);
                txta.setText(""); */
            }
            @Override        // 加载xml中的上下文菜单。实现右侧的MenuItem配置
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                number = 0;
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.actionmode, menu);
                return true;
            }
            @Override//设置的MenuItem点击之后调用
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                if (item.getItemId() == R.id.delete) {
                    number = 0;
                    sAdapter.clearSelection();
                    mode.finish();
                    return true;
                }
                return false;
            }
            @Override//菜单显示
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
                if (checked) {
                    number++;
                    sAdapter.setNewSelection(position, checked);
                } else {
                    number--;
                    sAdapter.removeSelection(position);
                }
                mode.setTitle(number + " selected");
            }
        });
    }
    //选中选项
    private class SelectionAdapter extends ArrayAdapter<String> {
        private HashMap<Integer, Boolean> mSelection = new HashMap<Integer, Boolean>();
        public SelectionAdapter(Context context, int resource,
                                int textViewResourceId, String[] objects) {
            super(context, resource, textViewResourceId, objects);
        }
        public void setNewSelection(int position, boolean value) {
            mSelection.put(position, value);
            notifyDataSetChanged();
        }
        public boolean isPositionChecked(int position) {
            Boolean result = mSelection.get(position);
            return result == null ? false : result;
        }
        public void removeSelection(int position) {
           mSelection.remove(position);
            notifyDataSetChanged();
        }
        public void clearSelection() {
            mSelection = new HashMap<Integer, Boolean>();
            notifyDataSetChanged();
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = super.getView(position, convertView, parent);
            //选中颜色改变 取消颜色变回
            v.setBackgroundColor(getResources().getColor(android.R.color.background_light));
            if (mSelection.get(position) != null) {
                v.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
            }
            return v;
        }
    }
}
