package org.example.ClasesDAO;

import org.example.conexion.Conexion;
import org.example.models.Cuadrilla;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuadrillaDAO implements org.example.dao.CuadrillaDAO {

    Connection c;

    public CuadrillaDAO() {
        this.c  = Conexion.getConnection();;
    }

    @Override
    public void add(Cuadrilla cuad) {
        String sql="insert into Cuadrilla (nombe,supervisor_id) values(?,?)";

        try(PreparedStatement st = c.prepareStatement(sql)) {

            st.setString(1, cuad.getNombre());
            st.setInt(2,cuad.getSupervisorId());

            st.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Cuadrilla> read() {
        List<Cuadrilla> lista= new ArrayList<>();
        String sql="select * from Cuadrilla";
        try(Statement st = c.createStatement()){

            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){

                Cuadrilla cuad = new Cuadrilla(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)
                );
                lista.add(cuad);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return  lista;
    }

    @Override
    public List<Cuadrilla> getCuadrillasByOlivarId(int id) {
        List<Cuadrilla> lista = new ArrayList<>();
        String sql="select cuad.* from Cuadrilla cuad,Olivar ol, Cuadrilla_Olivar cuadol where cuadol.cuadrilla_id=cuad.id and cuadol.olivar_id=ol.id where ol.id=?";
            try(PreparedStatement st = c.prepareStatement(sql)){

                st.setInt(1,id);

                ResultSet rs = st.executeQuery();

                while (rs.next()){
                    Cuadrilla cuad = new Cuadrilla(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3)
                    );
                    lista.add(cuad);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        return  lista;
    }

    @Override
    public List<Cuadrilla> getCuadrillasByTrabajadorId(int id) {
        List<Cuadrilla> lista = new ArrayList<>();
        String sql="select cuad.* from Cuadrilla cuad,Trabajador t, Cuadrilla_Trabajador cuadt where cuadt.cuadrilla_id=cuad.id and cuadt.olivar_id=t.id where t.id=?";
        try(PreparedStatement st = c.prepareStatement(sql)){

            st.setInt(1,id);

            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Cuadrilla cuad = new Cuadrilla(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)
                );
                lista.add(cuad);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  lista;
    }

    @Override
    public void update(Cuadrilla cuad) {

        String sql="update Cuadrilla nombe=?,supervisor_id=? where id=?";

        try(PreparedStatement st = c.prepareStatement(sql)){

            st.setString(1, cuad.getNombre());
            st.setInt(2,cuad.getSupervisorId());
            st.setInt(3,cuad.getId());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {

        String sql="delete Cuadrilla where id=?";

        try(PreparedStatement st = c.prepareStatement(sql)){

            st.setInt(1,id);

            st.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
