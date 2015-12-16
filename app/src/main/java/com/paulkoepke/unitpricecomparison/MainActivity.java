/*	Copyright © 2014 Paul Koepke paul.koepke@gmail.com
Version 0.1.0:
	First working version. Required setting constants in Item 2 and 3 price and units field, which made entry unwieldy. Any blank fields caused errors which stopped all calculation (onClick function couldn't finish).
Version 0.1.1:
	To make blank entries acceptable, included if statements that check whether there are blanks and skip functions that would fail on a blank value. 
Version 0.2.0:
	Changed layout to LinearLayout to make columns equally weighted so they would share a small screen well. Removed Calculate button and replaced onClickListener with textWatcher.
Version 0.2.1:
	Added function isNumeric check whether text entered in Price and Units fields is numeric and prevent calculation if it is not numeric. This fixes a bug where the app crashes if the first thing you enter is a decimal point. Also should prevent crashes if a use with a physical keyboard enters invalid (non-numeric) characters.
	Added a line to the isEmpty and isNumeric check that clears the previous result if the user deletes their numbers from the Price or Units field. This is a minor fix, but it prevents stale vales from sitting around in the result field.
	Also changed minimum API level to 1, as this app is so basic that it should work pretty much anywhere. Considered changing minimum API to  9 (2.3) as level 8 (2.2)'s numeric keypad stinks and makes it difficult to enter a decimal, but this seemed like an overreaction.
Version 0.2.2: Changed all float type variables to doubles. Not strictly necessary but the David Eck textbook says to prefer to doubles for real numbers over floats.
Version 0.2.3:
	Added DecimalDigitsInputFilter, which implements InputFilter to ensure that only 2 decimals are entered for a price (units can have any amount of decimals).
	Added DecimalFormat for rounding price/unit to 5 decimal places. Would be nice to make the number of decimal places configurable in the future.
Version 0.2.4:
	Forgot to add DecimalFormat to all output, so version 0.2.3 is pretty broken / inconsistent.  
	Changed widths of rows and columns in /layout/activity_main.xml and /layout-land/activity_main.xml to match_parent instead of wrap_content. This locks the widths of the columns and prevents resizing of columns that have lots of characters in them when the device is rotated and the screen is redrawn.
Version 0.2.5:
	Added a Clear All button below the numbers. Sometime in the past I changed the minimum API to 9 because the DecimalFormat in DecimalDigitsInputFilter requires at least API level 9. That's Android 2.3, I'm comfortable not supporting anything prior to 2.3.
Version 0.3.0:
	Tried added a banner ad to the bottom of the screen. This required importing the google-play-services_lib into Eclipse and adding it to my project. Found it to be too challenging to do right now, took the library out. Will add later.
Version 1.0.0:
	Finally decided to publish to the app store! No changes from previous version, just called it 1.0.0 to reflect the fact that it's ready for release.
Version 1.0.1:
	Just before I published it to Google Play, I noticed that if the app was started in landscape it gave focus to Item 4 instead of Item 1. Fixed that, will publish this version.
Version 1.0.2:
	No changes. Couldn't download from Google Play, and I wondered if it was due to my funky .apk name. So I will export it again with a normal .apk name (no spaces) and see if that will download.
Version 1.0.3:
	For some unknown reason the Clear All button only affected numerical fields. Fixed it so it clears label fields as well.
Version 1.0.4:
	Added a ScrollView around the entire app in portait.
Version 1.0.5:
	Added ScrollView around the entire app in landscape. Also prevented full-screen edit mode in landscape so the entire app remains in view while editing.
Version 1.0.6:
	Made Price and Units fields jump to the next numeric editable field when the Next button is pushed using the Next Focus Forward /  android:nextFocusForward XML attribute. 
Version 1.0.7:
	Deleted unused xml files from /res/layout/. No other changes, not really meant for publication / production.
Version 1.0.8:
	Playing with applying styles to EditTexts - added a 1dp black border to all numeric fields. Will try it out on my devices for awhile, but I'm not sure it's Useful. Added shape_grey_rectangle.xml and shape_black_rectangle.xml to /res/drawable/xhdpi/.
Version 1.0.9:
	While playing with styles and drawables, I introduced a bad app icon - one with a red X through it. This was cached in a subfolder of /bin/ and got uploaded with 1.0.8. I cleaned the project to get rid of it and repackaged as 1.0.9.
Version 1.1.0:
	Adding a blue background with a gradient to the app. Created a shape XML in drawable-xhdpi with a gradient: shape_background_blue_rectangle_with_gradient.xml.
	Also added Focus directives to the Name fields so the Next button will take the user through all the name fields. Not all that useful but good for consistency. 
Version 1.1.1:
	The boxes added in version 1.0.8 worked on newer devices but broke on older devices. Decided to remove the styling but keep the drawable xml file for future use / reference. 
	The blue gradient background and white text added in Version 1.1.0 looked nice, but maybe not nice enough for production / to warrant such a big change. Decided to remove the styling but keep the drawable xml file for future use / reference.
	Made currency symbol respect system locale with ¤ symbol in DecimalFormat per http://tutorials.jenkov.com/java-internationalization/decimalformat.html.
	Attempting to localize to a large number of languages: Arabic, German, English-UK, Spanish, French, Hebrew, Italian, Japanese, Korean, Russian, and Chinese (Tradtional). Used Google Translate to automatically do it so the translations are probably really bad.
Version 1.1.2:
	Fixed Price string in Spanish strings.xml file.
Version 1.1.3:
	Made this much more object-oriented: instead of running every calculation every time and catching empty fields, we now have clases and objects to represent the items and calculate the results for just 1 item at a time. 
	-Created a new class, TextWatcherReturnsEditText, which implements TextWatcher and causes it to return the EditText which changed. This allows me to do the calculation on only the changed item, and also to compare which item is less expensive. Details here: http://stackoverflow.com/a/4283532/3784441 
	-Created a new class, ComparisonItem, to allow me to create an object for each item to store the item's details and implement the formula for each item's price per unit. 
	-For now, I will manually create the 6 objects and reference them directly. In the future I might consider creating an array of objects depending on how many items the user wants to compare. I could add "Add item" and "Remove item" buttons.
	In Manifest.xml, made max version Android 5.0 (API level 21) since that's the most recent version. Also made minimum Android version 4.0 (API version 14) so I'm not constrained by < 4.0 devices. None of my users/downloads were on less than 4.0 anyway.
	Cleaned up some comments.
	There's still a lot of cruft in this version - unused commented-out code, things that could be cleaned up after the OOP transition. I'm exporting this just to put it in Alpha testing and get it on my phone.
Version 1.1.4:
	Gave the UI a Material Design-inspired overhaul. Couldn't use the new Material theme since it requires Android 5.0. Many changes to styles.
	-Still need to add hiding bottom row and highlighting best price
	Removed translations out of English. All translations were just using Google Translate so they were probably really bad. Kept the ability to change the currency symbol to match the system's locale setting.
Version 1.1.5:
	The app now highlights the lowest price per unit.
Version 1.1.6:
	Prevented input fields from going to full-screen mode when in landscape.
	Added some padding around the cards to improve appearance.
Version 1.1.7:
	Calculations now respect quantity field.
	Hid second row of each item, added a button on the action bar to show the second row.
	-button icon doesn't change when the row is shown. Wanted to export and upload immediately so will work on changing it and animating the change later.
	-row 2 appearance isn't animated, will work on that later as well.
Version 1.1.8:
	Added animation to the cards when they expand and collapse
	Added a Clear All button to the action bar - it doesn't work yet.
Version 1.1.9:
	Clear all button on Action Bar works. Clear all button at bottom set to Gone, will remove in a later release.
Version 1.2.0:
	Renamed "UnitPriceComparison1.java" to "UnitPriceComparison1.java". Testing to make sure it still works.
	Made Clear All button clear quantity fields.
Version 2.0.0:
	Final build for production. Has all changes from version 1.1.3 up to now:
	-Material Design redesign: each item gets a Material Design-inspired card.
	-Expand button added to top: expands the cards so you can enter quantity, item name, and units name.
	-Clear All button added to top: clears all fields so you can start over.
Version 2.0.1:
	Added LayoutParams code to adjustCardWidth() in itemForComparison to shrink the cards if the screen is too big.
	-Would have liked to do this in the layout XML, but match_parent overrides every way of doing max width.
Version 2.0.2:
	Migrated to Android Studio, publishing mostly to make sure
	Updated target API version to 23, i.e. Android 6.0.
*/

package com.paulkoepke.unitpricecomparison;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;
// import java.util.HashMap;
// import com.google.android.gms.analytics.GoogleAnalytics;
// import com.google.android.gms.analytics.Tracker;
import com.paulkoepke.unitpricecomparison.R;
import android.app.Activity;
// import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Gravity;
//import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
// import android.view.animation.Animation;
// import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
// import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

	// Create EditText, TextView, and Button pointer to represent each text field & button object. Has to be done here for scoping reasons - they must be available to all functions in this class. Tried assigning each object to its pointer here but they don't exist until onCreate runs (I think).
	EditText item1Price;
	EditText item1Units;
	EditText item1Qty;
	EditText item1Name;
	EditText item1UnitsName;
	EditText item2Price;
	EditText item2Units;
	EditText item2Qty;
	EditText item2Name;
	EditText item2UnitsName;
	EditText item3Price;
	EditText item3Units;
	EditText item3Qty;
	EditText item3Name;
	EditText item3UnitsName;
	EditText item4Price;
	EditText item4Units;
	EditText item4Qty;
	EditText item4Name;
	EditText item4UnitsName;
	EditText item5Price;
	EditText item5Units;
	EditText item5Qty;
	EditText item5Name;
	EditText item5UnitsName;
	EditText item6Price;
	EditText item6Units;
	EditText item6Qty;
	EditText item6Name;
	EditText item6UnitsName;

	TextView item1PricePerUnit;
	TextView item2PricePerUnit;
	TextView item3PricePerUnit;
	TextView item4PricePerUnit;
	TextView item5PricePerUnit;
	TextView item6PricePerUnit;
	TextView debugTextView;
	
	itemForComparison[] itemObjectArray = new itemForComparison[6];

	Button clearAllButton;
	
	DecimalFormat pricePerUnitDecimalFormat;

	// onCreate is a standard Android function that creates the application UI and sets up needed resources (e.g., pointers to EditTexts and TextViews) when the app is launched. 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_cards);

		// Assign the variables created above to the fields/editTexts/textViews in my layout. Tried to declare the variables here but that caused scoping problems. Tried to assign each object to its pointer at the start of class MainActivity but the TextView, EditText, and Button objects don't exist until onCreate runs (I think). 
		item1Price = (EditText) findViewById(R.id.item1Price);
		item1Price.requestFocus();
		item1Units = (EditText) findViewById(R.id.item1Units);
		item1Qty = (EditText) findViewById(R.id.item1Qty);
		item1Name = (EditText) findViewById(R.id.item1Name);
		item1UnitsName = (EditText) findViewById(R.id.item1UnitsName);
		item2Price = (EditText) findViewById(R.id.item2Price);
		item2Units = (EditText) findViewById(R.id.item2Units);
		item2Qty = (EditText) findViewById(R.id.item2Qty);
		item2Name = (EditText) findViewById(R.id.item2Name);
		item2UnitsName = (EditText) findViewById(R.id.item2UnitsName);
		item3Price = (EditText) findViewById(R.id.item3Price);
		item3Units = (EditText) findViewById(R.id.item3Units);
		item3Qty = (EditText) findViewById(R.id.item3Qty);
		item3Name = (EditText) findViewById(R.id.item3Name);
		item3UnitsName = (EditText) findViewById(R.id.item3UnitsName);
		item4Price = (EditText) findViewById(R.id.item4Price);
		item4Units = (EditText) findViewById(R.id.item4Units);
		item4Qty = (EditText) findViewById(R.id.item4Qty);
		item4Name = (EditText) findViewById(R.id.item4Name);
		item4UnitsName = (EditText) findViewById(R.id.item4UnitsName);
		item5Price = (EditText) findViewById(R.id.item5Price);
		item5Units = (EditText) findViewById(R.id.item5Units);
		item5Qty = (EditText) findViewById(R.id.item5Qty);
		item5Name = (EditText) findViewById(R.id.item5Name);
		item5UnitsName = (EditText) findViewById(R.id.item5UnitsName);
		item6Price = (EditText) findViewById(R.id.item6Price);
		item6Units = (EditText) findViewById(R.id.item6Units);
		item6Qty = (EditText) findViewById(R.id.item6Qty);
		item6Name = (EditText) findViewById(R.id.item6Name);
		item6UnitsName = (EditText) findViewById(R.id.item6UnitsName);

		item1PricePerUnit = (TextView) findViewById(R.id.item1PricePerUnitResult);
		item2PricePerUnit = (TextView) findViewById(R.id.item2PricePerUnitResult);
		item3PricePerUnit = (TextView) findViewById(R.id.item3PricePerUnitResult);
		item4PricePerUnit = (TextView) findViewById(R.id.item4PricePerUnitResult);
		item5PricePerUnit = (TextView) findViewById(R.id.item5PricePerUnitResult);
		item6PricePerUnit = (TextView) findViewById(R.id.item6PricePerUnitResult);
		
		// Big TextView where I can dump any amount of info and have it all be readable. Comment out the second line to make it visible, uncomment it to hide it completely.
		debugTextView = (TextView) findViewById(R.id.debugTextView);
		debugTextView.setVisibility(View.GONE);
		debugTextView.setText("Nothing yet");

		clearAllButton = (Button) findViewById(R.id.clearAllButton);  
		
		// Add the localized currency symbol to the hints so I don't have to store it in strings.xml for every language.
		
		Locale currentLocale = Locale.getDefault();
		Currency localCurrency = Currency.getInstance(currentLocale);
		
		String Price_per_unit_field_hint_with_currency = localCurrency.getSymbol() + getString( R.string.Price_Per_Units_Hint );
		item1PricePerUnit.setHint( Price_per_unit_field_hint_with_currency );
		item2PricePerUnit.setHint( Price_per_unit_field_hint_with_currency );
		item3PricePerUnit.setHint( Price_per_unit_field_hint_with_currency );
		item4PricePerUnit.setHint( Price_per_unit_field_hint_with_currency );
		item5PricePerUnit.setHint( Price_per_unit_field_hint_with_currency );
		item6PricePerUnit.setHint( Price_per_unit_field_hint_with_currency );
		
		String Price_field_hint_with_currency = getString ( R.string.Price_field_hint ) + " " + localCurrency.getSymbol();
		item1Price.setHint( Price_field_hint_with_currency );
		item2Price.setHint( Price_field_hint_with_currency );
		item3Price.setHint( Price_field_hint_with_currency );
		item4Price.setHint( Price_field_hint_with_currency );
		item5Price.setHint( Price_field_hint_with_currency );
		item6Price.setHint( Price_field_hint_with_currency );
		
		LinearLayout item1Card = (LinearLayout)findViewById(R.id.item1Card);
		LinearLayout item2Card = (LinearLayout)findViewById(R.id.item2Card);
		LinearLayout item3Card = (LinearLayout)findViewById(R.id.item3Card);
		LinearLayout item4Card = (LinearLayout)findViewById(R.id.item4Card);
		LinearLayout item5Card = (LinearLayout)findViewById(R.id.item5Card);
		LinearLayout item6Card = (LinearLayout)findViewById(R.id.item6Card);
		
		// Create objects for each item and an array to hold all the objects
		itemForComparison item1Object;
		item1Object = new itemForComparison(MainActivity.this, item1Price, item1Units, item1PricePerUnit, item1Qty, item1Card);
		itemForComparison item2Object;
		item2Object = new itemForComparison(MainActivity.this, item2Price, item2Units, item2PricePerUnit, item2Qty, item2Card);
		itemForComparison item3Object;
		item3Object = new itemForComparison(MainActivity.this, item3Price, item3Units, item3PricePerUnit, item3Qty, item3Card);
		itemForComparison item4Object;
		item4Object = new itemForComparison(MainActivity.this, item4Price, item4Units, item4PricePerUnit, item4Qty, item4Card);
		itemForComparison item5Object;
		item5Object = new itemForComparison(MainActivity.this, item5Price, item5Units, item5PricePerUnit, item5Qty, item5Card);
		itemForComparison item6Object;
		item6Object = new itemForComparison(MainActivity.this, item6Price, item6Units, item6PricePerUnit, item6Qty, item6Card);
		
		itemObjectArray[0] = item1Object;
		itemObjectArray[1] = item2Object;
		itemObjectArray[2] = item3Object;
		itemObjectArray[3] = item4Object;
		itemObjectArray[4] = item5Object;
		itemObjectArray[5] = item6Object;
		
		// New method: Set a afterTextChanged listener on all of the fields; if any changes it performs the function which does all the calculations. It does every calculation on every change because it was simpler to write that way. This could be made more efficient and more complex by only calculating the unit price of the item that was changed, but this is such a tiny app that there really aren't performance concerns with doing/repeating all of the calculations on every change.
		// Also sets an InputFilter on the price fields so only 2 decimal places can be entered for a price. Units can have any amount of decimals.
		item1Price.addTextChangedListener(new TextWatcherReturnsEditText(item1Price, MainActivity.this, item1Object));
		item1Price.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(2)});
		item1Units.addTextChangedListener(new TextWatcherReturnsEditText(item1Units, MainActivity.this, item1Object));
		item1Qty.addTextChangedListener(new TextWatcherReturnsEditText(item1Qty, MainActivity.this, item1Object));
		item2Price.addTextChangedListener(new TextWatcherReturnsEditText(item1Units, MainActivity.this, item2Object));
		item2Price.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(2)});
		item2Units.addTextChangedListener(new TextWatcherReturnsEditText(item2Units, MainActivity.this, item2Object));
		item2Qty.addTextChangedListener(new TextWatcherReturnsEditText(item2Qty, MainActivity.this, item2Object));
		item3Price.addTextChangedListener(new TextWatcherReturnsEditText(item3Price, MainActivity.this, item3Object));
		item3Price.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(2)});
		item3Units.addTextChangedListener(new TextWatcherReturnsEditText(item3Units, MainActivity.this, item3Object));
		item3Qty.addTextChangedListener(new TextWatcherReturnsEditText(item3Qty, MainActivity.this, item3Object));
		item4Price.addTextChangedListener(new TextWatcherReturnsEditText(item4Price, MainActivity.this, item4Object));
		item4Price.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(2)});
		item4Units.addTextChangedListener(new TextWatcherReturnsEditText(item4Units, MainActivity.this, item4Object));
		item4Qty.addTextChangedListener(new TextWatcherReturnsEditText(item4Qty, MainActivity.this, item4Object));
		item5Price.addTextChangedListener(new TextWatcherReturnsEditText(item5Price, MainActivity.this, item5Object));
		item5Price.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(2)});
		item5Units.addTextChangedListener(new TextWatcherReturnsEditText(item5Units, MainActivity.this, item5Object));
		item5Qty.addTextChangedListener(new TextWatcherReturnsEditText(item5Qty, MainActivity.this, item5Object));
		item6Price.addTextChangedListener(new TextWatcherReturnsEditText(item6Price, MainActivity.this, item6Object));
		item6Price.setFilters(new InputFilter[] {new DecimalDigitsInputFilter(2)});
		item6Units.addTextChangedListener(new TextWatcherReturnsEditText(item6Units, MainActivity.this, item6Object));
		item6Qty.addTextChangedListener(new TextWatcherReturnsEditText(item6Qty, MainActivity.this, item6Object));

		// Set a listener on the Clear All button.
		clearAllButton.setOnClickListener((View.OnClickListener) this);
		
		// Create a DecimalFormat to round the results. Apparently this is recommended instead of Math.round. By default DecimalFormats use "banker's rounding" (ROUND_HALF_EVEN), which rounds .5 to the closest even. So we set the rounding mode for the DecimalFormat to HALF_UP which is normal rounding (rounds < .5 down and >= 0.5 up).
		// ¤ instead of $ allows the DecomalFormat object to use the currency symbol for the system's current locale.
		pricePerUnitDecimalFormat = new DecimalFormat("¤###,###,###,###,##0.#####");
		pricePerUnitDecimalFormat.setRoundingMode(RoundingMode.HALF_UP);
		
		// Hide second row of every card
		expandHideRow2();
		
		// If the screen is too large, limit the width of the cards
		// http://stackoverflow.com/questions/15055458/detect-7-inch-and-10-inch-tablet-programmatically
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int widthInPixels = metrics.widthPixels;
		// debugTextView.setText(String.valueOf(widthInPixels));
		float widthDpi = metrics.xdpi;
		float widthInInches = widthInPixels / widthDpi;
		// debugTextView.setText(String.valueOf(widthInInches));
		
		// set max width depending on screen size
		if (widthInInches > 6) {
			for (int i = 0; i < 6; i++){
				itemObjectArray[i].adjustCardWidth();	
			}
		}

	} // end onCreate()
	
	// Creates the menu in the action bar with the expand arrow 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_activity_actions, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	// Responds to the expand arrow being pressed 
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    // case-switch statements suck. Changing to if-else
		/* switch (item.getItemId()) {
	        case R.id.Expand_second_row:
	            expandHideRow2();
	            return true;
	        case R.id.Clear_all:
	        	debugTextView.setText("clearAllActionBar was pressed");
	        	clearAll();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    } */
		if (item.getItemId() == R.id.Expand_second_row) {
			expandHideRow2();
            return true;
		} else if (item.getItemId() == R.id.Clear_all) {
			debugTextView.setText("clearAllActionBar was pressed");
        	clearAll();
            return true;
		} else {
			return super.onOptionsItemSelected(item);
		}
	}
	
	// Shows or hides Row 2 of all items
	// Used the method here: http://developer.android.com/training/animation/layout.html
	// Details for more complex animations animations from these 2 sites: http://stackoverflow.com/a/19766034/3784441, http://developer.android.com/guide/topics/graphics/view-animation.html
	void expandHideRow2() {
		// rows
		LinearLayout item1Row2 = (LinearLayout) findViewById(R.id.item1Row2);
		LinearLayout item2Row2 = (LinearLayout) findViewById(R.id.item2Row2);
		LinearLayout item3Row2 = (LinearLayout) findViewById(R.id.item3Row2);
		LinearLayout item4Row2 = (LinearLayout) findViewById(R.id.item4Row2);
		LinearLayout item6Row2 = (LinearLayout) findViewById(R.id.item6Row2);
		LinearLayout item5Row2 = (LinearLayout) findViewById(R.id.item5Row2);
		
		// cards, decided not to use this method as it is more complex
		// LinearLayout item1Card = (LinearLayout) findViewById(R.id.item1Card);
		// LinearLayout item2Card = (LinearLayout) findViewById(R.id.item2Card);
		// LinearLayout item3Card = (LinearLayout) findViewById(R.id.item3Card);
		// LinearLayout item4Card = (LinearLayout) findViewById(R.id.item4Card);
		// LinearLayout item6Card = (LinearLayout) findViewById(R.id.item6Card);
		// LinearLayout item5Card = (LinearLayout) findViewById(R.id.item5Card);
		
		// Animation slideCardDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
		// Animation slideCardUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
		if (item1Row2.getVisibility() == View.VISIBLE){
			// item1Card.startAnimation(slideCardUp);
			item1Row2.setVisibility(LinearLayout.GONE);
			item2Row2.setVisibility(LinearLayout.GONE);
			item3Row2.setVisibility(LinearLayout.GONE);
			item4Row2.setVisibility(LinearLayout.GONE);
			item5Row2.setVisibility(LinearLayout.GONE);
			item6Row2.setVisibility(LinearLayout.GONE);
		} else {
			// item1Card.startAnimation(slideCardDown);
			item1Row2.setVisibility(LinearLayout.VISIBLE);
			item2Row2.setVisibility(LinearLayout.VISIBLE);
			item3Row2.setVisibility(LinearLayout.VISIBLE);
			item4Row2.setVisibility(LinearLayout.VISIBLE);
			item5Row2.setVisibility(LinearLayout.VISIBLE);
			item6Row2.setVisibility(LinearLayout.VISIBLE);
		}
	}
	
	// Sets text in debug TextView
	public void setDebugTextViewText(String newText) {
		debugTextView.setText(newText);
	}

	// New code: uses afterTextChanged to do the calculations instead of onClickListener
	/* @Override
	public void afterTextChanged(Editable v) {
		// Entire function runs when any value changes. Could be made more efficient with if statements or a switch statement that only does the calculation for the particular item that was changed. 

		// Adding a toast to play around with discovering which editable field was changed.
		// if ( v == (EditText) findViewById(R.id.item1Price) ) {
		//	Toast.makeText(getApplicationContext(), "You changed item 1's price.", Toast.LENGTH_LONG).show();
		//}
		
		//if ( true ) {
		//	Toast.makeText(getApplicationContext(), v, Toast.LENGTH_LONG).show();
		//}
		
		// Create double variables. The program takes the entered text and converts it to numbers, put those numbers in these variables, then use these to do the calculations.
		double item1PriceNum = 0;
		double item1UnitsNum = 0;
		double item1PricePerUnitDouble = 0;
		double item2PriceNum = 0;
		double item2UnitsNum = 0;
		double item2PricePerUnitDouble = 0;
		double item3PriceNum = 0;
		double item3UnitsNum = 0;
		double item3PricePerUnitDouble = 0;
		double item4PriceNum = 0;
		double item4UnitsNum = 0;
		double item4PricePerUnitDouble = 0;
		double item5PriceNum = 0;
		double item5UnitsNum = 0;
		double item5PricePerUnitDouble = 0;
		double item6PriceNum = 0;
		double item6UnitsNum = 0;
		double item6PricePerUnitDouble = 0;

		// Create a DecimalFormat to round the results. Apparently this is recommended instead of Math.round. By default DecimalFormats use "banker's rounding" (ROUND_HALF_EVEN), which rounds .5 to the closest even. So we set the rounding mode for the DecimalFormat to HALF_UP which is normal rounding (rounds < .5 down and >= 0.5 up).
		// ¤ instead of $ allows the DecomalFormat object to use the currency symbol for the system's current locale.
		DecimalFormat pricePerUnitDecimalFormat = new DecimalFormat("¤###,###,###,###,##0.#####");
		pricePerUnitDecimalFormat.setRoundingMode(RoundingMode.HALF_UP);
		
		// Give a default value of -1 to Price or Units when an item is blank or non-numeric so we can skip that calculation later. Also clears the price/units result in case there was already a result. Non-numeric check is important as Android will allow you to enter a decimal point without entering any numbers, but that causes the app to crash as it can't do calculations on just the decimal which results in a crash.
		if (TextUtils.isEmpty(item1Price.getText().toString()) || !(isNumeric(item1Price.getText().toString()))) {
			item1PriceNum = -1;
			item1PricePerUnit.setText("");
		} else {
			item1PriceNum = Float.parseFloat(item1Price.getText().toString());

		}

		if (TextUtils.isEmpty(item1Units.getText().toString()) || !(isNumeric(item1Units.getText().toString()))) {
			item1UnitsNum = -1;
			item1PricePerUnit.setText("");
		} else {
			item1UnitsNum = Float.parseFloat(item1Units.getText().toString());
		}

		if (TextUtils.isEmpty(item2Price.getText().toString()) || !(isNumeric(item2Price.getText().toString()))) {
			item2PriceNum = -1;
			item2PricePerUnit.setText("");
		} else {
			item2PriceNum = Float.parseFloat(item2Price.getText().toString());
		}

		if (TextUtils.isEmpty(item2Units.getText().toString()) || !(isNumeric(item2Units.getText().toString()))) {
			item2UnitsNum = -1;
			item2PricePerUnit.setText("");
		} else {
			item2UnitsNum = Float.parseFloat(item2Units.getText().toString());
		}

		if (TextUtils.isEmpty(item3Price.getText().toString()) || !(isNumeric(item3Price.getText().toString()))) {
			item3PriceNum = -1;
			item3PricePerUnit.setText("");
		} else {
			item3PriceNum = Float.parseFloat(item3Price.getText().toString());
		}

		if (TextUtils.isEmpty(item3Units.getText().toString()) || !(isNumeric(item3Units.getText().toString()))) {
			item3UnitsNum = -1;
			item3PricePerUnit.setText("");
		} else {
			item3UnitsNum = Float.parseFloat(item3Units.getText().toString());
		}

		if (TextUtils.isEmpty(item4Price.getText().toString()) || !(isNumeric(item4Price.getText().toString()))) {
			item4PriceNum = -1;
			item4PricePerUnit.setText("");
		} else {
			item4PriceNum = Float.parseFloat(item4Price.getText().toString());
		}

		if (TextUtils.isEmpty(item4Units.getText().toString()) || !(isNumeric(item4Units.getText().toString()))) {
			item4UnitsNum = -1;
			item4PricePerUnit.setText("");
		} else {
			item4UnitsNum = Float.parseFloat(item4Units.getText().toString());
		}

		if (TextUtils.isEmpty(item5Price.getText().toString()) || !(isNumeric(item5Price.getText().toString()))) {
			item5PriceNum = -1;
			item5PricePerUnit.setText("");
		} else {
			item5PriceNum = Float.parseFloat(item5Price.getText().toString());
		}

		if (TextUtils.isEmpty(item5Units.getText().toString()) || !(isNumeric(item5Units.getText().toString()))) {
			item5UnitsNum = -1;
			item5PricePerUnit.setText("");
		} else {
			item5UnitsNum = Float.parseFloat(item5Units.getText().toString());
		}

		if (TextUtils.isEmpty(item6Price.getText().toString()) || !(isNumeric(item6Price.getText().toString()))) {
			item6PriceNum = -1;
			item6PricePerUnit.setText("");
		} else {
			item6PriceNum = Float.parseFloat(item6Price.getText().toString());
		}

		if (TextUtils.isEmpty(item6Units.getText().toString()) || !(isNumeric(item6Units.getText().toString()))) {
			item6UnitsNum = -1;
			item6PricePerUnit.setText("");
		} else {
			item6UnitsNum = Float.parseFloat(item6Units.getText().toString());
		}

		// Calculate the price per unit and use this to create the output using setText to set the value of the Price/Units TextViews.
		// String.valueOf() converts the float variables to text since setText can only accept textual values, not floats.
		// If statements required to avoid printing odd values.
		// Added rounding to 7 decimal places, as infinite decimals just look weird
		if (item1PriceNum == -1 || item1UnitsNum == -1) {
		} else {
			item1PricePerUnitDouble = item1PriceNum / item1UnitsNum;
			item1PricePerUnit.setText(pricePerUnitDecimalFormat.format(item1PricePerUnitDouble));
		}

		if (item2PriceNum == -1 || item2UnitsNum == -1) {
		} else {
			item2PricePerUnitDouble = item2PriceNum / item2UnitsNum;
			item2PricePerUnit.setText(pricePerUnitDecimalFormat.format(item2PricePerUnitDouble));
		}

		if (item3PriceNum == -1 || item3UnitsNum == -1) {
		} else {
			item3PricePerUnitDouble = item3PriceNum / item3UnitsNum;
			item3PricePerUnit.setText(pricePerUnitDecimalFormat.format(item3PricePerUnitDouble));
		}

		if (item4PriceNum == -1 || item4UnitsNum == -1) {
		} else {
			item4PricePerUnitDouble = item4PriceNum / item4UnitsNum;
			item4PricePerUnit.setText(pricePerUnitDecimalFormat.format(item4PricePerUnitDouble));
		}

		if (item5PriceNum == -1 || item5UnitsNum == -1) {
		} else {
			item5PricePerUnitDouble = item5PriceNum / item5UnitsNum;
			item5PricePerUnit.setText(pricePerUnitDecimalFormat.format(item5PricePerUnitDouble));
		}

		if (item6PriceNum == -1 || item6UnitsNum == -1) {
		} else {
			item6PricePerUnitDouble = item6PriceNum / item6UnitsNum;
			item6PricePerUnit.setText(pricePerUnitDecimalFormat.format(item6PricePerUnitDouble));
		}

	} // end afterTextChanged

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,int after) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) 
	{
		// TODO Auto-generated method stub

	} */ // End old overrides for TextWatcher interface.

	// isNumeric checks whether an input is numeric; it's used to prevent an error. We can generally assume that input has no letters because the inputType is numeric.
	public static boolean isNumeric(String str)  
	{  
		try  
		{  
			@SuppressWarnings("unused")
			double d = Double.parseDouble(str);  
		}  
		catch(NumberFormatException nfe)  
		{  
			return false;  
		}  
		return true;  
	}

	// Input filter that limits the number of decimal digits that can be entered.
	// Found here: http://stackoverflow.com/posts/6264829/revisions

	public class DecimalDigitsInputFilter implements InputFilter {

		private final int decimalDigits;

		/*
		 * Constructor.
		 * @param decimalDigits maximum decimal digits
		 */
		public DecimalDigitsInputFilter(int decimalDigits) {
			this.decimalDigits = decimalDigits;
		}

		@Override
		public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

			int dotPos = -1;
			int len = dest.length();
			for (int i = 0; i < len; i++) {
				char c = dest.charAt(i);
				if (c == '.' || c == ',') {
					dotPos = i;
					break;
				}
			}
			if (dotPos >= 0) {

				// protects against many dots
				if (source.equals(".") || source.equals(","))
				{
					return "";
				}
				// if the text is entered before the dot
				if (dend <= dotPos) {
					return null;
				}
				if (len - dotPos > decimalDigits) {
					return "";
				}
			}

			return null;
		}

	} // end of class DecimalDigitsInputFilter

	// Method to clear all fields when the Clear All button is pushed.
	
	public void clearAll() {
		item1Price.setText("");
		item1Units.setText("");
		item1Qty.setText("");
		item2Price.setText("");
		item2Units.setText("");
		item2Qty.setText("");
		item3Price.setText("");
		item3Units.setText("");
		item3Qty.setText("");
		item4Price.setText("");
		item4Units.setText("");
		item4Qty.setText("");
		item5Price.setText("");
		item5Units.setText("");
		item5Qty.setText("");
		item6Price.setText("");
		item6Units.setText("");
		item6Qty.setText("");
		item1Name.setText("");
		item1UnitsName.setText("");
		item2Name.setText("");
		item2UnitsName.setText("");
		item3Name.setText("");
		item3UnitsName.setText("");
		item4Name.setText("");
		item4UnitsName.setText("");
		item5Name.setText("");
		item5UnitsName.setText("");
		item6Name.setText("");
		item6UnitsName.setText("");
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		// Clear all input fields. This will also clear all results, as it will trigger another calculation.

		clearAll();
		
		
	}
	
	public void highlightLowestPrice() {
		
		double lowestPrice = -1;
		int lowestPriceItem = -1;
		
		for (int i = 0; i < 6; i++) {
			itemObjectArray[i].unHighlightPricePerUnit();
			if (itemObjectArray[i].returnUnitPrice() == -1) {
				// do nothing, this item doesn't have a unit price yet
			} else if ( (itemObjectArray[i].returnUnitPrice() != -1) && (lowestPrice == -1) ) {
				lowestPrice = itemObjectArray[i].returnUnitPrice();
				lowestPriceItem = i;
			} else if ( itemObjectArray[i].returnUnitPrice() < lowestPrice) {
				lowestPrice = itemObjectArray[i].returnUnitPrice();
				lowestPriceItem = i;
			}
		}
		
		if (lowestPriceItem != -1) {
			itemObjectArray[lowestPriceItem].highlightPricePerUnit();
		}
		
	}

	/* 
	public enum TrackerName {
		APP_TRACKER, // Tracker used only in this app.
		GLOBAL_TRACKER, // Tracker used by all the apps from a company. eg: roll-up tracking.
		ECOMMERCE_TRACKER, // Tracker used by all ecommerce transactions from a company.
	}

	HashMap<TrackerName, Tracker> mTrackers = new HashMap<TrackerName, Tracker>();

	synchronized Tracker getTracker(TrackerName trackerId) {
		if (!mTrackers.containsKey(trackerId)) {

			GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
			Tracker t = (trackerId == TrackerName.APP_TRACKER) ? analytics.newTracker(PROPERTY_ID)
					: (trackerId == TrackerName.GLOBAL_TRACKER) ? analytics.newTracker(R.xml.app_tracker)
							: analytics.newTracker(R.xml.ecommerce_tracker);
					mTrackers.put(trackerId, t);

		}
		return mTrackers.get(trackerId);
	} /*

	/*
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	 */

} // end of class MainActivity, end of program

// Class to override TextWatcher's default behavior and return which EditText triggered the change. From http://stackoverflow.com/a/4283532/3784441
// Code to pass the MainActivity found here: http://stackoverflow.com/a/7836925/37844
// Code to properly pass MainActivity in parameters found here: http://stackoverflow.com/questions/22031441/passing-mainactivity-in-params
class TextWatcherReturnsEditText implements TextWatcher {
    private EditText changedEditText;
    private MainActivity myMainActivity;
    private itemForComparison currentItemObject;

    public TextWatcherReturnsEditText(EditText e, MainActivity activity, itemForComparison i) { 
        changedEditText = e;
        myMainActivity = activity;
        currentItemObject = i;
        
		// Create a DecimalFormat to round the results. Apparently this is recommended instead of Math.round. By default DecimalFormats use "banker's rounding" (ROUND_HALF_EVEN), which rounds .5 to the closest even. So we set the rounding mode for the DecimalFormat to HALF_UP which is normal rounding (rounds < .5 down and >= 0.5 up).
		// ¤ instead of $ allows the DecomalFormat object to use the currency symbol for the system's current locale.
		DecimalFormat pricePerUnitDecimalFormat = new DecimalFormat("¤###,###,###,###,##0.#####");
		pricePerUnitDecimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    }
    
	@Override
	public void afterTextChanged(Editable v) {
		
		currentItemObject.setUnitPriceTextView();
		myMainActivity.highlightLowestPrice();
		
		// code for testing whether afterTextChanged() ran
		myMainActivity.setDebugTextViewText( changedEditText.toString() );

	} // end afterTextChanged

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,int after) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) 
	{
		// TODO Auto-generated method stub

	} // End old overrides for TextWatcher interface.

} // end of class TextWatcherReturnsEditText

class itemForComparison {

	private double itemPrice = 0;
	private double itemUnits = 0;
	private double itemQty = 1;
	private MainActivity myMainActivity;
	private EditText priceEditText, unitsEditText, qtyEditText;
	private TextView unitPriceTextView;
	private LinearLayout itemCardLinearLayout;

	// initializer
	itemForComparison(MainActivity m, EditText p, EditText u, TextView v, EditText q, LinearLayout l) {
		myMainActivity = m;
		priceEditText = p;
		unitsEditText = u;
		unitPriceTextView = v;
		qtyEditText = q;
		itemCardLinearLayout = l;
	}
	
	double returnPrice() {
		// Grabs price from EditText, returns -1 if there's no text or it's invalid. 
		if ( TextUtils.isEmpty(priceEditText.getText().toString()) || !(MainActivity.isNumeric( priceEditText.getText().toString() )) ) {
			return -1;
		} else return Float.parseFloat(priceEditText.getText().toString());
	}
	
	double returnUnits() {
		// Grabs units from EditText, returns -1 if there's no text or it's invalid.
		if (TextUtils.isEmpty(unitsEditText.getText().toString()) || !(MainActivity.isNumeric( unitsEditText.getText().toString()))
		|| Float.parseFloat(unitsEditText.getText().toString()) == 0) {
			return -1;
		} else return Float.parseFloat(unitsEditText.getText().toString());
	}
	
	double returnQty() {
		// Grabs quantity from EditText, returns 1 if there's no text or it's invalid (quantity is assumed to be 1 unless explicitly stated otherwise).
		if ( TextUtils.isEmpty(qtyEditText.getText().toString()) || !(MainActivity.isNumeric( qtyEditText.getText().toString() )) ) {
			return 1;
		} else return Float.parseFloat(qtyEditText.getText().toString() );
	}
	
	// function to calculate unit price and set the unit price field
	void setUnitPriceTextView() {
		itemPrice = returnPrice();
		itemUnits = returnUnits();
		itemQty = returnQty();
		if (itemPrice == -1 || itemUnits == -1) {
			unitPriceTextView.setText("");
		} else {			
			unitPriceTextView.setText(myMainActivity.pricePerUnitDecimalFormat.format( returnUnitPrice() ));
		}
	}
	
	double returnUnitPrice() {
		itemPrice = returnPrice();
		itemUnits = returnUnits();
		itemQty = returnQty();
		if (itemPrice == -1 || itemUnits == -1) {
			return -1;
		} else {
			return itemPrice / (itemUnits * itemQty);
		}
	}
	
	void highlightPricePerUnit() {
		// unitPriceTextView.setBackgroundColor( myMainActivity.getResources().getColor(R.color.LightBlue) );
		unitPriceTextView.setBackgroundColor( myMainActivity.getResources().getColor(R.color.GreenHighlight) );
	}
	
	void unHighlightPricePerUnit() {
		unitPriceTextView.setBackgroundColor( 0x00000000 );
	}
	
	void adjustCardWidth() {
		LayoutParams itemCardLayoutParameters = (LayoutParams) itemCardLinearLayout.getLayoutParams();
		itemCardLayoutParameters.width = 1500;
		itemCardLayoutParameters.gravity = Gravity.CENTER_HORIZONTAL;
	}

} // end class itemForComparison