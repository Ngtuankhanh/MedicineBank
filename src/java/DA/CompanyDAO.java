/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DA;

import Models.Company;
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
public class CompanyDAO{

    private Connection connection = new DBContext().connection;
    private String status = "OK";

    public List<Company> getCompany() {
        List<Company> list = new ArrayList<>();
        String sql = "select * from Company";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                String GCN = rs.getString("GCN");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String imgURL = rs.getString("imgURL");
                list.add(new Company(GCN, name,address,phone,imgURL));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void insertCompany(String GCN,String name,String address,String phone,String imgURL){
        String sql = "INSERT INTO Company (GCN, name, address, phone, imgURL) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, GCN);
            pre.setString(2, name);
            pre.setString(3, address);
            pre.setString(4, phone);
            pre.setString(5, imgURL);
            pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public boolean checkCompanyExist(String GCN){
        String sql = "select * from Company where GCN = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, GCN);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
    public Company getCompanyByGCN(String GCN) {
        for (Company c : this.getCompany()) {
            if (c.getGCN().equals(GCN)){
                return c;
            }
        }
        return null;
    }
        
    public void deleteCompany(String GCN) {
        MedicineDAO medDao = new MedicineDAO();
        medDao.deleteMedicinebyGCN(GCN);
        String sql = "DELETE FROM Company WHERE GCN = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, GCN);
            pre.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        CompanyDAO DAO = new CompanyDAO();
        for (Company a : DAO.getCompany()) {
            System.out.println(a.getName());
        }
    }

    public boolean updateCompany(String GCN,String name, String address,String phone,String imgURL) {
        boolean check = true;
        String sql = "UPDATE Company SET name = ?, address = ?, phone = ?, imgURL = ? WHERE GCN = ?;";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, name);
            pre.setString(2, address);
            pre.setString(3, phone);
            pre.setString(4, imgURL);
            pre.setString(5, GCN);
            pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            check = false;
        }
        return check;
    }
}
