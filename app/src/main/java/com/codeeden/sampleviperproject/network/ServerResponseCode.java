package com.codeeden.sampleviperproject.network;

/**
 * Created by saraswati on 13/03/18.
 */

public class ServerResponseCode {

    /***response codes***/

    public static final int RESPONSE_FB_USER_NOT_EXIST = 5004;
    public static final int RESPONSE_AUTHENTICATION_FAILED = 4001;


    public static final int RESPONSE_NO_RECORD_FOUND = 5002;
    public static final int RESPONSE_OTP_NOT_VERIFIED = 5003;
    public static final int REPONE_SUCCESSFULLY_SYNC = 5005;
    public static final int REPONE_PASSWORD_NOT_UPDATED = 4002;

    // Retrofit error
    public static final int RESPONSE_Retrofit_EXCEPTION = 1001;
// Exception
    public static final int RESPONSE_IO_EXCEPTION = 1002;
    public static final int RESPONSE_NETWORK_EXCEPTION = 1003;
    public static final int RESPONSE_TRY_CATCH_EXCEPTION = 1004;

    // common to all response
    public static final int RESPONSE_SUCESS = 2000;
    public static final int REPONE_INSUFFICIENT_REQUEST_DATA = 5000; // need to change this code

    // Registration
    public static final int RESPONSE_USER_ALREADY_EXIST = 2009;

    // Login Response code
    public static final int RESPONSE_USER_DOES_NOT_EXIST = 4000;
    public static final int RESPONSE_USER_AUTH_FAIL = 5005;
    public static final int REPONE_PASSWORD_DOES_NOT_MATCH = 4010;

    public static class ForgotPassword {
        public static final int RESPONSE_EMAIL_DOES_NOT_EXIST = 4000;

    }




}
