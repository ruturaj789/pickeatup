package com.raj.pickeatup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//            Intent ip=new Intent(MainActivity.this,MyBackgroundProcess.class);
//
//            ip.setAction("BackgroundProcess1");
//
//             PendingIntent pendingIntent= PendingIntent.getBroadcast(MainActivity.this,0,ip,0);
//
//             AlarmManager alarmManager= (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//
//             alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,0,10,pendingIntent);


        Thread t= new Thread(){

            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);

                    Intent im=new Intent(MainActivity.this,Otp.class);

                    startActivity(im);

                    finish();

                }

                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };


        t.start();

    }
}