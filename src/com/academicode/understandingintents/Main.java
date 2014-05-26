package com.academicode.understandingintents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * This class represents the Main activity for our application.  It is the first screen that the 
 * user sees upon entering the application.  Here, we simply ask the user to type a message.
 * 
 * The associated XML file representing the layout of this Activity is "layout\main.xml".
 * 
 * @author Marc J. McDougall
 */
public class Main extends Activity {

	// Publicly-accessible id distinguishing our String extra.
	public static final String DATA_TAG = "message";
	
	// References to the Views contained inside this Activity.
	private EditText et;
	private Button next;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// Mandatory super method call.
		super.onCreate(savedInstanceState);
		
		// Set the content view top the correct layout file.
		setContentView(R.layout.main);
		
		// Associate the Java variables with the correct XML components.
		next = (Button) findViewById(R.id.button1);
		et = (EditText) findViewById(R.id.editText1);
		
		// Here, we set a click listener to react to touch events on the "preview" Button.
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// Create a new Intent pointed at the "Next" class.
				Intent intent = new Intent(Main.this, Next.class);
				
				// Add the user's text from the EditText View as a String Extra.
				intent.putExtra(DATA_TAG, et.getText().toString());
				
				// Start the new Activity.
				startActivity(intent);
			}
		});
	}
}
