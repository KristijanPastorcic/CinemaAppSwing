/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package hr.kpastorcic11.roles.enums;

/**
 *
 * @author islan
 */
public enum Role {
    
    USER("User"), ADMIN("Admin");
    
    private final String role;
    
    Role(String role){
        this.role = role;
    }

    @Override
    public String toString() {
        return role;
    }
    
    
}
