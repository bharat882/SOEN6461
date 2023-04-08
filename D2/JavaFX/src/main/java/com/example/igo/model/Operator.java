package com.example.igo.model;

public class Operator extends Role{
    private int operatorId;
    private int roleId;
    private String title;
    private String name;
    private String email;

    Operator(){
        super();
        this.operatorId = 0;
        this.roleId = 0;
        this.title = null;
        this.name = null;
        this.email = null;
    }

    public Operator(int operatorId, int roleId, String title, String name, String email) {
        this.operatorId = operatorId;
        this.roleId = roleId;
        this.title = title;
        this.name = name;
        this.email = email;
    }

    public Operator(int roleId, String title, String description, int operatorId, int roleId1, String title1, String name, String email) {
        super(roleId, title, description);
        this.operatorId = operatorId;
        this.roleId = roleId1;
        this.title = title1;
        this.name = name;
        this.email = email;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    @Override
    public int getRoleId() {
        return roleId;
    }

    @Override
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
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
