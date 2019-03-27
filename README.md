# Android UI组件
1. Android ListView的用法 

   利用SimpleAdapter实现如下界面效果

    ![first](https://img-blog.csdnimg.cn/20190323095917252.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjQ3OTEzNA==,size_16,color_FFFFFF,t_70)

   1. 关键代码

         animal_listview.xml

        ```xml
        <ListView
            android:id="@+id/mylist"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:listSelector="#a61c1c"
            >
        </ListView>
        ```
        animal.xml
        ```xml
        <TextView
            android:id="@+id/header"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="15dp"
            android:layout_marginLeft="10dp"
            android:layout_weight="1"/>
        <ImageView
            android:id="@+id/images"
            android:layout_width="30dp"
            android:layout_height="30dp"
            android:layout_marginTop="10dp"
            android:layout_marginRight="10dp"
            android:layout_marginVertical="10dp"
            android:maxHeight="5dp"
            android:maxWidth="5dp"/>
        ```
        animal.java
        ```java
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
        ```
   1. 模拟器截图

        ![first homework](https://img-blog.csdnimg.cn/20190323103026560.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjQ3OTEzNA==,size_16,color_FFFFFF,t_70)

1. 创建自定义布局的AlertDialog
    
   ![second](https://img-blog.csdnimg.cn/20190323100946495.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjQ3OTEzNA==,size_16,color_FFFFFF,t_70)
   
   1. 关键代码

        alertdialog.xml
        ```xml
        <ImageView
            android:src="@drawable/tu"
            android:layout_width="match_parent"
            android:layout_height="64dp"
            android:scaleType="center"
            android:background="#FFFFBB33"
            android:contentDescription="@string/app_name" />
        <EditText
            android:id="@+id/editText2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:ems="10"
            android:hint="Username"
            android:inputType="textPersonName" />
        <EditText
            android:id="@+id/editText4"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:ems="10"
            android:hint="Password"
            android:inputType="textPassword" />
        ```
        alertdialog.java
        ```java
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
        ```
   1. 模拟器截图
   
        ![second homework](https://img-blog.csdnimg.cn/20190323103414996.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjQ3OTEzNA==,size_16,color_FFFFFF,t_70)

1. 使用XML定义菜单

    ![third](https://img-blog.csdnimg.cn/20190323101258434.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjQ3OTEzNA==,size_16,color_FFFFFF,t_70)

   1. 关键代码
   
        xml_show.xml
        ```xml
        <TextView
            android:id="@+id/textview"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="TextView" />
        ```
        xml_menu.xml
        ```xml
        <menu xmlns:android="http://schemas.android.com/apk/res/android">
            <item
                android:title="字体大小"
                >
                <!--字体大小菜单组-->
                <menu>
                    <group >
                        <item
                            android:id="@+id/font_10"
                            android:title="小"/>
                        <item
                            android:id="@+id/font_16"
                            android:title="中"/>
                        <item
                            android:id="@+id/font_20"
                            android:title="大"/>
                    </group>
                </menu>
            </item>
            <!--普通菜单项-->
            <item
                android:id="@+id/plain_item"
                android:title="普通菜单项"/>
            <!--字体颜色菜单组-->
            <item
                android:title="字体颜色"
                >
                <menu>
                    <group>
                        <item
                            android:id="@+id/font_red"
                            android:title="红色" />
                        <item
                            android:title="黑色"
                            android:id="@+id/font_black"/>
                    </group>
                </menu>
            </item>
        </menu>
        ```
        xml.menu.java
        ```java
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
        ```
   1. 模拟器截图

        ![third homework-1](https://img-blog.csdnimg.cn/20190323103859556.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjQ3OTEzNA==,size_16,color_FFFFFF,t_70)
        ![third homework-2](https://img-blog.csdnimg.cn/20190323103939637.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjQ3OTEzNA==,size_16,color_FFFFFF,t_70)
        ![third homework-3](https://img-blog.csdnimg.cn/20190323104013874.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjQ3OTEzNA==,size_16,color_FFFFFF,t_70)
        ![third homework-4](https://img-blog.csdnimg.cn/20190323104031358.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjQ3OTEzNA==,size_16,color_FFFFFF,t_70)

1. 创建上下文操作模式(ActionMode)的上下文菜单

    ![forth](https://img-blog.csdnimg.cn/20190323101427928.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjQ3OTEzNA==,size_16,color_FFFFFF,t_70)

   1. 关键代码

        actionmode_list.xml
        ```xml
         <ImageView
            android:id="@+id/imageView1"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:src="@mipmap/ic_launcher_round" />
        <TextView
            android:id="@+id/textView1"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:textColor="#000000"
            android:layout_marginTop="15dp"
            android:layout_marginLeft="10dp"
            android:textStyle="bold" />
        ```
        actionmode_main.xml
        ```xml
        <ListView
            android:id="@android:id/list"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_centerVertical="true"
            android:choiceMode="multipleChoice">
        </ListView>
        ```
        actionmode.xml
        ```xml
        <menu xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        tools:context="com.example.contextmenu.MainActivity" >
            <item
                android:id="@+id/delete"
                android:icon="@android:drawable/ic_menu_delete"
                android:title="Delete"
                android:titleCondensed="Delete"
                >
            </item>
        </menu>
        ```
        actionMode.java
        ```java
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
        ```
   1. 模拟器截图

        ![forth homework](https://img-blog.csdnimg.cn/20190323104848633.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjQ3OTEzNA==,size_16,color_FFFFFF,t_70)
    
1. 主界面

    ![main](https://img-blog.csdnimg.cn/20190323105004451.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl80MjQ3OTEzNA==,size_16,color_FFFFFF,t_70)