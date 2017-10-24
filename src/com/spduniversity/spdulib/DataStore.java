package com.spduniversity.spdulib;

import com.spduniversity.spdulib.entity.Item;
import com.spduniversity.spdulib.entity.User;
import com.spduniversity.spdulib.entity.UserItem;

public class DataStore {
    private static final int TOTAL_USER_COUNT = 10;
    private static final int ITEM_TYPES_COUNT = 2;

    private User[] users = new User[TOTAL_USER_COUNT];
    private Item[][] items = new Item[ITEM_TYPES_COUNT][TOTAL_USER_COUNT];  // Our library
    private UserItem[] userItems = new UserItem[ITEM_TYPES_COUNT*TOTAL_USER_COUNT]; // User has some items
}
