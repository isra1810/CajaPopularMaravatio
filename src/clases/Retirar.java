/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane; //importar JOptionPane

/**
 *
 * @author Israel Nava Reyes y Luis Arturo Tapia Reyes
 */
public class Retirar {
        private static Retirar instancia; //Agregar clase privada para mostrar en consola si el retiro fue exitoso.

//Pedir datos para mostrar el estado de cuenta.
public void estado(String nombre, String numero_cuenta, String periodo, int saldo_actual, int cantidad_retirada){//Disponible para el cliente
        String resultado = Retirar.realizarTransaccion(nombre, numero_cuenta, periodo, saldo_actual, cantidad_retirada);//Requisitos del estado de cuenta
        JOptionPane.showMessageDialog(null, "ESTADO DE CUENTA: " + "\nSe realizó un Retiro de $ " + cantidad_retirada + "\nA nombre de: " + nombre + "."+
                 "\nPara el número de cuenta: " + numero_cuenta + "\nDel banco: " + resultado + "\nEn la fecha de: " + 
                periodo + "\nSu saldo anterior es de: $" + saldo_actual + "\nSu saldo actual restante es de: $" + (saldo_actual - cantidad_retirada) + "\nGracias por hacer su retiro en Caja Popular Maravatío " +"\nLo esperamos de vuelta pronto.");//Operacion donde se realiza el retiro.
        }
    //Función que permite realizar el movimiento deseado.
    public static String realizarTransaccion(String nombre, String numero_cuenta, String periodo, int saldo_actual, int cantidad){//Funcion del static que permite hacer el proceso de retirar
        String[] bancos = {"Bancomer", "Banamex", "Banorte", "BanCoppel", "Banco Azteca"}; //Bancos disponibles por no. de tarjeta
        int indice;
        if(periodo.startsWith("25"))//Funcion else if de indice del periodo startsWith
            indice = numeroAleatorio(0, bancos.length -5);
        else
            indice = numeroAleatorio(0, bancos.length -1);
        String bancoExterno = bancos[indice]; //Mostrar banco especifico
        return bancoExterno;
    }
     
    //Esta funcion nos permite mostrar el banco de manera aleatoria en base al patrón de diseño de facade
    public static int numeroAleatorio(int minimo, int maximo){
        return ThreadLocalRandom.current().nextInt(minimo, maximo);
    }
    
//Uso del Patron de diseño singleton para mostrar a consola si el retiro fue exitoso
    public static Retirar getInstancia(){
        //Comprobación de que el objeto se ha o no creado
        if( instancia == null)
            instancia = new Retirar();
        else
            System.out.println("Se esta realizando su operación");
        
        return instancia;
    }
    
    public void conectar() {
        System.out.println("Se esta(n) realizando su(s) retiro(s). Por favor espere...");
        
    }
    
    public void desconectar() {
        System.out.println("Se realizó su retiro con éxito");
        System.out.println("Operación de retiro finalizada");
        System.out.println("Gracias por preferir Caja Popular Maravatío");
    }   
    
}
