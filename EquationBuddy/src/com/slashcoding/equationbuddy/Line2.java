package com.slashcoding.equationbuddy;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Line2 extends MenuBuddy implements OnClickListener {
	TextView eq, answer;
	EditText xa, xb, xc, xa2, xb2, xc2;
	Button submit;
	float a, b, c, d, e, f;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linear2);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		eq = (TextView) findViewById(R.id.tvLinearEq);
		answer = (TextView) findViewById(R.id.tvLinear2Answer);
		xa = (EditText) findViewById(R.id.eTL2a1);
		xb = (EditText) findViewById(R.id.eTL2b1);
		xc = (EditText) findViewById(R.id.eTL2c1);
		xa2 = (EditText) findViewById(R.id.eTL2a2);
		xb2 = (EditText) findViewById(R.id.eTL2b2);
		xc2 = (EditText) findViewById(R.id.eTL2c2);
		submit = (Button) findViewById(R.id.bLinearSolve);
		eq.setText(Html.fromHtml("a1X + b1Y + c1 = 0 <br/>a2X + b2Y + c2 = 0"));
		submit.setOnClickListener(this);
		MenuBuddy.a3=this;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		float x, y;
		InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

		inputManager.hideSoftInputFromWindow(
				getCurrentFocus().getWindowToken(),
				InputMethodManager.HIDE_NOT_ALWAYS);
		if (xa.getText().length() == 0 || xb.getText().length() == 0
				|| xc.getText().length() == 0 || xa2.getText().length() == 0
				|| xb2.getText().length() == 0 || xc2.getText().length() == 0) {
			answer.setText("Please enter values for every coefficient.");
		} else {
			a = Float.parseFloat(xa.getText().toString());
			b = Float.parseFloat(xb.getText().toString());
			c = Float.parseFloat(xc.getText().toString());
			d = Float.parseFloat(xa2.getText().toString());
			e = Float.parseFloat(xb2.getText().toString());
			f = Float.parseFloat(xc2.getText().toString());
			x = ((f * b) - (c * e)) / ((a * e) - (d * b));
			y = ((c * d) - (f * a)) / ((a * e) - (d * b));
			answer.setText("The values are : " + "\nX=" + x + "\nY=" + y);
		}

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu((android.view.Menu) menu);
		InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

		inputManager.hideSoftInputFromWindow(
				getCurrentFocus().getWindowToken(),
				InputMethodManager.HIDE_NOT_ALWAYS);
		MenuInflater blowup = getMenuInflater();
		blowup.inflate(R.menu.mainmenu, (android.view.Menu) menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		createMenuAneesh(item);
		return false;
	}
}
