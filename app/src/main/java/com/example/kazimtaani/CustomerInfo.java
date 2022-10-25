package com.example.kazimtaani;

public class CustomerInfo {
    String Email;
    String Password;
    String ConfirmPassword;
    String Username;
    String Mobile;
    String Location;
    public CustomerInfo(){
        //required for calls to DataSnapshot.getValue(User.class
    }

    public CustomerInfo(String email, String password) {
        Email = email;
        Password = password;
    }

    public CustomerInfo(String confirmPassword, String username, String mobile, String location) {
        ConfirmPassword = confirmPassword;
        Username = username;
        Mobile = mobile;
        Location = location;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public String getUsername() {
        return Username;
    }

    public String getMobile() {
        return Mobile;
    }

    public String getLocation() {
        return Location;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public void setLocation(String location) {
        Location = location;
    }
}

