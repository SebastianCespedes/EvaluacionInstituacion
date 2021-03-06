/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Conexion {
     private static Connection conexion = null;
    // variable estatica local.

    private static void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //  trae la libreria para poder realizar la conexion.
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/evaluacion", "root", "");
            // la conexion tomara la direccion donde se encuentra la base de datos, la base de datos
            // el usuario que usa la base de datos y el password de la misma
            // en pocas palabras toma la direccion de la base de datos.
        } catch (SQLException e) {
            System.out.println("Error de MySQL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        } 
    }

    private Conexion() {
        
    }
// Patron singleton
    public static Connection getInstance() {
        if (conexion == null) {
            conectar();
        }
        return conexion;
    }
}
