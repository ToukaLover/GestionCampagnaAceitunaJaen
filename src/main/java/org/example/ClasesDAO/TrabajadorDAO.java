package org.example.ClasesDAO;

import org.example.conexion.Conexion;
import org.example.models.Olivar;
import org.example.models.Trabajador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorDAO implements org.example.dao.TrabajadorDAO {

    Connection c;

    public TrabajadorDAO() {
        this.c = Conexion.getConnection();
    }

    @Override
    public void add(Trabajador t) {
        String sql="insert into Trabajador (nombre,edad,puesto,salario) values(?,?,?,?) ";
        try (PreparedStatement st = c.prepareStatement(sql)){

            st.setString(1,t.getNombre());
            st.setInt(2,t.getId());
            st.setString(3,t.getPuesto());
            st.setDouble(4,t.getSalario());

            st.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Trabajador t) {
        String sql = "update Trabajador set nombe=?,edad=?,puesto=?,salario=? where id=?";

        try(PreparedStatement st = c.prepareStatement(sql)) {

            st.setString(1,t.getNombre());
            st.setInt(2,t.getEdad());
            st.setString(3,t.getPuesto());
            st.setDouble(4,t.getSalario());
            st.setInt(5,t.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        String sql="delete from Trabajador where id=?";

        try (PreparedStatement st = c.prepareStatement(sql)){

            st.setInt(1,id);

            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Trabajador> read() {
        List<Trabajador> lista=new ArrayList<>();

        String sql ="select * from Trabajador";

        try(Statement st = c.createStatement()){

            ResultSet rs =st.executeQuery(sql);

            while (rs.next()){
                Trabajador t = new Trabajador(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getDouble(5)
                );
                lista.add(t);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    @Override
    public void asociarCuadTrab(int id_Cuad, int id_Trab) {
        String sql="insert into Cuadrilla_Trabajador (cuadrilla_id,trabajador_id) values (?,?)";

        try (PreparedStatement st = c.prepareStatement(sql)){
            st.setInt(1,id_Cuad);
            st.setInt(2,id_Trab);

            st.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}