/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.ApiService;
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
    private String countryCode;
    private String stateCode;
    private String distCode;

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

    /**
     * @return the countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode the countryCode to set
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * @return the stateCode
     */
    public String getStateCode() {
        return stateCode;
    }

    /**
     * @param stateCode the stateCode to set
     */
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    /**
     * @return the distCode
     */
    public String getDistCode() {
        return distCode;
    }

    /**
     * @param distCode the distCode to set
     */
    public void setDistCode(String distCode) {
        this.distCode = distCode;
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
        ArrayList emp = EmployeeService.getInstance().getAllEmployees();
        ArrayList deptList = DepartmentService.getInstance().getAllDepartment();
        ArrayList roleList = RoleService.getInstance().getAllRole();

        if (success) {
            System.out.println("returning Success from doLogin method");
            sessionMap.put("Loggedin", this);
            result = "SUCCESS";
            sessionMap.put("empList", emp);
            sessionMap.put("DeptList", deptList);
            sessionMap.put("RoleList", roleList);
        } else {
            System.out.println("returning Failure from doLogin method");
        }

        return result;
    }

    public String doLogout() {
        String result = "SUCCESS";
        sessionMap.clear();
        System.out.println("SESSION CLEARED");
        return result;
    }
    
    public String doCancel() {
        String result = "SUCCESS";
        sessionMap.clear();
        System.out.println("SESSION CLEARED");
        return result;
    }


    public String doPreSignUp() throws Exception {
        String result = "SUCCESS";

        ArrayList countryList = LoginService.getAllCountries();
        ArrayList stateList = null;
        ArrayList distList = null;

        sessionMap.put("CountryList", countryList);

        System.out.println("Country Code=" + this.countryCode);
        
        sessionMap.put("User", this);

        if (this.stateCode != null) {
            distList = LoginService.getAllDistricts(this.stateCode);
            sessionMap.put("DistList", distList);
//            sessionMap.put("User", this);
            result = "DISTLIST";           
            
        }

        if (this.countryCode != null) {
            stateList = LoginService.getAllStates(this.countryCode);
            sessionMap.put("StateList", stateList);
//            sessionMap.put("User", this);
            result = "STATELIST";
        }
        
        
        if (this.firstName != null && this.firstName.length()>0 && this.lastName != null && this.lastName.length()>0 && this.emailAddess != null && this.emailAddess.length()>0 && this.password!= null && this.password.length()>0 && this.stateCode != null && this.stateCode.length() > 0 && this.countryCode != null && this.countryCode.length() > 0 && this.distCode != null && this.distCode.length() > 0) {
            boolean success = LoginService.getInstance().doSignUp(this);

            if (success) {
                result = "DONE";
                sessionMap.put("SuccessSignUp", "Successfully Registered !!");

            } 
            System.out.println(sessionMap);
            return result;
        }

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
    
    public String apiCall() throws Exception {
        String result = "SUCCESS";
        ArrayList userList=ApiService.getInstance().getAllData();
        boolean success = LoginService.getInstance().doSignUpAll(userList);

        if (success) {
            result = "SUCCESS";
            sessionMap.put("SuccessSignUp", "Successfully Registered");

        } else {
            sessionMap.put("FailSignUp", "Email All Ready Exsists");
        }
        System.out.println(sessionMap);
        return result;

    }

}
