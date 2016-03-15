package com.adm.reg;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class register extends AppCompatActivity {

    EditText fname,lname,emailid,phone,pass;
    TextView text1;
    CheckBox check;
    String fnames,lnames,emailids,passs,phones;
    int phonesval;
    Button bn;
    DatabaseOperations mydb;
    Context ctx=this;
    public static final String KEY1="email";
    public static final String KEY2="password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fname=(EditText)findViewById(R.id.Fname);
        lname=(EditText)findViewById(R.id.Lname);
        emailid=(EditText)findViewById(R.id.emailid);
        phone=(EditText)findViewById(R.id.Phoneno);
        pass=(EditText)findViewById(R.id.passwrd);
        bn=(Button)findViewById(R.id.regbut);
        text1=(TextView)findViewById(R.id.textView5);
        check=(CheckBox)findViewById(R.id.checkBox);
        Typeface typeFace= Typeface.createFromAsset(this.getAssets(), "fonts/CaviarDreams.ttf");
        fname.setTypeface(typeFace);
        lname.setTypeface(typeFace);
        pass.setTypeface(typeFace);
        emailid.setTypeface(typeFace);
        phone.setTypeface(typeFace);
        bn.setTypeface(typeFace);
        text1.setTypeface(typeFace);
        check.setTypeface(typeFace);
        final Intent index = new Intent(this , Login.class);
        bn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                fnames = fname.getText().toString();
                lnames = lname.getText().toString();
                emailids = emailid.getText().toString();
                phones = phone.getText().toString();
                phonesval=phones.length();
                passs = pass.getText().toString();
                if(validate(fnames,lnames,emailids,phones,passs)!=0)
                {
                    Toast.makeText(getBaseContext(), "oops!", Toast.LENGTH_LONG).show();
                }
                else
                {
                mydb = new DatabaseOperations(ctx);
                mydb.putinfo(mydb, fnames, lnames, emailids, phones, passs);
                Toast.makeText(getBaseContext(), "Registeration sucessful", Toast.LENGTH_LONG).show();
                    index.putExtra(KEY1, emailids);
                    index.putExtra(KEY2,passs);
                    startActivity(index);}
            }

        });



    }
    public int validate(String fnames1,String lnames1, String emailids1,String phones1,String passs1)
    {
         int fnameb=0,lnameb=0,emailb=0,phoneb=0,passwordb=0,final1;
        if(!validatefname(fnames1))
        {
            fname.setError("invalid");
            fnameb=1;
        }
        if(!validatelname(lnames1))
        {
            lname.setError("invalid");
            lnameb=1;
        }
        if(!validateemail(emailids1))
        {
            emailid.setError("Invalid email");
            emailb=1;
        }
        if(!validatephoneno(phones1)) {
            phone.setError("Invalid Phone number");
            phoneb=1;
        }
        if(!validatepassword(passs1))
        {
            pass.setError("Invalid password");
            passwordb=1;
        }
        final1 = (fnameb + lnameb + emailb + phoneb + passwordb);
        return (final1);
    }
    public  boolean validatefname(String fnames2)
    {
        if(fnames2!=null && fnames2.length()>=2)
        {
            return true;
        }
        else
        {

            return false;}
    }
    public  boolean validatelname(String lnames2)
    {
        if(lnames2!=null && lnames2.length()>=2)
        {
            return true;
        }
        else
        {

            return false;}
    }
    public boolean validateemail(String emailids2)
    {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(emailids2);
        return matcher.matches();

    }
    public boolean validatephoneno(String phones2)
    {
        if(phonesval==10)
            return true;
        else
        {fname.setError("invalid");
        return  false;}

    }
    public boolean validatepassword(String passs2)
    {
        return true;
    }
}
