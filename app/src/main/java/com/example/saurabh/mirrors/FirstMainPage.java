package com.example.saurabh.mirrors;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.saurabh.mirrors.mCloud.CloudinaryClient;
import com.example.saurabh.mirrors.tabs.Pager;
import com.example.saurabh.mirrors.tabs.Places;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstMainPage extends Fragment implements TabLayout.OnTabSelectedListener {


    private static final String TAG = "mirrors";
    private View myView;
    private JSONArray offersArray;
    private SliderLayout offersSlider;

    private OffersAdapter textSliderView;

    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.first_main_layout, container, false);
        offersArray = new JSONArray();

        try {
            makeDummyData();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        setOfferSlider();

        setTabs();

        return myView;
    }

    private void setTabs() {
        tabLayout = (TabLayout) myView.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) myView.findViewById(R.id.pager);

        tabLayout.addTab(tabLayout.newTab().setText("Places"));
        tabLayout.addTab(tabLayout.newTab().setText("Feed"));
        tabLayout.addTab(tabLayout.newTab().setText("Blog"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        Pager adapter = new Pager(getFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(
                new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        tabLayout.setScrollPosition(position,0,true);
                        tabLayout.setSelected(true);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                }
        );
        tabLayout.setOnTabSelectedListener(this);
    }

    private void setOfferSlider() {
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

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
