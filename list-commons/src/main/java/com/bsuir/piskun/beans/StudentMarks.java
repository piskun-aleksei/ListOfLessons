package com.bsuir.piskun.beans;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StudentMarks {

    private int studentId;
    private int lessonId;
    private String studentName;
    private String studentSurname;
    private Map<Integer, Integer> marks = new LinkedHashMap<>();
    private List<Boolean> absents =  new ArrayList<>();

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public List<Boolean> getAbsents() {
        return absents;
    }

    public void setAbsents(List<Boolean> absents) {
        this.absents = absents;
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

    public Map<Integer, Integer> getMarks() {
        return marks;
    }

    public void setMarks(Map<Integer, Integer> marks) {
        this.marks = marks;
    }

    public void addMark(Integer mark, boolean absent, Integer scheduleId) {
        marks.put(scheduleId, mark);
        absents.add(absent);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        StudentMarks that = (StudentMarks) o;

        if (studentId != that.studentId) {
            return false;
        }
        if (lessonId != that.lessonId) {
            return false;
        }
        if (studentName != null ? !studentName.equals(that.studentName) : that.studentName != null) {
            return false;
        }
        if (studentSurname != null ? !studentSurname.equals(that.studentSurname) : that.studentSurname != null) {
            return false;
        }
        if (marks != null ? !marks.equals(that.marks) : that.marks != null) {
            return false;
        }
        return absents != null ? absents.equals(that.absents) : that.absents == null;
    }

    @Override
    public int hashCode() {
        int result = studentId;
        result = 31 * result + lessonId;
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (studentSurname != null ? studentSurname.hashCode() : 0);
        result = 31 * result + (marks != null ? marks.hashCode() : 0);
        result = 31 * result + (absents != null ? absents.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StudentMarks{" +
                "studentId=" + studentId +
                ", lessonId=" + lessonId +
                ", studentName='" + studentName + '\'' +
                ", studentSurname='" + studentSurname + '\'' +
                ", marks=" + marks +
                ", absents=" + absents +
                '}';
    }
}
