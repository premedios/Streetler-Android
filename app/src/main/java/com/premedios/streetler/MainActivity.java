package com.premedios.streetler;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView MainTitle = (TextView) findViewById(R.id.main_title);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Exo2-SemiBold.otf");
        if (MainTitle != null) {
            MainTitle.setTypeface(typeface);
        }
    }
}
