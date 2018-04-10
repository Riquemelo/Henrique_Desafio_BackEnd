
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Henrique
 */
public class CustomerAccount {
   private int id;
   private String cpfCnpj;
   private String nome;
   private boolean ativo;
   private double valor; 


    public static void addCustomer(int id, String cpfCnpj, String nome, boolean ativo, double valor)throws Exception{
        String SQL = "INSERT INTO tb_customer_account VALUES("
                + "?,?,?,?,?)";
        PreparedStatement s;
        s = Conexao.getConnection().prepareStatement(SQL);
        s.setInt(1, id);
        s.setString(2, cpfCnpj);
        s.setString(3, nome);
        s.setBoolean(4, ativo);
        s.setDouble(5, valor);
        s.execute();
        s.close();
    }
    public static double getCustomerAccountValue() throws SQLException {
      String SQL = "SELECT AVG(vl_total) FROM tb_customer_account"
              + " WHERE vl_total > 560"
              + " AND id_customer BETWEEN 1500 AND 2700";
      PreparedStatement s = null;
      try{
      s = Conexao.getConnection().prepareStatement(SQL);
      }catch (Exception ex){
          System.out.println(Conexao.getConnectionException());
      }
      ResultSet rs = s.executeQuery();
      double cA = 0;
      if (rs.next()) {
         cA = rs.getDouble(1);
      }
      rs.close();
      s.close();
      return cA;
   }
    
   public static void getCustomerAccount() throws SQLException {
      String SQL = "SELECT * FROM tb_customer_account"
              + " WHERE vl_total > 560"
              + " AND id_customer BETWEEN 1500 AND 2700";
      PreparedStatement s = null;
      try{
      s = Conexao.getConnection().prepareStatement(SQL);
      }catch (Exception ex){
          System.out.println(Conexao.getConnectionException());
      }
      ResultSet rs = s.executeQuery();
      String isActive;
      while (rs.next()) {
          if(rs.getBoolean("is_active")){
              isActive = "Sim";
          }else{
              isActive = "Não";
          } 
          System.out.println(rs.getInt("id_customer") + " | "
          + rs.getString("cpf_cnpj") + " | "
          + rs.getString("nm_customer") + " | "
          + isActive + " | "
          + rs.getDouble("vl_total"));
      }
      rs.close();
      s.close();
   }
    
}
