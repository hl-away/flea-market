package com.fleamarket.objects;

import com.fleamarket.db.CategoryDAO;

import java.util.*;

/**
 * User: hl-away
 * Date: 10.10.13
 */
public class Category {
    private long id = 0;
    private String name;
    private long itemsCount = 0;
    private long parentCategoryId;

    public Category(long id, String name, int itemsCount, long parentCategoryId) {
        this.id = id;
        this.name = name;
        this.itemsCount = itemsCount;
        this.parentCategoryId = parentCategoryId;
    }

    public Category(String name, int itemsCount) {
        this.name = name;
        this.itemsCount = itemsCount;
        this.parentCategoryId = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(long parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public long getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    public static String[] getParametersList() {
        return new String[]{ CategoryDAO.COLUMN_ITEMS_COUNT, CategoryDAO.COLUMN_NAME };
    }

    public Map<String, Object> getViewMap() {
        Map<String, Object> parametersMap = new HashMap<String, Object>();
        parametersMap.put(CategoryDAO.COLUMN_NAME, name);
        parametersMap.put(CategoryDAO.COLUMN_ITEMS_COUNT, itemsCount);
        return parametersMap;
    }
}
