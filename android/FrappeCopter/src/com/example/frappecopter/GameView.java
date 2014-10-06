package com.example.frappecopter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

//class for sounds effects
//MediaPlayer mySong;
/*
class music {
	mySong = MediaPlayer.create
}*/

/*class MP3 {
    private String filename;
    private Player player; 

    // constructor that takes the name of an MP3 file
    public MP3(String filename) {
        this.filename = filename;
    }

    public void close() { if (player != null) player.close(); }

    // play the MP3 file to the sound card
    public void play() {
        try {
            FileInputStream fis     = new FileInputStream(filename);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
        }
        catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }

        // run in new thread to play in background
        new Thread() {
            public void run() {
                try { player.play(); }
                catch (Exception e) { System.out.println(e); }
            }
        }.start();
    }

}
*/
/*
class Music extends Activity{
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.)
	}
	
}
*/

// Canvas for drawing game objects
public class GameView extends View implements Runnable {	

	// Variables... TBD
	private Paint paint;
	//Array containing possible pictures of vegetables
	ArrayList<Bitmap> choice;
	// Current score of player
	double score;
	// Time game has gone on for
	double time;
	// Speed of game
	int speed;
	// width and height of the canvas for drawing purposes
	int width;
	int height;
	// sizes for frappe image
	int frappe_width;
	int frappe_height;
	// sizes for vegetable images
	int veggie_width;
	int veggie_height;
	// Declare objects
	Vegetable veggie_1;
	Vegetable veggie_2;
	Frappe frappe;
	
	// Construct a GameView object
	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// Initialize variables
		score = 0.0;
		time = 0.0;
		// Get vegetable images
		choice = new ArrayList<Bitmap>();
		
	}

	// Functions
	@Override
	public void run() {
		// main method of the program
		while (frappe.is_alive()) {
			// Run this until the player fails
			
			
			
			
			// Move vegetables to the left
			veggie_1.decrement_x(speed);
			veggie_2.decrement_x(speed);
			// Test if vegetable is off the screen - if so, move all the way to the right, change image, set random y-coord
			if (veggie_1.getx_coord() <= 0) {
				veggie_1.setx_coord(width - veggie_width);
				veggie_1.change_veggie(choice);
				veggie_1.set_random_height();
			}
			if (veggie_2.getx_coord() <= 0) {
				veggie_2.setx_coord(width - veggie_width);
				veggie_2.change_veggie(choice);
				veggie_2.set_random_height();
			}
			// Increment time
			time += 0.05;
			// set score
			score = time * 100;
			// Check to see if collisions have occurred, or player should be dead
			// Check if 
			// Redraw all objects
		}
		
		// Player has died - transition to next screen
		
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// Testing
		veggie_1.draw_self(canvas);
	}
	
	// Get coordinates of canvas
	@Override
	protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld)
	{
		super.onSizeChanged(xNew, yNew, xOld, yOld);
		
		// Set global width and height
		width = xNew;
	    height = yNew;
	    // Set global vegetable size parameters
	    veggie_width = (width / 10);
	    veggie_height = (height / 3);
	    // Set global frappe size parameters
	    frappe_width = (width / 4);
	    frappe_height = (height / 5);
	    // Set up ArrayList of veggie images
	    setup_choice(choice);
	    
	    // Create our vegetable objects
	    veggie_1 = new Vegetable(choice, veggie_width, veggie_height);
	    veggie_2 = new Vegetable(choice, veggie_width, veggie_height);
	    // Construct one frappe object
	    Bitmap frappe_image = BitmapFactory.decodeResource(getResources(), R.drawable.oreo_frappe);
	 	frappe = new Frappe(getResizedBitmap(frappe_image, frappe_height, frappe_width), frappe_width, frappe_height);
	}
	
	// Resize bitmap to fit screen - courtesy of stackoverflow
	public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth)
	{
		int width = bm.getWidth();
		int height = bm.getHeight();
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		// create a matrix for the manipulation
		Matrix matrix = new Matrix();
		// resize the bit map
		matrix.postScale(scaleWidth, scaleHeight);
		// recreate the new Bitmap
		Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
		return resizedBitmap;
	}
	
	// Set up the ArrayList choice with correct sizes of images
	public void setup_choice(ArrayList<Bitmap> choice) {
		// Get images
		Bitmap broccoli = BitmapFactory.decodeResource(getResources(), R.drawable.broccoli);
		Bitmap celery = BitmapFactory.decodeResource(getResources(), R.drawable.celery);
		Bitmap carrot = BitmapFactory.decodeResource(getResources(), R.drawable.carrot);
		Bitmap mushroom = BitmapFactory.decodeResource(getResources(), R.drawable.mushroom);
		Bitmap radish = BitmapFactory.decodeResource(getResources(), R.drawable.radish);
		
		// Put resized images into ArrayList
		choice.add(getResizedBitmap(broccoli, veggie_height, veggie_width));
		choice.add(getResizedBitmap(celery, veggie_height, veggie_width));
		choice.add(getResizedBitmap(carrot, veggie_height, veggie_width));
		choice.add(getResizedBitmap(mushroom, veggie_height, veggie_width));
		choice.add(getResizedBitmap(radish, veggie_height, veggie_width));
	}
	
	// Set speed of game
	public void set_speed(int input_speed) {
		speed = input_speed;
		return;
	}
	
}


/******** LOGIC FOR GAME ***************

test if player is still alive
move all vegetable objects to the left
	test if vegetable is off screen, if so move all the way to the right and change bitmap
increment time
increment and display score
redraw all objects

if player has died, stop and move to the next screen
**************************/
