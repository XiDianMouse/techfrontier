package com.techfrontier.beans;

/**
 * @auther gbh
 * Created on 2017/4/24.
 */

public class MenuItem {
    public int iconResId;
    public String text;

    public MenuItem(){

    }

    public MenuItem(String text,int resId){
        this.text = text;
        this.iconResId = resId;
    }
}
