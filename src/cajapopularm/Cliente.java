/*
//Patrón de diseño 1 utilizado: Facade.
//Patrón de diseño 2 utilizada: Singleton.
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajapopularm;

import clases.Depositar;
import clases.Retirar;
import operaciones.consultar;

/**
 *
* @author Israel Nava Reyes y Luis Arturo Tapia Reyes
 */
public class Cliente {

    /**
     * Clase del cliente y su estado de cuenta, Información acerca de los movimientos a usuarios y bancos externos
     */
    public static void main(String[] args) {
       
        //Patrón de Diseño Singletón 
        //Comprobar elDeposito de banco "x" a cuenta.
        Depositar bancos = Depositar.getInstancia();
        bancos.conectar();
        
        // Se muestran todos los clientes que van a realizar alguna acción
        consultar cliente_Isra = new consultar(); //Nombre, No. Cuenta a depositar, Periodo, Saldo actual y Depósito 
        cliente_Isra.clienteDepositando("Nava Reyes Israel","2021222324252627", "01/01/2022", 10000, 3500);
        
        consultar cliente_Juan = new consultar();
        cliente_Isra.clienteDepositando("Martínez Díaz Roque","1234567891011123", "16/12/2021", 10000, 5000);
        bancos.desconectar();
        
        //Comprobar el Retiro de banco.
        Retirar banco = Retirar.getInstancia();
        banco.conectar();
        consultar cliente_Andrés = new consultar(); //Nombre, No. Cuenta a depositar, Periodo, Saldo actual y Retiro
        cliente_Isra.clienteRetirando("Álvarez Luna Mario Andrés","1112131415161718", "03/01/2022", 10000, 5500);
        
        consultar cliente_Luciana = new consultar();
        cliente_Isra.clienteRetirando("Morales Alanís Luciana","2122232425262728", "04/01/2022", 10000, 4000);
        banco.desconectar();   
        
    }
    
    
        
        
        
    }
    
    

