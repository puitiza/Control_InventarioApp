package com.example.apuitiza.control_inventarioapp.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.apuitiza.control_inventarioapp.fragments.MovimientosFragment;
import com.example.apuitiza.control_inventarioapp.R;
import com.gigamole.navigationtabstrip.NavigationTabStrip;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private NavigationTabStrip mNavigationTabStrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        mNavigationTabStrip.setOnTabStripSelectedIndexListener(new NavigationTabStrip.OnTabStripSelectedIndexListener() {
            @Override
            public void onStartTabSelected(String title, int index) {
                switch (index){
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,new MovimientosFragment()).commit();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,new Fragment()).commit();
                        break;
                }
            }

            @Override
            public void onEndTabSelected(String title, int index) {
                //Toast.makeText(MainActivity.this, "End", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initUI() {
        //mViewPager = (ViewPager) findViewById(R.id.vp);
        mNavigationTabStrip = (NavigationTabStrip) findViewById(R.id.nts_center);
        mNavigationTabStrip.setTabIndex(0);
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,new MovimientosFragment()).commit();
    }

    private void setUI() {
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public boolean isViewFromObject(final View view, final Object object) {
                return view.equals(object);
            }

            @Override
            public void destroyItem(final View container, final int position, final Object object) {
                ((ViewPager) container).removeView((View) object);
            }

            @Override
            public Object instantiateItem(final ViewGroup container, final int position) {
                final View view = new View(getBaseContext());
                container.addView(view);
                return view;
            }
        });

    }
}
