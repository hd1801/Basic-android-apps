package com.example.resultrecord;

public class ReportCard {
    private String sName;
    private  Double totalGrade,englishGrade,mathGrade,historyGrade,scienceGrade;

    public ReportCard(String sName, Double englishGrade, Double mathGrade, Double historyGrade, Double scienceGrade) {
        this.sName = sName;
        this.englishGrade = englishGrade;
        this.mathGrade = mathGrade;
        this.historyGrade = historyGrade;
        this.scienceGrade = scienceGrade;
    }


    public Double getScienceGrade() {
        return scienceGrade;
    }

    public Double getTotalGrade() {
        totalGrade=mathGrade+scienceGrade+englishGrade+historyGrade;
        totalGrade=totalGrade/4.0;
        return totalGrade;
    }

    public Double getEnglishGrade() {
        return englishGrade;
    }

    public Double getMathGrade() {
        return mathGrade;
    }

    public Double getHistoryGrade() {
        return historyGrade;
    }


    public String getsName() {
        return sName;
    }

}
