/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopookrc;

import java.util.ArrayList;
import java.util.Scanner;





/**
 *
 * @author Argenys
 */
public class Comprador{
    private String nombres;
    private String apellidos;
    private String correo;
    private String organizacion;
    private String clave;

    public Comprador(String nombres, String apellidos, String correo, String organizacion, String clave) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.organizacion = organizacion;
        this.clave = clave;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

     public static ArrayList<Vehiculo> buscar_vehiculo(String nomfile) {
        ArrayList<Vehiculo> vehiculosfiltrados = new ArrayList<>();
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Ingrese el tipo de vehiculo que está buscando (EN MINUSCULA)(camioneta/motocicleta/auto): ");
        String tipo_vehiculo = sc1.nextLine();
        System.out.println("Especifique un rango del recorrido(Inicial): ");
        String recorrido_inicial = sc1.nextLine();
        System.out.println("Especifique un rango del recorrido(Final): ");
        String recorrido_final = sc1.nextLine();
        System.out.println("Especifique un año del vehiculo(Desde): ");
        String anio_inicial = sc1.nextLine();
        System.out.println("Especifique un año del vehiculo(Hasta): ");
        String anio_final = sc1.nextLine();
        System.out.println("Especifique un rango de precio(Inicial)");
        String precio_inicial = sc1.nextLine();
        System.out.println("Especifique un rango de precio(Final): ");
        String precio_final = sc1.nextLine();
        ArrayList<Vehiculo> vehiculosRegistrados = Vehiculo.lecturaVehiculo(nomfile);
        for (Vehiculo v : vehiculosRegistrados) {
            if (tipo_vehiculo.length() > 1) {
                if (v.getTipo_vehiculo().equals(tipo_vehiculo)) {
                    vehiculosfiltrados.add(v);
                }
              
            } else {
                vehiculosfiltrados.add(v);
            }
        }
        
        for (int i = 0; i<vehiculosfiltrados.size();i++) {
            if (recorrido_inicial.length() > 0 || recorrido_final.length() > 0) {
                double recorridoI = Double.parseDouble(recorrido_inicial);
                double recorridoF = Double.parseDouble(recorrido_final);
                if (!(vehiculosfiltrados.get(i).getRecorrido() > recorridoI && vehiculosfiltrados.get(i).getRecorrido() < recorridoF)) {
                    vehiculosfiltrados.remove(vehiculosfiltrados.get(i));
                }
            }
            if (anio_inicial.length() > 0 || anio_final.length() > 0) {
                int anioI = Integer.parseInt(anio_inicial);
                int anioF = Integer.parseInt(anio_final);
                if (!(vehiculosfiltrados.get(i).getAnio() > anioI && vehiculosfiltrados.get(i).getAnio() < anioF)) {
                    vehiculosfiltrados.remove(vehiculosfiltrados.get(i));
                }
            }
            if (precio_inicial.length() > 0|| precio_final.length() > 0) {
                double precioI = Double.parseDouble(precio_inicial);
                double precioF = Double.parseDouble(precio_final);
                if (!(vehiculosfiltrados.get(i).getPrecio() > precioI && vehiculosfiltrados.get(i).getPrecio() < precioF)) {
                    vehiculosfiltrados.remove(vehiculosfiltrados.get(i));
                }
            }
        }

        return vehiculosfiltrados;
    }
    
    
     
    
   
}