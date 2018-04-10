/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Henrique
 */
public class Conexao {
    private static Connection connection;
    private static Exception connectionException;
        
    public static Connection getConnection(){
        if(connection == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/database","root","");
                connectionException = null;
            }catch(Exception ex){
                connection = null;
                connectionException = ex;
            }
        }
        return connection;
    }
    public static Exception getConnectionException(){
        return connectionException;
    }
}
