package com.userLogin.model;

public class UserInformationRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String state;
    private String city;
    private String phone;
    private String address;
    private String username;

    public UserInformationRequest(String firstname, String lastname, String email, String state, String city, String phone, String address, String username) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.state = state;
        this.city = city;
        this.phone = phone;
        this.address = address;
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserInformation toUserInformation(){
        return new UserInformation(null,this.firstname,this.lastname,this.email,this.state,this.city,this.phone,this.address,null);
    }
}
