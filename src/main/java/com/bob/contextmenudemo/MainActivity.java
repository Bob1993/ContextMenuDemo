package com.bob.contextmenudemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"item1", "item2", "item3"});
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);//上下文菜单的呼出每一次都会被调用
       /* menu.setHeaderTitle("文件操作");
        menu.add(0, 1, Menu.NONE, "发送");//第一个是组别，第二个是数字是该组里的条目序号
        menu.add(0, 2,Menu.NONE, "删除");*///静态添加菜单项
        getMenuInflater().inflate(R.menu.menu_main, menu);//资源id易于管理，google推荐
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //获取到的是listView里的条目信息
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.mi1:
                Toast.makeText(this, "已发送" + info.id, Toast.LENGTH_SHORT).show();
                break;
            case R.id.mi2:
                Toast.makeText(this, "正在删除" + info.id, Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return true;
    }
}
