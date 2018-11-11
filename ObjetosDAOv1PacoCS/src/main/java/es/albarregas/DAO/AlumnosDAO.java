/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import es.albarregas.beans.Alumno;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author paco
 */
public class AlumnosDAO implements IAlumnosDAO {

    @Override
    public ArrayList<Alumno> getAlumnos(String limit) {
        ArrayList<Alumno> lista = new ArrayList();
        String consulta = "select nombre, grupo from alumnos " + limit;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);

            while (resultado.next()) {
                Alumno alumno = new Alumno();
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setGrupo(resultado.getString("grupo"));
                lista.add(alumno);
            }

            resultado.close();

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentecnia");
            ex.printStackTrace();
        }

        return lista;
    }

    @Override
    public void closeConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Alumno> getAlumnosEquipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
