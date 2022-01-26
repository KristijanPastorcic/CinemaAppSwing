/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hr.kpastor11.forms.interfaces;

import hr.kpastor11.roles.User;
import java.util.Optional;

/**
 *
 * @author islan
 */
public interface Registrable {
    void userRegistered(Optional<User> userOptional);
}
