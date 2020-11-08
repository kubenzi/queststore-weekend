package com.codecool.fusy_qs.dto;

public class MentorDataDto {
    private String newPassword;
    private String newEmail;

    public MentorDataDto(String newPassword, String newEmail) {
        this.newPassword = newPassword;
        this.newEmail = newEmail;
    }

    public MentorDataDto() {
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

}
