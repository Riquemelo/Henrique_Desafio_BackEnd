/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.SQLException;
import java.util.Scanner;

public class mainClass {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) throws SQLException{
        boolean control = true;
        String errorMessage = null;
        String controlString = "";
        Scanner leitor = new Scanner(System.in);
        System.out.println("Deseja inserir algum valor na base de dados?(S/n)");
        controlString = leitor.next();
        switch(controlString.toUpperCase()){
                case "S": 
                    control = true;
                break;
                case "N": 
                    control = false;
                break;
            }
        while(control){
            System.out.println("Insira valores na base de dados");
            System.out.println("Id da conta:");
            int id = leitor.nextInt();
            System.out.println("Cpf ou Cnpj do proprietario da conta: ");
            String cpfCnpj = leitor.next();
            System.out.println("Nome do proprietario da conta: ");
            String nome = leitor.next();
            System.out.println("A conta esta ativa?(S/n)");
            String ativoString = leitor.next();
            boolean ativo = false;
            switch(ativoString.toUpperCase()){
                case "S": 
                    ativo = true;
                    break;
                case "N": 
                    ativo = false;
                    break;
            }
            System.out.println("Valor total disponivel na conta:");
            double valor = leitor.nextDouble();
            
            
            try{
                CustomerAccount.addCustomer(id, cpfCnpj, nome, ativo, valor);
            }catch (Exception ex){
                errorMessage = ex.getMessage();
            }
            
            
            System.out.println("Deseja inserir outra conta?(S/n):");
            controlString = leitor.next();
            switch(controlString.toUpperCase()){
                case "S": 
                    control = true;
                break;
                case "N": 
                    control = false;
                break;
            }
        }
        double media = CustomerAccount.getCustomerAccount();
        System.out.println("Média dos valores:" + media);
    } 
    
}
