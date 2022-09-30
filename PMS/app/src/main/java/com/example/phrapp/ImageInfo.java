package com.example.phrapp;

import android.graphics.Bitmap;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

public class ImageInfo implements Serializable {
    private transient Bitmap image;
    private String patientName, description , doctorName , category,reportType;
    private String date;

    public ImageInfo(){
    }
    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ImageInfo(Bitmap image, String patientName, String description, String doctorName, String category, String date,String reportType) {
        this.image = image;
        this.patientName = patientName;
        this.description = description;
        this.doctorName = doctorName;
        this.category = category;
        this.date = date;
        this.reportType=reportType;
    }
}