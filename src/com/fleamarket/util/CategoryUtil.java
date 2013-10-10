package com.fleamarket.util;

import com.fleamarket.objects.Category;

import java.util.LinkedList;
import java.util.List;

/**
 * User: hl-away
 * Date: 10.10.13
 * Time: 23:10
 */
public class CategoryUtil {
    public static List<Category> getMainCategories() {
        List<Category> categories = new LinkedList<Category>();
        categories.add(new Category("Одежда. Обудь. Аксессуары", 23));
        categories.add(new Category("Детские товары. Игрушки", 623));
        categories.add(new Category("Монеты", 45));
        categories.add(new Category("Коллекционирование", 234));
        categories.add(new Category("Искусство. Антиквариат", 6));
        categories.add(new Category("Мобильные телефоны", 922));
        categories.add(new Category("Ноутбуки. Компьютеры. Техника", 90));
        categories.add(new Category("Авто. Мото. Вело", 32));
        categories.add(new Category("Дом. Дача. Недвижимость", 34));
        return categories;
    }
}
