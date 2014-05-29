package org.invisiblek.notlogger;

import android.app.Activity;
import android.app.INotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.os.ServiceManager;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.util.Log;

public class NotLogger extends Activity
{
    private static final String TAG = "NotLogger";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Log.e(TAG, " ");
        Log.e(TAG, " ");
        Log.e(TAG, " ");
        Log.e(TAG, "Starting Active Notifications List....");
        Log.e(TAG, "======================================");
        StatusBarNotification[] nots = null;
        try {
            nots = INotificationManager.Stub.asInterface(
                   ServiceManager.getService(Context.NOTIFICATION_SERVICE)).
                   getActiveNotifications(this.getPackageName());
        } catch (Exception ex) {}

        if (nots != null) {
            for (int i = 0; i < nots.length; i++) {
                Log.e(TAG, nots[i].getPackageName());
            }
        }

        Log.e(TAG, "======================================");
        Log.e(TAG, "Finished Listing Active Notifications!");
        Log.e(TAG, " ");
        Log.e(TAG, " ");
        Log.e(TAG, " ");
        finish();
    }
}
