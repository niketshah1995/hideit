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

public class SignupLogin extends AppCompatActivity {

    public static Button btn1;
    public static Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_login);
        btn1=(Button)findViewById(R.id.Register);
        btn2=(Button)findViewById(R.id.Login);

        Typeface typeFace= Typeface.createFromAsset(getAssets(), "fonts/cavier_bold.ttf");
        TextView myTextView1=(TextView)findViewById(R.id.question1);
        TextView myTextView2=(TextView)findViewById(R.id.textView2);
        TextView myTextView3=(TextView)findViewById(R.id.question2);
        myTextView1.setTypeface(typeFace);
        myTextView2.setTypeface(typeFace);
        btn1.setTypeface(typeFace);
        btn2.setTypeface(typeFace);
        myTextView3.setTypeface(typeFace);

    }
    public void regpage(View v)
    {
        final Intent intend1=new Intent(this,register.class);
        startActivity(intend1);
    }
    public void loginpage(View v)
    {
        final Intent intend2=new Intent(this,Login.class);
        startActivity(intend2);
    }
}
