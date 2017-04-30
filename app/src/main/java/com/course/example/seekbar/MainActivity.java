package com.course.example.seekbar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnSeekBarChangeListener{

    private SeekBar seekBarRed, seekBarGreen, seekBarBlue;
    private TextView textViewRed, textViewGreen, textViewBlue, colorTextView;
    private int progressRed=0, progressGreen=0, progressBlue=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarRed = (SeekBar) findViewById(R.id.seekBar1);
        seekBarGreen = (SeekBar) findViewById(R.id.seekBar2);
        seekBarBlue = (SeekBar) findViewById(R.id.seekBar3);
        textViewRed = (TextView) findViewById(R.id.textView1);
        textViewGreen = (TextView) findViewById(R.id.textView2);
        textViewBlue = (TextView) findViewById(R.id.textView3);
        colorTextView = (TextView)findViewById(R.id.color_text);

        // Initialize the textviews with '0'.
        textViewRed.setText("Value: " + seekBarRed.getProgress() + "/" + seekBarRed.getMax());
        textViewGreen.setText("Value: " + seekBarGreen.getProgress() + "/" + seekBarGreen.getMax());
        textViewBlue.setText("Value: " + seekBarBlue.getProgress() + "/" + seekBarBlue.getMax());

        //set listeners on the SeekBars
        seekBarRed.setOnSeekBarChangeListener(this);
        seekBarGreen.setOnSeekBarChangeListener(this);
        seekBarBlue.setOnSeekBarChangeListener(this);

    }

    //next 3 methods are to satisfy the interface
    @Override
    public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {

        switch (seekBar.getId()){
            case R.id.seekBar1: {
                progressRed = progresValue;
                break;
            }
            case R.id.seekBar2: {
                progressGreen = progresValue;
                break;
            }
            case R.id.seekBar3: {
                progressBlue = progresValue;
                break;
            }
        }

       // Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
      //  Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        switch (seekBar.getId()){
            case R.id.seekBar1: {
                textViewRed.setText("Covered: " + progressRed + "/" + seekBar.getMax());
                break;
            }
            case R.id.seekBar2: {
                textViewGreen.setText("Covered: " + progressGreen + "/" + seekBar.getMax());
                break;
            }
            case R.id.seekBar3: {
                textViewBlue.setText("Covered: " + progressBlue + "/" + seekBar.getMax());
                break;
            }
        }

      //  Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
        colorTextView.setTextColor(Color.rgb(progressRed,progressGreen,progressBlue));
    }


}