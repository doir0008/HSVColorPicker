/**
 *  HSV Color Picker App - adjustable hue, saturation, value/lightness channels with
 *  a select range of color quick buttons.
 *  @author Ryan Doiron (doir0008@algonquinlive.com)
 *  */
package com.algonquincollege.doir0008.hsvcolorpicker;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
// import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
// import android.app.DialogFragment;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Color;
import java.util.Observable;
import java.util.Observer;
import model.HSVModel;


public class MainActivity extends AppCompatActivity implements Observer, SeekBar.OnSeekBarChangeListener {

    private static final String ABOUT_DIALOG_TAG;
    private static final String LOG_TAG;

    static {
        ABOUT_DIALOG_TAG = "About Dialog";
        LOG_TAG = "CONVERTED_NUM";
    }

    // INSTANCE VARIABLES
    private AboutDialogFragment mAboutDialog;
    private TextView            mColorSwatch;
    private HSVModel            mModel;
    private SeekBar             mHueSB;
    private SeekBar             mSaturationSB;
    private SeekBar             mValueSB;
    private Button              mBlackBtn;
    private Button              mRedBtn;
    private Button              mLimeBtn;
    private Button              mBlueBtn;
    private Button              mYellowBtn;
    private Button              mCyanBtn;
    private Button              mMagentaBtn;
    private Button              mSilverBtn;
    private Button              mGrayBtn;
    private Button              mMaroonBtn;
    private Button              mOliveBtn;
    private Button              mGreenBtn;
    private Button              mPurpleBtn;
    private Button              mTealBtn;
    private Button              mNavyBtn;
    private TextView            mHueText;
    private TextView            mSaturationText;
    private TextView            mValueText;

    // Convert int value into float or vice-versa
    public float getConvertedFloatValue(int intVal){
        float floatVal = 0f;
        floatVal = 0.01f * intVal;
        return floatVal;
    }

    public int getConvertedIntValue(float floatVal){
        int intVal;
        intVal = Math.round(100 * floatVal);
        return intVal;
    }

    public float getConvertedFloatHue(int intVal){
        float floatVal = 0f;
        floatVal = 1.0f * intVal;
        return floatVal;
    }

    public int getConvertedIntHue(float floatVal){
        int intVal;
        intVal = Math.round(1 * floatVal);
        return intVal;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate a new AboutDialogFragment()
        // but do not show it (yet)
        mAboutDialog = new AboutDialogFragment();

        // Instantiate a new HSV model
        // Initialize the model hue (min), saturation (min), value (min)
        mModel = new HSVModel();
        mModel.setHue( HSVModel.MIN_H );
        mModel.setSaturation( HSVModel.MIN_S );
        mModel.setValue( HSVModel.MIN_V );
        // The Model is observing this Controller (class MainActivity implements Observer)
        mModel.addObserver( this );

        // reference each View
        mColorSwatch = (TextView) findViewById( R.id.colorSwatch );
        mHueSB = (SeekBar) findViewById( R.id.hueSB );
        mSaturationSB = (SeekBar) findViewById( R.id.saturationSB );
        mValueSB = (SeekBar) findViewById( R.id.valueSB );
        mHueText = (TextView) findViewById( R.id.hueText );
        mSaturationText = (TextView) findViewById( R.id.saturationText );
        mValueText = (TextView) findViewById( R.id.valueText );

        // reference each color swatch button
        mBlackBtn = (Button) findViewById( R.id.blackButton );
        mRedBtn = (Button) findViewById( R.id.redButton );
        mLimeBtn = (Button) findViewById( R.id.limeButton );
        mBlueBtn = (Button) findViewById( R.id.blueButton );
        mYellowBtn = (Button) findViewById( R.id.yellowButton );
        mCyanBtn = (Button) findViewById( R.id.cyanButton );
        mMagentaBtn = (Button) findViewById( R.id.magentaButton );
        mSilverBtn = (Button) findViewById( R.id.silverButton );
        mGrayBtn = (Button) findViewById( R.id.grayButton );
        mMaroonBtn = (Button) findViewById( R.id.maroonButton );
        mOliveBtn = (Button) findViewById( R.id.oliveButton );
        mGreenBtn = (Button) findViewById( R.id.greenButton );
        mPurpleBtn = (Button) findViewById( R.id.purpleButton );
        mTealBtn = (Button) findViewById( R.id.tealButton );
        mNavyBtn = (Button) findViewById( R.id.navyButton );

        // set the domain (i.e. max) for each component
        mHueSB.setMax( getConvertedIntHue( HSVModel.MAX_H ) );
        mSaturationSB.setMax( getConvertedIntValue( HSVModel.MAX_S ) );
        mValueSB.setMax( getConvertedIntValue( HSVModel.MAX_V ) );

        // register the event handler for each <SeekBar>
        mHueSB.setOnSeekBarChangeListener( this );
        mSaturationSB.setOnSeekBarChangeListener( this );
        mValueSB.setOnSeekBarChangeListener( this );

        // event handler for color swatch buttons
        mBlackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asBlack();
                Toast.makeText( getApplicationContext(), "H: " + mModel.getHue() + "\u00B0" + " S: " + getConvertedIntValue(mModel.getSaturation()) + "%" +  " V: " + getConvertedIntValue(mModel.getValue()) + "%", Toast.LENGTH_SHORT ).show();
            }
        });
        mRedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asRed();
                Toast.makeText( getApplicationContext(), "H: " + mModel.getHue() + "\u00B0" + " S: " + getConvertedIntValue(mModel.getSaturation()) + "%" +  " V: " + getConvertedIntValue(mModel.getValue()) + "%", Toast.LENGTH_SHORT ).show();
            }
        });
        mLimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asLime();
                Toast.makeText( getApplicationContext(), "H: " + mModel.getHue() + "\u00B0" + " S: " + getConvertedIntValue(mModel.getSaturation()) + "%" +  " V: " + getConvertedIntValue(mModel.getValue()) + "%", Toast.LENGTH_SHORT ).show();

            }
        });
        mBlueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asBlue();
                Toast.makeText( getApplicationContext(), "H: " + mModel.getHue() + "\u00B0" + " S: " + getConvertedIntValue(mModel.getSaturation()) + "%" +  " V: " + getConvertedIntValue(mModel.getValue()) + "%", Toast.LENGTH_SHORT ).show();

            }
        });
        mYellowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asYellow();
                Toast.makeText( getApplicationContext(), "H: " + mModel.getHue() + "\u00B0" + " S: " + getConvertedIntValue(mModel.getSaturation()) + "%" +  " V: " + getConvertedIntValue(mModel.getValue()) + "%", Toast.LENGTH_SHORT ).show();

            }
        });
        mCyanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asCyan();
                Toast.makeText( getApplicationContext(), "H: " + mModel.getHue() + "\u00B0" + " S: " + getConvertedIntValue(mModel.getSaturation()) + "%" +  " V: " + getConvertedIntValue(mModel.getValue()) + "%", Toast.LENGTH_SHORT ).show();

            }
        });
        mMagentaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asMagenta();
                Toast.makeText( getApplicationContext(), "H: " + mModel.getHue() + "\u00B0" + " S: " + getConvertedIntValue(mModel.getSaturation()) + "%" +  " V: " + getConvertedIntValue(mModel.getValue()) + "%", Toast.LENGTH_SHORT ).show();

            }
        });
        mSilverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asSilver();
                Toast.makeText( getApplicationContext(), "H: " + mModel.getHue() + "\u00B0" + " S: " + getConvertedIntValue(mModel.getSaturation()) + "%" +  " V: " + getConvertedIntValue(mModel.getValue()) + "%", Toast.LENGTH_SHORT ).show();

            }
        });
        mGrayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asGray();
                Toast.makeText( getApplicationContext(), "H: " + mModel.getHue() + "\u00B0" + " S: " + getConvertedIntValue(mModel.getSaturation()) + "%" +  " V: " + getConvertedIntValue(mModel.getValue()) + "%", Toast.LENGTH_SHORT ).show();

            }
        });
        mMaroonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asMaroon();
                Toast.makeText( getApplicationContext(), "H: " + mModel.getHue() + "\u00B0" + " S: " + getConvertedIntValue(mModel.getSaturation()) + "%" +  " V: " + getConvertedIntValue(mModel.getValue()) + "%", Toast.LENGTH_SHORT ).show();

            }
        });
        mOliveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asOlive();
                Toast.makeText( getApplicationContext(), "H: " + mModel.getHue() + "\u00B0" + " S: " + getConvertedIntValue(mModel.getSaturation()) + "%" +  " V: " + getConvertedIntValue(mModel.getValue()) + "%", Toast.LENGTH_SHORT ).show();

            }
        });
        mGreenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asGreen();
                Toast.makeText( getApplicationContext(), "H: " + mModel.getHue() + "\u00B0" + " S: " + getConvertedIntValue(mModel.getSaturation()) + "%" +  " V: " + getConvertedIntValue(mModel.getValue()) + "%", Toast.LENGTH_SHORT ).show();

            }
        });
        mPurpleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asPurple();
                Toast.makeText( getApplicationContext(), "H: " + mModel.getHue() + "\u00B0" + " S: " + getConvertedIntValue(mModel.getSaturation()) + "%" +  " V: " + getConvertedIntValue(mModel.getValue()) + "%", Toast.LENGTH_SHORT ).show();

            }
        });
        mTealBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asTeal();
                Toast.makeText( getApplicationContext(), "H: " + mModel.getHue() + "\u00B0" + " S: " + getConvertedIntValue(mModel.getSaturation()) + "%" +  " V: " + getConvertedIntValue(mModel.getValue()) + "%", Toast.LENGTH_SHORT ).show();

            }
        });
        mNavyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.asNavy();
                Toast.makeText( getApplicationContext(), "H: " + mModel.getHue() + "\u00B0" + " S: " + getConvertedIntValue(mModel.getSaturation()) + "%" +  " V: " + getConvertedIntValue(mModel.getValue()) + "%", Toast.LENGTH_SHORT ).show();

            }
        });

        // event handler for color swatch
        // display toast message with current color swatch hsv values
        mColorSwatch.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText( getApplicationContext(), "H: " + mModel.getHue() + "\u00B0" + " S: " + getConvertedIntValue(mModel.getSaturation()) + "%" +  " V: " + getConvertedIntValue(mModel.getValue()) + "%", Toast.LENGTH_SHORT ).show();
                return true;
            }
        });

        // initialize the View to the values of the Model
        this.updateView();
    }

    // Inflate the menu; this adds items to the action bar if it is present.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Handle action bar click of the about menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            DialogFragment newFragment = new AboutDialogFragment();
            newFragment.show( getFragmentManager(), ABOUT_DIALOG_TAG );
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // Event handler for the <SeekBar>s: hue, saturation, value
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        // Did the user cause this event?
        // YES > continue
        // NO  > leave this method
        if ( fromUser == false ) {
            return;
        }

        // Determine which <SeekBar> caused the event
        // GET the SeekBar's progress, and SET the model to it's new value
        switch ( seekBar.getId() ) {
            case R.id.hueSB:
                mModel.setHue( getConvertedFloatHue(mHueSB.getProgress()) );
                mHueText.setText("HUE: " + mHueSB.getProgress() + "\u00B0");
                break;

            case R.id.saturationSB:
                mModel.setSaturation( getConvertedFloatValue(mSaturationSB.getProgress()) );
                mSaturationText.setText("SATURATION: " + mSaturationSB.getProgress() + "%");
                break;

            case R.id.valueSB:
                mModel.setValue( getConvertedFloatValue(mValueSB.getProgress()) );
                mValueText.setText("VALUE / LIGHTNESS: " + mValueSB.getProgress() + "%");
                break;

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // No-Operation
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // Set the hue, saturation and value TextView.text back to default
        switch ( seekBar.getId() ) {
            case R.id.hueSB:
                mHueText.setText("Hue");
                break;

            case R.id.saturationSB:
                mSaturationText.setText("Saturation");
                break;

            case R.id.valueSB:
                mValueText.setText("Value / Lightness");
                break;
        }

    }

    // The Model has changed state!
    // Refresh the View to display the current values of the Model.
    @Override
    public void update(Observable observable, Object data) {
        this.updateView();
    }

    // update ColorSwatch BackgroundColor by converting HSV to Color
    private void updateColorSwatch() {
        mColorSwatch.setBackgroundColor(Color.HSVToColor(new float[] {mModel.getHue(), mModel.getSaturation(), mModel.getValue()}));
        // Log.i( LOG_TAG, Integer.toHexString(Color.HSVToColor(new float[] {mModel.getHue(), mModel.getSaturation(), mModel.getValue()})));
    }

    // set the blueSB's progress to the model's blue value
    private void updateHueSB() {
        mHueSB.setProgress( getConvertedIntHue(mModel.getHue()) );
    }

    // set the greenSB's progress to the model's green value
    private void updateSaturationSB() {
        mSaturationSB.setProgress( getConvertedIntValue(mModel.getSaturation()) );
    }

    // GET the model's red value, and SET the red <SeekBar>
    private void updateValueSB() {
        mValueSB.setProgress( getConvertedIntValue(mModel.getValue()) );
    }

    // synchronize each View component with the Model
    public void updateView() {
        this.updateColorSwatch();
        this.updateHueSB();
        this.updateSaturationSB();
        this.updateValueSB();
    }
}

