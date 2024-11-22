package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.example.ClasesDAO.*;
import org.example.Contenedores.*;
import org.example.conexion.Conexion;
import org.example.models.*;
import org.fusesource.hawtbuf.BufferEditor;

import javax.swing.*;
import javax.xml.bind.*;
import java.io.*;
import java.util.List;
import java.util.PropertyPermission;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Conexion.hacerTrigger();

        AlmazaraDAO almazaraDAO = new AlmazaraDAO();
        OlivarDAO olivarDAO = new OlivarDAO();
        TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
        CuadrillaDAO cuadrillaDAO = new CuadrillaDAO();
        ProduccionDAO produccionDAO= new ProduccionDAO();

        Almazaras almazaras = new Almazaras(almazaraDAO.read());
        Cuadrillas cuadrillas = new Cuadrillas(cuadrillaDAO.read());
        Olivares olivares = new Olivares(olivarDAO.read());
        Producciones producciones = new Producciones(produccionDAO.read());
        Trabajadores trabajadores = new Trabajadores(trabajadorDAO.read());

        BaseDeDatos baseDeDatos = new BaseDeDatos(almazaras,cuadrillas,olivares,producciones,trabajadores);

        Produccion p = new Produccion(1,5,6,"2024-12-12",20);
        Produccion p1 = new Produccion(1,5,6,"2024-12-12",-20);
//        produccionDAO.add(p);



        /*

        Batería de Datos


        Almazara almazara1 = new Almazara("Almazara El Olivo", "Madrid", 5000);
        Almazara almazara2 = new Almazara("Almazara La Cosecha", "Jaén", 6000);
        Almazara almazara3 = new Almazara("Almazara del Campo", "Sevilla", 4500);
        Almazara almazara4 = new Almazara("Almazara Virgen Extra", "Córdoba", 5500);
        Almazara almazara5 = new Almazara("Almazara Los Olivos", "Toledo", 7000);
        Almazara almazara6 = new Almazara("Almazara El Acebuche", "Granada", 4800);
        Almazara almazara7 = new Almazara("Almazara Sol y Aceite", "Badajoz", 3900);
        Almazara almazara8 = new Almazara("Almazara La Aceituna", "Ciudad Real", 6000);
        Almazara almazara9 = new Almazara("Almazara La Oliva", "Albacete", 5200);
        Almazara almazara10 = new Almazara("Almazara El Oro del Olivar", "Huelva", 6300);

        almazaraDAO.add(almazara1);
        almazaraDAO.add(almazara2);
        almazaraDAO.add(almazara3);
        almazaraDAO.add(almazara4);
        almazaraDAO.add(almazara5);
        almazaraDAO.add(almazara6);
        almazaraDAO.add(almazara7);
        almazaraDAO.add(almazara8);
        almazaraDAO.add(almazara9);
        almazaraDAO.add(almazara10);



        Olivar olivar1 = new Olivar("Jaén", 100.5, 12000.0);
        Olivar olivar2 = new Olivar("Córdoba", 80.0, 10000.0);
        Olivar olivar3 = new Olivar("Sevilla", 150.0, 18000.0);
        Olivar olivar4 = new Olivar("Badajoz", 200.0, 25000.0);
        Olivar olivar5 = new Olivar("Granada", 120.0, 14000.0);

        olivarDAO.add(olivar1);
        olivarDAO.add(olivar2);
        olivarDAO.add(olivar3);
        olivarDAO.add(olivar4);
        olivarDAO.add(olivar5);


        Trabajador trabajador1 = new Trabajador("Juan Pérez", 35, "Supervisor", 3000.50);
        Trabajador trabajador2 = new Trabajador("Ana Gómez", 28, "Operario", 1500.00);
        Trabajador trabajador3 = new Trabajador("Carlos Sánchez", 40, "Encargado", 2500.75);
        Trabajador trabajador4 = new Trabajador("Laura Díaz", 32, "Auxiliar", 1200.25);
        Trabajador trabajador5 = new Trabajador("Miguel Ruiz", 45, "Técnico", 2200.80);
        Trabajador trabajador6 = new Trabajador("Sandra Martín", 30, "Administrativa", 1800.00);
        Trabajador trabajador7 = new Trabajador("David López", 38, "Conductor", 1600.00);
        Trabajador trabajador8 = new Trabajador("Maria Rodríguez", 50, "Jefa de Almazara", 3500.60);
        Trabajador trabajador9 = new Trabajador("José Fernández", 55, "Director", 4000.00);
        Trabajador trabajador10 = new Trabajador("Patricia Pérez", 27, "Operaria", 1400.50);

        trabajadorDAO.add(trabajador1);
        trabajadorDAO.add(trabajador2);
        trabajadorDAO.add(trabajador3);
        trabajadorDAO.add(trabajador4);
        trabajadorDAO.add(trabajador5);
        trabajadorDAO.add(trabajador6);
        trabajadorDAO.add(trabajador7);
        trabajadorDAO.add(trabajador8);
        trabajadorDAO.add(trabajador9);
        trabajadorDAO.add(trabajador10);



        Cuadrilla cuadrilla1 = new Cuadrilla("Cuadrilla Norte", 1);
        Cuadrilla cuadrilla2 = new Cuadrilla("Cuadrilla Sur", 1);
        Cuadrilla cuadrilla3 = new Cuadrilla("Cuadrilla Este", 2);
        Cuadrilla cuadrilla4 = new Cuadrilla("Cuadrilla Oeste", 4);
        Cuadrilla cuadrilla5 = new Cuadrilla("Cuadrilla Centro", 5);

        cuadrillaDAO.add(cuadrilla1);
        cuadrillaDAO.add(cuadrilla2);
        cuadrillaDAO.add(cuadrilla3);
        cuadrillaDAO.add(cuadrilla4);
        cuadrillaDAO.add(cuadrilla5);


        Produccion produccion1 = new Produccion(1,2,1,"2024-10-10",2000.0);
        Produccion produccion2 = new Produccion(2,3,9,"2024-12-01",2000.0);

        produccionDAO.add(produccion1);
        produccionDAO.add(produccion2);

        for (int i=1;i<=3;i++){
            olivarDAO.asociarCuadOl(1,i);
        }

        for (int i=3;i<=5;i++){
            olivarDAO.asociarCuadOl(2,i);
        }

        for (int i=1;i<=5;i++){
            trabajadorDAO.asociarCuadTrab(1,i);
        }

        for (int i=6;i<=10;i++){
            trabajadorDAO.asociarCuadTrab(3,i);
        }*/

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar el menú de opciones
            System.out.println("Menú de opciones:");
            System.out.println("1. Mostrar los trabajadores de una determinada cuadrilla.");
            System.out.println("2. Mostrar las cuadrillas que supervisa un determinado trabajador.");
            System.out.println("3. Mostrar los olivares donde trabaja una determinada cuadrilla.");
            System.out.println("4. Mostrar las cuadrillas que trabajan en un determinado olivar.");
            System.out.println("5. Mostrar las almazaras donde lleva aceituna una determinada cuadrilla.");
            System.out.println("6. Mostrar la producción en una fecha concreta, de una cuadrilla concreta en una almazara concreta.");
            System.out.println("7. Mostrar la producción hasta una determinada fecha, de una determinada almazara.");
            System.out.println("8. Mostrar la producción hasta una determinada fecha, de un determinado olivar.");
            System.out.println("9. Mostrar la producción hasta una determinada fecha, de una cuadrilla determinada.");
            System.out.println("10. Hacer XML de toda la Base De Datos.");
            System.out.println("11. Hacer JSON de toda la Base De Datos.");
            System.out.println("12. Leer XML.");
            System.out.println("13. Leer JSON.");
            System.out.println("0. Salir.");

            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            // Ejecutar la acción correspondiente usando switch
            switch (opcion) {
                case 1:
                    System.out.println("Dime el id de la Cuadrilla que quieres ver");
                    int c = sc.nextInt();
                    for (Trabajador t : trabajadorDAO.getTrabajadorByCuadId(c)){
                        System.out.println(t.toString());
                    }
                    break;

                case 2:
                    System.out.println("Dime el id del Supervisor que quieres ver");
                    c = sc.nextInt();
                    for (Cuadrilla cuad : cuadrillaDAO.getCuadrillasBySupervisorId(c)){
                        System.out.println(cuad.toString());
                    }
                    break;

                case 3:
                    System.out.println("Dime el id de la Cuadrilla");
                    c=sc.nextInt();
                    for (Olivar ol : produccionDAO.PgetOlivarByCuadrillaId(c)){
                        System.out.println(ol.toString());
                    }
                    break;

                case 4:
                    System.out.println("Dime el id de Olivar");
                    c=sc.nextInt();
                    for (Cuadrilla cuad : produccionDAO.PgetCuadrillaByolivarId(c)){
                        System.out.println(cuad.toString());
                    }
                    break;

                case 5:
                    System.out.println("Dime el id de la Cuadrilla para Obtener las Almazaras");
                    c=sc.nextInt();
                    for (Almazara al : produccionDAO.PgetAlmazaaraByCuadrillaId(c)){
                        System.out.println(al.toString());
                    }
                    break;

                case 6:
                    System.out.println("Dime la fecha que quieres Introducir");
                    String fecha = sc.next();
                    System.out.println("Dime el Id de la Almazara");
                    c=sc.nextInt();
                    System.out.println("Dime el Id de la cruadrilla");
                    int d=sc.nextInt();
                    System.out.println(produccionDAO.getProdruccionByIds(c,fecha,d).toString());
                    break;
                case 7:
                    System.out.println("Dime la fecha que quieres Introducir");
                    String fecha1 = sc.next();
                    System.out.println("Dime el Id de la Almazara");
                    c=sc.nextInt();
                    System.out.println(produccionDAO.getProduccionByFechaAl(fecha1,c));
                    break;
                case 8:
                    System.out.println("Dime la fecha que quieres Introducir");
                    String fecha2 = sc.next();
                    System.out.println("Dime el Id del Olivar");
                    c=sc.nextInt();
                    System.out.println(produccionDAO.getProduccionByFechaOl(fecha2,c));
                    break;

                case 9:
                    System.out.println("Dime la fecha que quieres Introducir");
                    String fecha3 = sc.next();
                    System.out.println("Dime el Id de la Cuadrilla");
                    c=sc.nextInt();
                    System.out.println(produccionDAO.getProduccionByFechaCuad(fecha3,c));
                    break;
                case 10:
                    hacerXMLbaseDeDatos(baseDeDatos);
                    break;
                case 11:
                    hacerJSON(baseDeDatos);
                    break;
                case 12:
                    leerXMLbaseDeDatos();
                    break;
                case 13:
                    leerJSON();
                    break;
                /*case 10:
                    try{

                        JAXBContext jaxbContext = JAXBContext.newInstance(Almazaras.class);
                        Marshaller marshaller = jaxbContext.createMarshaller();
                        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                        marshaller.marshal(almazaras,new File("Archivos/XML/Almazaras.xml"));

                        System.out.println("XML de Almazaras Hecho");

                    } catch (JAXBException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 11:
                    try{
                        JAXBContext jaxbContext = JAXBContext.newInstance(Cuadrillas.class);
                        Marshaller marshaller = jaxbContext.createMarshaller();
                        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                        marshaller.marshal(cuadrillas,new File("Archivos/XML/Cuadrillas.xml"));

                        System.out.println("XML de Cuadrillas Hecho");

                    } catch (JAXBException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 12:
                    try{
                        JAXBContext jaxbContext = JAXBContext.newInstance(Olivares.class);
                        Marshaller marshaller = jaxbContext.createMarshaller();
                        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                        marshaller.marshal(olivares,new File("Archivos/XML/Olivares.xml"));

                        System.out.println("XML de Olivares Hecho");

                    } catch (JAXBException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 13:
                    try{
                        JAXBContext jaxbContext = JAXBContext.newInstance(Producciones.class);
                        Marshaller marshaller = jaxbContext.createMarshaller();
                        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                        marshaller.marshal(producciones,new File("Archivos/XML/Producciones.xml"));

                        System.out.println("XML de Producciones Hecho");

                    } catch (JAXBException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 14:
                    try{
                        JAXBContext jaxbContext = JAXBContext.newInstance(Trabajadores.class);
                        Marshaller marshaller = jaxbContext.createMarshaller();
                        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                        marshaller.marshal(trabajadores,new File("Archivos/XML/Trabajadores.xml"));

                        System.out.println("XML de Trabajadores Hecho");

                    } catch (JAXBException e) {
                        throw new RuntimeException(e);
                    }
                    break;*/
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    break;
            }

        } while (opcion != 0);

    }

    private static void hacerJSON(BaseDeDatos baseDeDatos) {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(baseDeDatos);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Archivos/JSON/BaseDeDatos.json"))){

            bw.write(json);

            System.out.println("JSON hecho");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void hacerXMLbaseDeDatos(BaseDeDatos baseDeDatos){
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(BaseDeDatos.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(baseDeDatos,new File("Archivos/XML/BaseDeDatos.xml"));

            System.out.println("XML de la Base De Datos Hecho");

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
    public static void leerXMLbaseDeDatos(){
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(BaseDeDatos.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            BaseDeDatos baseDeDatos1 = (BaseDeDatos) unmarshaller.unmarshal(new File("Archivos/XML/BaseDeDatos.xml"));

            System.out.println("Xml leido");

            System.out.println(baseDeDatos1.toString());

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    private static void leerJSON() {
        File f = new File("Archivos/JSON/BaseDeDatos.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            BaseDeDatos baseDeDatos = gson.fromJson(new FileReader(f),BaseDeDatos.class);

            System.out.println(baseDeDatos.toString());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
