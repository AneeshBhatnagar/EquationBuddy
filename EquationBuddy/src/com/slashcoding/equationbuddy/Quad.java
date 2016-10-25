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

public class Quad extends MenuBuddy implements OnClickListener {
	EditText a, b, c;
	TextView answer,eq;
	Button solve;
	float va, vb, vc;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quadratic);
		a = (EditText) findViewById(R.id.eTa);
		b = (EditText) findViewById(R.id.eTb);
		c = (EditText) findViewById(R.id.eTc);
		answer = (TextView) findViewById(R.id.tvQuadAnswer);
		solve = (Button) findViewById(R.id.bQuadSolve);
		solve.setOnClickListener(this);
		eq = (TextView) findViewById(R.id.tvQuadeq);
		eq.setText(Html.fromHtml("aX<sup>2</sup> + bX + c = 0"));
		MenuBuddy.a2=this;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

		inputManager.hideSoftInputFromWindow(
				getCurrentFocus().getWindowToken(),
				InputMethodManager.HIDE_NOT_ALWAYS);

		if (a.getText().length() == 0 || b.getText().length() == 0
				|| c.getText().length() == 0) {
			answer.setText("Please enter values for every coefficient.");
		} else {
			float d;
			double x1, x2;
			va = Float.parseFloat(a.getText().toString());
			vb = Float.parseFloat(b.getText().toString());
			vc = Float.parseFloat(c.getText().toString());
			if (va == 0)
				answer.setText("The value of 'a' can not be zero!");
			else {
				d = (vb * vb) - (4 * va * vc);
				if (d >= 0) {
					x1 = ((-vb) + Math.sqrt(d)) / (2 * va);
					x2 = ((-vb) - Math.sqrt(d)) / (2 * va);
					answer.setText("The roots are : \n\nX1= " + x1 + "\nX2= " + x2);
				} else {
					d = d * -1;
					float a2 = 2 * va;
					answer.setText("The roots are: \n\nX1= " + (-vb / a2) + " + "
							+ (Math.sqrt(d)) / a2 + " i \nX2= " + (-vb / a2)
							+ " - " + (Math.sqrt(d)) / a2 + " i");
				}

			}

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
