package com.akvelon.myfirstapp.lesson2.recyclerview;

import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akvelon.myfirstapp.R;
import com.akvelon.myfirstapp.lesson2.intents.ColorInfo;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class ColorInfoAdapter extends RecyclerView.Adapter<ColorInfoHolder> {

    private List<ColorInfo> colorInfoArray;

    private OnColorClick clickListener;

    public ColorInfoAdapter(List<ColorInfo> colorInfoArray, OnColorClick clickListener) {
        this.colorInfoArray = colorInfoArray;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ColorInfoHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_color_info, viewGroup, false);
        return new ColorInfoHolder(v, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorInfoHolder colorInfoHolder, int i) {
        colorInfoHolder.setInfo(colorInfoArray.get(i));
    }

    @Override
    public int getItemCount() {
        return colorInfoArray.size();
    }

    public void setColorInfoArray(List<ColorInfo> colorInfoArray) {
        this.colorInfoArray = colorInfoArray;
    }

    public interface OnColorClick {
        void onColorClick(@NonNull ColorInfo colorInfo);
    }
}
