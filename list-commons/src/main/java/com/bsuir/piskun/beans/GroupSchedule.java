package com.bsuir.piskun.beans;

import com.bsuir.piskun.constants.LessonType;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class GroupSchedule {

    private Group group;
    private List<String> roomNumbers;
    private List<Teacher> teachers;
    private List<Lesson> lessons;
    private List<Date> dates;

    public GroupSchedule() {
        roomNumbers = new ArrayList<>();
        teachers = new ArrayList<>();
        lessons = new ArrayList<>();
        dates = new ArrayList<>();
    }

    public Group getGroup() {
        return group;
    }

    public List<String> getRoomNumbers() {
        return roomNumbers;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public List<Date> getDates() {
        return dates;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void addLesson(String roomNumber, Teacher teacher, Lesson lesson, Date date) {
        if (roomNumber == null || roomNumber.isEmpty() || teacher == null || lesson == null ||
                date == null) {
            //TODO log
            return;
        }
        roomNumbers.add(roomNumber);
        teachers.add(teacher);
        lessons.add(lesson);
        dates.add(date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupSchedule that = (GroupSchedule) o;

        if (group != null ? !group.equals(that.group) : that.group != null) return false;
        if (roomNumbers != null ? !roomNumbers.equals(that.roomNumbers) : that.roomNumbers != null) return false;
        if (teachers != null ? !teachers.equals(that.teachers) : that.teachers != null) return false;
        if (lessons != null ? !lessons.equals(that.lessons) : that.lessons != null) return false;
        return dates != null ? dates.equals(that.dates) : that.dates == null;

    }

    @Override
    public int hashCode() {
        int result = group != null ? group.hashCode() : 0;
        result = 31 * result + (roomNumbers != null ? roomNumbers.hashCode() : 0);
        result = 31 * result + (teachers != null ? teachers.hashCode() : 0);
        result = 31 * result + (lessons != null ? lessons.hashCode() : 0);
        result = 31 * result + (dates != null ? dates.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GroupSchedule{" +
                "group=" + group +
                ", roomNumbers=" + roomNumbers +
                ", teachers=" + teachers +
                ", lessons=" + lessons +
                ", dates=" + dates +
                '}';
    }
}
