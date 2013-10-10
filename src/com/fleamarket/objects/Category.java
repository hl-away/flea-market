package com.fleamarket.objects;

import android.R;

import java.util.*;

/**
 * User: hl-away
 * Date: 10.10.13
 * Time: 23:06
 */
public class Category {
    private int id = 0;
    private String name;
    private int itemsCount = 0;
    private int parentCategoryId;

    public Category(String name, int itemsCount) {
        this.name = name;
        this.itemsCount = itemsCount;
        this.parentCategoryId = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(int parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public static String[] getParametersList() {
        return new String[]{ "itemsCount", "name" };
    }

    public Map<String, Object> getViewMap() {
        Map<String, Object> parametersMap = new HashMap<String, Object>();
        parametersMap.put("name", name);
        parametersMap.put("itemsCount", itemsCount);
        return parametersMap;
    }
}
