/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.kpastorcic11.accounts;

import hr.kpastorcic11.roles.User;
import hr.kpastorcic11.factories.RepositoryFactory;
import hr.kpastorcic11.repositories.interfaces.AuthRepositry;
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
