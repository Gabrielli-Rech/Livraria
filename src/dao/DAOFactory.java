package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
public class DAOFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/mundodoslivros=convertToNull";
    private static final String USER = "root";
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String SENHA = "";
    
    public static void executar(String query){
        try{
            Class.forName(DRIVER);
            Connection conn = (Connection) DriverManager.getConnection(URL,USER,SENHA);
            Statement st = (Statement) conn.createStatement();
            st.execute();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    //public static ResultSet consultar(String query){
        //try{
            //Class.forName(DRIVER);
            //Connection conn = (Connection) DriverManager.getConnection(URL,USER,SENHA);
            //Statement st = (Statement) conn.createStatement();
            //ResultSet rs = st.execute();
            
            //return rs;
        //} catch ( Exception e) {
            //JOptionPane.showMessageDialog(null, e.toString());
            //return null;
        //}
    //}
}
