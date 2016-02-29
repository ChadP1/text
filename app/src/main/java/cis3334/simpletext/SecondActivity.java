package cis3334.simpletext;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SecondActivity extends Activity {
	
	String eventNum;		// number of the event from mainActivity
	RadioButton first, second, third, fourth;
	RadioGroup selected;
	String message;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_second);
		
	    first = (RadioButton) findViewById(R.id.radioButton);
		second = (RadioButton) findViewById(R.id.radioButton2);
		third = (RadioButton) findViewById(R.id.radioButton3);
		fourth = (RadioButton) findViewById(R.id.radioButton4);

        // get the data passed from the main activity using extras
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
            // grab the event number as a string from the main activity using extras
		    eventNum = extras.getString("eventNum");
		}
		//depending on the event number, display different information on this form
		if (eventNum.equals("1")) {

			first.setText("Han Solo");
			second.setText("Hey its me");
			third.setText("Never tell me the odds");
			fourth.setText("I don't know, fly casual");


		}
		if (eventNum.equals("2")) {
			first.setText("Chewie");
			second.setText("Rawersera");
			third.setText("ASDfaslkj");
			fourth.setText("asdkfhkj");
		}
		if (eventNum.equals("3")) {
			first.setText("Luke");
			second.setText("Just like shooting womp rats back home");
			third.setText("Headed to Tosche station to pick up a power converter");
			fourth.setText("Have to help my uncle wih the harvest");

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.layout_second, menu);
		return true;
	}
	
	public void onClickSendText (View v) {


		Intent sendIntent = new Intent(Intent.ACTION_VIEW);
		sendIntent.setData(Uri.parse("sms:2183911863"));
		sendIntent.putExtra("sms_body", "Content of the SMS goes here...");
		startActivity(sendIntent);

	}
}
