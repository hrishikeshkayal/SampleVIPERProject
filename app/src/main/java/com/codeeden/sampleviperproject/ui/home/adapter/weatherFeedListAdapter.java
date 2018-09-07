package com.codeeden.sampleviperproject.ui.home.adapter;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
//import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import java.io.Serializable;
import java.util.List;

public class weatherFeedListAdapter /*extends RecyclerView.Adapter<AudiocaptionGalleryListAdapter.ViewHolder> implements Serializable*/ {

    /*private transient List<AudiocaptionItem> AudiocaptionItems;
    private transient Activity activity;


    public weatherFeedListAdapter(Activity activity, List<AudiocaptionItem> AudiocaptionItems) {
        this.AudiocaptionItems = AudiocaptionItems;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        ViewDataBinding binding  = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext())
                , R.layout.audiocaption_item, viewGroup, false);
        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(AudiocaptionGalleryListAdapter.ViewHolder viewHolder, int position) {
        ViewDataBinding viewDataBinding = viewHolder.getViewDataBinding();
        viewDataBinding.setVariable(BR.AudiocaptionItem, AudiocaptionItems.get(position));
        viewDataBinding.setVariable(BR.AudiocaptionItemCallBack, activity);
    }

    @Override
    public int getItemCount() {
        return (null != AudiocaptionItems ? AudiocaptionItems.size() : 0);
    }

    *//**
     * View holder to display each RecylerView item
     *//*
    protected class ViewHolder extends RecyclerView.ViewHolder {
        private ViewDataBinding mViewDataBinding;

        public ViewHolder( ViewDataBinding viewDataBinding) {
            super(viewDataBinding.getRoot());

            mViewDataBinding = viewDataBinding;
            mViewDataBinding.executePendingBindings();
        }

        public ViewDataBinding getViewDataBinding() {
            return mViewDataBinding;
        }
    }

    public List<AudiocaptionItem> getAudiocaptionItems() {
        return AudiocaptionItems;
    }

    public void setAudiocaptionList(List<AudiocaptionItem> AudiocaptionItems) {
        this.AudiocaptionItems = AudiocaptionItems;
        notifyDataSetChanged();
    }*/
}