package com.akvelon.myfirstapp.lesson8.models;

import androidx.databinding.Bindable;

public class DataBindingUserInfo {

    private String firstName;
    private String lastName;

    public DataBindingUserInfo(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
