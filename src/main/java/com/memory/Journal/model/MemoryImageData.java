package com.memory.Journal.model;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class MemoryImageData {

    private static final String YYYY_MM_DD = "yyyy-MM-dd";
    private MultipartFile multipartFile;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private DateTime forDate;
    private String imageName;

    public MemoryImageData(MultipartFile multipartFile, DateTime forDate, String imageName) {
        this.multipartFile = multipartFile;
        this.forDate = forDate;
        this.imageName = imageName;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public DateTime getForDate() {
        return forDate;
    }

    public void setForDate(DateTime forDate) {
        this.forDate = forDate;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getFormattedDateString() {
        return forDate.toString(YYYY_MM_DD);
    }
}
