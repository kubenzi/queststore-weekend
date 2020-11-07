package com.codecool.fusy_qs.dto;

public class LoginDto {
    private boolean logged;

    public LoginDto(boolean logged) {
        this.logged = logged;
    }

    public LoginDto() {
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }
}
