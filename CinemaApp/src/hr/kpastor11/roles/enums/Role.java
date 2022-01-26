/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package hr.kpastor11.roles.enums;

/**
 *
 * @author islan
 */
public enum Role {
    ADMIN("Admin"),
    USER("User");
    
    private final String role;
    
    Role(String role){
        this.role = role;
    }
}
