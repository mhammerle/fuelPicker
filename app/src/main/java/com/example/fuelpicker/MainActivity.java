package com.example.fuelpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private NumberFormat currencyFormat =
            NumberFormat.getCurrencyInstance();

    private SeekBar gasolineSeekBar;
    private SeekBar ethanolSeekBar;
    private TextInputEditText fuelPickedTextInputEditText;
    private ImageView fuelPickedImageView;
    private TextView gasolineValueTextView;
    private TextView ethanolValueTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gasolineSeekBar = findViewById(R.id.gasolineSeekbar);
        gasolineSeekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);

        ethanolSeekBar = findViewById(R.id.ethanolSeekBar);
        ethanolSeekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);

        fuelPickedTextInputEditText = findViewById(R.id.fuelPickedTextInputEditText);
        fuelPickedImageView = findViewById(R.id.fuelPickedImageView);

        gasolineValueTextView = findViewById(R.id.gasolineValueTextView);
        ethanolValueTextView = findViewById(R.id.ethanolValueTextView);

        double gasolinePrice = gasolineSeekBar.getProgress() / 10D;
        double ethanolPrice = ethanolSeekBar.getProgress()  / 10D;

        double result = ethanolPrice/gasolinePrice;

        if(result > 0.7){
            fuelPickedTextInputEditText.setText(R.string.gasoline);
            fuelPickedImageView.setImageResource(R.drawable.gasoline);
            gasolineValueTextView.setText(currencyFormat.format(gasolinePrice));
            ethanolValueTextView.setText(currencyFormat.format(ethanolPrice));
        } else {
            fuelPickedTextInputEditText.setText(R.string.ethanol);
            fuelPickedImageView.setImageResource(R.drawable.ethanol);
            gasolineValueTextView.setText(currencyFormat.format(gasolinePrice));
            ethanolValueTextView.setText(currencyFormat.format(ethanolPrice));
        }


    }

    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener =
            new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                    double gasolinePrice = gasolineSeekBar.getProgress() / 10D;
                    double ethanolPrice = ethanolSeekBar.getProgress()  / 10D;

                    gasolineValueTextView.setText(currencyFormat.format(gasolinePrice));
                    ethanolValueTextView.setText(currencyFormat.format(ethanolPrice));


                    double result = ethanolPrice/gasolinePrice;

                    if(result > 0.7){
                        fuelPickedTextInputEditText.setText(R.string.gasoline);
                        fuelPickedImageView.setImageResource(R.drawable.gasoline);
                    } else {
                        fuelPickedTextInputEditText.setText(R.string.ethanol);
                        fuelPickedImageView.setImageResource(R.drawable.ethanol);
                    }
                }
                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {}
                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {}
            };


}
