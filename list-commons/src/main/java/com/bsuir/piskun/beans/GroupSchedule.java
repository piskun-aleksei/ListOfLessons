package com.bsuir.piskun.beans;

import java.util.ArrayList;
import java.util.List;

public class GroupSchedule {

    private List<CalendarLesson> calendarLessons = new ArrayList<>();
    private List<StudentMarks> studentMarks = new ArrayList<>();

    public List<CalendarLesson> getCalendarLessons() {
        return calendarLessons;
    }

    public void setCalendarLessons(List<CalendarLesson> calendarLessons) {
        this.calendarLessons = calendarLessons;
    }

    public List<StudentMarks> getStudentMarks() {
        return studentMarks;
    }

    public void setStudentMarks(List<StudentMarks> studentMarks) {
        this.studentMarks = studentMarks;
    }

    public void addCalendarLesson(CalendarLesson lesson) {
        if (lesson != null) {
            calendarLessons.add(lesson);
        }
    }

    public void addStudentMarks(StudentMarks marks) {
        if (marks != null) {
            studentMarks.add(marks);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupSchedule that = (GroupSchedule) o;

        if (calendarLessons != null ? !calendarLessons.equals(that.calendarLessons) : that.calendarLessons != null)
            return false;
        return studentMarks != null ? studentMarks.equals(that.studentMarks) : that.studentMarks == null;

    }

    @Override
    public int hashCode() {
        int result = calendarLessons != null ? calendarLessons.hashCode() : 0;
        result = 31 * result + (studentMarks != null ? studentMarks.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GroupSchedule{" +
                "calendarLessons=" + calendarLessons +
                ", studentMarks=" + studentMarks +
                '}';
    }
}
