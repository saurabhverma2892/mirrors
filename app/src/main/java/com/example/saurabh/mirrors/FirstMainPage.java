package com.example.saurabh.mirrors;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.saurabh.mirrors.mCloud.CloudinaryClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstMainPage extends Fragment {


    private static final String TAG = "mirrors";
    private View myView;
    private JSONArray offersArray;
    private SliderLayout offersSlider;

    private OffersAdapter textSliderView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.first_main_layout, container, false);
        offersArray = new JSONArray();

        try {
            makeDummyData();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        offersSlider = (SliderLayout) myView.findViewById(R.id.offersSlider);

        for (int i = 0; i<offersArray.length(); i++){
            try {
                JSONObject offerObject = offersArray.getJSONObject(i);

                textSliderView = new OffersAdapter(getActivity());

                String imageName = offerObject.getString("image");
                String imgSrc = CloudinaryClient.getImage(imageName);
                Log.i(TAG,imgSrc);
                textSliderView.image(imgSrc);
                offersSlider.addSlider(textSliderView);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return myView;
    }


    private void makeDummyData() throws JSONException {
        int x = 1;
        while (x < 4)
        {
            JSONObject offer = new JSONObject();
            offer.put("title", "this is a new title"+x);
            offer.put("image", "sample"+x+".jpg");
            offersArray.put(offer);
            x++;
        }
    }

}
