package com.akvelon.myfirstapp.lesson2.recyclerview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.akvelon.myfirstapp.R;
import com.akvelon.myfirstapp.lesson2.intents.ColorDetailsInfoActivity;
import com.akvelon.myfirstapp.lesson2.intents.ColorInfo;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewActivity extends AppCompatActivity implements ColorInfoAdapter.OnColorClick {

    private List<ColorInfo> colorInfoList = new ArrayList<>();

    private ColorInfoAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_recycler_view);

        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        colorInfoList.add(new ColorInfo(android.R.color.holo_blue_dark, "Blue"));
        colorInfoList.add(new ColorInfo(android.R.color.holo_orange_light, "Orange"));
        colorInfoList.add(new ColorInfo(android.R.color.holo_green_light, "Green"));

        adapter = new ColorInfoAdapter(colorInfoList, this);
        recyclerView.setAdapter(adapter);

        findViewById(R.id.btnAddColor).setOnClickListener(v -> addPurpleColor());
    }

    @Override
    public void onColorClick(@NonNull ColorInfo colorInfo) {
        ColorDetailsInfoActivity.start(this, colorInfo);
    }

    private void addPurpleColor() {
        colorInfoList.add(new ColorInfo(android.R.color.holo_purple, "Purple"));
        adapter.notifyDataSetChanged();
    }
}
