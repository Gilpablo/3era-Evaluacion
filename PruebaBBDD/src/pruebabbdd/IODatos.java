/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebabbdd;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author daw-B
 */
public class IODatos {
    
    private static String URL = "jdbc:mysql://34.229.80.204:3306/programacion";
    private static String USER = "pepe";
    private static String PASS = "pepe";

    
    public static ArrayList<Alumno> cargarDatosBBDD(){
        ArrayList<Alumno> vAlumnos = new ArrayList<Alumno>();

        try (Connection con =  DriverManager.getConnection(URL, USER, PASS);){
        
            String sentencia = "SELECT * FROM alumno;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sentencia);
            
            while (rs.next()) {                
                vAlumnos.add(new Alumno(rs.getString(1), rs.getInt(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
        }

            return vAlumnos;
    }
    
   

    public static void guadarDatosBBDD(Alumno alum) {


        try (Connection con = DriverManager.getConnection(URL, USER, PASS);) {

            String sentencia = "Insert into alumno values(?,?,?,null)";

            PreparedStatement ps = con.prepareStatement(sentencia);

            ps.setString(1, alum.getNombre());
            ps.setInt(2, alum.getEdad());
            ps.setString(3, alum.getDireccion());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    public static void actualizarDatosBBDD() {
        
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);){
            
            String sentencia = "update alumno set direccion = ? where nombre = ?";

            PreparedStatement ps = con.prepareStatement(sentencia);

            ps.setString(1, "Donde puedo");
            ps.setString(2, "Gil Pablo");
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(IODatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
}

    


