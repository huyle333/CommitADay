package com.example.frappecopter;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

public class Instructions extends Activity {
	
	// Set difficulty based on speed, default to easy for the weak
	int speed;
	
	// Debouncer for touch listener
	boolean has_fired = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_instructions);

		speed = getIntent().getIntExtra("speed", 1);
		
		View rl = findViewById(R.id.relativelayout);
		rl.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent motionEvent) {
				if (has_fired == false) {
					start_game(view);
					has_fired = true;
				}
				return true;
			}
		});
	}
	
	// Reset debouncer every time we return to instructions screen
	@Override
	protected void onResume() {
		super.onResume();
		has_fired = false;
	}
	
	
	// Transition to the next screen
		public void start_game(View v) {
			// Make new intent object to pass speed to game screen
			Intent game = new Intent(this, Gameplay.class);
			
			// Pass speed along to game screen
			game.putExtra("speed", speed);
			
			// Start Gameplay
			startActivity(game);
		}
		
}
