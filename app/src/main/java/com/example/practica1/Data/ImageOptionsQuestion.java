package com.example.practica1.Data;

public class ImageOptionsQuestion extends Question {

    private final int imageId1, imageId2, imageId3, imageId4;

    public ImageOptionsQuestion(String question, int imageId1, int imageId2, int imageId3, int imageId4, int correctAnswer) {
        super(question, correctAnswer);
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
}
