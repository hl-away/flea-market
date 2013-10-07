package com.hlaway;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FleaMarketActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

        String[] texts = { "sometext 1", "sometext 2", "sometext 3",
                "sometext 4", "sometext 5" };
        Map<String, Object> m;
        for (String text : texts) {
            m = new HashMap<String, Object>();
            m.put("text", text);
            data.add(m);
        }

        // массив имен атрибутов, из которых будут читаться данные
        String[] from = { "text" };
        // массив ID View-компонентов, в которые будут вставлять данные
        int[] to = { R.id.item_title };
        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.menu_item, from, to);
        ListView lv = (ListView) this.findViewById(R.id.main_menu);
        lv.setAdapter( adapter );
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add("menu1");
        menu.add("menu2");
        menu.add("menu3");
        menu.add("menu4");

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
