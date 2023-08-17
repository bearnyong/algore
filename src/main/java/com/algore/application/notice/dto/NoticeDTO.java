package com.algore.application.notice.dto;

import java.util.Date;

public class NoticeDTO {

    private int nNum; //공지번호
    private String nTitle; //공지제목
    private String nDetail; //공지내용
    private Date nDate; //작성날짜
    private String nStatus; //상태
    private Date nModiDate; //수정날짜

    public NoticeDTO() {
    }

    public NoticeDTO(int nNum, String nTitle, String nDetail, Date nDate, String nStatus, Date nModiDate) {
        this.nNum = nNum;
        this.nTitle = nTitle;
        this.nDetail = nDetail;
        this.nDate = nDate;
        this.nStatus = nStatus;
        this.nModiDate = nModiDate;
    }

    public int getnNum() {
        return nNum;
    }

    public void setnNum(int nNum) {
        this.nNum = nNum;
    }

    public String getnTitle() {
        return nTitle;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public String getnDetail() {
        return nDetail;
    }

    public void setnDetail(String nDetail) {
        this.nDetail = nDetail;
    }

    public Date getnDate() {
        return nDate;
    }

    public void setnDate(Date nDate) {
        this.nDate = nDate;
    }

    public String getnStatus() {
        return nStatus;
    }

    public void setnStatus(String nStatus) {
        this.nStatus = nStatus;
    }

    public Date getnModiDate() {
        return nModiDate;
    }

    public void setnModiDate(Date nModiDate) {
        this.nModiDate = nModiDate;
    }

    @Override
    public String toString() {
        return "NoticeDTO{" +
                "nNum=" + nNum +
                ", nTitle='" + nTitle + '\'' +
                ", nDetail='" + nDetail + '\'' +
                ", nDate=" + nDate +
                ", nStatus='" + nStatus + '\'' +
                ", nModiDate=" + nModiDate +
                '}';
    }
}
