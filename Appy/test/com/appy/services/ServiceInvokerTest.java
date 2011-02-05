package com.appy.services;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.app.Application;
import android.content.ComponentName;

import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import com.xtremelabs.robolectric.shadows.ShadowApplication;


@RunWith(RobolectricTestRunner.class)
public class ServiceInvokerTest {
	
	private Application testApplication;
	
	@Before
	public void setup() {
		testApplication = Robolectric.application;
	}
	
	@Test
	public void testOnReceiveMethod() {
		new ServiceInvoker().onReceive(testApplication.getApplicationContext(), null);
		ShadowApplication shadowApplication = (ShadowApplication) Robolectric.shadowOf(testApplication);
		ComponentName component = shadowApplication.peekNextStartedService().getComponent();
		Assert.assertEquals("com.appy.services.AppInfoTracker", component.getClassName());
	}

}
