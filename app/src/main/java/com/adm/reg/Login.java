package com.adm.reg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    Button bn;
    Button bnfrg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bn=(Button)findViewById(R.id.regbut);
        bnfrg=(Button)findViewById(R.id.frgbutton);
        final Intent login2frgetpswd=new Intent(this,Forgotpassword.class);
        final Intent login2welcome=new Intent(this,Welcome.class);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(login2welcome);
            }
        });
        bnfrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(login2frgetpswd);
            }
        });

        Intent int1 = getIntent();
        String message_email=int1.getStringExtra(register.KEY1);
        String message_password=int1.getStringExtra(register.KEY2);


        TextView mailvalue =  (TextView)findViewById(R.id.emailid);
        mailvalue.setText(message_email);

        TextView passvalue =  (TextView)findViewById(R.id.Passwrd);
        passvalue.setText(message_password);
    }



}
