package com.example.frappecopter;

import android.graphics.Bitmap;

// This is the player-controlled Frappe

public class Frappe {

	// Variables controlling location of frappe
	private int x_coord; // this should be a constant!
	private int y_coord;
	private int height;
	private int width;
	
	// Frappe image
	private Bitmap image;
	
	// Frappe is still alive!
	private boolean alive;
	
	// Construct a frappe object
	Frappe(Bitmap set_image, int set_width, int set_height) {
		// Initialize variables
		image = set_image;
		height = set_height;
		width = set_width;
		x_coord = 0;
		y_coord = height;
		alive = true;
	}
	
	// Functions for getting/setting/incrementing private variables
	public int getx_coord() {
		// returns x position of the frappe
		return x_coord;
	}
	public int gety_coord() {
		// returns y position of the frappe
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
	public void increment_y(int add_y) {
		// adds input number to y_coord
		y_coord += add_y;
		return;
	} 
	
	// Function for killing frappe
	public void kill_frappe() {
		alive = false;
		return;
	}
	
	// See if frappe is alive
	public boolean is_alive() {
		return alive;
	}
}
