package com.example.saurabh.mirrors.mCloud;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;

/**
 * Created by saurabh on 02/08/16.
 */
public class CloudinaryClient {

    public static String getRoundedCorners(String imgSrc){
        Cloudinary cloud = new Cloudinary(Config.myConfig());

        Transformation t = new Transformation();
        t.radius(60);

        return cloud.url().transformation(t).generate(imgSrc);
    }

    public static String resize(String imgSrc){
        Cloudinary cloud = new Cloudinary(Config.myConfig());

        Transformation t = new Transformation();
        t.width(300);
        t.height(250);

        return cloud.url().transformation(t).generate(imgSrc);
    }

    public static String getImage(String imgSrc){
        Cloudinary cloud = new Cloudinary(Config.myConfig());
        return cloud.url().generate(imgSrc);
    }
}
