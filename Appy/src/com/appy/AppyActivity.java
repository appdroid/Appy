package com.appy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.appy.services.ServiceInvoker;

public class AppyActivity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button serviceButton = (Button) findViewById(R.id.run_service);
        serviceButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View clickArguments) {
				new ServiceInvoker().onReceive(AppyActivity.this, null);
			}
		});
    }
}