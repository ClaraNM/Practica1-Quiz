package com.example.practica1.Data;

public class ImageOptionsQuestion extends Question {

    private int imageId1, imageId2, imageId3, imageId4;

    public ImageOptionsQuestion(int id,String question, int imageId1, int imageId2, int imageId3, int imageId4, int correctAnswer, int dificulty, int theme) {
        super(id, question, correctAnswer, dificulty, theme);
        this.imageId1 = imageId1;
        this.imageId2 = imageId2;
        this.imageId3 = imageId3;
        this.imageId4 = imageId4;
    }

    public int getImageId1() {
        return imageId1;
    }

    public int getImageId2() {
        return imageId2;
    }

    public int getImageId3() {
        return imageId3;
    }

    public int getImageId4() {
        return imageId4;
    }
    public void setImageId1(int i){this.imageId1=i;}
    public void setImageId2(int i){this.imageId2=i;}
    public void setImageId3(int i){this.imageId3=i;}
    public void setImageId4(int i){this.imageId4=i;}
}
