package com.example.findus.findme;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.telephony.SmsManager;
import android.widget.RemoteViews;

import com.example.findus.findme.AlertWidgetConfigureActivity;
import com.example.findus.findme.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Implementation of App Widget functionality.
 * App Widget Configuration implemented in {@link AlertWidgetConfigureActivity AlertWidgetConfigureActivity}
 */
public class AlertWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {


        CharSequence widgetText = AlertWidgetConfigureActivity.loadTitlePref(context, appWidgetId);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.alert_widget);
        views.setTextViewText(R.id.appwidget_text, widgetText);




        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    public void getProfileData() {
        FirebaseUser users = FirebaseAuth.getInstance().getCurrentUser();
        String uid = users.getUid();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("user").child(uid);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String person1Cont = dataSnapshot.child("emergencyContacts").child("emergencyContactNumberOne").getValue().toString();
                String dataPhoneNumberOne = person1Cont.getBytes().toString();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:=" + dataPhoneNumberOne));
            }
                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


            }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
            final int N = appWidgetIds.length;

            // Perform this loop procedure for each App Widget that belongs to this provider
            for (int i=0; i<N; i++) {
                int appWidgetId = appWidgetIds[i];

                sendSms();

                // Create an Intent to launch ExampleActivity
                Intent intent = new Intent(context, HomeScreenProfile.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

                // Get the layout for the App Widget and attach an on-click listener
                //  to the button

                RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.alert_widget);
                views.setOnClickPendingIntent(R.id.header_cover_image, pendingIntent);
                views.getClass();
                // Tell the AppWidgetManager to perform an update on the current app widget
                appWidgetManager.updateAppWidget(appWidgetId, views);
            }

        for (int i=0; i<N; i++) {
            int appWidgetId = appWidgetIds[i];

            Intent intentnew = new Intent(context, AlertWidget.class);
            PendingIntent pendingIntentnew = PendingIntent.getActivity(context, 0, intentnew, 0);

            // Get the layout for the App Widget and attach an on-click listener
            //  to the button
            getProfileData();
            RemoteViews viewsnew = new RemoteViews(context.getPackageName(), R.layout.alert_widget);
            viewsnew.setOnClickPendingIntent(R.id.PhoneimageButton,pendingIntentnew);
            viewsnew.getClass();

            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, viewsnew);
        }

    }



    public void  sendSms(){

        FirebaseUser users = FirebaseAuth.getInstance().getCurrentUser();
        String uid = users.getUid();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("user").child(uid);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //emergency contact model
                String person1Cont = dataSnapshot.child("emergencyContacts").child("emergencyContactNumberOne").getValue().toString();
                String person2Cont = dataSnapshot.child("emergencyContacts").child("emergencyContactNumberTwo").getValue().toString();
                String person3Cont = dataSnapshot.child("emergencyContacts").child("emergencyContactNumberThree").getValue().toString();

                SmsManager manager = SmsManager.getDefault();
                String locationUri= String.format("Hey am in danger. My Current Location: \nhttps://www.google.com/maps/@%f,%f,11z\n",42.585444,13.007813);


                String[] phoneNums = {person1Cont,person2Cont,person3Cont};

                for (String num : phoneNums) {
                    manager.sendTextMessage(num,null,locationUri,null,null);
                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        // When the user deletes the widget, delete the preference associated with it.
        for (int appWidgetId : appWidgetIds) {
            AlertWidgetConfigureActivity.deleteTitlePref(context, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created

    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }



}

