package com.codeeden.sampleviperproject.network;

/**
 * Created by saraswati on 08/03/18.
 */

public class EventTypeControl {

    public static final int EventTypeGeneral = -1;
    //Login Screen
    public static final int EventTypeLogin = 101;
    public static final int EventTypeForgotPassword = 102;
    public static final int EventTypeAlreadyExist = 103;

    // Registration Screen
    public static final int EventTypeRegistrationMe = 201;

    // Profile  Screen
    public static final int ProfileEventTypeGetProfile = 301;
    public static final int ProfileEventTypeUpdateProfile = 302;
    public static final int ProfileEventTypeChangePassword = 303;
    public static final int ProfileEventTypeLogout = 304;


    // Home Screen
    public static final int ChromatasityListEventTypeGetChromatasity = 401;
    public static final int ChromatasityListEventTypeAddChromatasity = 402;

    // Menu Screen
    public static final int EventTypeMenu = 501;

    // Setting Screen
    public static final int EventTypeSetting = 601;
}
