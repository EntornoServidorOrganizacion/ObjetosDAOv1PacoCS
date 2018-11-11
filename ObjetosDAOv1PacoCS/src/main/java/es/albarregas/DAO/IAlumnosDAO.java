/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import es.albarregas.beans.Alumno;
import java.util.ArrayList;

/**
 *
 * @author paco
 */
public interface IAlumnosDAO {
    public ArrayList<Alumno> getAlumnos(String where);
    public ArrayList<Alumno> getAlumnosEquipo();
    public void closeConnection();
}
