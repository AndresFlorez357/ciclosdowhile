package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado= new Scanner(System.in);
        Random generador=new Random();
        boolean administrador;
        String respuestaPerfil;
        double tarifaEnergia;
        Integer opcion;
        final String contrasena="admin123*";
        String contrasenaAdmin;
        Integer contadorDeEnergia=0;

        System.out.println("******Bienvenido**********");
        System.out.println("*****Eres Administrador*****");
        respuestaPerfil=teclado.nextLine();
        if (respuestaPerfil.equalsIgnoreCase("si")){
            System.out.print("Digita tu contraseña");
            contrasenaAdmin=teclado.nextLine();
            if (contrasenaAdmin.equals(contrasena)){
                System.out.println("usted es un admin");
                System.out.print("Ingrese el valor del kwh");
                tarifaEnergia=teclado.nextDouble();
                System.out.println("la tarifa de energia quedo en: "+tarifaEnergia);
                // generando datos para una empresa
                Integer numeroVueltas=0;//contador
                Integer contadorDePicos=0;


                do {
                    Integer numeroGenerado= generador.nextInt(401);
                    numeroVueltas++;
                    contadorDeEnergia=contadorDeEnergia + numeroGenerado;
                    if (numeroGenerado>300){
                        System.out.println("pico dectetado");
                        contadorDePicos++;
                    }else{
                        System.out.println("operando normalmente");
                    }

                }while (numeroVueltas<30);


                System.out.println(numeroVueltas);
                System.out.println(contadorDePicos);
                System.out.println("1.ver tarifa");
                System.out.println("2. mostrar consumo promedio");
                System.out.println("3. mostrar consumo picos");
                System.out.println("4. mostrar factura");
                System.out.println("5. salir");
                do{
                    System.out.println("apreciado cliente, digita una opcion: ");
                    opcion=teclado.nextInt();
                    switch (opcion){
                        case 1:
                            System.out.println("la tarifa kwh es: "+tarifaEnergia);
                            break;
                        case 2:
                            System.out.println("el consumo total fue: "+contadorDeEnergia);
                            Double promedioConsumo=contadorDeEnergia/30.0;
                            System.out.println("el consumo promedio es: "+promedioConsumo);
                            break;
                        case 3:
                            System.out.println("la cantidad de picos fue: "+contadorDePicos);
                            break;
                        case 4:
                            System.out.println("el resumen de tu factura es: ");
                            double totalApagar=contadorDeEnergia*tarifaEnergia;
                            System.out.println("$....."+totalApagar);
                            break;
                        default:
                            System.out.println("opcion invalida: ");


                    }
                }while (opcion!=5);

            }else {
                System.out.println("Usted es un hacker");
            }

        }else {
            System.out.println("usted es una empresa");
        }

    }
}