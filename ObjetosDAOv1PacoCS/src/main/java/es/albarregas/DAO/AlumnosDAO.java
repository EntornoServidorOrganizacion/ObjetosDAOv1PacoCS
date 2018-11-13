/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.DAO;

import es.albarregas.beans.Alumno;
import es.albarregas.beans.Equipo;
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
        //Esto jamás en la vida me puede devolver un resultSet
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

        return lista;//no retorna nunca null porque ya he asignado un new ArrayList. En el controlador hay que preguntar si el arrayList está vacia
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConexion();
    }

    @Override
    public ArrayList<Alumno> getAlumnosEquipo() {
        ArrayList<Alumno> lista = new ArrayList();
        String consulta = "Select a.nombre, a.grupo, e.marca, e.idEquipo from alumnos as a inner join equipos as e using(idEquipo)";
        //Esto jamás en la vida me puede devolver un resultSet 
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);

            while (resultado.next()) {
                Alumno alumno = new Alumno();
                alumno.setNombre(resultado.getString("nombre"));
                alumno.setNombre(resultado.getString("grupo"));
                Equipo equipo = new Equipo();
                equipo.setMarca(resultado.getString("marca"));
                equipo.setIdEquipo(resultado.getInt("idEquipo"));
                alumno.setEquipo(equipo);
                lista.add(alumno);
            }

            resultado.close();

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentecnia");
            ex.printStackTrace();
        }

        return lista;
    }

}
