package com.akvelon.myfirstapp.lesson2.recyclerview;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import com.akvelon.myfirstapp.R;
import com.akvelon.myfirstapp.lesson2.intents.ColorInfo;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class ColorInfoHolder extends RecyclerView.ViewHolder {

    private View colorView;

    private TextView textView;

    private ColorInfoAdapter.OnColorClick clickListener;

    public ColorInfoHolder(@NonNull View v, ColorInfoAdapter.OnColorClick clickListener) {
        super(v);
        this.clickListener = clickListener;
        colorView = v.findViewById(R.id.vColor);
        textView = v.findViewById(R.id.tvColorName);
    }

    public void setInfo(ColorInfo colorInfo) {
        itemView.setOnClickListener(v -> clickListener.onColorClick(colorInfo));
        colorView.setBackgroundColor(ContextCompat.getColor(itemView.getContext(), colorInfo.colorRes));
        textView.setText(colorInfo.colorName);
    }

}
