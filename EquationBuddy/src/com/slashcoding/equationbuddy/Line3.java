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

public class Line3 extends MenuBuddy implements OnClickListener {
	EditText x1, y1, z1, c1, x2, y2, z2, c2, x3, y3, z3, c3;
	TextView answer, eq;
	Button submit;
	float a, b, c, d, l, m, n, k, p, D, q, r, s, x, y, z;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.linear3);
		initialize();
	}

	private void initialize() {
		// TODO Auto-generated method stub
		x1 = (EditText) findViewById(R.id.eTL3a1);
		y1 = (EditText) findViewById(R.id.eTL3b1);
		z1 = (EditText) findViewById(R.id.eTL3c1);
		c1 = (EditText) findViewById(R.id.eTL3d1);
		x2 = (EditText) findViewById(R.id.eTL3a2);
		y2 = (EditText) findViewById(R.id.eTL3b2);
		z2 = (EditText) findViewById(R.id.eTL3c2);
		c2 = (EditText) findViewById(R.id.eTL3d2);
		x3 = (EditText) findViewById(R.id.eTL3a3);
		y3 = (EditText) findViewById(R.id.eTL3b3);
		z3 = (EditText) findViewById(R.id.eTL3c3);
		c3 = (EditText) findViewById(R.id.eTL3d3);
		answer = (TextView) findViewById(R.id.tvLinear3Answer);
		eq = (TextView) findViewById(R.id.tvLinearEq3);
		eq.setText(Html
				.fromHtml("a1x+b1y+c1z+d1=0 <br/>a2x+b2y+c2z+d2=0 <br/>a3x+b3y+c3z+d3=0"));
		submit = (Button) findViewById(R.id.bLine3);
		submit.setOnClickListener(this);
		MenuBuddy.a4=this;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

		inputManager.hideSoftInputFromWindow(
				getCurrentFocus().getWindowToken(),
				InputMethodManager.HIDE_NOT_ALWAYS);
		if (x1.getText().length() == 0 || y1.getText().length() == 0
				|| z1.getText().length() == 0 || c1.getText().length() == 0
				|| x2.getText().length() == 0 || y2.getText().length() == 0
				|| z2.getText().length() == 0 || c2.getText().length() == 0
				|| x3.getText().length() == 0 || y3.getText().length() == 0
				|| z3.getText().length() == 0 || c3.getText().length() == 0) {
			answer.setText("Please enter values for every coefficient.");
		} else {
			a = Float.valueOf(x1.getText().toString());
			b = Float.valueOf(y1.getText().toString());
			c = Float.valueOf(z1.getText().toString());
			d = Float.valueOf(c1.getText().toString());
			l = Float.valueOf(x2.getText().toString());
			m = Float.valueOf(y2.getText().toString());
			n = Float.valueOf(z2.getText().toString());
			k = Float.valueOf(c2.getText().toString());
			p = Float.valueOf(x3.getText().toString());
			q = Float.valueOf(y3.getText().toString());
			r = Float.valueOf(z3.getText().toString());
			s = Float.valueOf(c3.getText().toString());
			D = (a * m * r + b * p * n + c * l * q)
					- (a * n * q + b * l * r + c * m * p);
			x = ((b * r * k + c * m * s + d * n * q) - (b * n * s + c * q * k + d
					* m * r))
					/ D;
			y = ((a * n * s + c * p * k + d * l * r) - (a * r * k + c * l * s + d
					* n * p))
					/ D;
			z = ((a * q * k + b * l * s + d * m * p) - (a * m * s + b * p * k + d
					* l * q))
					/ D;
			answer.setText("The values are : " + "\nX=" + x + "\nY=" + y
					+ "\nZ=" + z);
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
