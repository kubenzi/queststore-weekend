package com.codecool.fusy_qs.Group;

public class Group {
    private String groupId;
    private String classId;
    private String groupName;
    private Integer groupWallet;
    private String mentorId;

    public Group(String groupId, String classId, String groupName,
                 Integer groupWallet, String mentorId) {
        this.groupId = groupId;
        this.classId = classId;
        this.groupName = groupName;
        this.groupWallet = groupWallet;
        this.mentorId = mentorId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGropuWallet() {
        return groupWallet;
    }

    public void setGropuWallet(Integer groupWallet) {
        this.groupWallet = groupWallet;
    }

    public String getMentorId() {
        return mentorId;
    }

    public void setMentorId(String mentorId) {
        this.mentorId = mentorId;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId='" + groupId + '\'' +
                ", classId='" + classId + '\'' +
                ", groupName='" + groupName + '\'' +
                ", groupWallet=" + groupWallet +
                ", mentorId='" + mentorId + '\'' +
                '}';
    }
}
