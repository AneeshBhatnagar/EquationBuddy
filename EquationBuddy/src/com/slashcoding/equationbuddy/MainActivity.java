package com.slashcoding.equationbuddy;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends MenuBuddy implements OnClickListener,
		OnCheckedChangeListener {
	RadioGroup selection;
	Button b;
	@SuppressWarnings("rawtypes")
	Class action;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		selection = (RadioGroup) findViewById(R.id.rgMain);
		b = (Button) findViewById(R.id.bMain);
		selection.setOnCheckedChangeListener(this);
		b.setOnClickListener(this);
		try {
			action = Class.forName("com.slashcoding.equationbuddy.Quad");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MenuBuddy.a1=this;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		Intent i = new Intent(MainActivity.this, action);
		startActivity(i);
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch (checkedId) {
		case R.id.rQuad:
			try {
				action = Class.forName("com.slashcoding.equationbuddy.Quad");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.rLine2:
			try {
				action = Class.forName("com.slashcoding.equationbuddy.Line2");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.rLine3:
			try {
				action = Class.forName("com.slashcoding.equationbuddy.Line3");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu((android.view.Menu) menu);
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
