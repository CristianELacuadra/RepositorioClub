/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.ProyectoClub.Persistencia.Dao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface Caption {
    String value();
}
