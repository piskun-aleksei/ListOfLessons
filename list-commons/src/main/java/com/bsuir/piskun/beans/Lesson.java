package com.bsuir.piskun.beans;

import com.bsuir.piskun.constants.LessonType;


public class Lesson {

    private int lessonId;
    private String lessonName;
    private LessonType lessonType;

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
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

        Lesson lesson = (Lesson) o;

        if (lessonId != lesson.lessonId) return false;
        if (lessonName != null ? !lessonName.equals(lesson.lessonName) : lesson.lessonName != null) return false;
        return lessonType == lesson.lessonType;

    }

    @Override
    public int hashCode() {
        int result = lessonId;
        result = 31 * result + (lessonName != null ? lessonName.hashCode() : 0);
        result = 31 * result + (lessonType != null ? lessonType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonId=" + lessonId +
                ", lessonName='" + lessonName + '\'' +
                ", lessonType=" + lessonType +
                '}';
    }
}
