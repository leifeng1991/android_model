package com.leifeng.android.model.databinding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.leifeng.base.module.glide.ImageLoader;

import java.io.Serializable;

public class User implements Serializable {
    private String name;

    private String password;

    private String imageUrl;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @BindingAdapter({"imageUrl"})
    public static void setImageUrl(ImageView imageView,String url){
        ImageLoader.loadImageView(url,imageView);
    }

    @Override
    public String toString() {
        return "User{" +
            "name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", imageUrl='" + imageUrl + '\'' +
            '}';
    }
}
