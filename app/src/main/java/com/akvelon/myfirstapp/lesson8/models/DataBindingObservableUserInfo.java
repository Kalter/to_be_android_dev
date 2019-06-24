package com.akvelon.myfirstapp.lesson8.models;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.akvelon.myfirstapp.BR;

public class DataBindingObservableUserInfo extends BaseObservable {

    private String firstName;
    private String lastName;

    public DataBindingObservableUserInfo(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Bindable
    public String getFirstName() {
        return this.firstName;
    }

    @Bindable
    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(BR.lastName);
    }
}
