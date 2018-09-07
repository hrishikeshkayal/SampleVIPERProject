package com.audiocaption.common.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;

import com.audiocaption.BR;
import com.audiocaption.R;
import com.audiocaption.common.entity.ConfirmDialogModel;

/**
 * Created by Hrishikesh on 7/8/2018.
 */

@SuppressLint("ValidFragment")
public class ConfirmDialog  extends DialogFragment {

    private ConfirmDialogModel audiocaptionModel;
    private ConfirmDialogModel.ConfirmDialogModelCallBack callBack;

    @SuppressLint("ValidFragment")
    public ConfirmDialog(ConfirmDialogModel audiocaptionModel, ConfirmDialogModel.ConfirmDialogModelCallBack callBack) {
        this.audiocaptionModel = audiocaptionModel;
        this.callBack = callBack;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        FragmentActivity activity = getActivity();
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()),
                R.layout.audiocaption_confirmation_dialog, null, false);

        binding.setVariable(BR.ConfirmDialogModel,audiocaptionModel);
        binding.setVariable(BR.ConfirmDialogModelCallBack,this.callBack);

        return new AlertDialog.Builder(activity, R.style.CustomDialog)
                .setView(binding.getRoot())
                .create();
    }
}