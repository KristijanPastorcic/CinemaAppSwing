/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.kpastor11.factories;

import hr.kpastor11.repositories.interfaces.AuthRepositry;
import hr.kpastor11.repositories.interfaces.UsersRepository;
import hr.kpastor11.repositories.sql.MSqlAuthRepository;
import hr.kpastor11.repositories.sql.MSqlUsersRepository;


/**
 *
 * @author islan
 */
public class RepositoryFactory {
    
    private RepositoryFactory() {
    }
    
    public static AuthRepositry getAuthRepository() {
        return new MSqlAuthRepository();
    }

    public static UsersRepository getUsersRepository(){
        return new MSqlUsersRepository();
    }
}
