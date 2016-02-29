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
import android.widget.TextView;

public class SecondActivity extends Activity {
	
	String eventNum;		// number of the event from mainActivity
	TextView tvTitle, tvSum, tvLoc, tvDate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_second);
		
		tvTitle = (TextView) findViewById(R.id.txtTitle);
		tvSum = (TextView) findViewById(R.id.txtSummary);
		tvLoc = (TextView) findViewById(R.id.txtLocation);
		tvDate = (TextView) findViewById(R.id.txtDate);
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    eventNum = extras.getString("eventNum");
		}
		
		if (eventNum.equals("1")) {
			tvTitle.setText("An Evening With The Voice");
			tvSum.setText("NBC’s The Voice’s Madi Davis and twins Andi & Alex Peot will perform in concert");
			tvLoc.setText("Mitchell Auditorium");
			tvDate.setText("SUNDAY, FEBRUARY 28, 2016");
		}
		if (eventNum.equals("2")) {
			tvTitle.setText("Thistles & Shamrocks");
			tvSum.setText("An Evening of Scottish & Irish Music and Dance sponsored by the Duluth Scottish Heritage Association");
			tvLoc.setText("Mitchell Auditorium");
			tvDate.setText("FRIDAY, March 4, 2016");
		}
		if (eventNum.equals("3")) {
			tvTitle.setText("Why Civil Resistance Works with Erica Chenoweth");
			tvSum.setText("Erica Chenoweth, Ph.D., is an associate professor at the Josef Korbel School of International Studies at the University of Denver and an associate senior researcher at the Peace Research Institute of Oslo.");
			tvLoc.setText("Mitchell Auditorium");
			tvDate.setText("THURSDAY, MARCH 10, 2016");
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.layout_second, menu);
		return true;
	}
	
	public void onClickSendText (View v) {
		
		if (eventNum.equals("1")) {
		
			Intent calIntent = new Intent(Intent.ACTION_INSERT);
			calIntent.setType("vnd.android.cursor.item/event");
			calIntent.putExtra(Events.TITLE, "An Evening With the Voice");
			calIntent.putExtra(Events.EVENT_LOCATION, "Mitchell Auditorium");
			GregorianCalendar begDate = new GregorianCalendar(2015, 2, 22, 7, 30);
			GregorianCalendar endDate = new GregorianCalendar(2015, 2, 22, 9, 30);
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
					begDate.getTimeInMillis());
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
					endDate.getTimeInMillis());
			startActivity(calIntent);
		}
		if (eventNum.equals("2")) {
			Intent calIntent = new Intent(Intent.ACTION_INSERT);
			calIntent.setType("vnd.android.cursor.item/event");
			calIntent.putExtra(Events.TITLE, "Thistles & Shamrocks");
			calIntent.putExtra(Events.EVENT_LOCATION, "Mitchell Auditorium");
			startActivity(calIntent);
		}
		if (eventNum.equals("3")) {
			Intent calIntent = new Intent(Intent.ACTION_INSERT);
			calIntent.setType("vnd.android.cursor.item/event");
			calIntent.putExtra(Events.TITLE, "Why Civil Resistance Works with Erica Chenoweth");
			calIntent.putExtra(Events.EVENT_LOCATION, "Mitchell Auditorium");
			Calendar beginTime = Calendar.getInstance();
			beginTime.set(2015, 2, 22, 7, 30);
			Calendar endTime = Calendar.getInstance();
			endTime.set(2015, 2, 22, 9, 30);
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
					beginTime.getTimeInMillis());
			calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
					endTime.getTimeInMillis());
			startActivity(calIntent);

		}
		

	}
	

}
