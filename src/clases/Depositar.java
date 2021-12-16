/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static clases.Depositar.numeroAleatorio; //Importar función de número aleatorio
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;//importar JOptionPane

/**
 *
* @author Israel Nava Reyes y Luis Arturo Tapia Reyes
 */
public class Depositar {
    private static Depositar instancia;//Agregar clase privada para mostrar en consola si el deposito fue exitoso.
    
    //Pedir datos para mostrar el estado de cuenta.
    public void estado(String nombre, String numero_cuenta, String periodo, int saldo_actual, int cantidad_depositada){//Disponible para el cliente
        String resultado = Depositar.realizarTransaccion(nombre, numero_cuenta, periodo, saldo_actual, cantidad_depositada);
        JOptionPane.showMessageDialog(null, "ESTADO DE CUENTA: " + "\nSe realizó un depósito de $ " + cantidad_depositada + "\nA nombre de: " + nombre + "."+
                "\nPara el número de cuenta: " + numero_cuenta + "\nDel banco: " + resultado + "\nEn la fecha de: " + 
                periodo + "\nSu saldo anterior es de: $" + saldo_actual + "\nSu saldo actual total es de: $" + (saldo_actual + cantidad_depositada)  + "\nGracias por hacer su depósito en Caja Pupular Maravatío." + "\nLo esperamos de vuelta pronto.");
        }
    //Función que permite realizar el movimiento deseado.
    public static String realizarTransaccion(String nombre, String numero_cuenta, String periodo, int saldo_actual, int cantidad){
        String[] bancos = {"Bancomer", "Banamex", "Banorte", "BanCoppel", "Banco Azteca"};
        int indice;
        if(periodo.startsWith("25"))
            indice = numeroAleatorio(0, bancos.length -6);
        else
            indice = numeroAleatorio(0, bancos.length -1);
        String bancoExterno = bancos[indice]; //Mostrar banco especifico por número de tarjeta
        return bancoExterno;
    }  
    
    //Esta funcion nos permite mostrar el banco de manera aleatoria en base al patrón de diseño de facade
    public static int numeroAleatorio(int minimo, int maximo){
        return ThreadLocalRandom.current().nextInt(minimo, maximo);
    }
    
    //Uso del Patron de diseño singleton para mostrar a consola si el deposito fue exitoso
    public static Depositar getInstancia(){
        //Comprobación de que el objeto se ha o no creado
        if( instancia == null)
            instancia = new Depositar();
        else
            System.out.println("Se esta realizando su operación");
        
        return instancia;
        }
    
    public void conectar() {
        System.out.println("Se esta(n) realizando su(s) deposito(s). Por favor espere...");
        
    }
    
    public void desconectar() {
        System.out.println("Se Realizó su deposito con éxito");
        System.out.println("Operación finalizada");
    }
    

   
  }

