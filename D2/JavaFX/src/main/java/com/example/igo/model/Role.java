package com.example.igo.model;

public class Role {
    private int roleId;
    private String title;
    private String description;

    Role(){
        this.roleId = 0;
        this.title = null;
        this.description = null;
    }

    public Role(int roleId, String title, String description) {
        this.roleId = roleId;
        this.title = title;
        this.description = description;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
