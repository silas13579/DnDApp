package com.killian.simple.simplestart;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Silas on 8/25/2016.
 * Our custom PagerAdapter. I'm pretty sure all of this is from the bignerdranch tutorial. I don't
 * entirely understand what it does.
 */
public class CustomPagerAdapter extends PagerAdapter
{
    private Context mContext;

    public CustomPagerAdapter(Context context)
    {
        mContext = context;
    }


    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        RacesEnum racesEnum = RacesEnum.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(racesEnum.getLayoutResId(), collection, false);
        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return RacesEnum.values().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        RacesEnum racesEnum = RacesEnum.values()[position];
        return mContext.getString(racesEnum.getTitleResId());
    }

}