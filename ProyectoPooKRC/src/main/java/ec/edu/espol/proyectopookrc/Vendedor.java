/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopookrc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author EmilioGomex
 */
public class Vendedor {

    private String nombre;
    private String apellido;
    private String correo;
    private String organizacion;
    private String clave;

    public Vendedor(String nombre, String apellido, String correo, String organizacion, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.organizacion = organizacion;
        this.correo = correo;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
public static void aceptarOferta() throws NoSuchAlgorithmException {
        int vehiculoChequeo = 0;
        int contador = 0;
        ArrayList<Oferta> ofertasFiltradas = new ArrayList<>();

        ArrayList<Vehiculo> vehiculosRegistrados = Vehiculo.lecturaVehiculo("Vehiculos.txt");
        ArrayList<Oferta> ofertasRegistradas = Oferta.lecturaOferta("Ofertas.txt");
        System.out.println("Ingrese correo:");
        Scanner sc = new Scanner(System.in);
        String correo1 = sc.nextLine();
        System.out.println("Ingrese clave:");
        String clave1 = sc.nextLine();
        String claveHASH = ProyectoPooKRC.toHexString(ProyectoPooKRC.getSHA(clave1));
        ArrayList<Vendedor> vendedoresRegistrados = ProyectoPooKRC.lecturaVendedor("Vendedores.txt");
        int cont = 1;

        for (int i = 0; i < vendedoresRegistrados.size(); i++) {

            if (vendedoresRegistrados.get(i).getCorreo().equals(correo1)) {
                if (vendedoresRegistrados.get(i).getClave().equals(claveHASH)) {
                    System.out.println("BIENVENIDO VENDEDOR: REVISE SUS OFERTAS");
                    System.out.println("INGRESE PLACA DE VEHICULO:");
                    String placabusca = sc.nextLine();
                    for (Vehiculo v : vehiculosRegistrados) {
                        if (v.getPlaca().equals(placabusca)) {
                            vehiculoChequeo = contador;
                            System.out.println(v.getMarca() + v.getModelo() + "Precio : " + v.getPrecio());
                        }
                        contador++;

                    }
                    for (Oferta a : ofertasRegistradas) {
                        if (a.getPlaca().equals(placabusca)) {
                            ofertasFiltradas.add(a);
                        }
                    }

                    for (int q = 0; q < ofertasFiltradas.size(); q++) {
                        if (q == 0) {
                            System.out.println("oferta" + cont + "\n"
                                    + ofertasFiltradas.get(0).getPrecio() + "\n"
                                    + ofertasFiltradas.get(0).getCorreoComprador());
                            System.out.println("""
                                   \t-------OPCIONES---------
                                   1.\tSiguiente oferta"
                                   2.\tAceptar oferta""");
                            String opcionOferta = sc.nextLine();
                            cont += 1;
                            if (opcionOferta.equals("2")) {
                                //GMAIL, ELIMINAR ARCHIVO
                                String destinatario = ofertasFiltradas.get(0).getCorreoComprador();
                                String asunto = "VENTA VEHICULO";
                                String cuerpo = "HE ACEPTADO SU OFERTA";

                                ProyectoPooKRC.enviarConGMail(destinatario, asunto, cuerpo);
                                System.out.println(vehiculoChequeo);
                                vehiculosRegistrados.remove(vehiculosRegistrados.get(vehiculoChequeo));
                                ProyectoPooKRC.eliminarVehiculo(vehiculosRegistrados);
                                break;
                            }

                        } else {
                            System.out.println("oferta" + cont + "\n"
                                    + ofertasFiltradas.get(q).getPrecio() + "\n"
                                    + ofertasFiltradas.get(q).getCorreoComprador());
                            System.out.println("""
                                   \t-------OPCIONES---------
                                   1.\tSiguiente oferta"
                                   2.\tOferta Anterior
                                   3.\tAceptar oferta""");
                            cont = +1;
                            String opcionOferta = sc.nextLine();
                            if (opcionOferta.equals("2")) {
                                q = q - 2;
                            }
                            if (opcionOferta.equals("3")) {
                                //GMAIL, ELIMINAR ARCHIVO
                                String destinatario = ofertasFiltradas.get(q).getCorreoComprador();
                                String asunto = "VENTA VEHICULO";
                                String cuerpo = "HE ACEPTADO SU OFERTA";
                                ProyectoPooKRC.enviarConGMail(destinatario, asunto, cuerpo);
                                System.out.println(vehiculoChequeo);
                                vehiculosRegistrados.remove(vehiculosRegistrados.get(vehiculoChequeo));
                                ProyectoPooKRC.eliminarVehiculo(vehiculosRegistrados);

                            }
                        }
                    }

                }

            }

        }
    }
}