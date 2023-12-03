/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectpl2;

/**
 *
 * @author user
 */
public class User {

 private final int id;
 private final String name;
 private String email;
 private String password;
  private final String role;
  User(int id, String name,String email, String password, String role){
  this.id=id;
  this.name=name;
  this.email=email;
  this.password=password;
  this.role=role;}
  
  public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    
     public String getpassword(){
     return this.password;
     }
      public String getrole(){
      return this.role; }
      
      public String getemail(){
     return this.email;
     }
   public void setemail(String email){
       this.email=email;
   }
    public void setpassword(String password){
       this.password=password;
}
}
