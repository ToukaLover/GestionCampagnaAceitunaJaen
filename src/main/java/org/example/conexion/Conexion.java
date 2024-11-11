package org.example.conexion;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
    private static Connection connection;

    static {
        try(InputStream input = ClassLoader.getSystemResourceAsStream("db.properties")){

            Properties p = new Properties();
            if (input == null) {
                System.out.println("No se encontró el archivo db.properties en el classpath.");

            }
            p.load(input);

            String url=p.getProperty("db.url");
            String user=p.getProperty("db.user");
            String password=p.getProperty("db.password");

            connection = DriverManager.getConnection(url,user,password);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        return connection;
    }

}
