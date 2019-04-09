package com.akvelon.myfirstapp.lesson6.room;

import android.view.View;
import android.widget.TextView;

import com.akvelon.myfirstapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RoomDatabaseItemsHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.db_row_id_tv) TextView idTextView;
    @BindView(R.id.db_row_name_tv) TextView nameTextView;
    @BindView(R.id.db_row_age_tv) TextView ageTextView;

    public RoomDatabaseItemsHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(@NonNull RoomUserInfo userInfo) {
        idTextView.setText(String.valueOf(userInfo.getId()));
        nameTextView.setText(userInfo.getName());
        ageTextView.setText(String.valueOf(userInfo.getAge()));
    }

}
