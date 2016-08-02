package com.example.saurabh.mirrors;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.example.saurabh.mirrors.mCloud.CloudinaryClient;
import com.example.saurabh.mirrors.mPicasso.PicassoClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

/**
 * Created by saurabh on 02/08/16.
 */
public class OffersAdapter extends BaseSliderView {

    private static final String TAG = "mirrors";


    public OffersAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.offer_item,null);
        ImageView offersImage = (ImageView) view.findViewById(R.id.offersImg);
        bindEventAndShow(view, offersImage);
        return view;
    }
}
