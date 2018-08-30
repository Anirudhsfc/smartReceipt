package com.anirudh.android.smartreceipt.User;

public class User {


    public String octopus;
    public String email;
    public String password;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String octopus, String email,String password  ) {
        this.octopus= octopus;
        this.email = email;
        this.password=password;
    }

}
