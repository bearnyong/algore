package com.algore.application.kitchenguide.dto;

import org.springframework.web.multipart.MultipartFile;

public class TrimProcedureDTO {

    private int tpStepNum; //단계번호
    private int trimNum; //손질번호
    private String tpFileName; //파일명
    private String tpDetail; //내용
    private String tpPath; //저장경로
    private MultipartFile inputFile;//손질사진
    private String saveName; //저장이름

    public TrimProcedureDTO() {
    }

    public TrimProcedureDTO(String tpPath, String saveName, int trimNum) {
        /*write, update에서 사진 저장에 필요한 생성자*/
        this.tpPath = tpPath;
        this.saveName = saveName;
        this.trimNum = trimNum;
    }

    public TrimProcedureDTO(int trimNum, String tpDetail, String saveName) {
        /*손질번호, 손질내용, 사진파일이름*/
        this.trimNum = trimNum;
        this.tpDetail = tpDetail;
        this.saveName = saveName;
    }

    public TrimProcedureDTO(int tpStepNum, int trimNum, String tpFileName, String tpDetail, String tpPath, MultipartFile inputFile, String saveName) {
        this.tpStepNum = tpStepNum;
        this.trimNum = trimNum;
        this.tpFileName = tpFileName;
        this.tpDetail = tpDetail;
        this.tpPath = tpPath;
        this.inputFile = inputFile;
        this.saveName = saveName;
    }

    public int getTpStepNum() {
        return tpStepNum;
    }

    public void setTpStepNum(int tpStepNum) {
        this.tpStepNum = tpStepNum;
    }

    public int getTrimNum() {
        return trimNum;
    }

    public void setTrimNum(int trimNum) {
        this.trimNum = trimNum;
    }

    public String getTpFileName() {
        return tpFileName;
    }

    public void setTpFileName(String tpFileName) {
        this.tpFileName = tpFileName;
    }

    public String getTpDetail() {
        return tpDetail;
    }

    public void setTpDetail(String tpDetail) {
        this.tpDetail = tpDetail;
    }

    public String getTpPath() {
        return tpPath;
    }

    public void setTpPath(String tpPath) {
        this.tpPath = tpPath;
    }

    public MultipartFile getInputFile() {
        return inputFile;
    }

    public void setInputFile(MultipartFile inputFile) {
        this.inputFile = inputFile;
    }

    public String getSaveName() {
        return saveName;
    }

    public void setSaveName(String saveName) {
        this.saveName = saveName;
    }

    @Override
    public String toString() {
        return "TrimProcedureDTO{" +
                "tpStepNum=" + tpStepNum +
                ", trimNum=" + trimNum +
                ", tpFileName='" + tpFileName + '\'' +
                ", tpDetail='" + tpDetail + '\'' +
                ", tpPath='" + tpPath + '\'' +
                ", inputFile=" + inputFile +
                ", saveName='" + saveName + '\'' +
                '}';
    }
}