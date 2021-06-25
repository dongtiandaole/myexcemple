package com.myexcemple.entity;

public class FilesPath {
    private String fileName;
    private int sum;
    private String id;
    private String parent_id;

    public String getFileName() {
        return fileName;
    }

    public int getSum() {
        return sum;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getId() {
        return id;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }
}
