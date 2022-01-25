/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hr.kpastor11.repositories.interfaces;

import hr.kpastor11.modles.User;

/**
 *
 * @author islan
 */
public interface RoleManager {
    boolean isUserInRole(User user);
}
