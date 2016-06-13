package com.example.yujingxie.addmap2;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;
import android.app.Application;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.interceptors.ParseLogInterceptor;
import com.parse.ParseInstallation;
import com.parse.PushService;
import com.parse.SaveCallback;
//import com.parse;

public class ParseApplication extends Application {

    public static final String APP_ID = "aquascale";
    public static final String SERVER = "https://aquascale.herokuapp.com/parse/";
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
//        ParseObject.registerSubclass(Report.class);
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId(APP_ID)
                .server(SERVER)   // '/' important after 'parse'
                .addNetworkInterceptor(new ParseLogInterceptor())
                .build());
        ParseInstallation.getCurrentInstallation().saveInBackground();
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();

        // If you would like all objects to be private by default, remove this
        // line.
        defaultACL.setPublicReadAccess(true);

        ParseACL.setDefaultACL(defaultACL, true);
//        PushService.setDefaultPushCallback(this, ReportWaterActivity.class);
    }

//    @Override
//    protected void attachBaseContext(Context context) {
//        super.attachBaseContext(context);
//        MultiDex.install(this);
//    }
}