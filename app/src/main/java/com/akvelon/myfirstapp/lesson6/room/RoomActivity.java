package com.akvelon.myfirstapp.lesson6.room;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.akvelon.myfirstapp.R;
import com.akvelon.myfirstapp.lesson6.sqlite.UsersInfoDbHelper;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.text.TextUtils.isEmpty;

public class RoomActivity extends Activity {

    @BindView(R.id.name_et) TextView nameText;
    @BindView(R.id.age_et) TextView ageText;
    @BindView(R.id.db_rv) RecyclerView databaseRecyclerView;

    private RoomDatabaseItemsAdapter databaseItemsAdapter;
    private UsersInfoDbHelper usersInfoDbHelper;

    public static void start(@NonNull Context context) {
        context.startActivity(new Intent(context, RoomActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_db_example);
        ButterKnife.bind(this);

        usersInfoDbHelper = new UsersInfoDbHelper(this);

        databaseItemsAdapter = new RoomDatabaseItemsAdapter();
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

        final UserDao userDao = AppDatabase.getInstance(this).userDao();

        AppDatabase.getInstance(this).runInTransaction(() ->
                userDao.insertAll(new RoomUserInfo(nameText.getText().toString(),
                        Integer.valueOf(ageText.getText().toString()))));

        nameText.setText("");
        ageText.setText("");
        Toast.makeText(this, "Created new user", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.read_db_btn)
    void readDatabase() {
        final UserDao userDao = AppDatabase.getInstance(this).userDao();
        final List<RoomUserInfo> users = userDao.getAll();
        databaseItemsAdapter.setData(users);
    }

    @OnClick(R.id.read_db_with_filter_btn)
    void readDatabaseWithFilter() {
        final UserDao userDao = AppDatabase.getInstance(this).userDao();
        final List<RoomUserInfo> users = userDao.loadByAges();
        databaseItemsAdapter.setData(users);
    }
}
