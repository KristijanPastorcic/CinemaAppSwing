/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package hr.kpastorcic11.roles.enums;

/**
 *
 * @author islan
 */
public enum MovieRole {
    DIRECTOR("Director"),
    ACTOR("Actor");

    private final String movieRole;

    private MovieRole(String movieRole) {
        this.movieRole = movieRole;
    }

    @Override
    public String toString() {
        return movieRole;
    }
}
