/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

import clases.Depositar;
import clases.Retirar;

/**
 *
* @author Israel Nava Reyes y Luis Arturo Tapia Reyes
 */
public class consultar { //Proceso para hacer una consulta
    
    private Retirar banco; // Función privada para retirar
    private Depositar bancos; //Función privada para depositar
    
   public consultar(){ //vincular las funciones con las clases e importarlas a la consulta
       banco = new Retirar();
       bancos = new Depositar();
       
   }
   //Función que permite al cliente depositar
   public void clienteDepositando(String nombre, String numero_cuenta, String periodo, int saldo_actual, int cantidad_depositada){
       bancos.estado(nombre, numero_cuenta, periodo, saldo_actual, cantidad_depositada);

   }
   //Función que permite al cliente retirar
   public void clienteRetirando(String nombre, String numero_cuenta, String periodo, int saldo_actual, int cantidad_retirada){
       banco.estado(nombre, numero_cuenta, periodo, saldo_actual, cantidad_retirada);

   }
   
}

