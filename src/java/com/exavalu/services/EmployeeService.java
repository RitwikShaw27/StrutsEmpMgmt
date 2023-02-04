/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Employee;
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
public class EmployeeService {

    public static EmployeeService employeeService = null;

    public static EmployeeService getInstance() {
        if (employeeService == null) {
            return new EmployeeService();
        } else {
            return employeeService;
        }
    }

    public ArrayList getAllEmployees() {
        ArrayList empList = new ArrayList();
        String sql = "Select * from employees e,departments d,roles r where e.departmentId=d.departmentId and e.roleId=r.roleId";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);

            while (rs.next()) {
                Employee emp = new Employee();

                emp.setEmployeeId(rs.getString("employeeId"));
                emp.setFirstName(rs.getString("firstName"));
                emp.setLastName(rs.getString("lastName"));
                emp.setPhoneNumber(rs.getString("phoneNumber"));
                emp.setGender(rs.getString("gender"));
                emp.setAddress(rs.getString("address"));
                emp.setDepartmentName(rs.getString("departmentName"));
                emp.setRoleName(rs.getString("roleName"));
                emp.setBasicSalary(rs.getString("basicSalary"));
                emp.setCarAllowance(rs.getString("carAllowance"));
                emp.setDearnessAllowance(rs.getString("dearnessAllowance"));

                empList.add(emp);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.err.println("Total rows:" + empList.size());
        return empList;
    }

    public boolean doEdit(Employee emp) {
        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE employeedb.employees\n"
                    + "SET firstName = ? , lastName = ? , phoneNumber = ? , address = ? ,\n"
                    + "gender = ? ,  basicSalary = ?,carAllowance = ? , departmentId = ? , roleId = ?\n"
                    + "WHERE employeeId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, emp.getFirstName());
            preparedStatement.setString(2, emp.getLastName());
            preparedStatement.setString(3, emp.getPhoneNumber());
            preparedStatement.setString(4, emp.getAddress());
            preparedStatement.setString(5, emp.getGender());
            preparedStatement.setDouble(6, Double.parseDouble(emp.getBasicSalary()));
            preparedStatement.setDouble(7, Double.parseDouble(emp.getCarAllowance()));
            preparedStatement.setString(8, emp.getDepartmentId());
            preparedStatement.setString(9, emp.getRoleId());

            preparedStatement.setString(10, emp.getEmployeeId());

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;

    }
    
    public Employee getEmployee(String Id) {
        Employee emp = new Employee();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from employees e, departments d, roles r "
                    + "where e.departmentId=d.departmentId and e.roleId=r.roleId and e.employeeId =?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, Id);

            ResultSet rs = preparedStatement.executeQuery();
            System.out.print(preparedStatement);
            while (rs.next()) {
                emp.setAddress(rs.getString("address"));
                emp.setEmployeeId(rs.getString("employeeId"));
                emp.setFirstName(rs.getString("firstName"));
                emp.setLastName(rs.getString("lastName"));
                emp.setPhoneNumber(rs.getString("phoneNumber"));
                emp.setGender(rs.getString("gender"));
//                emp.setAge(rs.getString("age"));
                emp.setDepartmentName(rs.getString("departmentName"));
                emp.setRoleName(rs.getString("roleName"));
                emp.setBasicSalary(rs.getString("basicSalary"));
                emp.setCarAllowance(rs.getString("carAllowance"));
                emp.setDearnessAllowance(rs.getString("dearnessAllowance"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return emp;
    }
    
    
    public ArrayList searchEmployee(Employee emp) {
        ArrayList empList = new ArrayList<>();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from employees e, departments d, roles r where e.departmentId=d.departmentId and e.roleId=r.roleId "
                    + "having firstName like ? and lastName like ? and gender like ? and d.departmentId like ? and e.roleId like ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            System.out.println(emp.getFirstName());
            preparedStatement.setString(1, emp.getFirstName() + "%");
            preparedStatement.setString(2, emp.getLastName() + "%");
            preparedStatement.setString(3, emp.getGender() + "%");
            preparedStatement.setString(4, emp.getDepartmentId() + "%");
            preparedStatement.setString(5, emp.getRoleId() + "%");
            System.out.println("Prepared statement = " + preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Employee emp1 = new Employee();
                emp1.setEmployeeId(rs.getString("employeeId"));
                emp1.setFirstName(rs.getString("firstName"));
                emp1.setLastName(rs.getString("lastName"));
                emp1.setPhoneNumber(rs.getString("phoneNumber"));
                emp1.setGender(rs.getString("gender"));
                emp1.setAddress(rs.getString("address"));
                emp1.setDepartmentId(rs.getString("departmentId"));
                emp1.setDepartmentName(rs.getString("departmentName"));

                emp1.setRoleId(rs.getString("roleId"));
                emp1.setRoleName(rs.getString("roleName"));
                emp1.setBasicSalary(rs.getString("basicSalary"));
                emp1.setCarAllowance(rs.getString("carAllowance"));
                emp1.setDearnessAllowance(rs.getString("dearnessAllowance"));

                empList.add(emp1);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empList;
    }
    
    public boolean addnewEmployee(Employee emp) {
        boolean result = false;

        try {
            Connection con = JDBCConnectionManager.getConnection();

            String sql = "INSERT INTO employees (firstName,lastName,phoneNumber,address,gender,departmentId,roleId,basicSalary,carAllowance,dearnessAllowance)"
                    + "VALUES(?,?, ? ,? ,? ,?,? ,? ,?, ? )";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, emp.getFirstName());
            preparedStatement.setString(2, emp.getLastName());
            preparedStatement.setString(3, emp.getPhoneNumber());
            preparedStatement.setString(4, emp.getAddress());
            preparedStatement.setString(5, emp.getGender());
            preparedStatement.setString(6, emp.getDepartmentId());
            preparedStatement.setString(7, emp.getRoleId());
            preparedStatement.setDouble(8, Double.parseDouble(emp.getBasicSalary()));
            preparedStatement.setDouble(9, Double.parseDouble(emp.getCarAllowance()));
            preparedStatement.setDouble(10, Double.parseDouble(emp.getDearnessAllowance()));
            System.out.println(preparedStatement);
            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    public boolean deleteEmployee(String employeeId) {
        boolean result = false;
        try {

            Connection con = JDBCConnectionManager.getConnection();
            String sql = "DELETE FROM employees" + " WHERE employeeId = " + employeeId;
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            int row = preparedStatement.executeUpdate();
            if (row != 0) {
                result = true;
            }
            System.out.println("ROW DELETED !!");
            

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
