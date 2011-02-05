package com.appy.services;

import java.util.List;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.util.Log;

public class AppInfoTracker extends WakeEventService {
	
	public List<ResolveInfo> pkgAppsList;

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	
	@Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("AppInfoTracker", "Received start id " + startId + ": " + intent);
        super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

	@Override
	public void doServiceTask() {
		try {
			Log.i("AppInfoTracker", "Fetching a list of installed apps on phone");
			final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
			mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
			pkgAppsList = this.getPackageManager().queryIntentActivities( mainIntent, 0);
			for(ResolveInfo eachApp : pkgAppsList) {
				if(isSystemApp(eachApp)) {
					Log.i("App Name:: ", eachApp.activityInfo.name);
				}
			}
		} catch(Exception e) {
			Log.e("AppInfoTracker", e.getMessage());
		} finally {
			//Whatever said and done, once we are done processing
			//stop this service!!
			Log.i("AppInfoTracker","Stopping service now, since we are done fetching the listing!!");
			this.stopSelf();
		}
	}
	
	private boolean isSystemApp(ResolveInfo resolveInfo) {
		Log.i("Flag Values::::::::", resolveInfo.activityInfo.applicationInfo.flags + "");
		return ((resolveInfo.activityInfo.applicationInfo.flags & 
				ApplicationInfo.FLAG_SYSTEM) !=0 ) ? true : false ;
	}
}
