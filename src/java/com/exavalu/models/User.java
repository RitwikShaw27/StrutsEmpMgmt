/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.DepartmentService;
import com.exavalu.services.EmployeeService;
import com.exavalu.services.LoginService;
import com.exavalu.services.RoleService;
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
 * @author anich
 */
public class User extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    /**
     * @param args the command line arguments
     */
    private String firstName;
    private String lastName;
    private String emailAddess;
    private String password;
//    private int status;

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
     * @return the emailAddess
     */
    public String getEmailAddess() {
        return emailAddess;
    }

    /**
     * @param emailAddess the emailAddess to set
     */
    public void setEmailAddess(String emailAddess) {
        this.emailAddess = emailAddess;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    @Override
    public void setApplication(Map<String, Object> application) {
        map = (ApplicationMap) application;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        sessionMap = (SessionMap) session;
    }

    public String doLogin() throws Exception {
        String result = "FAILURE";

        boolean success = LoginService.getInstance().doLogin(this);
        ArrayList emp=EmployeeService.getInstance().getAllEmployees();
        ArrayList deptList = DepartmentService.getInstance().getAllDepartment();
        ArrayList roleList = RoleService.getInstance().getAllRole();

        if (success) {
            System.out.println("returning Success from doLogin method");
            sessionMap.put("Loggedin", this);
            result = "SUCCESS";
            sessionMap.put("empList",emp);
            sessionMap.put("DeptList", deptList);
            sessionMap.put("RoleList", roleList);
        } else {
            System.out.println("returning Failure from doLogin method");
        }

        return result;
    }
    
    public String doLogout(){
        String result = "SUCCESS";
        sessionMap.clear();
        return result;
    }
    
    public String doSignUp() throws Exception {
        String result = "FAILURE";
        boolean success = LoginService.getInstance().doSignUp(this);

        if (success) {
            result = "SUCCESS";
            System.out.println(sessionMap);
            sessionMap.put("SuccessSignUp", "Successfully Registered");

        } else {
            sessionMap.put("FailSignUp", "Email already exists !");
        }
        System.out.println(sessionMap);
        return result;

    }

    
    
    
}