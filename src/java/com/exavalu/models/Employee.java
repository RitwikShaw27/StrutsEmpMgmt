/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.EmployeeService;
import com.exavalu.services.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class Employee extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    private String employeeId;
    private String firstName ;
    private String lastName ;
    private String phoneNumber ;
    private String address ;
    private String gender ;
    private String departmentId ;
    private String roleId ;
    private String basicSalary ;
    private String carAllowance;
    private String dearnessAllowance;
    private String departmentName;
    private String roleName;
    private int status;

    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    @Override
    public void setApplication(Map<String, Object> application) {
        setMap((ApplicationMap) application);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        setSessionMap((SessionMap<String, Object>) (SessionMap) session);
    }
    
    
    public String doEdit() throws Exception {
        String result = "FAILURE";
        System.out.println(this.getEmployeeId());
        Employee emp = EmployeeService.getInstance().getEmployee(this.getEmployeeId());
//        boolean success = EmployeeService.getInstance().doEdit(this, this.employeeId);

        if (this != null) {
            sessionMap.put("Emp", emp);
            System.out.println("returning Employee");
            System.out.println(sessionMap);
            System.out.println(emp.getFirstName());
            
            result = "SUCCESS";
        } else {
            System.out.println("returning Failure from doEdit method");
        }
        return result;
    }
    
    public String saveEmployee() throws Exception {
        String result = "FAILURE";
        boolean success = EmployeeService.getInstance().doEdit(this);

        if (success) {
            System.out.println("returning success from editemployee method");
            ArrayList empList = EmployeeService.getInstance().getAllEmployees();
            sessionMap.put("empList", empList);
            result = "SUCCESS";
        } else {
            System.out.println("returning Failure from editemployee method");
        }
        return result;
    }
    
     public String findEmployee() throws Exception {
        String result = "FAILURE";
        ArrayList empList = EmployeeService.getInstance().searchEmployee(this);

        if (!empList.isEmpty()) {
            System.out.println("returning success from findemployee method");
            sessionMap.put("empList1", empList);

            result = "SUCCESS";
        } else {
            System.out.println("returning Failure from findemployee method");
        }
        return result;
    }
     
     
     public String addEmployee() throws Exception {
        String result = "FAILURE";
        boolean success = EmployeeService.getInstance().addnewEmployee(this);

        if (success) {
            System.out.println("returning success from addemployee method");
            String msg="Employee added successfully !";
            ArrayList empList = EmployeeService.getInstance().getAllEmployees();
            sessionMap.put("empList", empList);
            sessionMap.put("Success", msg);
            System.out.println(sessionMap);
            result = "SUCCESS";
        } else {
            System.out.println("returning Failure from addemployee method");
             String msg="Data not Added to the table";
            sessionMap.put("Failure", msg);
        }
        return result;
    }
     
     public String delete() throws Exception {
        String result = "FAILURE";
        System.out.println(this.getEmployeeId());
        boolean success = EmployeeService.getInstance().deleteEmployee(this.getEmployeeId());
        if (success) {
            String msg="Employee deleted successfully !";
            ArrayList empList = EmployeeService.getInstance().getAllEmployees();
            sessionMap.put("empList", empList);
            sessionMap.put("deleteSuccess", msg);
            result = "SUCCESS";
        }
        return result;
    }
     
    

    

    /**
     * @return the employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }


    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the roleId
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the sessionMap
     */
    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    /**
     * @param sessionMap the sessionMap to set
     */
    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    /**
     * @return the map
     */
    public ApplicationMap getMap() {
        return map;
    }

    /**
     * @param map the map to set
     */
    public void setMap(ApplicationMap map) {
        this.map = map;
    }
    
    
     

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the departmentId
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId the departmentId to set
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * @return the basicSalary
     */
    public String getBasicSalary() {
        return basicSalary;
    }

    /**
     * @param basicSalary the basicSalary to set
     */
    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary;
    }

    /**
     * @return the carAllowance
     */
    public String getCarAllowance() {
        return carAllowance;
    }

    /**
     * @param carAllowance the carAllowance to set
     */
    public void setCarAllowance(String carAllowance) {
        this.carAllowance = carAllowance;
    }

    /**
     * @return the dearnessAllowance
     */
    public String getDearnessAllowance() {
        return dearnessAllowance;
    }

    /**
     * @param dearnessAllowance the dearnessAllowance to set
     */
    public void setDearnessAllowance(String dearnessAllowance) {
        this.dearnessAllowance = dearnessAllowance;
    }

    /**
     * @return the departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName the departmentName to set
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName the roleName to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
