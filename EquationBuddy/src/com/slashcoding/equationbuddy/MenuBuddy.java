package com.slashcoding.equationbuddy;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;

public class MenuBuddy extends Activity {
	public static Activity a1,a2,a3,a4;
	String emailid[] = { "aneesh@slashcoding.com" };
	String reportid[] = { "admin@slashcoding.com" };
	Intent send;

	public void createMenuAneesh(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.reportBug:
			send = new Intent(android.content.Intent.ACTION_SEND);
			send.putExtra(android.content.Intent.EXTRA_EMAIL, reportid);
			send.putExtra(android.content.Intent.EXTRA_SUBJECT,
					"Reporting a Bug in Equation Buddy Application");
			send.setType("plain/text");
			startActivity(Intent.createChooser(send, "Send Email"));
			break;
		case R.id.email:
			send = new Intent(android.content.Intent.ACTION_SEND);
			send.putExtra(android.content.Intent.EXTRA_EMAIL, emailid);
			send.putExtra(android.content.Intent.EXTRA_SUBJECT,
					"Feedback for Equation Buddy");
			send.setType("plain/text");
			startActivity(Intent.createChooser(send, "Send Email"));
			break;
		case R.id.exit:
			if(MenuBuddy.a1!=null)
				MenuBuddy.a1.finish();
			if(MenuBuddy.a2!=null)
				MenuBuddy.a2.finish();
			if(MenuBuddy.a3!=null)
				MenuBuddy.a3.finish();
			if(MenuBuddy.a4!=null)
				MenuBuddy.a4.finish();
			break;
		}
	}
}
