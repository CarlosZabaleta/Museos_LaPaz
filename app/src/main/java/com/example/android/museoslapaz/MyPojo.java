package com.example.android.museoslapaz;

/**
 * Created by bubu on 10/20/14.
 */
public class MyPojo {

    String title;
    String desc;
    int image;
    String dir;
    String hora;

    public MyPojo(String title, String desc, int image, String hora, String dir) {
        this.title = title;
        this.desc = desc;
        this.hora = hora;
        this.dir = dir;
        this.image = image;
    }

    public String getHora() {
        return hora;
    }

    public String getDir() {
        return dir;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getImage() {
        return image;
    }

}

