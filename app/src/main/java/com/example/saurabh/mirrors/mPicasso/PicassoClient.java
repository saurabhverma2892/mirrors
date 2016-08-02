package com.example.saurabh.mirrors.mPicasso;

import android.content.Context;
import android.widget.ImageView;

import com.example.saurabh.mirrors.R;
import com.squareup.picasso.Picasso;

/**
 * Created by saurabh on 02/08/16.
 */
public class PicassoClient {

    private static final String TAG = "mirrors";

    public static void downloadImage(Context context, String url, ImageView img){
        if(url != null && url.length()>0){

            //Picasso.with(context).load(url).placeholder(R.drawable.placeholder)
            Picasso.with(context).load(url).placeholder(R.drawable.male_pic).into(img);

        }else
        {
            Picasso.with(context).load(R.drawable.female_pic).into(img);
        }
    }
}
