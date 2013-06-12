package com.sleepyapps.codecracka;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{
	//TODO: read codes from external file
	private String[] codes = {"UUDDLRLRBA"};
	private ArrayList<String> codeList;
	private String currentEntry = "";
	
	private static final String TAG = "MainActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		codeList = new ArrayList<String>(Arrays.asList(codes));
		
		Button aButton = (Button)findViewById(R.id.aButton);
		aButton.setOnClickListener(this);
		
		Button bButton = (Button)findViewById(R.id.bButton);
		bButton.setOnClickListener(this);
		
		Button upButton = (Button)findViewById(R.id.upButton);
		upButton.setOnClickListener(this);
		
		Button downButton = (Button)findViewById(R.id.downButton);
		downButton.setOnClickListener(this);
		
		Button leftButton = (Button)findViewById(R.id.leftButton);
		leftButton.setOnClickListener(this);
		
		Button rightButton = (Button)findViewById(R.id.rightButton);
		rightButton.setOnClickListener(this);
		
		Button resetButton = (Button)findViewById(R.id.resetButton);
		resetButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private boolean checkMatch(){
		boolean isMatch = false;
		
		Log.i(TAG, "currentEntry: " + currentEntry);
		if(currentEntry != null && !currentEntry.isEmpty()){
			if(codeList.contains(currentEntry)){
				isMatch = true;
			}
		}
		return isMatch;
	}

	@Override
	public void onClick(View v) {
		if(v instanceof Button){
			int id = ((Button) v).getId();
			
			//TODO: externalize button mappings
			switch(id){
				case R.id.aButton:
					currentEntry += "A";
					break;
				case R.id.bButton:
					currentEntry += "B";
					break;
				case R.id.upButton:
					currentEntry += "U";
					break;
				case R.id.downButton:
					currentEntry += "D";
					break;
				case R.id.leftButton:
					currentEntry += "L";
					break;
				case R.id.rightButton:
					currentEntry += "R";
					break;	
				case R.id.resetButton:
					currentEntry = "";
					break;
				default:
					break;
			}
			
			if(checkMatch()){
				doSomethingCrazy();
			}
		}
	}
	
	private void doSomethingCrazy(){
		AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
		builder.setMessage("OMG YOU CRAZY");
		builder.show();
		
	}

}
