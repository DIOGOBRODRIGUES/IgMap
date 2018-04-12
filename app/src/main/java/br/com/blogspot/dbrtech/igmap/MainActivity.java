package br.com.blogspot.dbrtech.igmap;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import br.com.blogspot.dbrtech.utils.MesesUtil;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String selecPicker = null;
    private FragmentManager fragmentManager;
    private int mesatual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.mes_etr);
                dialog.setTitle("Mês:");
                //Get the widgets reference from XML layout
                NumberPicker np = (NumberPicker) dialog.findViewById(R.id.np);
                //Set the minimum value of NumberPicker
                np.setMinValue(0); //from array first value
                //Initializing a new string array with elements
                final MesesUtil mesesUtil = new MesesUtil();
                final String[] values = mesesUtil.getMesesArray();
                //Specify the maximum value/number of NumberPicker
                np.setMaxValue(values.length-1); //to array last value
                //Specify the NumberPicker data source as array elements
                np.setDisplayedValues(values);
                //Gets whether the selector wheel wraps when reaching the min/max value.
                np.setWrapSelectorWheel(true);
                np.setValue(mesatual);
                dialog.show();


                np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                    @Override
                    public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                        //Display the newly selected value from picker
                         selecPicker = values[newVal];
                         mesatual = mesesUtil.Convert(selecPicker);
                    }
                });
                Button dialogButton = (Button) dialog.findViewById(R.id.button3);
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        GeoJsonDemoActivity fragetr = (GeoJsonDemoActivity) getSupportFragmentManager().findFragmentByTag("GeoJsonDemoActivity");
                        if (fragetr != null && fragetr.isVisible()) {
                            showFragment(new GeoJsonDemoActivity(), "GeoJsonDemoActivity");

                        }
                        GeoJsonBalActivity fragbal = (GeoJsonBalActivity) getSupportFragmentManager().findFragmentByTag("GeoJsonBalActivity");
                        if (fragbal != null && fragbal.isVisible()) {
                            showFragment(new GeoJsonBalActivity(), "GeoJsonBalActivity");
                        }

                        GeoJsonETPActivity fragetp = (GeoJsonETPActivity) getSupportFragmentManager().findFragmentByTag("GeoJsonETPActivity");
                        if (fragetp != null && fragetp.isVisible()) {
                            showFragment(new GeoJsonETPActivity(), "GeoJsonETPActivity");
                        }

                        dialog.dismiss();
                    }
                });

            }
        });




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        //drawer.setDrawerListener(toggle);
        toggle.syncState();

        //itens do menu
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.container, new MapsActivity(), "MapsFragments" );

        transaction.commitAllowingStateLoss();


    }

    private Context getContext() {
        return  this;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showFragment (Fragment fragment, String name){
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.container, fragment, name);

        transaction.commit();
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Date data = new Date();
        GregorianCalendar dataCal = new GregorianCalendar();
        dataCal.setTime(data);


        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            mesatual = dataCal.get(Calendar.MONTH);
            showFragment(new GeoJsonDemoActivity(), "GeoJsonDemoActivity");


        } else if (id == R.id.nav_gallery) {
            mesatual = dataCal.get(Calendar.MONTH);
            showFragment(new GeoJsonETPActivity(), "GeoJsonETPActivity");

        } else if (id == R.id.nav_slideshow) {
            mesatual = dataCal.get(Calendar.MONTH);
            showFragment(new GeoJsonBalActivity(), "GeoJsonBalActivity");
//        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public int getMyData() {

        return mesatual;
    }
}
