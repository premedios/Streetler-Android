package com.premedios.streetler;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView MainTitle = (TextView) findViewById(R.id.main_title);
        Button registerButton = (Button) findViewById(R.id.register_button);
        Button loginButton = (Button) findViewById(R.id.login_button);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Exo2-SemiBold.otf");
        if (MainTitle != null) {
            MainTitle.setTypeface(typeface);
            registerButton.setTypeface(typeface);
            loginButton.setTypeface(typeface);
        }
    }
}
