package com.example.jamesmai.billsplitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class WelcomeScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        //Display the Action Bar Icon
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //Initiate instance of an object
        ImageButton move = findViewById(R.id.btnBill);

        //Make actions when the user click the button
        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Move to the Split Bill activity from the Welcome Screen
                startActivity(new Intent(WelcomeScreen.this,SplitBill.class));
            }
        });
    }
}
