package com.appy.services;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import com.xtremelabs.robolectric.shadows.ShadowApplication;


@RunWith(RobolectricTestRunner.class)
public class AppInfoTrackerTest {
	
	private Application testApplication;
	private Context applicationContext;
	
	@Before
	public void setup(){
		testApplication = Robolectric.application;
		applicationContext = testApplication.getApplicationContext();
	}
	
	@Test
	public void testThatAppTrackerInfoServiceIsKickedOff() {
		applicationContext.startService((new Intent(applicationContext, AppInfoTracker.class)));
		ShadowApplication shadowApplication = (ShadowApplication) Robolectric.shadowOf(testApplication);
		
		String serviceName = shadowApplication.peekNextStartedService().getComponent().getClassName();
		Assert.assertEquals("com.appy.services.AppInfoTracker", serviceName);
	}
}
