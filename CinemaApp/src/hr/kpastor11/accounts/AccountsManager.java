/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.kpastor11.accounts;

import hr.kpastor11.modles.User;
import hr.kpastor11.factories.RepositoryFactory;
import hr.kpastor11.repositories.interfaces.AuthRepositry;
import java.util.Optional;

/**
 *
 * @author islan
 */
public class AccountsManager {

    private static AuthRepositry authRepositry = RepositoryFactory.getAuthRepository();

    public static Optional<Integer> login(User user) throws Exception {
        return authRepositry.login(user);
    }

    public static boolean register(User user) throws Exception {
        return authRepositry.register(user);
    }

}
