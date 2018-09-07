package com.audiocaption.common.entity.base;

import android.databinding.Bindable;
import android.view.View;

import com.audiocaption.BR;
import com.audiocaption.common.entity.common.BaseDatabindAdapter;


public class BaseModel extends BaseDatabindAdapter {

    private boolean isToolBarShowing = true;
    private boolean isNavBarShowing = true;
    private boolean isBottomNavBarShowing = true;
    private String tittle;
    private String profileName;
    private String profileImage;
    private String userEmail;
    private boolean isBackButtonShow = false;
    private boolean isOnlineShow = false;
    private boolean isOnline = false;
    private boolean isLoading = false;
    private boolean isToolbarLeftOptionShowing = true;
    private boolean isSearchModeOn = false;
    private int selectedItemInNavBar = 1;
    private boolean showCameraButton = false;

    public BaseModel() {
    }

    public BaseModel(boolean isToolBarShowing, boolean isNavBarShowing, boolean isBottomNavBarShowing, String tittle, String profileName, String profileImage, String userEmail, boolean isBackButtonShow, boolean isOnlineShow, boolean isOnline, boolean isLoading, boolean isToolbarLeftOptionShowing, boolean isSearchModeOn, int selectedItemInNavBar, boolean showCameraButton) {
        this.isToolBarShowing = isToolBarShowing;
        this.isNavBarShowing = isNavBarShowing;
        this.isBottomNavBarShowing = isBottomNavBarShowing;
        this.tittle = tittle;
        this.profileName = profileName;
        this.profileImage = profileImage;
        this.userEmail = userEmail;
        this.isBackButtonShow = isBackButtonShow;
        this.isOnlineShow = isOnlineShow;
        this.isOnline = isOnline;
        this.isLoading = isLoading;
        this.isToolbarLeftOptionShowing = isToolbarLeftOptionShowing;
        this.isSearchModeOn = isSearchModeOn;
        this.selectedItemInNavBar = selectedItemInNavBar;
        this.showCameraButton = showCameraButton;
    }

    @Bindable
    public boolean isToolBarShowing() {
        return isToolBarShowing;
    }

    @Bindable
    public boolean isBottomNavBarShowing() {
        return isBottomNavBarShowing;
    }

    @Bindable
    public String getTittle() {
        return tittle;
    }

    @Bindable
    public boolean isBackButtonShow() {
        return isBackButtonShow;
    }

    @Bindable
    public boolean isNavBarShowing() {
        return isNavBarShowing;
    }

    @Bindable
    public boolean isOnlineShow() {
        return isOnlineShow;
    }

    @Bindable
    public boolean isOnline() {
        return isOnline;
    }

    @Bindable
    public boolean isToolbarLeftOptionShowing() {
        return isToolbarLeftOptionShowing;
    }

    @Bindable
    public boolean isLoading() {
        return isLoading;
    }

    @Bindable
    public String getProfileName() {
        return profileName;
    }

    @Bindable
    public String getProfileImage() {
        return profileImage;
    }

    @Bindable
    public String getUserEmail() {
        return userEmail;
    }

    @Bindable
    public boolean isSearchModeOn() {
        return isSearchModeOn;
    }

    @Bindable
    public int getSelectedItemInNavBar() {
        return selectedItemInNavBar;
    }

    @Bindable
    public boolean isShowCameraButton() {
        return showCameraButton;
    }

    public void setToolBarShowing(boolean toolBarShowing) {
        isToolBarShowing = toolBarShowing;
        notifyPropertyChanged(BR.toolBarShowing);
    }

    public void setBottomNavBarShowing(boolean bottomNavBarShowing) {
        isBottomNavBarShowing = bottomNavBarShowing;
        notifyPropertyChanged(BR.bottomNavBarShowing);
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
        notifyPropertyChanged(BR.tittle);
    }

    public void setBackButtonShow(boolean backButtonShow) {
        isBackButtonShow = backButtonShow;
        notifyPropertyChanged(BR.backButtonShow);
    }

    public void setOnlineShow(boolean onlineShow) {
        isOnlineShow = onlineShow;
        notifyPropertyChanged(BR.onlineShow);
    }

    public void setOnline(boolean online) {
        isOnline = online;
        notifyPropertyChanged(BR.online);
    }

    public void setNavBarShowing(boolean navBarShowing) {
        isNavBarShowing = navBarShowing;
        notifyPropertyChanged(BR.navBarShowing);
    }

    public void setToolbarLeftOptionShowing(boolean toolbarLeftOptionShowing) {
        isToolbarLeftOptionShowing = toolbarLeftOptionShowing;
        notifyPropertyChanged(BR.toolbarLeftOptionShowing);
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
        notifyPropertyChanged(BR.loading);
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
        notifyPropertyChanged(BR.profileName);
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
        notifyPropertyChanged(BR.profileImage);
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        notifyPropertyChanged(BR.userEmail);
    }

    public void setSearchModeOn(boolean searchModeOn) {
        isSearchModeOn = searchModeOn;
        notifyPropertyChanged(BR.searchModeOn);
    }

    public void setSelectedItemInNavBar(int selectedItemInNavBar) {
        this.selectedItemInNavBar = selectedItemInNavBar;
        notifyPropertyChanged(BR.selectedItemInNavBar);
    }

    public void setShowCameraButton(boolean showCameraButton) {
        this.showCameraButton = showCameraButton;
        notifyPropertyChanged(BR.showCameraButton);
    }

    public interface BaseModelCallBack{
        void leftOptionCallBack(View view, boolean state);
        void searchCallBack(View view);
        void openGalleryCallBack(View view);
        void openProfile(View view);
        void onCameraButtonClicked(View view);
        void createAudioCaption(View view);
        void audiocaptionList(View view);
        void audioBook(View view);
        void myGallery(View view);
        void settings(View view);
        /*
        public void openSings(View view);
        public void openDances(View view);
        public void openDiscover(View view);
        public void openFeeds(View view);
        public void logout(View view);
        */
        public boolean searchText(String query);
    }
}