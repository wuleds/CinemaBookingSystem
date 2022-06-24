package com.wule.pojo;

//创建于2022/6/23 23:13
public class Seat
{
    String userNum;
    String cinemaNum;
    String filmDate;
    String eventNum;
    String seatNum;

    @Override
    public String toString() {
        return "Seat{" +
                "userNum='" + userNum + '\'' +
                ", cinemaNum='" + cinemaNum + '\'' +
                ", filmDate='" + filmDate + '\'' +
                ", eventNum='" + eventNum + '\'' +
                ", seatNum='" + seatNum + '\'' +
                '}';
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    public String getCinemaNum() {
        return cinemaNum;
    }

    public void setCinemaNum(String cinemaNum) {
        this.cinemaNum = cinemaNum;
    }

    public String getFilmDate() {
        return filmDate;
    }

    public void setFilmDate(String filmDate) {
        this.filmDate = filmDate;
    }

    public String getEventNum() {
        return eventNum;
    }

    public void setEventNum(String eventNum) {
        this.eventNum = eventNum;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }
}
