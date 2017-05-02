package com.bsuir.piskun.constants;

public enum LessonType {

    LECTURE("Lecture"), PRACTICAL("Practical"), LABORATORY_WORK("Laboratory"), TEST("Test"), EXAM("Exam");

    private String value;

    LessonType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static LessonType getLessonTypeByValue(String value) {

        LessonType lessonType = null;

        switch (value) {
            case "Lecture":
                lessonType = LECTURE;
                break;
            case "Practical":
                lessonType = PRACTICAL;
                break;
            case "Laboratory":
                lessonType = LABORATORY_WORK;
                break;
            case "Test":
                lessonType = TEST;
                break;
            case "Exam":
                lessonType = EXAM;
                break;
            default:
                break;
        }
        return lessonType;
    }

    @Override
    public String toString() {
        return value;
    }
}
