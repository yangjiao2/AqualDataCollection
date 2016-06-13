/*
package com.example.yujingxie.addmap2;

import android.app.Activity;
import android.app.TabActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View;
import android.support.v4.app.DialogFragment;
import android.widget.TabHost;
import android.widget.TextView;
import java.util.Calendar;
import android.app.TimePickerDialog;
import android.widget.TimePicker;
import android.view.View.OnClickListener;
import java.util.Locale;
import java.text.SimpleDateFormat;

import com.parse.ParseObject;
import com.parse.ParseUser;


public class ReportWaterActivity extends  AppCompatActivity{
    final Calendar myCalendar = Calendar.getInstance();
    TextView edittext;
    String getLoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_water2);

        Spinner spinner = (Spinner) findViewById(R.id.LeakageType_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        //Time Dialogue
          edittext=(EditText)findViewById(R.id.timeText);

        */
/*Bundle bundle = getIntent().getExtras();
        getLoc=bundle.getString("location");
        System.out.print(getLoc);*//*


        final TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {

            public void onTimeSet(TimePicker view, int hour, int minutes) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.HOUR_OF_DAY, hour);
                myCalendar.set(Calendar.MINUTE, minutes);
                updateLabel();
            }

        };

        edittext.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new TimePickerDialog(ReportWaterActivity.this, time,myCalendar
                        .get(Calendar.HOUR_OF_DAY), myCalendar.get(Calendar.MINUTE),true).show();
            }
        });

        //save button into database with Report button
       final DataHelper helper=new DataHelper(this, DataHelper.DATABASE_NAME,null,DataHelper.DATABASE_VER);
        final SQLiteDatabase db=helper.getWritableDatabase();;
        Button reportButton=(Button)findViewById(R.id.reportbtn);
        final EditText editName=(EditText)findViewById(R.id.name);
        final EditText editLocation=(EditText)findViewById(R.id.location);
        final EditText editTime=(EditText)findViewById(R.id.timeText);
        final EditText editDuration=(EditText)findViewById(R.id.duration);
        final Spinner editType=(Spinner) findViewById(R.id.LeakageType_spinner);
        final EditText editDescrp=(EditText) findViewById(R.id.description);
        final Spinner durationType=(Spinner)findViewById(R.id.DurationType);
        reportButton.setOnClickListener(new OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                String name=editName.getText().toString().trim();
                                                String location=editLocation.getText().toString().trim();
                                              //  String location=getLoc;
                                                String time=editTime.getText().toString().trim();
                                                double duration=Double.parseDouble(editDuration.getText().toString().trim());
                                                String durationType1=durationType.getItemAtPosition(durationType.getSelectedItemPosition()).toString();
                                                String type=editType.getItemAtPosition(editType.getSelectedItemPosition()).toString();
                                                String description=editDescrp.getText().toString().trim();
                                                if(!name.equals("") && !location.equals("") && !time.equals("") && !type.equals("") ){


                                                    ParseUser currentUser = ParseUser.getCurrentUser();
                                                    Report report = new Report(currentUser, location, time, duration, type, description);
                                                    report.saveInBackground();

                                                    ContentValues content=new ContentValues();
                                                    content.put(DataHelper.KEY_NAME,name);
                                                    content.put(DataHelper.KEY_Location,location);
                                                    content.put(DataHelper.KEY_TIME,time);
                                                    content.put(DataHelper.KEY_Duration,duration);
                                                    content.put(DataHelper.KEY_Duration_Type,durationType1);
                                                    content.put(DataHelper.KEY_LEAKAGE_TYPE,type);
                                                    content.put(DataHelper.KEY_Description,description);

                                                    db.insert(DataHelper.TABLE_Report,null,content);
                                                    AlertDialog.Builder alertBuilder=new AlertDialog.Builder(ReportWaterActivity.this);
                                                    alertBuilder.setTitle("Success");
                                                    alertBuilder.
                                                            setMessage("Thank you for reporting the water leakage!")
                                                            .setCancelable(false)
                                                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    ReportWaterActivity.this.finish();
                                                                }

                                                                });
                                                    AlertDialog alertDialog=alertBuilder.create();
                                                    alertDialog.show();
                                                }
                                                else{

                                                    AlertDialog.Builder alertBuilderIllegal=new AlertDialog.Builder(ReportWaterActivity.this);
                                                    alertBuilderIllegal.
                                                            setMessage("You should fill in all the required field, include name,location,time, type")
                                                            .setCancelable(false)
                                                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    ReportWaterActivity.this.finish();
                                                                }

                                                            });
                                                    AlertDialog alertDialog=alertBuilderIllegal.create();
                                                    alertDialog.show();



                                                }
                                                db.close();
                                            }



                                        }

        );

   */
/*     String [] projection={DataHelper.KEY_Location};
        String [] selection={"Nancy"};
        Cursor c=db.query(DataHelper.TABLE_Report,projection,null,null,null,null,null);
        c.moveToFirst();
        String location=c.getString(c.getColumnIndexOrThrow(DataHelper.KEY_Location));
        System.out.println(location);*//*


        //do nothing when click on cancel button
        Button cancelButton=(Button)findViewById(R.id.cancelBtn);
        cancelButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                ReportWaterActivity.this.finish();
            }
        });
    }

    private void updateLabel() {

        String myFormat = "hh:mm"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edittext.setText(sdf.format(myCalendar.getTime()));
    }

}






*/




package com.example.yujingxie.addmap2;

import android.app.Activity;
import android.app.TabActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View;
import android.support.v4.app.DialogFragment;
import android.widget.TabHost;
import android.widget.TextView;
import java.util.Calendar;
import android.app.TimePickerDialog;
import android.widget.TimePicker;
import android.view.View.OnClickListener;
import java.util.Locale;
import java.text.SimpleDateFormat;

import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.ParseCloud;

public class ReportWaterActivity extends  AppCompatActivity{
    final Calendar myCalendar = Calendar.getInstance();
    TextView edittext;
    String getLoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_water2);

        Spinner spinner = (Spinner) findViewById(R.id.LeakageType_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        //Time Dialogue
        edittext=(EditText)findViewById(R.id.timeText);

        /*Bundle bundle = getIntent().getExtras();
        getLoc=bundle.getString("location");
        System.out.print(getLoc);*/

        final TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {

            public void onTimeSet(TimePicker view, int hour, int minutes) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.HOUR_OF_DAY, hour);
                myCalendar.set(Calendar.MINUTE, minutes);
                updateLabel();
            }

        };

        edittext.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new TimePickerDialog(ReportWaterActivity.this, time,myCalendar
                        .get(Calendar.HOUR_OF_DAY), myCalendar.get(Calendar.MINUTE),true).show();
            }
        });

        //save button into database with Report button
        final DataHelper helper=new DataHelper(this, DataHelper.DATABASE_NAME,null,DataHelper.DATABASE_VER);
        final SQLiteDatabase db=helper.getWritableDatabase();
        Button reportButton=(Button)findViewById(R.id.reportbtn);
        final EditText editName=(EditText)findViewById(R.id.name);
        final EditText editLocation=(EditText)findViewById(R.id.location);
        final EditText editTime=(EditText)findViewById(R.id.timeText);
        final EditText editDuration=(EditText)findViewById(R.id.duration);
        final Spinner editType=(Spinner) findViewById(R.id.LeakageType_spinner);
        final EditText editDescrp=(EditText) findViewById(R.id.description);
        final Spinner durationType=(Spinner)findViewById(R.id.DurationType);
        reportButton.setOnClickListener(new OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                String name=editName.getText().toString().trim();
                                                String location=editLocation.getText().toString().trim();
                                                //  String location=getLoc;
                                                String time=editTime.getText().toString().trim();
                                                double duration=Double.parseDouble(editDuration.getText().toString().trim());
                                                String durationType1=durationType.getItemAtPosition(durationType.getSelectedItemPosition()).toString();
                                                String type=editType.getItemAtPosition(editType.getSelectedItemPosition()).toString();
                                                String description=editDescrp.getText().toString().trim();
                                                if(!name.equals("") && !location.equals("") && !time.equals("") && !type.equals("") ){

                                                    ParseObject report = new ParseObject("Report");
                                                    ParseUser currentUser = ParseUser.getCurrentUser();
                                                    report.put("user", currentUser.getObjectId());
                                                    report.put("location", location);
                                                    report.put("time", time);
                                                    report.put("duration", duration);
                                                    report.put("durationType", durationType1);
                                                    report.put("type", type);
                                                    report.put("description", description);
                                                    report.saveInBackground();


                                                    final Map<String, Object> params = new HashMap<>();
                                                    params.put("message", "We received report from" + location + ".");
                                                    params.put("useMasterKey", true);

                                                    ParseCloud.callFunctionInBackground("sendAnnouncement", params, new FunctionCallback<String>() {
                                                        public void done(String result, ParseException e) {
                                                            if (e == null) {
                                                                Utils.d("ANNOUNCEMENT SUCCESS");
                                                            } else {
                                                                Utils.e("ANNOUNCEMENT FAILURE");
                                                            }
                                                        }
                                                    });




//
                                                    ContentValues content=new ContentValues();
                                                    content.put(DataHelper.KEY_NAME,name);
                                                    content.put(DataHelper.KEY_Location,location);
                                                    content.put(DataHelper.KEY_TIME,time);
                                                    content.put(DataHelper.KEY_Duration,duration);
                                                    content.put(DataHelper.KEY_Duration_Type,durationType1);
                                                    content.put(DataHelper.KEY_LEAKAGE_TYPE,type);
                                                    content.put(DataHelper.KEY_Description,description);

                                                    db.insert(DataHelper.TABLE_Report,null,content);
                                                    AlertDialog.Builder alertBuilder=new AlertDialog.Builder(ReportWaterActivity.this);
                                                    alertBuilder.setTitle("Success");
                                                    alertBuilder.
                                                            setMessage("Thank you for reporting the water leakage!")
                                                            .setCancelable(false)
                                                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    ReportWaterActivity.this.finish();
                                                                }

                                                            });
                                                    AlertDialog alertDialog=alertBuilder.create();
                                                    alertDialog.show();
                                                }
                                                else{

                                                    AlertDialog.Builder alertBuilderIllegal=new AlertDialog.Builder(ReportWaterActivity.this);
                                                    alertBuilderIllegal.
                                                            setMessage("You should fill in all the required field, include name,location,time, type")
                                                            .setCancelable(false)
                                                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    ReportWaterActivity.this.finish();
                                                                }

                                                            });
                                                    AlertDialog alertDialog=alertBuilderIllegal.create();
                                                    alertDialog.show();



                                                }
                                                db.close();
                                            }



                                        }

        );

   /*     String [] projection={DataHelper.KEY_Location};
        String [] selection={"Nancy"};
        Cursor c=db.query(DataHelper.TABLE_Report,projection,null,null,null,null,null);
        c.moveToFirst();
        String location=c.getString(c.getColumnIndexOrThrow(DataHelper.KEY_Location));
        System.out.println(location);*/

        //do nothing when click on cancel button
        Button cancelButton=(Button)findViewById(R.id.cancelBtn);
        cancelButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                ReportWaterActivity.this.finish();
            }
        });
    }

    private void updateLabel() {

        String myFormat = "hh:mm"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edittext.setText(sdf.format(myCalendar.getTime()));
    }

}







