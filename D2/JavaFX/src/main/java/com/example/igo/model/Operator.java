package com.example.igo.model;

public class Operator extends Role{
    private int operatorId;
    private String operatorTitle;
    private String name;
    private String email;

    Operator(){
        super();
        this.operatorId = 0;
        this.operatorTitle = null;
        this.name = null;
        this.email = null;
    }

    public Operator(int operatorId, String operatorTitle, String name, String email) {
        this.operatorId = operatorId;
        this.operatorTitle = operatorTitle;
        this.name = name;
        this.email = email;
    }

    public Operator(int roleId, String roleTitle, String roleDescription, int operatorId, String operatorTitle, String name, String email) {
        super(roleId, roleTitle, roleDescription);
        this.operatorId = operatorId;
        this.operatorTitle = operatorTitle;
        this.name = name;
        this.email = email;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorTitle() {
        return operatorTitle;
    }

    public void setOperatorTitle(String operatorTitle) {
        this.operatorTitle = operatorTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
