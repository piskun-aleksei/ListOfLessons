package com.bsuir.piskun.beans;

public class Student {

    private int studentId;
    private String studentName;
    private String studentSurname;
    private int userId;
    private String studentCardNumber;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStudentCardNumber() {
        return studentCardNumber;
    }

    public void setStudentCardNumber(String studentCardNumber) {
        this.studentCardNumber = studentCardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (studentId != student.studentId) return false;
        if (userId != student.userId) return false;
        if (studentName != null ? !studentName.equals(student.studentName) : student.studentName != null) return false;
        if (studentSurname != null ? !studentSurname.equals(student.studentSurname) : student.studentSurname != null)
            return false;
        return studentCardNumber != null ? studentCardNumber.equals(student.studentCardNumber) : student.studentCardNumber == null;

    }

    @Override
    public int hashCode() {
        int result = studentId;
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (studentSurname != null ? studentSurname.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + (studentCardNumber != null ? studentCardNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentSurname='" + studentSurname + '\'' +
                ", userId=" + userId +
                ", studentCardNumber='" + studentCardNumber + '\'' +
                '}';
    }
}
