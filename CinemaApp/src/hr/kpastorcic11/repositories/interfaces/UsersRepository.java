/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hr.kpastorcic11.repositories.interfaces;

import hr.kpastorcic11.roles.User;

/**
 *
 * @author islan
 */
public interface UsersRepository {

    User getUser(int id) throws Exception;

}
