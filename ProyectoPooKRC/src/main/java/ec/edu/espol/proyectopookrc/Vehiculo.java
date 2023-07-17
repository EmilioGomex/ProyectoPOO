/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopookrc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author EmilioGomex
 */
class Vehiculo {

    protected String tipo_vehiculo; //DEJA ESTE ATRIBUTO
    protected String placa;
    protected String marca;
    protected String modelo;
    protected String motor;
    protected int anio;
    protected double recorrido;
    protected String color;
    protected String tipo_combustible;
    protected String vidrios;
    protected String transmision;
    protected double precio;

    public Vehiculo(String tipo_vehiculo, String placa, String marca, String modelo, String motor, int anio, double recorrido, String color, String tipo_combustible, String vidrios, String transmision, double precio) {
        this.tipo_vehiculo = tipo_vehiculo;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
        this.anio = anio;
        this.recorrido = recorrido;
        this.color = color;
        this.tipo_combustible = tipo_combustible;
        this.vidrios = vidrios;
        this.transmision = transmision;
        this.precio = precio;
    }

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(double recorrido) {
        this.recorrido = recorrido;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo_combustible() {
        return tipo_combustible;
    }

    public void setTipo_combustible(String tipo_combustible) {
        this.tipo_combustible = tipo_combustible;
    }

    public String getVidrios() {
        return vidrios;
    }

    public void setVidrios(String vidrios) {
        this.vidrios = vidrios;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public static void ingresarVehiculo() throws NoSuchAlgorithmException {
        System.out.println("Ingrese correo:");
        Scanner sc = new Scanner(System.in);
        String correo = sc.nextLine();
        System.out.println("Ingrese clave:");
        String clave = sc.nextLine();
        String claveHASH = ProyectoPooKRC.toHexString(ProyectoPooKRC.getSHA(clave));
        ArrayList<Vendedor> vendedoresRegistrados = ProyectoPooKRC.lecturaVendedor("Vendedores.txt");
        for (int i = 0; i < vendedoresRegistrados.size(); i++) {

            if (vendedoresRegistrados.get(i).getCorreo().equals(correo)) {
                if (vendedoresRegistrados.get(i).getClave().equals(claveHASH)) {

                    System.out.println("CREDENCIALES VERIFICADAS "
                            + ""
                            + "seleccione el tipo de vehiculo(motocicleta/auto/camioneta)");
                    String tipoVehiculo = sc.nextLine();
                    if (tipoVehiculo.equals("motocicleta")) {
                        System.out.println("ingrese placa:");
                        String placa = sc.nextLine();
                        System.out.println("ingrese marca:");
                        String marca = sc.nextLine();
                        System.out.println("ingrese modelo:");
                        String modelo = sc.nextLine();
                        System.out.println("ingrese tipo motor(ELECTRICO/MECANICO):");
                        String motor = sc.nextLine();
                        System.out.println("ingrese año:");
                        int anio = sc.nextInt();

                        sc.nextLine();
                        System.out.println("ingrese recorrido:");
                        double recorrido = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("ingrese color");
                        String color = sc.nextLine();
                        System.out.println("ingrese tipo combustible(DIESEL/GASOLINA)");
                        String combustible = sc.nextLine();
                        System.out.println("ingrese precio");
                        double precio = sc.nextDouble();
                        sc.nextLine();
                        Vehiculo moto = new Motocicletas("motocicleta", placa, marca, modelo, motor, anio, recorrido, color, combustible, null, null, precio);
                        registroVehiculo(moto);

                    } else if (tipoVehiculo.equals("auto")) {
                        System.out.println("ingrese placa:");
                        String placa = sc.nextLine();
                        System.out.println("ingrese marca:");
                        String marca = sc.nextLine();
                        System.out.println("ingrese modelo:");
                        String modelo = sc.nextLine();
                        System.out.println("ingrese tipo motor(ELECTRICO/MECANICO):");
                        String motor = sc.nextLine();
                        System.out.println("ingrese año:");
                        int anio = sc.nextInt();
                        sc.nextLine();
                        System.out.println("ingrese recorrido:");
                        double recorrido = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("ingrese color");
                        String color = sc.nextLine();
                        System.out.println("ingrese tipo combustible(DIESEL/GASOLINA)");
                        String combustible = sc.nextLine();
                        System.out.println("ingrese vidrios(NORMALES/TEMPLADOS)");
                        String vidrios = sc.nextLine();
                        System.out.println("ingrese transmision(AUTOMATICO/MANUAL)");
                        String transmision = sc.nextLine();
                        System.out.println("ingrese precio");
                        double precio = sc.nextDouble();
                        sc.nextLine();
                        Vehiculo auto = new Auto("auto", placa, marca, modelo, motor, anio, recorrido, color, combustible, vidrios, transmision, precio);
                        registroVehiculo(auto);
                    } else if (tipoVehiculo.equals("camioneta")) {
                        System.out.println("ingrese placa:");
                        String placa = sc.nextLine();
                        System.out.println("ingrese marca:");
                        String marca = sc.nextLine();
                        System.out.println("ingrese modelo:");
                        String modelo = sc.nextLine();
                        System.out.println("ingrese tipo motor(ELECTRICO/MECANICO):");
                        String motor = sc.nextLine();
                        System.out.println("ingrese año:");
                        int anio = sc.nextInt();
                        sc.nextLine();
                        System.out.println("ingrese recorrido:");
                        double recorrido = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("ingrese color");
                        String color = sc.nextLine();
                        System.out.println("ingrese tipo combustible(DIESEL/GASOLINA)");
                        String combustible = sc.nextLine();
                        System.out.println("ingrese vidrios(NORMALES/TEMPLADOS)");
                        String vidrios = sc.nextLine();
                        System.out.println("ingrese transmision(AUTOMATICO/MANUAL)");
                        String transmision = sc.nextLine();
                        System.out.println("ingrese traccion de su camioneta(4X4/4WD/AWD)");
                        String traccion = sc.nextLine();
                        System.out.println("ingrese precio");
                        double precio = sc.nextDouble();
                        sc.nextLine();
                        Vehiculo camioneta = new Camioneta("camioneta", placa, marca, modelo, motor, anio, recorrido, color, combustible, vidrios, transmision, traccion, precio);
                        registroVehiculo(camioneta);
                    }

                }
            }

        }
    }

    public static void registroVehiculo(Vehiculo vehiculo) {
        ArrayList<Vehiculo> placavehiculos = lecturaVehiculo("Vehiculos.txt");
        boolean registrovalido = true;
        for (Vehiculo v1 : placavehiculos) {
            if (v1.getPlaca().equals(vehiculo.getPlaca()) && registrovalido) {
                System.out.println("NO ESTA APTO PARA REGISTRO");
                registrovalido = false;
            }
        }

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File("Vehiculos.txt"), true))) {
            if (registrovalido) {
                if (vehiculo instanceof Camioneta c) {
                    pw.println(c.getTipo_vehiculo() + "|" + c.getPlaca() + "|" + c.getMarca() + "|" + c.getModelo() + "|" + c.getMotor() + "|" + c.getAnio() + "|" + c.getRecorrido() + "|" + c.getColor() + "|" + c.getTipo_combustible() + "|" + c.getVidrios() + "|" + c.getTransmision() + "|" + c.getTraccion() + "|" + c.getPrecio());
                    System.out.println("REGISTRADO EXITOSO DE CAMIONETA");
                }
                else if (vehiculo instanceof Motocicletas) {
                    Motocicletas m = (Motocicletas) vehiculo;
                    pw.println(m.getTipo_vehiculo() + "|" + m.getPlaca() + "|" + m.getMarca() + "|" + m.getModelo() + "|" + m.getMotor() + "|" + m.getAnio() + "|" + m.getRecorrido() + "|" + m.getColor() + "|" + m.getTipo_combustible() + "|" + m.getPrecio());
                    System.out.println("REGISTRO EXITOSO DE MOTOCICLETA");
                }
                else if (vehiculo instanceof Auto a) {
                    pw.println(a.getTipo_vehiculo() + "|" + a.getPlaca() + "|" + a.getMarca() + "|" + a.getModelo() + "|" + a.getMotor() + "|" + a.getAnio() + "|" + a.getRecorrido() + "|" + a.getColor() + "|" + a.getTipo_combustible() + "|" + a.getVidrios() + "|" + a.getTransmision() + "|" + a.getPrecio());
                    System.out.println("REGISTRO EXITOSO DE AUTO");
                }

                pw.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió una excepción: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public static ArrayList<Vehiculo> lecturaVehiculo(String nomfile) {
        ArrayList<Vehiculo> vehiculosPlaca = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(nomfile))) {

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Vehiculo vplaca = new Vehiculo(tokens[0], tokens[1], null, null, null, 0, 0., null, null, null, null, 0.);
                if (vplaca.getTipo_vehiculo().equals("motocicleta")) {
                    Vehiculo motoPlaca = new Motocicletas("motocicleta", tokens[1], tokens[2], tokens[3], tokens[4], Integer.parseInt(tokens[5]), Double.parseDouble(tokens[6]), tokens[7], tokens[8], null, null, Double.parseDouble(tokens[9]));
                    vehiculosPlaca.add(motoPlaca);
                }

                if (vplaca.getTipo_vehiculo().equals("auto")) {
                    Vehiculo autoPlaca = new Auto("auto", tokens[1], tokens[2], tokens[3], tokens[4], Integer.parseInt(tokens[5]), Double.parseDouble(tokens[6]), tokens[7], tokens[8], tokens[9], tokens[10], Double.parseDouble(tokens[11]));
                    vehiculosPlaca.add(autoPlaca);
                }
                if (vplaca.getTipo_vehiculo().equals("camioneta")) {
                    Vehiculo camionetaPlaca = new Camioneta("camioneta", tokens[1], tokens[2], tokens[3], tokens[4], Integer.parseInt(tokens[5]), Double.parseDouble(tokens[6]), tokens[7], tokens[8], tokens[9], tokens[10], tokens[11], Double.parseDouble(tokens[12]));
                    vehiculosPlaca.add(camionetaPlaca);
                }
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return vehiculosPlaca;
    }

    @Override
    public String toString() {
        return "\n  tipo de vehículo: '" + tipo_vehiculo + '\''
                + "\n  placa: '" + placa + '\''
                + "\n  marca: '" + marca + '\''
                + "\n  modelo: '" + modelo + '\''
                + "\n  motor: '" + motor + '\''
                + "\n  año: " + anio
                + "\n  recorrido: " + recorrido
                + "\n  color: '" + color + '\''
                + "\n  tipo de combustible: '" + tipo_combustible + '\''
                + "\n  vidrios: '" + vidrios + '\''
                + "\n  transmisión: '" + transmision + '\''
                + "\n  precio: " + precio;
    }
}
