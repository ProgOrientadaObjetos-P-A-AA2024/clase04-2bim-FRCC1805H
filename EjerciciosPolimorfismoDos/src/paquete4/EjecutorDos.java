/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete4;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import paquete2.Arriendo;
import paquete3.ArriendoLocalComercial;
import paquete3.ArriendoLocalComida;
import paquete3.ArriendoLocalSesiones;

public class EjecutorDos {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        int contador = 0;
        entrada.useLocale(Locale.US);

        ArrayList<Arriendo> listaArriendos = new ArrayList<>();

        int narriendo;
        System.out.println("Cuantos arriendos que desea ingresar");
        narriendo = entrada.nextInt();
        entrada.nextLine(); 

        while (contador < narriendo) {
            System.out.println("Tipo de Arriendo \n"
                    + "Ingrese (1) Arriendo Comercial ");
            System.out.println("Ingrese (2) Arriendo Comida ");
            System.out.println("Ingrese (3) Arriendo Sesiones ");
            opcion = entrada.nextInt();
            entrada.nextLine();

            if (opcion == 1) {
                System.out.println("Ingrese el Nombre y "
                        + "Apellido del Arrendatario");
                String nombre = entrada.nextLine();
                System.out.println(" Dijite la Cuota Base ");
                double cuotaBase = entrada.nextDouble();
                System.out.println(" Ingrese Valor Fijo Adicional ");
                double valorAdicionalFijo = entrada.nextDouble();
                entrada.nextLine(); 
                ArriendoLocalComercial arriendoComercial
                        = new ArriendoLocalComercial(nombre, cuotaBase);
                arriendoComercial.establecerValorAdicionalFijo
                                               (valorAdicionalFijo); // en $

                listaArriendos.add(arriendoComercial);

            } else {
                if (opcion == 2) {
                    System.out.println("Ingrese el Nombre y "
                            + "Apellido del Arrendatario");
                    String nombre = entrada.nextLine();
                    System.out.println(" Dijite la Cuota Base ");
                    double cuotaBase = entrada.nextDouble();
                    System.out.println("Dijite el Valor del Agua ");
                    double valorAgua = entrada.nextDouble();
                    System.out.println("Dijite el Valor de la Luz");
                    double valorLuz = entrada.nextDouble();
                    System.out.println("Dijite el Valor del Iva");
                    double valorIva = entrada.nextDouble();
                    entrada.nextLine(); 

                    ArriendoLocalComida arriendoComida
                            = new ArriendoLocalComida(nombre, cuotaBase);
                    arriendoComida.establecerIva(valorIva); 
                    arriendoComida.establecerValorAgua(valorAgua); // en $
                    arriendoComida.establecerValorLuz(valorLuz); // en $

                    listaArriendos.add(arriendoComida);

                } else {
                    if (opcion == 3) {
                        System.out.println("Ingrese el Nombre y "
                                + "Apellido del Arrendatario");
                        String nombre = entrada.nextLine();
                        System.out.println(" Dijite la Cuota Base ");
                        double cuotaBase = entrada.nextDouble();
                        System.out.println("Dijite el Valor de las Sillas");
                        double valorSillas = entrada.nextDouble();
                        System.out.println("Dijite el Valor de las"
                                + " Amplificaciones");
                        double valorAmplificaciones = entrada.nextDouble();
                        entrada.nextLine(); 

                        ArriendoLocalSesiones arriendoSesiones
                                = new ArriendoLocalSesiones(nombre, cuotaBase);
                        arriendoSesiones.establecerValorSillas
                                                         (valorSillas); // en $
                        arriendoSesiones.establecerValorAmplificacion
                                                (valorAmplificaciones); // en $

                        listaArriendos.add(arriendoSesiones);

                    } else {
                        System.out.println("Error");
                    }
                    contador = contador + 1;
                }

                for (int i = 0; i < listaArriendos.size(); i++) {
                    listaArriendos.get(i).establecerArriendoMensual();
                }

                CentroComercial centro = new CentroComercial("La Pradera",
                        listaArriendos);
                centro.establecerTotalArriendosBaseMensual();
                centro.establecerTotalArriendosFinalMensual();
                System.out.println(centro);
            }
        }
    }
}
