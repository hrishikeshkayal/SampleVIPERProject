package com.audiocaption.common.entity.common;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;


import com.customviews.DropDownView;
import com.utility.AppData;
import com.utility.GLideDownloader;
import com.utility.smoothscroller.SnappingLinearLayoutManager;
import com.audiocaption.R;

import java.util.ArrayList;
import java.util.List;


import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by hrishi on 12/01/2018.
 */

public class BaseDatabindAdapter extends BaseObservable {
    @BindingAdapter({"bind:imageSrc"})
    public static void loadImage(CircleImageView view, String imageUrl) {
        if(!TextUtils.isEmpty(imageUrl))
            GLideDownloader.setGlideImageCache(view.getContext(),view,imageUrl);
        else
            view.setImageResource(R.drawable.default_img);
    }

    @BindingAdapter("bind:imageSrc")
    public static void loadImage(ImageView view, String imageUrl) {
        if(!TextUtils.isEmpty(imageUrl))
            GLideDownloader.setGlideImageCache(view.getContext(),view,imageUrl);
        else
            view.setImageResource(R.drawable.default_img);
    }


    @BindingAdapter("bind:imageDynamicSrc")
    public static void loadImageWithOut(ImageView view, String imageUrl) {
        if(!TextUtils.isEmpty(imageUrl))
            GLideDownloader.setGlideImage(view.getContext(),view,imageUrl);
        else
            view.setImageResource(R.drawable.default_img);
    }

    @BindingAdapter({"bind:gifUrl"})
    public static void loadGif(ImageView view, String imageUrl) {
        if(!TextUtils.isEmpty(imageUrl)){
            System.out.println(AppData.TAG+" ImagePath in glide loading===>"+imageUrl);
            if(imageUrl.contains(".gif")){
                GLideDownloader.setGlideGifImageCache(view.getContext(),view,imageUrl);
            }else{
                GLideDownloader.setGlideImageCache(view.getContext(),view,imageUrl);
            }
        }
    }

    @BindingAdapter({"bind:gifUrl"})
    public static void loadGif(ImageView view, int imageUrl) {
        if(imageUrl!=0){
            GLideDownloader.setGlideGifImageCache(view.getContext(),view,imageUrl);
        }
    }


    @BindingAdapter({"bind:gifDrawable"})
    public static void loadDrawableGif(ImageView view, String gifDrawable) {
        if(gifDrawable!=null){
            GLideDownloader.setGlideGifLocalImageCache(view.getContext(),view,gifDrawable);
        }
    }

    /*@BindingAdapter("bind:imageSrc")
    public static void loadImage(CustomActionBarImageView view, String imageUrl) {
        if(!TextUtils.isEmpty(imageUrl))
            GLideDownloader.setGlideImageCache(view.getContext(),view,imageUrl);
        else
            view.setImageResource(R.drawable.splash_logo_bg);
    }*/

    /*@BindingAdapter("bind:imageSrc")
    public static void imageSrc(RoundedImageView view, String imageUrl) {
        if(!TextUtils.isEmpty(imageUrl))
            GLideDownloader.setGlideImageCache(view.getContext(),view,imageUrl);
        else
            view.setImageResource(R.drawable.splash_logo_bg);
    }*/

    @BindingAdapter({"bind:fontFamily"})
    public static void loadCustomFont(TextView view, String fontFamily){
        System.out.println(AppData.TAG+" Font =====>"+fontFamily);
        Typeface face = Typeface.createFromAsset(view.getContext().getAssets(),
                fontFamily);
        view.setTypeface(face);
    }

    @BindingAdapter({"bind:setDefaultAdapter"})
    public static void setDefaultAdapter(RecyclerView view, Object adapter) {
        view.hasFixedSize();
        view.setLayoutManager(new SnappingLinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL,false));
        view.setAdapter((RecyclerView.Adapter) adapter);
    }

    @BindingAdapter({"bind:scrollTo"})
    public static void scrollTo(RecyclerView view, int pos){
        if(pos!=0)
            view.smoothScrollToPosition(pos);
    }

    @BindingAdapter({"bind:setGridAdapter"})
    public static void setGrdAdapter(RecyclerView view, Object adapter) {
        view.hasFixedSize();
        view.setLayoutManager(new GridLayoutManager(view.getContext(),3));
        view.setAdapter((RecyclerView.Adapter) adapter);
    }

    @BindingAdapter({"bind:listData"})
    public static void loadDropDownList(DropDownView view, String[] listData) {
        List<String> dataList = new ArrayList<>();
        for(int i=0;i<listData.length;i++){
            dataList.add(listData[i]);
        }
        view.setItems(dataList);
    }

    @BindingAdapter({"bind:setDynamicSize"})
    public static void setDynamicSize(RelativeLayout view, String snapFeedItem) {
        try{
            if(!TextUtils.isEmpty(snapFeedItem)){
                view.getLayoutParams().height = Integer.parseInt(snapFeedItem.split(",")[0]);
                view.getLayoutParams().width = Integer.parseInt(snapFeedItem.split(",")[1]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @BindingAdapter({"bind:tabIndicatorColor"})
    public static void setTabIndicatorColor(android.support.design.widget.TabLayout view,int color){
        if(color!=0){
            view.setSelectedTabIndicatorColor(color);
        }
    }

    @BindingAdapter({"tagLabel","callBack"})
    public static void setTagLabelOnSeekBar(final SeekBar view, final TextView label, SeekBar.OnSeekBarChangeListener callBack){
        //view.setOnSeekBarChangeListener(callBack);

        if(label!=null && view!=null){
            view.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    try{
                        float val = (i* (seekBar.getWidth() - 2 * seekBar.getThumbOffset())) / seekBar.getMax();
                        System.out.println(AppData.TAG+" seek amount====>val==>"+val+" i===>"+i+" seekBar.width==>"+seekBar.getWidth()+" label.getWidth()/2==>"+label.getWidth()/2);
                        System.out.println(AppData.TAG+" val===>"+label.getWidth()/2+" seekBar.getMax()===>"+seekBar.getMax());
                        System.out.println(AppData.TAG+" seekBar.getThumbOffset()===>"+seekBar.getThumbOffset());
                        label.setX((int)(val));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
        }
    }

/*
    @BindingAdapter({"bind:setViwePagerAdapter","bind:offsetPageLimit","bind:viewPagerCallBack"})
    public static void setViewPagerAdapter(ViewPager view, PagerAdapter adapter, @Nullable int pageLimit, @Nullable final FeedModel.FeedModelCallBack callback){
        view.setAdapter(adapter);
        if(pageLimit!=0)
            view.setOffscreenPageLimit(pageLimit);

        view.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                callback.onPagechange(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }*/

    @BindingAdapter({"setViewPager"})
    public static void setViewPaggerAdapterInTabView(TabLayout view, ViewPager viewPagger){
        view.setupWithViewPager(viewPagger);
    }

}
