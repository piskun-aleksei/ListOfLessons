package com.bsuir.piskun.beans;

public class Room {

    private int roomId;
    private String roomNumber;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Room room = (Room) o;

        if (roomId != room.roomId) {
            return false;
        }
        return roomNumber != null ? roomNumber.equals(room.roomNumber) : room.roomNumber == null;
    }

    @Override
    public int hashCode() {
        int result = roomId;
        result = 31 * result + (roomNumber != null ? roomNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomNumber='" + roomNumber + '\'' +
                '}';
    }
}
