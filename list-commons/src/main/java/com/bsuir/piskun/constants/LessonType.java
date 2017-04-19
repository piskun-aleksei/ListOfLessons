package com.bsuir.piskun.constants;

public enum LessonType {

    LECTURE(1), PRACTICAL(2), LABORATORY_WORK(3), TEST(4), EXAM(5);

    private int value;

    LessonType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static LessonType getLessonTypeById(int id) {

        LessonType lessonType = null;

        switch (id) {
            case 1:
                lessonType = LECTURE;
                break;
            case 2:
                lessonType = PRACTICAL;
                break;
            case 3:
                lessonType = LABORATORY_WORK;
                break;
            case 4:
                lessonType = TEST;
                break;
            case 5:
                lessonType = EXAM;
                break;
            default:
                break;
        }
        return lessonType;
    }

    @Override
    public String toString() {
        switch (value) {
            case 1:
                return "LessonType{" +
                        "value= LECTURE" +
                        '}';
            case 2:
                return "LessonType{" +
                        "value= PRACTICAL" +
                        '}';
            case 3:
                return "LessonType{" +
                        "value= LABORATORY WORK" +
                        '}';
            case 4:
                return "LessonType{" +
                        "value= TEST" +
                        '}';
            case 5:
                return "LessonType{" +
                        "value= EXAM" +
                        '}';
            default:
                break;
        }
        return Integer.toString(value);
    }
}
