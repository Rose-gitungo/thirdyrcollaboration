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
    public CustomerInfo(String Email,String Password,String ConfirmPassword, String Username,String Mobile,String Location){
        this.Email=Email;
        this.Password=Password;
        this.ConfirmPassword=ConfirmPassword;
        this.Username=Username;
        this.Location=Location;
        this.Mobile=Mobile;

    }

}
