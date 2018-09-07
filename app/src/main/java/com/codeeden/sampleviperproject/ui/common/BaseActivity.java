package com.audiocaption.common;

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.audiocaption.BR;
import com.audiocaption.audiocaptiongallery.AudiocaptionGalleryActivity;
import com.audiocaption.audiocaptionscreen.AudiocaptionActivity;
import com.audiocaption.common.dialog.ConfirmDialog;
import com.audiocaption.common.entity.ConfirmDialogModel;
import com.audiocaption.common.entity.base.BaseModel;
import com.audiocaption.settings.SettingsActivity;
import com.permission.PermissionResultCallback;
import com.permission.PermissionUtils;
import com.services.BackendService;
import com.services.callback.ServiceCallBack;
import com.utility.AppData;
import com.utility.PrefUtils;
import com.audiocaption.R;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.iid.FirebaseInstanceId;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BaseActivity extends AppCompatActivity implements BaseModel.BaseModelCallBack,ServiceCallBack,PermissionResultCallback,ConfirmDialogModel.ConfirmDialogModelCallBack {

    /****** Ui component **********/
    public Toolbar toolbar;
    public DrawerLayout navView;
    private FrameLayout containerFrameLayout;
    private ConfirmDialog confirmDialog;

    /****** component **********/
    public boolean networkstate = false;
    private final int REQUEST_FINE_LOCATION = 3000;
    public PrefUtils prefUtils;
    public ViewDataBinding binding;
    public ViewDataBinding baseBinding;
    protected BaseModel baseModel;
    public ConfirmDialogModel confirmDialogModel;
    public long createTimeStamp = 0;
    public boolean isBackShowing = false;
    /****** Permission *******/
    PermissionUtils permissionUtils;
    ArrayList<String> permissions=new ArrayList<>();


    //////// service binding ////////

    private boolean mIsBound = false;
    protected BackendService mServ;
    private ServiceConnection socketConnection;

    void doBindService(){
        bindService(new Intent(this,BackendService.class),
                socketConnection, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService()
    {
        if(mIsBound)
        {
            unbindService(socketConnection);
            mIsBound = false;
        }
    }

    private void initService(){
        socketConnection =new ServiceConnection(){

            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                BackendService.LocalBinder binder = (BackendService.LocalBinder)service;
                //get service
                mServ = binder.getServerInstance();
                mIsBound = true;
                if(null!=mServ){
                    mServ.setservicecallBack(BaseActivity.this);
                }else {
                    startService(new Intent(BaseActivity.this, BackendService.class));
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
    }


    //////// service binding ////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseModel = new BaseModel();
        confirmDialogModel = new ConfirmDialogModel();
        baseBinding = DataBindingUtil.setContentView(this, R.layout.activity_base);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        baseBinding.setVariable(BR.NavBarCallBack, this);
        baseBinding.setVariable(BR.NavBar, baseModel);
        baseBinding.setVariable(BR.Context, this);
        prefUtils.init(this);
        prefUtils = PrefUtils.getInstance();
        initView();
        if (Build.VERSION.SDK_INT >= 23){
            permissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
            permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            permissions.add(Manifest.permission.CAMERA);
            permissions.add(Manifest.permission.RECORD_AUDIO);
            permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
            permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);

            //AppUtility.toast(SplashScreen.this,"SplashScreen oncreate"," checking permission");
            permissionUtils = PermissionUtils.builtPermission(this,permissions, getString(R.string.app_name));
        }
        /* Old method to get run time permission */
        //showPermission();
        /* This method is called to start the service in backend */
        //initService();
        prefUtils.setPushRegId(FirebaseInstanceId.getInstance().getToken());
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (mServ != null) {
                    /////// for start driver location emit ......//////
                    mServ.setservicecallBack(BaseActivity.this);
                    //mBoundService.setPassengerConfirmResponse(BaseAWithDrawerctivity.this);

                } else {
                    handler.postDelayed(this, 1000);
                }
            }
        });

        baseModel.setSelectedItemInNavBar(prefUtils.getSelectedPage());

    }

    public void dismissConfirmDialog(){
        if(confirmDialog!=null){
            confirmDialog.dismiss();
        }
    }

    public void showConfirmDialog(String title, String message, String confirmBtnText, String declineBtnText, boolean declineBtnShow, String option, @Nullable ConfirmDialogModel.ConfirmDialogModelCallBack callBack){

        if(confirmDialog!=null){
            confirmDialog.dismiss();
        }

        confirmDialogModel.setTitle(title);
        confirmDialogModel.setMessage(message);
        confirmDialogModel.setConfirmBtnText(confirmBtnText);
        confirmDialogModel.setDeclineBtnText(declineBtnText);
        confirmDialogModel.setDeclineBtnShowing(declineBtnShow);
        confirmDialogModel.setOption(option);

        confirmDialog = new ConfirmDialog(confirmDialogModel, (callBack==null)?BaseActivity.this:callBack);
        confirmDialog.show(getSupportFragmentManager(), "ConfirmDialog");
    }

    private void initView(){
        containerFrameLayout = (FrameLayout) findViewById(R.id.containerFrameLayout);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navView = findViewById(R.id.drawer_layout);

        baseModel.setProfileImage(prefUtils.getUser_Image());
        baseModel.setUserEmail(prefUtils.getUser_email());
        baseModel.setProfileName(prefUtils.getUserFirstName());

    }

    protected void setContentOfView(int _layoutId,Activity activity) {
        View view = LayoutInflater.from(activity).inflate(_layoutId, containerFrameLayout, false);
        containerFrameLayout.addView(view, new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
    }

    protected void setContentOfViewWithBinding(int _layoutId, Activity activity, int BRInstance, Object bindObject) {
        addCustomView(LayoutInflater.from(activity),containerFrameLayout,_layoutId,BRInstance,bindObject);
    }

    public void addCustomView(LayoutInflater inflater, ViewGroup container, int layoutId, int instance, Object user) {
        binding = DataBindingUtil.inflate(inflater,layoutId, container, true);
        binding.setVariable(instance, user);
    }

    public void hideToolbarLeftOption() {
        baseModel.setToolbarLeftOptionShowing(false);
    }

    public ViewDataBinding getBinding() {
        return binding;
    }

    public void removeToolBar(boolean callback) {
        baseModel.setToolBarShowing(!callback);
    }

    public void removeBottomNavBar(boolean callback) {
        baseModel.setBottomNavBarShowing(!callback);
    }

    public void searchModeOn(boolean state){
        baseModel.setSearchModeOn(state);
    }


    public void showBackButton() {
        isBackShowing = true;
        baseModel.setBackButtonShow(true);
    }

    public void showMenuButton() {
        isBackShowing = false;
        baseModel.setBackButtonShow(false);
    }

    public void setTittle(String text) {
        baseModel.setTittle(text);
    }

    public void showOnlineOption(boolean callback) {
        baseModel.setOnlineShow(callback);
    }

    public void showNavBar(boolean state){
        baseModel.setNavBarShowing(state);
        if(state){
            navView.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,Gravity.LEFT);
        }else{
            navView.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED,Gravity.LEFT);
        }
    }

    public void isLoading(boolean state){
        baseModel.setLoading(state);
    }



    @Override
    public void networkStateChange(boolean state) {
        if(!state && !networkstate){
            try{
                networkstate = true;
                AlertDialog.Builder builder = new AlertDialog.Builder(BaseActivity.this);

                builder.setPositiveButton("Close the app", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        finish();
                        moveTaskToBack(true);
                    }
                });
                builder.setNegativeButton("Retry", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        networkstate = false;
                    }
                });
                builder.setMessage("There is no internet connectivity !!!");
                builder.setTitle("Network Error");
                AlertDialog dialog = builder.create();
                //dialog.show();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void locationChangeListener(LatLng location) {

    }

    /* To start the back end service we need to use the doBindService()*/

    @Override
    protected void onResume() {
        super.onResume();
        //doBindService();
        //GLideDownloader.setGlideImage(this,toolbar.getDrawable_right_icon(),prefUtils.getUser_Image());
        if (permissionUtils!=null&&!permissionUtils.handleNeverAskSetting) {
            permissionUtils.handleNeverAskSetting = true;
            permissionUtils.check_permission(permissions," Chrmatacity app needs permissions",1);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        doUnbindService();
    }
    @Override
    public void leftOptionCallBack(View view, boolean state) {
        if(state){
            finish();
        }else {
            if(navView.isDrawerOpen(Gravity.LEFT)){
                navView.closeDrawer(Gravity.LEFT);
            }else{
                navView.openDrawer(Gravity.LEFT);
            }
        }
    }

    @Override
    public void searchCallBack(View view) {

    }

    @Override
    public void openGalleryCallBack(View view) {

    }

    @Override
    public void openProfile(View view) {
        /*AppData.startNewActivity(BaseActivity.this, ProfileActivity.class,true);
        finish();*/
    }

    public void showCameraOption(boolean option){
        baseModel.setShowCameraButton(option);
    }

    @Override
    public void onCameraButtonClicked(View view) {

    }

    @Override
    public void createAudioCaption(View view) {
        baseModel.setSelectedItemInNavBar(1);
        prefUtils.setSelectedPage(1);
        AppData.startNewActivity(this, AudiocaptionActivity.class,true);
    }

    @Override
    public void audiocaptionList(View view) {
        prefUtils.setSelectedPage(2);
        baseModel.setSelectedItemInNavBar(2);
        AppData.startNewActivity(this, AudiocaptionGalleryActivity.class,true);
    }

    @Override
    public void audioBook(View view) {
        prefUtils.setSelectedPage(3);
        baseModel.setSelectedItemInNavBar(3);
    }

    @Override
    public void myGallery(View view) {
        prefUtils.setSelectedPage(4);
        baseModel.setSelectedItemInNavBar(4);
    }

    @Override
    public void settings(View view) {
        prefUtils.setSelectedPage(5);
        baseModel.setSelectedItemInNavBar(5);
        AppData.startNewActivity(this, SettingsActivity.class,true);
    }

    /*

        @Override
        public void openSings(View view) {
            AppData.startNewActivity(BaseActivity.this, SingActivity.class,true);
            finish();
        }

        @Override
        public void openDances(View view) {
            AppData.startNewActivity(BaseActivity.this, DanceActivity.class,true);
            finish();
        }

        @Override
        public void openDiscover(View view) {
            AppData.startNewActivity(BaseActivity.this, DiscoveryActivity.class,true);
            finish();
        }

        @Override
        public void openFeeds(View view) {
            AppData.startNewActivity(BaseActivity.this, FeedListActivity.class,true);
            finish();
        }

        @Override
        public void logout(View view) {
            isLoading(true);
            LogoutRequest logoutRequest = new LogoutRequest();
            logoutRequest.setApptype(AppData.apptype);
            logoutRequest.setDevicetoken(prefUtils.getPushRegId());
            logoutRequest.setUserId(prefUtils.getUser_ID());
            Call<LogoutResponse> logoutResponseCall = WebServiceCall.service().logoutService(logoutRequest);
            logoutResponseCall.enqueue(new Callback<LogoutResponse>() {
                @Override
                public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                    try{
                        isLoading(false);
                        if(response.body().getResponseCode()==AppData.RESPONSE_SUCESS){
                            prefUtils.setUser_ID("");
                            prefUtils.setAuth_Token("");
                            prefUtils.setUser_First_Name("");
                            prefUtils.setUser_email("");
                            prefUtils.setUser_Image("");

                            AppData.startNewActivity(BaseActivity.this, LoginActivity.class,true);
                            finish();
                        }else{
                            AppData.showToast(BaseActivity.this,response.body().getResponseMessage());
                            isLoading(false);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                        isLoading(false);
                        AppData.showToast(BaseActivity.this,getString(R.string.please_try_again));
                    }
                }

                @Override
                public void onFailure(Call<LogoutResponse> call, Throwable t) {
                    isLoading(false);
                    AppData.showToast(BaseActivity.this,getString(R.string.please_try_again));
                }
            });


        }

        */
    @Override
    public boolean searchText(String query) {
        return  true;
    }



    /****** Permission ******/
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        // redirects to utils
        permissionUtils.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }
    @Override
    public void PermissionGranted(int request_code) {

        //  ToastUtility.toast(this,"","Permission Granted");
    }
    @Override
    public void PartialPermissionGranted(int request_code, ArrayList<String> granted_permissions) {
        Log.i("PERMISSION PARTIALLY","GRANTED");
        permissionUtils.handlePartialPermission(granted_permissions, "Chrmatacity");
    }
    @Override
    public void PermissionDenied(int request_code) {
        Log.i("PERMISSION","DENIED");
        if (permissionUtils!=null&&!permissionUtils.handleNeverAskSetting) {
            permissionUtils.handleNeverAskSetting = true;
            permissionUtils.check_permission(permissions," Chrmatacity app needs permissions",1);
        }
    }
    @Override
    public void NeverAskAgain(int request_code) {
        Log.i("PERMISSION","NEVER ASK AGAIN");
        //checkSystemWritePermission(SplashScreen.this);
        permissionUtils.startInstalledAppDetailsActivity(this);
    }

    @Override
    public void confirmBtnCallBack(View view) {

    }

    @Override
    public void declineBtnCallBack(View view) {

    }
}
