package com.wwyx.a1v7.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wwyx.a1v7.Fragments.ChampionsFragment;
import com.wwyx.a1v7.Fragments.DropRatesFragment;
import com.wwyx.a1v7.Fragments.ClassesFragment;
import com.wwyx.a1v7.Fragments.CombinationsFragment;
import com.wwyx.a1v7.Fragments.ItemsFragment;
import com.wwyx.a1v7.R;

public class MainActivity extends AppCompatActivity {

    final Fragment fragment1 = new ItemsFragment();
    final Fragment fragment2 = new CombinationsFragment();
    final Fragment fragment3 = new ChampionsFragment();
    final Fragment fragment4 = new ClassesFragment();
    final Fragment fragment5 = new DropRatesFragment();
    Fragment active = fragment1;
    final FragmentManager fm = getSupportFragmentManager();

    AdView mAdview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        /*MobileAds.initialize(this,"c");
        mAdview = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);*/

        /* <com.google.android.gms.ads.AdView
        xmlns:ads="http://schemas.android.com/apk/res-auto"
        android:id="@+id/adView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_above="@+id/line"
        ads:adSize="BANNER"
        ads:adUnitId="">
    </com.google.android.gms.ads.AdView>*/

        // Custom bottom navigation
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        // All fragments are created upon opening app
        fm.beginTransaction().add(R.id.fragment_container, fragment5, "5").hide(fragment5).commit();
        fm.beginTransaction().add(R.id.fragment_container, fragment4, "4").hide(fragment4).commit();
        fm.beginTransaction().add(R.id.fragment_container, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.fragment_container, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.fragment_container, fragment1, "1").commit();
    }

    // Switching fragments hides fragments rather than deleting and recreating
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.nav_items:
                            fm.beginTransaction().hide(active).show(fragment1).commit();
                            active = fragment1;
                            /*getSupportActionBar().setTitle("Items");*/
                            return true;

                        case R.id.nav_combinations:
                            fm.beginTransaction().hide(active).show(fragment2).commit();
                            active = fragment2;
                            /*getSupportActionBar().setTitle("Combinations");*/
                            return true;

                        case R.id.nav_champions:
                            fm.beginTransaction().hide(active).show(fragment3).commit();
                            active = fragment3;
                            /*getSupportActionBar().setTitle("Champions");*/
                            return true;

                        case R.id.nav_classes:
                            fm.beginTransaction().hide(active).show(fragment4).commit();
                            active = fragment4;
                            /*getSupportActionBar().setTitle("Traits");*/
                            return true;

                        case R.id.nav_rates:
                            fm.beginTransaction().hide(active).show(fragment5).commit();
                            active = fragment4;
                            /*getSupportActionBar().setTitle("Drop Rates");*/
                            return true;
                    }
                    return false;
                }
            };

    /* Toolbar implementation

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbarmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                startActivity(new Intent(this,SettingsActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/
}