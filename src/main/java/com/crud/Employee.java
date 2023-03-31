package com.crud;

public class Employee {
	
    int id;
    String name;
    String address;
    String gender;


    public void createEmployee(int id, String name, String address, String gender){
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public String getGender(){
        return this.gender;
    }

}
