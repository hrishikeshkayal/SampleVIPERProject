package com.audiocaption.common.entity;

import android.databinding.Bindable;
import android.view.View;

import com.audiocaption.BR;
import com.audiocaption.common.entity.common.BaseDatabindAdapter;

/**
 * Created by Hrishikesh on 7/8/2018.
 */

public class ConfirmDialogModel extends BaseDatabindAdapter {
    private String title = "Audiocaption";
    private String message;
    private String confirmBtnText;
    private String declineBtnText;
    private boolean isDeclineBtnShowing = true;
    private String option;

    public ConfirmDialogModel() {
    }

    public ConfirmDialogModel(String title, String message, String confirmBtnText, String declineBtnText, boolean isDeclineBtnShowing, String option) {
        this.title = title;
        this.message = message;
        this.confirmBtnText = confirmBtnText;
        this.declineBtnText = declineBtnText;
        this.isDeclineBtnShowing = isDeclineBtnShowing;
        this.option = option;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    @Bindable
    public String getMessage() {
        return message;
    }

    @Bindable
    public String getConfirmBtnText() {
        return confirmBtnText;
    }

    @Bindable
    public String getDeclineBtnText() {
        return declineBtnText;
    }

    @Bindable
    public boolean isDeclineBtnShowing() {
        return isDeclineBtnShowing;
    }

    @Bindable
    public String getOption() {
        return option;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    public void setMessage(String message) {
        this.message = message;
        notifyPropertyChanged(BR.message);
    }

    public void setConfirmBtnText(String confirmBtnText) {
        this.confirmBtnText = confirmBtnText;
        notifyPropertyChanged(BR.confirmBtnText);
    }

    public void setDeclineBtnText(String declineBtnText) {
        this.declineBtnText = declineBtnText;
        notifyPropertyChanged(BR.declineBtnText);
    }

    public void setDeclineBtnShowing(boolean declineBtnShowing) {
        isDeclineBtnShowing = declineBtnShowing;
        notifyPropertyChanged(BR.declineBtnShowing);
    }

    public void setOption(String option) {
        this.option = option;
        notifyPropertyChanged(BR.option);
    }

    public interface ConfirmDialogModelCallBack{
        void confirmBtnCallBack(View view);
        void declineBtnCallBack(View view);
    }
}
