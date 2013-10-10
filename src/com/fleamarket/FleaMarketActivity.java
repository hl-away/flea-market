package com.fleamarket;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import android.widget.SimpleAdapter;
import com.fleamarket.objects.Category;
import com.fleamarket.util.CategoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FleaMarketActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        List<Category> mainCategories = CategoryUtil.getMainCategories();
        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
        for (Category category : mainCategories) {
            data.add(category.getViewMap());
        }
        int[] ids = { R.id.items_count, R.id.category_name };
        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.category_layout, Category.getParametersList(), ids);
        ListView lv = (ListView) findViewById(R.id.main_categories);
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
        //Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
