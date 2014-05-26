package com.academicode.understandingintents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * This class represents the second activity for our application.  It is the second screen that the 
 * user sees upon clicking the "preview" button from the previous Activity.  Here, we simply ask 
 * the user to send their message after they see the preview..
 * 
 * The associated XML file representing the layout of this Activity is "layout\next.xml".
 * 
 * @author Marc J. McDougall
 */
public class Next extends Activity {

	// Publicly-accessible id distinguishing our String extra.
	private Button send;
	private TextView message;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// Mandatory super method call.
		super.onCreate(savedInstanceState);
		
		// Set the content view top the correct layout file.
		setContentView(R.layout.next);
		
		// Associate the Java variables with the correct XML components.
		send = (Button) findViewById(R.id.button1);
		message = (TextView) findViewById(R.id.textView2);
		
		// Here, we set the text displayed in this View to the String value pulled from the Extra in the Intent
		// used to launch this Activity.
		message.setText(getIntent().getExtras().getString(Main.DATA_TAG));
		
		// Here, we set a click listener to react to touch events on the "send" Button.
		send.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// We create another Intent - this one will be used implicitly.
				Intent implicitIntent = new Intent(Intent.ACTION_SEND);
				
				// We add the text Extra to this Intent.  Note that we have to use the Intent's "EXTRA_TEXT"
				// id so that the Android OS can find it later.
				implicitIntent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
				
				// We specify the type of data contained in this intent (we are working with plain text).
				implicitIntent.setType("text/plain");
				
				// Create a chooser (this is again another Activity) so that the user can select the 
				// appropriate application to resolve the Intent.
				Intent chooserIntent = Intent.createChooser(implicitIntent, "Choose an Application:");
				
				// We start the chooser.
				startActivity(chooserIntent);
			}
		});
	}
}
