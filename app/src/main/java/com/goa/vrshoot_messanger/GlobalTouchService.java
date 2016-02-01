package com.goa.vrshoot_messanger;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.widget.Toast;

public class GlobalTouchService extends Service {

    BroadcastReceiver br;
    IntentFilter filter;

    @Override
    public IBinder onBind(Intent arg0) {
// TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        filter = new IntentFilter("android.media.VOLUME_CHANGED_ACTION");

        br = new BroadcastReceiver()
        {
            public void onReceive(Context context, Intent intent)
            {
                if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION"))
                {

                    /*DO
                    TASK*/
                    MainActivity.serverThread.sendMessage();

/*
                    Intent i = new Intent(context, Meaning.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
*/
                    Toast.makeText(getApplicationContext(), "volume uo", Toast.LENGTH_SHORT).show();

                }
            }
        };

        getApplicationContext().registerReceiver(br, filter);

    }

}