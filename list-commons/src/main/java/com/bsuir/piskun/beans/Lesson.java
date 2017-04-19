package com.bsuir.piskun.beans;

import com.bsuir.piskun.constants.LessonStartTime;
import com.bsuir.piskun.constants.LessonType;

import java.util.Date;

public class Lesson {

    private Date date;
    private LessonType lessonType;
    private LessonStartTime lessonStartTime;
    private String roomName;

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

    public LessonStartTime getLessonStartTime() {
        return lessonStartTime;
    }

    public void setLessonStartTime(LessonStartTime lessonStartTime) {
        this.lessonStartTime = lessonStartTime;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Lesson lesson = (Lesson) o;

        if (getDate() != null ? !getDate().equals(lesson.getDate()) : lesson.getDate() != null) {
            return false;
        }
        if (getLessonType() != lesson.getLessonType()) {
            return false;
        }
        if (getLessonStartTime() != lesson.getLessonStartTime()) {
            return false;
        }
        return getRoomName() != null ? getRoomName().equals(lesson.getRoomName()) : lesson.getRoomName() == null;
    }

    @Override
    public int hashCode() {
        int result = getDate() != null ? getDate().hashCode() : 0;
        result = 31 * result + (getLessonType() != null ? getLessonType().hashCode() : 0);
        result = 31 * result + (getLessonStartTime() != null ? getLessonStartTime().hashCode() : 0);
        result = 31 * result + (getRoomName() != null ? getRoomName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "date=" + date +
                ", lessonType=" + lessonType.toString() +
                ", lessonStartTime=" + lessonStartTime.getValue() +
                ", roomName='" + roomName + '\'' +
                '}';
    }
}
