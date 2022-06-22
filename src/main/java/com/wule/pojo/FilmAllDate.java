package com.wule.pojo;

//创建于2022/6/22 10:01
public class FilmAllDate
{
    String cinemaNum;//放映厅编号
    String eventNum;//场次号
    String filmDate;//播放日期
    String filmNum;//电影号
    String filmName;//电影名
    String filmProfile;//电影简介
    String filmClass;//电影分类
    String filmPrice;//电影价格
    String eventBeginTime;//场次开始时间
    String eventEndTime;//场次结束时间


    @Override
    public String toString() {
        return "FilmAllDate{" +
                "cinemaNum='" + cinemaNum + '\'' +
                ", eventNum='" + eventNum + '\'' +
                ", filmDate='" + filmDate + '\'' +
                ", filmNum='" + filmNum + '\'' +
                ", filmName='" + filmName + '\'' +
                ", filmProfile='" + filmProfile + '\'' +
                ", filmClass='" + filmClass + '\'' +
                ", filmPrice='" + filmPrice + '\'' +
                ", eventBeginTime='" + eventBeginTime + '\'' +
                ", eventEndTime='" + eventEndTime + '\'' +
                '}';
    }

    public String getCinemaNum() {
        return cinemaNum;
    }

    public void setCinemaNum(String cinemaNum) {
        this.cinemaNum = cinemaNum;
    }

    public String getEventNum() {
        return eventNum;
    }

    public void setEventNum(String eventNum) {
        this.eventNum = eventNum;
    }

    public String getFilmDate() {
        return filmDate;
    }

    public void setFilmDate(String filmDate) {
        this.filmDate = filmDate;
    }

    public String getFilmNum() {
        return filmNum;
    }

    public void setFilmNum(String filmNum) {
        this.filmNum = filmNum;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmProfile() {
        return filmProfile;
    }

    public void setFilmProfile(String filmProfile) {
        this.filmProfile = filmProfile;
    }

    public String getFilmClass() {
        return filmClass;
    }

    public void setFilmClass(String filmClass) {
        this.filmClass = filmClass;
    }

    public String getFilmPrice() {
        return filmPrice;
    }

    public void setFilmPrice(String filmPrice) {
        this.filmPrice = filmPrice;
    }

    public String getEventBeginTime() {
        return eventBeginTime;
    }

    public void setEventBeginTime(String eventBeginTime) {
        this.eventBeginTime = eventBeginTime;
    }

    public String getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(String eventEndTime) {
        this.eventEndTime = eventEndTime;
    }
}
