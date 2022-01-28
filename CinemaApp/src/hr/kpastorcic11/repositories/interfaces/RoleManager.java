/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hr.kpastorcic11.repositories.interfaces;

import hr.kpastorcic11.roles.enums.Role;

/**
 *
 * @author islan
 */
public interface RoleManager {

    boolean isUserInRole(int idUser, Role role) throws Exception;
    
}
