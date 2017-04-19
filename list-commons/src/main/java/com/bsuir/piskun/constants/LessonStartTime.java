package com.bsuir.piskun.constants;

public enum LessonStartTime {

    FIRST(1), SECOND(2), THIRD(3), FOURTH(4), FIFTH(5), SIXTH(6),
        SEVENTH(7), EIGHTH(8);

    private String value;

    LessonStartTime(int order) {
        switch (order) {
            case 1:
                this.value = "08:00";
                break;
            case 2:
                this.value = "09:45";
                break;
            case 3:
                this.value = "11:40";
                break;
            case 4:
                this.value = "13:25";
                break;
            case 5:
                this.value = "15:20";
                break;
            case 6:
                this.value = "17:05";
                break;
            case 7:
                this.value = "18:45";
                break;
            case 8:
                this.value = "20:25";
                break;
            default:
                break;
        }
    }

    public String getValue() {
        return value;
    }

    public void setValue(int order) {
        switch (order) {
            case 1:
                this.value = "08:00";
                break;
            case 2:
                this.value = "09:45";
                break;
            case 3:
                this.value = "11:40";
                break;
            case 4:
                this.value = "13:25";
                break;
            case 5:
                this.value = "15:20";
                break;
            case 6:
                this.value = "17:05";
                break;
            case 7:
                this.value = "18:45";
                break;
            case 8:
                this.value = "20:25";
                break;
            default:
                break;
        }
    }

    public static LessonStartTime getLessonTimeStartByOrder(int order) {

        LessonStartTime lessonStartTime = null;

        switch (order) {
            case 1:
                lessonStartTime = FIRST;
                break;
            case 2:
                lessonStartTime = SECOND;
                break;
            case 3:
                lessonStartTime = THIRD;
                break;
            case 4:
                lessonStartTime = FOURTH;
                break;
            case 5:
                lessonStartTime = FIFTH;
                break;
            case 6:
                lessonStartTime = SIXTH;
                break;
            case 7:
                lessonStartTime = SEVENTH;
                break;
            case 8:
                lessonStartTime = EIGHTH;
                break;
            default:
                break;
        }
        return lessonStartTime;
    }
}
