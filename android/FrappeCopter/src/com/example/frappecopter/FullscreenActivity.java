package com.example.frappecopter;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.frappecopter.util.SystemUiHider;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class FullscreenActivity extends Activity {

	// Global variable to control speed of game
	int speed = 1; // Initialize to easy for the weak

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fullscreen);
		
		MediaPlayer mpSplash = MediaPlayer.create(this, R.raw.lorde);
		mpSplash.start();

		
	}
	
	// Set speed based on difficulty
	public void set_speed(View v) {
		RadioButton button = (RadioButton)v;
		// Check to see if radiobutton is checked
		if(button.isChecked()) {
			// Set speed based on id of checked radiobutton
			switch(button.getId()) {
				case R.id.radioButton1:
					// Easy
					speed = 1;
					break;
				case R.id.radioButton2:
					// Medium
					speed = 2;
					break;
				case R.id.radioButton3:
					// Hard
					speed = 3;
					break;
			}
		}
		return;
	}
	
	// Transition to the next screen
	public void show_instructions(View v) {
		// Make new intent object to pass speed to instructions screen
		Intent instructions = new Intent(this, Instructions.class);
		
		// Pass speed along to instructions screen
		instructions.putExtra("speed", speed);
		
		// Start Instructions
		startActivity(instructions);
	}
}
