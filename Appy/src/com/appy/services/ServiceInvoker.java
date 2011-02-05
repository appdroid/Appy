package com.appy.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ServiceInvoker extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.i("ServiceInvoker", "Received Boot Notification. Will start service");
		AppInfoTracker.acquireStaticLock(context);
		context.startService(new Intent(context, AppInfoTracker.class));
	}

}
