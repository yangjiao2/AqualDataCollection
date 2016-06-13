/*
package com.example.yujingxie.addmap2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<Report> reports;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler_view);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        reports = new ArrayList<>();
        reports.add(new Report(ParseUser.getCurrentUser(),"DBH","3:33AM",1.0,"Type111111","Front Door"));
        reports.add(new Report(ParseUser.getCurrentUser(),"Langson","15:20PM",1.5,"Type2222","Restroom"));
        reports.add(new Report(ParseUser.getCurrentUser(),"MSTB","2:10PM",2.0,"Type3333","2 floor"));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(reports);
        rv.setAdapter(adapter);
    }
}
*/


package com.example.yujingxie.addmap2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseUser;
import com.parse.*;

import java.util.ArrayList;
import java.util.List;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
//import com.parse.ParseQueryAdapter;
import com.parse.ParseUser;
import com.parse.FindCallback;
import com.parse.LogInCallback;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import com.example.yujingxie.addmap2.ReportClass;


public class RecyclerViewActivity extends AppCompatActivity {

    private List<ReportClass> reports;
    private List<ReportClass> reports1;
    private RecyclerView rv;
//    private int i = 0;

    private int COUNT = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter(reports);

    }

    private void initializeData(){
        reports = new ArrayList<ReportClass>();
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Report");
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    for (ParseObject Areport : objects) {
                        reports.add(new ReportClass("UCI", "01:04AM", "Medium"));
                    }
                }
            }
        });

        reports.add(new ReportClass("DBH", "3:33AM","Medium"));
        reports.add(new ReportClass("MSTB", "12:05PM", "Serious"));
        reports.add(new ReportClass("UCI", "01:04AM", "Medium"));
////        reports.add(new ReportClass("UTC plaza", "05:25PM", "Medium"));
//
//        reports1 = new ArrayList<ReportClass>();
//        ParseQuery<Report> query = ParseQuery.getQuery("Report");
//        // Configure limit and sort order
////        query.whereEqualTo("user", ParseUser.getCurrentUser());
////        query.setLimit(3);
//        query.orderByAscending("createdAt");
//        // Execute query to fetch all messages from Parse asynchronously
//        // This is equivalent to a SELECT query with SQL
//        reports1.add(new ReportClass("UCI2", "01:04AM", "Medium"));
//        query.findInBackground(new FindCallback<Report>() {
//            public void done(List<Report> reportlst, ParseException e) {
//                if (e == null) {
//
//                    for (Report areport : reportlst) {
////                        i = i + 1;
//                        reports1.add(new ReportClass("UCI", "01:04AM", "Medium"));
//                        reports1.add(new ReportClass(areport.getLocation(), areport.getTime(), areport.getType()));
//                    }
//                }
//            }

//        });
//        reports = reports1;
//        int a = i;

//        reports.add(new Report("Langson","15:20PM",1.5,"High","Restroom"));
//        reports.add(new Report("MSTB","2:10PM",2.0,"Medium","2 floor"));
//        ParseUser pu = ParseUser.getCurrentUser();
//        Log.i("user", pu.toString());
//
//        ParseQuery<ParseObject> query = ParseQuery.getQuery("Report");
//        query.whereEqualTo("objectId", "yqbarUMVCM");
//        query.findInBackground(new FindCallback<ParseObject>(){
//            @Override
//            public void done(List<ParseObject> list, ParseException e){
//                for (ParseObject report: list){
////                    reports.add(new Report(aReport.getUser(), aReport.getTime(), aReport.getLocation(), aReport.getDuration(),
////                            aReport.getType(), aReport.getDescription()));
//                    Log.i("report", report.toString());
//                }
//            }
//        });
//            @Override
//            public void done(List<Report> list, ParseException e){
//                for (Report aReport : list){
//                    reports.add(new Report(aReport.getUser(), aReport.getTime(), aReport.getLocation(), aReport.getDuration(),
//                            aReport.getType(), aReport.getDescription()));
//                }
//            }
//        });


//        ParseQuery<ParseObject> query1 = ParseQuery.getQuery("Report");
//        query1.findInBackground(new FindCallback<ParseObject>() {
//            @Override
//            public void done(List<ParseObject> objects, ParseException e) {
//                for (ParseObject object : objects){
//                    reports.add(new Report(object., object.get("time"), object.get("location"), object.get("duration"),
//                            object.get("type"), object.get("description")));
//                }
//            }
//        });
    }

    private void initializeAdapter(List<ReportClass> reports12){
        RVAdapter adapter = new RVAdapter(reports12);
        rv.setAdapter(adapter);
    }
}

