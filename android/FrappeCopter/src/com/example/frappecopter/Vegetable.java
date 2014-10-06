package com.example.frappecopter;

import java.util.ArrayList;
import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;

// These are the "enemies" that the frappe must avoid

public class Vegetable {

	// Variables controlling location and size of vegetable
	private int x_coord;
	private int y_coord;
	private int width;
	private int height;
	private Bitmap image;
	private Paint paint;
	
	// Construct a Vegetable object
	public Vegetable(ArrayList<Bitmap> choice, int set_width, int set_height) {
		// Initialize variables
		width = set_width;
		height = set_height;
		paint = new Paint();
		
		set_random_height();
		x_coord = set_width*9;
		// Set initial veggie image
		change_veggie(choice);
	}
	
	// Functions for getting/setting/incrementing private variables
	public int getx_coord() {
		// returns x position of the vegetable
		return x_coord;
	}
	public int gety_coord() {
		// returns y position of the vegetable
		return y_coord;
	}
	public void setx_coord(int input_x) {
		// sets x_coord to the input number
		x_coord = input_x;
		return;
	}
	public void sety_coord(int input_y) {
		// sets y_coord to the input number
		y_coord = input_y;
		return;
	}
	public void decrement_x(int add_x) {
		// subtracts input number to x_coord - move object to the left
		x_coord -= add_x;
		return;
	}
	
	// Function for changing vegetable image
	public void change_veggie(ArrayList<Bitmap> choice) {
		// Picks random image from array and assigns it to vegetable
		Random randomgenerator = new Random();
		int index = randomgenerator.nextInt(choice.size());
		image = choice.get(index);
		
		return;
	}
	
	// Draws vegetable on the canvas
	public void draw_self(Canvas canvas) {
		canvas.drawBitmap(image, x_coord, y_coord, paint);
	}
	
	// Set random height for veggie
	public void set_random_height() {
		// Set random height
		Random random = new Random();
		int randomheight = random.nextInt(height*2);
		y_coord = randomheight;
	}
	
}
