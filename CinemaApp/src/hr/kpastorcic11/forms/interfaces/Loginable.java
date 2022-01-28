/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hr.kpastorcic11.forms.interfaces;

import hr.kpastorcic11.roles.User;
import java.util.Optional;

/**
 *
 .interfaces* @author islan
 */
public interface Loginable {
    void Login(Optional<User> user);
}
