package com.akvelon.myfirstapp.lesson6;

import android.view.View;
import android.widget.TextView;

import com.akvelon.myfirstapp.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DatabaseItemsHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.db_row_id_tv) TextView idTextView;
    @BindView(R.id.db_row_name_tv) TextView nameTextView;
    @BindView(R.id.db_row_age_tv) TextView ageTextView;

    public DatabaseItemsHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setData(@NonNull UserInfo userInfo) {
        idTextView.setText(String.valueOf(userInfo.getId()));
        nameTextView.setText(userInfo.getName());
        ageTextView.setText(String.valueOf(userInfo.getAge()));
    }

}
