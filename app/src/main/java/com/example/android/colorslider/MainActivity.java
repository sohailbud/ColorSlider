package com.example.android.colorslider;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView valueRed = (TextView) findViewById(R.id.valueRed);
        final SeekBar seekBarRed = (SeekBar) findViewById(R.id.sliderRed);

        final TextView valueGreen = (TextView) findViewById(R.id.valueGreen);
        final SeekBar seekBarGreen = (SeekBar) findViewById(R.id.sliderGreen);

        final TextView valueBlue = (TextView) findViewById(R.id.valueBlue);
        final SeekBar seekBarBlue = (SeekBar) findViewById(R.id.sliderBlue);

        final TextView valueAlpha = (TextView) findViewById(R.id.valueAlpha);
        final SeekBar seekBarAlpha = (SeekBar) findViewById(R.id.sliderAlpha);

        final View colorBox = findViewById(R.id.colorBox);

        final TextView hexVal = (TextView) findViewById(R.id.hexValue);

        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueRed.setText(String.valueOf(progress));
                colorBox.setBackgroundColor(Color.argb(seekBarAlpha.getProgress(), progress,
                        seekBarGreen.getProgress(), seekBarBlue.getProgress()));
                hexVal.setText(getHexValue(progress, seekBarGreen.getProgress(), seekBarBlue.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueGreen.setText(String.valueOf(progress));
                colorBox.setBackgroundColor(Color.argb(seekBarAlpha.getProgress(),
                        seekBarRed.getProgress(), progress, seekBarBlue.getProgress()));
                hexVal.setText(getHexValue(seekBarRed.getProgress(), progress, seekBarBlue.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueBlue.setText(String.valueOf(progress));
                colorBox.setBackgroundColor(Color.argb(seekBarAlpha.getProgress(),
                        seekBarRed.getProgress(), seekBarGreen.getProgress(), progress));
                hexVal.setText(getHexValue(seekBarRed.getProgress(), seekBarGreen.getProgress(), progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarAlpha.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valueAlpha.setText(String.valueOf(progress));
                colorBox.setBackgroundColor(Color.argb(progress, seekBarRed.getProgress(),
                        seekBarGreen.getProgress(), seekBarBlue.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public String getHexValue(int red, int green, int blue) {
        int rgb = (red * 256 * 256) + (green * 256) + blue;
        return String.format("#%06X", (0xFFFFFF & rgb));
    }
}
