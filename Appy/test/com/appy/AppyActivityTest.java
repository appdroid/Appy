package com.appy;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class AppyActivityTest {
	
	@Test
	public void testAppyActivity() {
		String hello = new AppyActivity().getResources().getString(R.string.app_name);
		Assert.assertEquals(hello, "Appy");
		
	}

}
