/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopookrc;



/**
 *
 * @author Argenys
 */
public class Camioneta extends Vehiculo{
private String traccion;

    public Camioneta( String tipo_vehiculo, String placa, String marca, String modelo, String motor, int anio, double recorrido, String color, String tipo_combustible, String vidrios, String transmision,String traccion, double precio) {
        super(tipo_vehiculo, placa, marca, modelo, motor, anio, recorrido, color, tipo_combustible, vidrios, transmision, precio);
        this.traccion = traccion;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    @Override
    public String toString() {
        return "\n  tipo de vehículo: '" + tipo_vehiculo + '\'' +
            "\n  placa: '" + placa + '\'' +
            "\n  marca: '" + marca + '\'' +
            "\n  modelo: '" + modelo + '\'' +
            "\n  motor: '" + motor + '\'' +
            "\n  año: " + anio +
            "\n  recorrido: " + recorrido +
            "\n  color: '" + color + '\'' +
            "\n  tipo de combustible: '" + tipo_combustible + '\'' +
            "\n  vidrios: '" + vidrios + '\'' +
            "\n  transmisión: '" + transmision + '\'' +
            "\n  tracción: '" + traccion + '\'' +
            "\n  precio: " + precio ;
    }

    

  
    
   
    
}