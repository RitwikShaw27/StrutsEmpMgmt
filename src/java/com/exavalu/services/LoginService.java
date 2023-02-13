/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Country;
import com.exavalu.models.District;
import com.exavalu.models.Employee;
import com.exavalu.models.Province;
import com.exavalu.models.User;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class LoginService {

    public static LoginService loginService = null;

    private LoginService() {
    }

    public static LoginService getInstance() {
        if (loginService == null) {
            return new LoginService();
        } else {
            return loginService;
        }
    }

    public boolean doLogin(User user) {
        boolean success = false;

        String sql = "Select * from users where emailAddress=? and password=?";

        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmailAddess());
            ps.setString(2, user.getPassword());

            System.out.println("LoginService :: " + ps);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                success = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return success;
    }

    public boolean doSignUp(User user) {
        boolean result = false;
        String sql = "INSERT INTO users(emailAddress,password,firstName,lastName,status,countryCode,stateCode,districtCode)" + "VALUES(? ,? ,? ,?, ?, ?, ?, ?)";

        try {
            Connection con = JDBCConnectionManager.getConnection();

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, user.getEmailAddess());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setInt(5, 1);
            preparedStatement.setString(6, user.getCountryCode());
            preparedStatement.setString(7, user.getStateCode());
            preparedStatement.setString(8, user.getDistCode());
            
            System.out.println(preparedStatement);
            int res = preparedStatement.executeUpdate();

            if (res == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            int e = ex.getErrorCode();
            System.out.println(e);
        }

        return result;

    }

    public static ArrayList getAllCountries() {

        ArrayList countryList = new ArrayList();
        Connection con = JDBCConnectionManager.getConnection();

        try {
            String sql = "Select * from countries";
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Country country = new Country();
                country.setCountryCode(rs.getString("countryCode"));
                country.setCountryName(rs.getString("countryName"));
                countryList.add(country);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return countryList;
    }

    public static ArrayList getAllStates(String countryCode) {

        ArrayList stateList = new ArrayList();
        Connection con = JDBCConnectionManager.getConnection();

        try {
            String sql = "Select * from states where countryCode = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, countryCode);

            System.out.println(ps);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Province province = new Province();
                province.setCountryCode(rs.getString("countryCode"));
                province.setProvinceName(rs.getString("stateName"));
                province.setProvinceCode(rs.getString("stateCode"));
                stateList.add(province);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return stateList;

    }

    public static ArrayList getAllDistricts(String stateCode) {
        ArrayList distList = new ArrayList();
        Connection con = JDBCConnectionManager.getConnection();

        try {
            String sql = "Select * from districts where stateCode = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, stateCode);

            System.out.println(ps);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                District dist = new District();
                dist.setDistCode(rs.getString("districtCode"));
                dist.setDistName(rs.getString("districtName"));
                dist.setProvinceCode(rs.getString("stateCode"));
                distList.add(dist);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return distList;
    }
    
    public boolean doSignUpAll(ArrayList userList) {
        boolean result = true;
        for(int i=0;i<userList.size();i++)
        {
            if(!doSignUp((User)userList.get(i)))
            {
                result=false;
            }
        }
        return result;
    }

}
