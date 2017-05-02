package com.bsuir.piskun.beans;

public class Teacher {

    private int teacherId;
    private String teacherName;
    private String teacherSurname;
    private int userId;
    private String position;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public void setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (teacherId != teacher.teacherId) return false;
        if (userId != teacher.userId) return false;
        if (teacherName != null ? !teacherName.equals(teacher.teacherName) : teacher.teacherName != null) return false;
        if (teacherSurname != null ? !teacherSurname.equals(teacher.teacherSurname) : teacher.teacherSurname != null)
            return false;
        return position != null ? position.equals(teacher.position) : teacher.position == null;

    }

    @Override
    public int hashCode() {
        int result = teacherId;
        result = 31 * result + (teacherName != null ? teacherName.hashCode() : 0);
        result = 31 * result + (teacherSurname != null ? teacherSurname.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherSurname='" + teacherSurname + '\'' +
                ", userId=" + userId +
                ", position='" + position + '\'' +
                '}';
    }
}
