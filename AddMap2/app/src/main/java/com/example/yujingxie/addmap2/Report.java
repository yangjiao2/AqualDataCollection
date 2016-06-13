/*
package com.example.yujingxie.addmap2;

import com.parse.Parse;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseUser;
import com.parse.ParseObject;
import com.parse.ParseInstallation;
import com.parse.PushService;
import com.parse.ParseClassName;


*/
/**
 * Created by Yang on 2016/6/3.
 *//*

@ParseClassName("Report")

    public class Report extends ParseObject{
        public Report(){
            super();
        }

        public Report(ParseUser User, String Location, String Time, double Durantion, String Type, String Description) {
            super();
            // setName(Name);
            setUser(User);
            setLocation(Location);
            setTime(Time);
            setDurantion(Durantion);
            setType(Type);
            setDescription(Description);
        }

        // Use getString and others to access fields
    public String getLocation() {
        return getString("location");
    }
    public String getTime() {
        return getString("time");
    }
    public int getDuration() {
        return getInt("duration");
    }
    public String getType() {
        return getString("type");
    }
    public String getDescription() {
        return getString("description");
    }
    // Use put to modify field values
    public void setLocation(String value) {
        put("location", value);
    }
    public void setTime(String value) {
        put("time", value);
    }
    public void setDurantion(double value) {
        put("duration", value);
    }
    public void setType(String value) {
        put("type", value);
    }
    public void setDescription(String value) {
        put("description", value);
    }

    // Get the user for this item
    public ParseUser getUser()  {
        return getParseUser("owner");
    }

    // Associate each item with a user
    public void setUser(ParseUser user) {
        put("user", user);
    }


}
*/


package com.example.yujingxie.addmap2;

import com.parse.Parse;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseUser;
import com.parse.ParseObject;
import com.parse.ParseInstallation;
import com.parse.PushService;
import com.parse.ParseClassName;


/**
 * Created by Yang on 2016/6/3.
 */
@ParseClassName("Report")

public class Report extends ParseObject{
//    public Report(){
//        super();
//    }

//    public Report(String User, String Location, String Time, double Durantion, String Type, String Description) {
//        super();
//        // setName(Name);
//        setUser(User);
//        setLocation(Location);
//        setTime(Time);
//        setDurantion(Durantion);
//        setType(Type);
//        setDescription(Description);
//    }

    // Use getString and others to access fields
    public String getLocation() {
        return getString("location");
    }
    public String getTime() {
        return getString("time");
    }
    public double getDuration() {
        return getDouble("duration");
    }
    public String getDurationType() {return getString("durationType");}
    public String getType() {
        return getString("type");
    }
    public String getDescription() {
        return getString("description");
    }
    // Use put to modify field values
    public void setLocation(String value) {
        put("location", value);
    }
    public void setTime(String value) {
        put("time", value);
    }
    public void setDuration(double value) {
        put("duration", value);
    }
    public void setDurationType(String value)  {
        put("durationType", value);
    }
    public void setType(String value) {
        put("type", value);
    }
    public void setDescription(String value) {
        put("description", value);
    }

    // Get the user for this item
    public String getUser()  {
        return getParseUser("user").getObjectId();
    }

    // Associate each item with a user
    public void setUser(String user) {
        put("user", user);
    }


}
