/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hr.kpastorcic11.roles;

/**
 *
 * @author islan
 */
public class User {
    
    private final int id;
    private final String loginName;
    private final String password;

    public User(int id, String loginName, String password) {
        this.id = id;
        this.loginName = loginName;
        this.password = password;
    }

    public User(String loginName, String password) {
        this(0, loginName, password);
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }
    
    
}
