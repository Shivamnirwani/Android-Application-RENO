package com.example.reno;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        final TextInputEditText titletext=(TextInputEditText)findViewById(R.id.title_id);
       final TextInputEditText contenttext=(TextInputEditText)findViewById(R.id.content_id);
        Button nbutton=(Button) findViewById(R.id.nbutton_id) ;
        nbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=titletext.getText().toString();
                String content=contenttext.getText().toString();
                NotificationCompat.Builder builder=new NotificationCompat.Builder(notification.this,"mynoti");
                builder.setContentTitle(title);
                builder.setContentText(content);
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                    NotificationChannel channel=new NotificationChannel("mynoti","mynoti", NotificationManager.IMPORTANCE_DEFAULT);
                    NotificationManager manager=getSystemService(NotificationManager.class);
                    manager.createNotificationChannel(channel);
                }
                else{
                    NotificationManagerCompat manger=NotificationManagerCompat.from(notification.this);
                    manger.notify(999,builder.build());
                }





            }
        });
        FirebaseMessaging.getInstance().subscribeToTopic("general")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Successful";
                        if (!task.isSuccessful()) {
                            msg = "Failed";
                        }

                        Toast.makeText(notification.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
