package com.adm.reg;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Welcome extends AppCompatActivity {

    DrawerLayout drawerlay;
    ActionBarDrawerToggle abdt;
        Toolbar toolbara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        toolbara = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbara);
        drawerlay=(DrawerLayout)findViewById(R.id.drawlayout);
        abdt = new ActionBarDrawerToggle(this,drawerlay,toolbara,R.string.drawer_open, R.string.drawer_close);
        drawerlay.setDrawerListener(abdt);


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        abdt.syncState();

    }

    @Override
    public void onBackPressed() {
        exitdialoguebox dialog=new exitdialoguebox();
        dialog.show(getSupportFragmentManager(),"My dialog");

    }

    public final void getpro(View v)
    {
        try
        {startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://play.google.com/store/apps/details?id=com.harsh.material")));}
        catch(Exception e)
        {
            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("market://details?id=com.harsh.material")));
        }
    }
    public final void gotoupload(View v)
    {
        Intent welcometoupload=new Intent(this,Documents.class);
        startActivity(welcometoupload);

    }

}
