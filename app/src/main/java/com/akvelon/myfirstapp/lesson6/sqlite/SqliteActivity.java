package com.akvelon.myfirstapp.lesson6.sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.akvelon.myfirstapp.R;
import com.akvelon.myfirstapp.lesson6.DatabaseItemsAdapter;
import com.akvelon.myfirstapp.lesson6.UserInfo;
import com.akvelon.myfirstapp.lesson6.sqlite.UsersInfoContract.UserEntry;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.text.TextUtils.isEmpty;

public class SqliteActivity extends Activity {

    @BindView(R.id.name_et) TextView nameText;
    @BindView(R.id.age_et) TextView ageText;
    @BindView(R.id.db_rv) RecyclerView databaseRecyclerView;

    private DatabaseItemsAdapter databaseItemsAdapter;
    private UsersInfoDbHelper usersInfoDbHelper;

    public static void start(@NonNull Context context) {
        context.startActivity(new Intent(context, SqliteActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_db_example);
        ButterKnife.bind(this);

        usersInfoDbHelper = new UsersInfoDbHelper(this);

        databaseItemsAdapter = new DatabaseItemsAdapter();
        databaseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        databaseRecyclerView.setAdapter(databaseItemsAdapter);
    }

    @Override
    protected void onDestroy() {
        usersInfoDbHelper.close();
        super.onDestroy();
    }

    @OnClick(R.id.add_user_to_db_btn)
    void addUserToDb() {
        if (isEmpty(nameText.getText()) || isEmpty(ageText.getText())) {
            return;
        }
        final SQLiteDatabase db = usersInfoDbHelper.getWritableDatabase();

        final ContentValues values = new ContentValues();
        values.put(UserEntry.COLUMN_NAME, nameText.getText().toString());
        values.put(UserEntry.COLUMN_AGE,
                Integer.valueOf(ageText.getText().toString()));

        try {
            long newRowId = db.insertOrThrow(UserEntry.TABLE_NAME, null, values);
            nameText.setText("");
            ageText.setText("");
            Toast.makeText(this, "Created new user with id: " + newRowId, Toast.LENGTH_SHORT).show();
        } catch (SQLException e) {
            Log.e(SqliteActivity.class.getName(), e.getMessage());
        }
    }

    @OnClick(R.id.read_db_btn)
    void readDatabase() {
        SQLiteDatabase db = usersInfoDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                UserEntry.COLUMN_NAME,
                UserEntry.COLUMN_AGE
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                UserEntry._ID + " ASC";

        Cursor cursor = db.query(
                UserEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        final List<UserInfo> users = readUsersFromCursor(cursor);
        cursor.close();
        databaseItemsAdapter.setData(users);
    }

    @OnClick(R.id.read_db_with_filter_btn)
    void readDatabaseWithFilter() {
        SQLiteDatabase db = usersInfoDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                UserEntry.COLUMN_NAME,
                UserEntry.COLUMN_AGE
        };

        // Filter results WHERE "age" = '10'
        String selection = UserEntry.COLUMN_AGE + " > ?";
        String[] selectionArgs = {"10"};

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                UserEntry._ID + " ASC";

        Cursor cursor = db.query(
                UserEntry.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        final List<UserInfo> users = readUsersFromCursor(cursor);
        cursor.close();
        databaseItemsAdapter.setData(users);
    }

    @OnClick(R.id.read_db_btn)
    void readDatabaseRawQuery() {
        SQLiteDatabase db = usersInfoDbHelper.getReadableDatabase();

        final String query = "SELECT " + UserEntry._ID + ", "
                + UserEntry.COLUMN_NAME + ", "
                + UserEntry.COLUMN_AGE
                + " FROM " + UserEntry.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        final List<UserInfo> users = readUsersFromCursor(cursor);
        cursor.close();
        databaseItemsAdapter.setData(users);
    }

    private List<UserInfo> readUsersFromCursor(@NonNull Cursor cursor) {
        final List<UserInfo> users = new ArrayList<>();
        while (cursor.moveToNext()) {
            long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(UserEntry._ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(UserEntry.COLUMN_NAME));
            int age = cursor.getInt(cursor.getColumnIndexOrThrow(UserEntry.COLUMN_AGE));
            users.add(new UserInfo(itemId, name, age));
        }
        return users;
    }

}
