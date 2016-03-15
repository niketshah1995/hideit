package com.adm.reg;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Forgotpassword extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        TextView myTextView=(TextView)findViewById(R.id.emailtext);
        Typeface typeFace= Typeface.createFromAsset(this.getAssets(), "fonts/CaviarDreams.ttf");
        myTextView.setTypeface(typeFace);

    }
}
