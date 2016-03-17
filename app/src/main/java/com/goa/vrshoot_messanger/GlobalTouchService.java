package com.goa.vrshoot_messanger;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;
import android.view.KeyEvent;

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
                    MainActivity.serverThread.sendMessage(1);
                    Log.d("change","change");
/*
                    Intent i = new Intent(context, Meaning.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i);
*/
                    //Toast.makeText(getApplicationContext(), "volume uo", Toast.LENGTH_SHORT).show();

                }
                else if (Intent.ACTION_MEDIA_BUTTON.equals(intent.getAction())) {
                    KeyEvent event = (KeyEvent)intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
                    if (KeyEvent.KEYCODE_VOLUME_UP == event.getKeyCode()) {
                        // Handle key press.
                        Log.d("up","up");
                        MainActivity.serverThread.sendMessage(1);
                    }else if (KeyEvent.KEYCODE_VOLUME_DOWN == event.getKeyCode()) {
                        // Handle key press.
                        Log.d("down","down");
                        MainActivity.serverThread.sendMessage(0);
                    }
                }
            }
        };

        getApplicationContext().registerReceiver(br, filter);

    }

}