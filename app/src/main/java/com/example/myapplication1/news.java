package com.example.myapplication1;

import java.io.Serializable;

public class news implements Serializable {
    String title,des,img_url,res,date;
    public news(String title,String des,String img_url,String res,String date)
    {
        this.res=res;
        this.title=title;
        this.des=des;
        this.img_url=img_url;
        this.date=date;
        //this.content=content;
    }


    public String getTitle() {
        return title;
    }

    public String getDes() {
        return des;
    }
    public String getDate() {
        return date;
    }
    public String getImg_url() {
        return img_url;
    }


    public String getRes() {
        return res;
    }



}
