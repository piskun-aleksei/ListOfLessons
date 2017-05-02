package com.bsuir.piskun.beans;

import com.bsuir.piskun.constants.LessonType;

import java.util.Date;

public class GroupSchedule {

    private Group group;
    private String roomNumber;
    private Teacher teacher;
    private Lesson lesson;
    private Date date;
    private LessonType lessonType;

    public Group getGroup() {
        return group;
    }

    public void setGroupNumber(Group group) {
        this.group = group;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LessonType getLessonType() {
        return lessonType;
    }

    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupSchedule that = (GroupSchedule) o;

        if (group != null ? !group.equals(that.group) : that.group != null) return false;
        if (roomNumber != null ? !roomNumber.equals(that.roomNumber) : that.roomNumber != null) return false;
        if (teacher != null ? !teacher.equals(that.teacher) : that.teacher != null) return false;
        if (lesson != null ? !lesson.equals(that.lesson) : that.lesson != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return lessonType == that.lessonType;

    }

    @Override
    public int hashCode() {
        int result = group != null ? group.hashCode() : 0;
        result = 31 * result + (roomNumber != null ? roomNumber.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + (lesson != null ? lesson.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GroupSchedule{" +
                "group=" + group +
                ", roomNumber='" + roomNumber + '\'' +
                ", teacher='" + teacher + '\'' +
                ", lesson=" + lesson +
                ", date=" + date +
                ", lessonType=" + lessonType +
                '}';
    }
}
