package com.akvelon.myfirstapp.lesson6.room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akvelon.myfirstapp.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RoomDatabaseItemsAdapter extends RecyclerView.Adapter<RoomDatabaseItemsHolder> {

    private List<RoomUserInfo> usersInfo = new ArrayList<>();

    @NonNull
    @Override
    public RoomDatabaseItemsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_db_row, parent, false);
        return new RoomDatabaseItemsHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomDatabaseItemsHolder holder, int position) {
        holder.setData(usersInfo.get(position));
    }

    @Override
    public int getItemCount() {
        return usersInfo.size();
    }

    public void setData(@NonNull List<RoomUserInfo> usersInfo) {
        this.usersInfo = usersInfo;
        notifyDataSetChanged();
    }
}
