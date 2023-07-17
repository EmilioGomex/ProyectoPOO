/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopookrc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kruro
 */
public class Oferta {

    private String placa;
    private double precio;
    private String correoComprador;

    public Oferta(String placa, double precio, String correoComprador) {
        this.placa = placa;
        this.precio = precio;
        this.correoComprador = correoComprador;

    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCorreoComprador() {
        return correoComprador;
    }

    public void setCorreoComprador(String correoComprador) {
        this.correoComprador = correoComprador;
    }

    public static void mostrarVehiculos(ArrayList<Vehiculo> vehiculos) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese correo:");
        ArrayList<Comprador> compradoresRegistrados = ProyectoPooKRC.lecturaComprador("Compradores.txt");
        String correo = sc.nextLine();
        for (Comprador c : compradoresRegistrados) {
            if (c.getCorreo().equals(correo)) {

                for (int i = 0; i < vehiculos.size(); i++) {
                    if (i == 0) {
                        System.out.println(vehiculos.get(i).toString());
            System.out.println("""
                           -------OPCIONES-------
                           1.\tContinuar
                           2.\tRealizar Oferta""");

                        String opcionoferta = sc.nextLine();
                        if (opcionoferta.equals("2")) {
                            System.out.println("INGRESE EL PRECIO A OFERTAR:");
                            double precio = sc.nextDouble();
                            sc.nextLine();
                            try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File("Ofertas.txt"), true))) {

                                pw.println(vehiculos.get(i).getPlaca() + "|" + precio + "|"+c.getCorreo());

                                System.out.println("OFERTA SUBIDA CON EXITO");
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    } else {
                        System.out.println(vehiculos.get(i).toString());
                        System.out.println("""
                           -------OPCIONES-------
                           1.\tContinuar
                           2.\tRegresar
                           3.\tRealizar Oferta""");

                        String opcionRegreso = sc.nextLine();
                        if (opcionRegreso.equals("2")) {
                            i = i - 2;

                        }
                        if (opcionRegreso.equals("3")) {
                            System.out.println("INGRESE EL PRECIO A OFERTAR:");
                            double precio = sc.nextDouble();
                            try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File("Ofertas.txt"), true))) {

                                pw.println(vehiculos.get(i).getPlaca() + "|" + precio + "|"+c.getCorreo());
                                System.out.println("OFERTA SUBIDA CON EXITO");
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }
            }
        }

    }

    public static ArrayList<Oferta> lecturaOferta(String nomfile) {
        ArrayList<Oferta> ofertas = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(nomfile))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Oferta o = new Oferta(tokens[0], Double.parseDouble(tokens[1]), tokens[2]);
                ofertas.add(o);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return ofertas;

    }
}