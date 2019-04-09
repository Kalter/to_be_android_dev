package com.akvelon.myfirstapp.lesson6.sqlite;

import android.provider.BaseColumns;

public final class UsersInfoContract {

    private UsersInfoContract() {
    }

    public static class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "users";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_AGE = "age";
    }
}
