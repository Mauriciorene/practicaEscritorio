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
        }
    }    
            
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
        
private List OrganizarDatos (ResultSet rs){
    List filas=new ArrayList(); //Arreglo de elementos
    try{
        
        int numColumnas=rs.getMetaData() .getColumnCount();
        while(rs.next()) { //Recorre cada registro de la tabla
            Map<String, Object> renglon=new HashMap();
            for (int i=1; i<=numColumnas; i++){
                //se obtine nombre  de campo en la BD
                String nombreCampo=rs.getMetaData() .getColumnName(i);
                Object valor=rs.getObject(nombreCampo);
                //Por cada campo, se obtiene el nombre y el valor del mismo
                renglon.put(nombreCampo,valor);
            }
            filas.add(renglon);//se agrega al arreglo cada registro
        }   
    }catch(SQLException e){
        e.printStackTrace();
    }
    return filas;
    
    public List Listar(String consulta){
        ResultSet rs=null;
        List resultado=new ArrayList();
        try{
            Statement st=conexion.createStatement();
            rs=st.executeQuery(consulta);
            resultado=OrganizarDatos(rs);
            
        }catch(SQLException e){
            System.out.println("No se realizó la consulta");
            e.printStackTrace();
        }
        return resultado;
    
    public boolean ejecutarProcedimento (string nombre){
        try{
            CallableStatement cs=conexion.prepareCall("{call"+nombre+"}");
            return cs.execute();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
