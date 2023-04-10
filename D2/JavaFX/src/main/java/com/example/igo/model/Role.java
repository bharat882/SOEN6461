package com.example.igo.model;

public class Role {
    private int roleId;
    private String roleTitle;
    private String roleDescription;

    Role(){
        this.roleId = 0;
        this.roleTitle = null;
        this.roleDescription = null;
    }

    public Role(int roleId, String roleTitle, String roleDescription) {
        this.roleId = roleId;
        this.roleTitle = roleTitle;
        this.roleDescription = roleDescription;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
