/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.espol.proyectopookrc;

import com.sun.jdi.connect.Transport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author kruro
 */
public class ProyectoPooKRC {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        System.out.println("BIENVENIDO A LA VENTA DE VEHICULOS!!!");
        int menuInicial = 0;
        while (menuInicial != 3) {
            System.out.println("""
                           ------ MENU PRINCIPAL -----
                           Menu de Opciones:
                           1.\tVendedor
                           2.\tComprador
                           3.\tSalir""");

            Scanner sc = new Scanner(System.in);

            menuInicial = sc.nextInt();
            sc.nextLine();

            if (menuInicial == 1) {
                int optMenuVendedor = 0;

                while (optMenuVendedor != 4) {
                    System.out.println("""
                                   1.\tRegistrar un nuevo vendedor
                                   2.\tRegistrar un nuevo vehiculo
                                   3.\tAceptar oferta
                                   4.\tRegresar""");

                    optMenuVendedor = sc.nextInt();
                    sc.nextLine();

                    if (optMenuVendedor == 1) {
                        // registrar nuevo vendedor
                        System.out.println("Ingrese nombres:");
                        String nombre = sc.nextLine();
                        System.out.println("Ingrese apellidos:");
                        String apellidos = sc.nextLine();
                        System.out.println("Ingrese correo electronico:");
                        String correo = sc.nextLine();
                        System.out.println("Ingrese organizacion:");
                        String organizacion = sc.nextLine();
                        System.out.println("Ingrese clave:");
                        String clave = sc.nextLine();

                        Vendedor v1 = new Vendedor(nombre, apellidos, correo, organizacion, clave);
                        registroVendedor(v1);
                    }
                    if (optMenuVendedor == 2) {
                        // registrar un nuevo vehiculo
                        Vehiculo.ingresarVehiculo();

                    }
                    if (optMenuVendedor == 3) {
                        // aceptar oferta
                        Vendedor.aceptarOferta();
                    }
                }

            } else if (menuInicial == 2) {
                int menuComprador = 0;
                while (menuComprador != 3) {

                    System.out.println("""
                                   1.\tRegistrar un nuevo comprador
                                   2.\tOfertar por un vehiculo
                                   3.\tRegresar""");
                    menuComprador = sc.nextInt();
                    sc.nextLine();

                    if (menuComprador == 1) {
                        //Registrar nuevo comprador
                        System.out.println("Ingrese nombres:");
                        String nombre = sc.nextLine();
                        System.out.println("Ingrese apellidos:");
                        String apellidos = sc.nextLine();
                        System.out.println("Ingrese correo electronico:");
                        String correo = sc.nextLine();
                        System.out.println("Ingrese organizacion:");
                        String organizacion = sc.nextLine();
                        System.out.println("Ingrese clave:");
                        String clave = sc.nextLine();

                        Comprador c1 = new Comprador(nombre, apellidos, correo, organizacion, clave);
                        registroComprador("Compradores.txt", c1);
                    }
                    if (menuComprador == 2) {
                        //Ofertar por vehiculo
                        ArrayList<Vehiculo> vehiculos = Comprador.buscar_vehiculo("Vehiculos.txt");
                        Oferta.mostrarVehiculos(vehiculos);

                    }

                }

            }

        }
    }

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

    public static ArrayList<Vendedor> lecturaVendedor(String nomfile) {
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(nomfile))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Vendedor v = new Vendedor(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
                vendedores.add(v);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return vendedores;
    }

    public static ArrayList<Comprador> lecturaComprador(String nomfile) {
        ArrayList<Comprador> compradores = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(nomfile))) {

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Comprador c = new Comprador(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
                compradores.add(c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return compradores;
    }

    public static void registroVendedor(Vendedor vendedor) {

        ArrayList<Vendedor> vendedoresRegistrados = lecturaVendedor("Vendedores.txt");
        boolean registroinvalido = true;
        for (Vendedor v1 : vendedoresRegistrados) {
            if (v1.getCorreo().equals(vendedor.getCorreo()) && registroinvalido) {
                System.out.println("NO ESTA APTO PARA REGISTRO");
                registroinvalido = false;
            }
        }

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File("Vendedores.txt"), true))) {
            if (registroinvalido) {
                pw.println(vendedor.getNombre() + "|" + vendedor.getApellido() + "|" + vendedor.getCorreo() + "|" + vendedor.getOrganizacion() + "|" + toHexString(getSHA(vendedor.getClave())));
                System.out.println("REGISTRO EXITOSO");
            }
        } catch (Exception i) {
            System.out.println(i.getMessage());
        }

    }

    public static void registroComprador(String nomfile, Comprador comprador) {

        ArrayList<Comprador> compradorRegistrados = lecturaComprador(nomfile);
        boolean registroinvalido = true;
        for (Comprador c1 : compradorRegistrados) {
            if (c1.getCorreo().equals(comprador.getCorreo())) {
                System.out.println("NO ESTA APTO PARA REGISTRO");
                registroinvalido = false;
            }
        }

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile), true))) {
            if (registroinvalido) {
                pw.println(comprador.getNombres() + "|" + comprador.getApellidos() + "|" + comprador.getCorreo() + "|" + comprador.getOrganizacion() + "|" + toHexString(getSHA(comprador.getClave())));//faltan gets
                System.out.println("REGISTRO EXITOSO");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        //La direcciÃ³n de correo de envÃ­o
        String remitente = "kruron9@gmail.com";
        //La clave de aplicaciÃ³n obtenida segÃºn se explica en este artÃ­culo:
        String claveemail = "qddudvdvuhrcpise";

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", claveemail);    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticaciÃ³n mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrÃ­an aÃ±adir varios de la misma manera
            message.setSubject(asunto);
            message.setText(cuerpo);
            javax.mail.Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, claveemail);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException me) {
               //Si se produce un error
        }
    }

    public static void eliminarVehiculo(ArrayList<Vehiculo> vehiculos) {
        //vehiculos.remove(v);
        System.out.println("SE HA ELIMINADO EL VEHICULO OFERTADO");
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File("Vehiculos.txt"), false))) {
            for (Vehiculo v1 : vehiculos) {
                if (v1 instanceof Camioneta c) {
                    pw.println(c.getTipo_vehiculo() + "|" + c.getPlaca() + "|" + c.getMarca() + "|" + c.getModelo() + "|" + c.getMotor() + "|" + c.getAnio() + "|" + c.getRecorrido() + "|" + c.getColor() + "|" + c.getTipo_combustible() + "|" + c.getVidrios() + "|" + c.getTransmision() + "|" + c.getTraccion() + "|" + c.getPrecio());

                } else if (v1 instanceof Motocicletas m) {
                    
                    pw.println(m.getTipo_vehiculo() + "|" + m.getPlaca() + "|" + m.getMarca() + "|" + m.getModelo() + "|" + m.getMotor() + "|" + m.getAnio() + "|" + m.getRecorrido() + "|" + m.getColor() + "|" + m.getTipo_combustible() + "|" + m.getPrecio());

                } else if (v1 instanceof Auto a) {
                    pw.println(a.getTipo_vehiculo() + "|" + a.getPlaca() + "|" + a.getMarca() + "|" + a.getModelo() + "|" + a.getMotor() + "|" + a.getAnio() + "|" + a.getRecorrido() + "|" + a.getColor() + "|" + a.getTipo_combustible() + "|" + a.getVidrios() + "|" + a.getTransmision() + "|" + a.getPrecio());

                }
            }
            pw.close();
        }
    catch (FileNotFoundException e

        ) {
            System.out.println("No se encontrÃ³ el archivo: " + e.getMessage());
    }
    catch (IOException e

    
        ) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
    }
    catch (Exception e

    
        ) {
            System.out.println("OcurriÃ³ una excepciÃ³n: " + e.getMessage());
        e.printStackTrace();
    }
}

}