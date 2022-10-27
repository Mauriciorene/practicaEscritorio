/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import java.util.*;
 /* @author Mauricio Rubio
 */

public class DataBase {
    //Cadena de conexión de la BD
    private final String URL="jdbc:sqlserver://localhot:1433;databaseName=PRESTAMOS;"+
            "integratedSecurity=true;"+"encrypt=true;trustServerCentificate=true;";
    
    private Connection conexion; //para conexión con la BD
    
    public DataBase() { //Constructor de la clase
        try{
         //Usando Driver conector y cadena de conexión para conetar BD
         conexion=DriverManager.getConnection(URL);
         System.out.println("Conexión Establecida");
         
        }catch(SQLException e){
            System.out.println("Error de Conexión");
            e.printStackTrace();
            
        //Método para actualizar datos en la BD
        public int Actualizar(String consulta) {
            
        try{ //para manejar errores al realizar la conexión y transaccion en BD
            Statement st=conexion.createStatement();
            return st.executeUpdate(consulta);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
               
    }
}
