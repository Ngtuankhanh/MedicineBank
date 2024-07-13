/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DA;

import Models.Account;
import Models.Ingredent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author khanh
 */
public class IngredentDAO {

    private Connection connection = new DBContext().connection;
    private String status = "OK";

    
    public List<Ingredent> getIngredents() {
        List<Ingredent> list = new ArrayList();
        String sql = "select * from Ingredent";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String formula = rs.getString("formula");
                String description = rs.getString("description");
                list.add(new Ingredent(name, formula, description));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public Ingredent getIngredentByName(String name) {
        Ingredent ingre = null;
        String sql = "select * from Ingredent where name = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, name);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                String ingreName = rs.getString("name");
                String formula = rs.getString("formula");
                String description = rs.getString("description");
                ingre = new Ingredent(ingreName, formula, description);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return ingre;
    }
    
    public boolean checkIngredentExist(String name) {
        String sql = "select * from Ingredent where name = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, name);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    
    public void insertIngredents(String name, String formula, String description) {
        String sql = "INSERT INTO Ingredent (name, formula, description) VALUES (?, ?, ?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, name);
            pre.setString(2, formula);
            pre.setString(3, description);
            pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void deleteIngredents(String name){
        deleteMedIngredentRelationByIngre(name);
        String sql = "DELETE FROM Ingredent WHERE name = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, name);
            pre.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public boolean updateIngredents(String name,String formula,String des){
        String sql = "UPDATE Ingredent SET formula = ?, description = ? WHERE name = ?;";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, formula);
            pre.setString(2, des);
            pre.setString(3, name);
            pre.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    private void deleteMedIngredentRelationByIngre(String name) {
        String sql = "DELETE FROM Med_Ingre WHERE ingreName = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, name);
            pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        IngredentDAO adao = new IngredentDAO();
        System.out.println("");
    }



}
