package com.akvelon.myfirstapp.lesson6.sqlite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akvelon.myfirstapp.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DatabaseItemsAdapter extends RecyclerView.Adapter<DatabaseItemsHolder> {

    private List<UserInfo> usersInfo = new ArrayList<>();

    @NonNull
    @Override
    public DatabaseItemsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_db_row, parent, false);
        return new DatabaseItemsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DatabaseItemsHolder holder, int position) {
        holder.setData(usersInfo.get(position));
    }

    @Override
    public int getItemCount() {
        return usersInfo.size();
    }

    public void setData(@NonNull List<UserInfo> usersInfo) {
        this.usersInfo = usersInfo;
        notifyDataSetChanged();
    }
}
