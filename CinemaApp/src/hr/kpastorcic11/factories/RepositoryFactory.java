/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.kpastorcic11.factories;

import hr.kpastorcic11.repositories.interfaces.AuthRepositry;
import hr.kpastorcic11.repositories.interfaces.MoviesRepository;
import hr.kpastorcic11.repositories.interfaces.UsersRepository;
import hr.kpastorcic11.repositories.sql.MSqlAuthRepository;
import hr.kpastorcic11.repositories.sql.MSqlMoviesRepository;
import hr.kpastorcic11.repositories.sql.MSqlUsersRepository;


/**
 *
 * @author islan
 */
public class RepositoryFactory {

    public static MoviesRepository getMoviesRepository() {
        return new MSqlMoviesRepository();
    }
    
    private RepositoryFactory() {
    }
    
    public static AuthRepositry getAuthRepository() {
        return new MSqlAuthRepository();
    }

    public static UsersRepository getUsersRepository(){
        return new MSqlUsersRepository();
    }
}
