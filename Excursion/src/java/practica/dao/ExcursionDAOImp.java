/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import practica.model.Excursion;
import practica.util.UtilDB;

/**
 *
 * @author Karla
 */
public class ExcursionDAOImp implements ExcursionDAO {

    private Connection connection;
    
    public ExcursionDAOImp(){
       connection = UtilDB.getConnection();
    }
    @Override
    public void agregarExcursion(Excursion excursion) {
        try {
            String query = "INSERT INTO excursiones (destino, actividad, transporte, hotel)"
                    + "VALUES(?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, excursion.getDestino());
            ps.setString(2, excursion.getTransporte());
            ps.setString(3, excursion.getActividad());
            ps.setString(4, excursion.getHotel());            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarExcursion(int idExcursion) {
        try {
            String query = "DELETE FROM excursiones WHERE id_Excursion = ?";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setInt(1, idExcursion);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cambiarExcursion(Excursion excursion) {
        try {
            String query = "UPDATE excursiones SET destino =?,"
                    + "actividad =?,"
                    + "transporte =?,"
                    + "hotel = ?"
                    + "WHERE id_Excursion =?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, excursion.getDestino());
            ps.setString(2, excursion.getActividad());
            ps.setString(3, excursion.getTransporte());
            ps.setString(4, excursion.getHotel());
            ps.setInt(5, excursion.getIdExcursion());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    


    @Override
    public Excursion elegirExcursion(int idExcursion) {
        Excursion excursion = null;

        try {
            String query = "SELECT * FROM excursiones WHERE id_Excursion = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idExcursion);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                excursion = new Excursion(
                        rs.getInt("id_Excursion"), rs.getString("destino"), rs.getString("actividad"), rs.getString("transporte"), rs.getString("hotel"));

            }
            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return excursion;
    }

    @Override
    public List<Excursion> desplegarExcursion() {
        List<Excursion> excursiones = new ArrayList<Excursion>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(
                    "SELECT * FROM excursiones");
            while (rs.next()) {
                Excursion excursion = new Excursion(
                        rs.getInt("id_Excursion"), rs.getString("destino"), rs.getString("actividad"), rs.getString("transporte"), rs.getString("hotel"));
                excursiones.add(excursion);
            }
            rs.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return excursiones;
    }   

}
