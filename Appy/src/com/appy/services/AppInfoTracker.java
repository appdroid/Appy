package com.appy.services;

import java.util.List;

import android.app.Service;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.util.Log;

public class AppInfoTracker extends Service {
	
	public List<ResolveInfo> pkgAppsList =null;

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	
	@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("AppInfoTracker", "Received start id " + startId + ": " + intent);
        return START_STICKY;
    }
	
	@Override
	public void onCreate() {
		super.onCreate();
		Log.i("AppInfoTracker", "Here I am!!");
		final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
		mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
		pkgAppsList = this.getPackageManager().queryIntentActivities( mainIntent, 0);
		for(ResolveInfo eachApp : pkgAppsList) {
			Log.i("App Name:: ", eachApp.activityInfo.name);
		}
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}

}
