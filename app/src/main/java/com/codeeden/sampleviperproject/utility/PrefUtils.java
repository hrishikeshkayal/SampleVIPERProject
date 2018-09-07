package com.codeeden.sampleviperproject.utility;

import android.content.Context;

public class PrefUtils extends ParentPrefUtils {
    private static PrefUtils instance = null;

    private PrefUtils(Context context) {
        super(context);
    }

    public static void init(Context _context) {
        instance = new PrefUtils(_context);
    }

    public static PrefUtils getInstance() {

        if (instance == null)
            throw new InstantiationError(
                    "Null instance. Should instantiate first with application context");
        return instance;
    }

    public void setUser_ID(String value) {
        setString("User_ID", value);
    }

    public String getUser_ID() {
        return getString("User_ID", "");
    }

    public void setUserName(String name) {
        setString("Username", name);
    }

    public String getUserName() {
        return getString("Username", "");
    }

    public void setUserGender(String name) {
        setString("Gender", name);
    }

    public String getUserGender() {
        return getString("Gender", "");
    }

    public void setSelectedPage(int number) {
        setInt("page_number", number);
    }

    public int getSelectedPage() {
        return getInt("page_number", 0);
    }

    public void setUser_Image(String image) {
        setString("User_Image", image);
    }

    public String getUser_Image() {
        return getString("User_Image", "");
    }


    public String getAlbumImage() {
        return getString("Album_Image", "");
    }

    public void setAlbumImage(String image) {
        setString("Album_Image", image);
    }

    public String getRecordedMedia() {
        return getString("Recorded_Media_Url", "");
    }

    public void setRecordedMedia(String image) {
        setString("Recorded_Media_Url", image);
    }

    public int getMusicVolume() {
        return getInt("Music_Volume",0);
    }

    public void setMusicVolume(int amount) {
        setInt("Music_Volume", amount);
    }


    public int getVocalVolume() {
        return getInt("Vocal_Volume",0);
    }

    public void setVocalVolume(int amount) {
        setInt("Vocal_Volume", amount);
    }


    public void setUser_Pwd(String pwd) {
        setString("User_Pwd", pwd);
    }

    public void setUser_First_Name(String fname) {
        setString("User_Fname", fname);
    }

    public void setUser_Last_Name(String lname) {
        setString("User_Lname", lname);
    }

    public void setUser_Phone_Number(String number) {
        setString("User_phone", number);
    }

    public String getUser_Pwd() {
        return getString("User_Pwd", "");
    }


    public void setUser_membership(String membership) {
        setString("User_membership", membership);
    }

    public String getUser_membership() {
        return getString("User_membership", "");
    }


    public void setUser_city(String city) {
        setString("User_city", city);
    }

    public String getUser_city() {
        return getString("User_city", "");
    }


    public void setUser_email(String email) {
        setString("User_email", email);
    }

    public String getUser_email() {
        return getString("User_email", "");
    }


    public void setUser_fbId(String fbId) {
        setString("FacebookID", fbId);
    }

    public String getUser_fbId() {
        return getString("FacebookID", "");
    }

    public void setFirstInstallation(String firsttime) {
        setString("FIRSTTIME", firsttime);
    }

    public String getFirstInstallation() {
        return getString("FIRSTTIME", "");
    }

    public void setProfileUpdated(String profileupdated) {
        setString("PROFILE_UPDATE", profileupdated);
    }

    public String getProfileUpdated() {
        return getString("PROFILE_UPDATE", "");
    }


    public void setAuth_Token(String value) {
        setString("AUTH_TOKEN", value);
    }

    public String getAuth_Token() {
        return getString("AUTH_TOKEN", "");
    }


    public void setAppOldVersion(String value) {
        setString("OLD_APP_VERSION", value);
    }

    public String getAppOldVersion() {
        return getString("OLD_APP_VERSION", "");
    }

    public void setAppNewVersion(String value) {
        setString("NEW_APP_VERSION", value);
    }

    public String getAppNewVersion() {
        return getString("NEW_APP_VERSION", "");
    }


    public void setPushRegId(String value) {
        setString("PREF_PUSH_REG_ID", value);
    }

    public String getPushRegId() {
        return getString("PREF_PUSH_REG_ID", "");
    }


    public void setNotRegistered(String value) {
        setString("NOT_REGISTERD", value);
    }

    public String getNotRegistered() {
        return getString("NOT_REGISTERD", "");
    }

    public void setTokenSentToServer(boolean b) {
        setBoolean("SENT_TOKEN_TO_SERVER", b);
    }

    public boolean getTokenSentToServer() {
        return getBoolean("SENT_TOKEN_TO_SERVER", false);
    }

    public void setPushRegAutoRefreshr(boolean b) {
        setBoolean("PREF_PUSH_REG_AUTO_REFRESH", b);
    }

    public boolean getPushRegAutoRefresh() {
        return getBoolean("PREF_PUSH_REG_AUTO_REFRESH", false);
    }

    public void setSavedPushRegId(String savedPushRegId) {
        setString("PREF_SAVED_PUSH_REG_ID", savedPushRegId);
    }

    public String getSavedPushRegId() {
        return getString("PREF_SAVED_PUSH_REG_ID", "");
    }


    public void setPushNotication(boolean b) {
        setBoolean("PUSH_NOTIFICATION", b);
    }

    public boolean getPushNotification() {
        return getBoolean("PUSH_NOTIFICATION", true);
    }

    public void setCityCommuter(boolean b) {
        setBoolean("CITY_COMMUTERS", b);
    }

    public boolean getCityCommuter() {
        return getBoolean("CITY_COMMUTERS", true);
    }

    public void setComfortCruiser(boolean b) {
        setBoolean("COMFORT_CRUISER", b);
    }

    public boolean getComfortCruiser() {
        return getBoolean("COMFORT_CRUISER", true);
    }

    public void setUserType(String userType) {
        setString("USER_TYPE", userType);
    }

    public String getUserType() {
        return getString("USER_TYPE", "");
    }

    public String getUserFirstName(){
        return getString("User_Fname","");
    }

    public String getUserLastName(){
        return getString("User_Lname","");
    }

    public String getUserPhoneNumber(){
        return getString("User_phone","");
    }

    public void setCountryCode(String code){
        setString("Country_code",code);
    }

    public String getCountryCode(){
        return getString("Country_code","");
    }

    public String getUserAccountVerifiedState(){
        return getString("user_account_state","false");
    }

    public void setUserAccountVerifiedState(String state){
        setString("user_account_state",state);
    }

    public String getQuickBloxVerifiedState(){
        return getString("user_quickblox_state","false");
    }

    public void setQuickBloxVerifiedState(String state){
        setString("user_quickblox_state",state);
    }

    public String getChatToken(){
        return getString("user_chat_token","");
    }

    public void setChatToken(String token){
        setString("user_chat_token",token);
    }


}
