package com.akvelon.myfirstapp.lesson2.intents;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.ColorRes;

public class ColorInfo implements Parcelable {

    @ColorRes
    public final int colorRes;

    public final String colorName;

    public ColorInfo(@ColorRes int colorRes, String colorName) {
        this.colorRes = colorRes;
        this.colorName = colorName;
    }

    protected ColorInfo(Parcel in) {
        colorRes = in.readInt();
        colorName = in.readString();
    }

    public static final Creator<ColorInfo> CREATOR = new Creator<ColorInfo>() {
        @Override
        public ColorInfo createFromParcel(Parcel in) {
            return new ColorInfo(in);
        }

        @Override
        public ColorInfo[] newArray(int size) {
            return new ColorInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(colorRes);
        dest.writeString(colorName);
    }
}
