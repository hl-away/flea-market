package com.fleamarket.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.fleamarket.objects.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * User: hl-away
 * Date: 12.10.13
 */
public class CategoryDAO {
    public static final String TABLE_NAME = "category";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ITEMS_COUNT = "itemsCount";
    public static final String COLUMN_PARENT_CATEGORY_ID = "parentCategoryId";

    public static final String[] COLUMNS = {COLUMN_ID, COLUMN_NAME, COLUMN_ITEMS_COUNT, COLUMN_PARENT_CATEGORY_ID};

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT NOT NULL, " +
                    COLUMN_ITEMS_COUNT + " INTEGER DEFAULT 0," +
                    COLUMN_PARENT_CATEGORY_ID + " INTEGER DEFAULT 0);";

    private SQLiteDatabase database;

    public CategoryDAO(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    private Category cursorToCategory(Cursor cursor) {
        return new Category(cursor.getLong(0), cursor.getString(1), cursor.getInt(2), cursor.getLong(3));
    }

    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<Category>();
        Cursor cursor = database.query(TABLE_NAME, COLUMNS, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Category category = cursorToCategory(cursor);
            categories.add(category);
            cursor.moveToNext();
        }
        cursor.close();
        return categories;
    }

    public Category createCategory(Category category) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, category.getName());
        values.put(COLUMN_ITEMS_COUNT, category.getItemsCount());
        values.put(COLUMN_PARENT_CATEGORY_ID, category.getParentCategoryId());

        long insertId = database.insert(TABLE_NAME, null, values);
        Cursor cursor = database.query(TABLE_NAME, COLUMNS, COLUMN_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Category newCategory = cursorToCategory(cursor);
        cursor.close();
        return newCategory;
    }
}
