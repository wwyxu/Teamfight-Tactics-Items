package com.wwyx.a1v7.Fragments;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.wwyx.a1v7.Adapters.DataAdapter;
import com.wwyx.a1v7.Database.DatabaseAccess;
import com.wwyx.a1v7.Adapters.Items;
import com.wwyx.a1v7.R;

import java.util.ArrayList;

public class ItemsFragment extends Fragment {

    private View view;
    private ListView mlistView;
    private DataAdapter data;
    private ArrayList<Items> items;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Items");*/
        view = inflater.inflate(R.layout.fragment_items, container, false);

        final ImageView bf = view.findViewById(R.id.bf);
        final ImageView recurve = view.findViewById(R.id.recurve);
        final ImageView rod = view.findViewById(R.id.rod);
        final ImageView tear = view.findViewById(R.id.tear);
        final ImageView vest = view.findViewById(R.id.vest);
        final ImageView cloak = view.findViewById(R.id.cloak);
        final ImageView belt = view.findViewById(R.id.belt);
        final ImageView spatula = view.findViewById(R.id.spatula);
        final ImageView glove = view.findViewById(R.id.gloves);

        final Drawable clickhighlight = getResources().getDrawable(R.drawable.clickhighlight);
        final Drawable highlight = getResources().getDrawable(R.drawable.highlight);

        final TextView headername = view.findViewById(R.id.headername);
        final TextView headerstat = view.findViewById(R.id.headerstat);

        // Filter data and change headers according to image clicked
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.bf:
                        data.filterBF();
                        headername.setText("B.F. Sword");
                        headerstat.setText("+ 15 Attack Damage");
                        bf.setColorFilter(null);
                        recurve.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        rod.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        tear.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        vest.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        cloak.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        belt.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        spatula.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        bf.setForeground(clickhighlight);
                        recurve.setForeground(highlight);
                        rod.setForeground(highlight);
                        tear.setForeground(highlight);
                        vest.setForeground(highlight);
                        cloak.setForeground(highlight);
                        belt.setForeground(highlight);
                        spatula.setForeground(highlight);
                        glove.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        glove.setForeground(highlight);
                        break;
                    case R.id.recurve:
                        data.filterRecurve();
                        headername.setText("Recurve Bow");
                        headerstat.setText("+ 15% Attack Speed");
                        recurve.setColorFilter(null);
                        bf.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        rod.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        tear.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        vest.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        cloak.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        belt.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        spatula.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        bf.setForeground(highlight);
                        recurve.setForeground(clickhighlight);
                        rod.setForeground(highlight);
                        tear.setForeground(highlight);
                        vest.setForeground(highlight);
                        cloak.setForeground(highlight);
                        belt.setForeground(highlight);
                        spatula.setForeground(highlight);
                        glove.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        glove.setForeground(highlight);
                        break;
                    case R.id.rod:
                        data.filterRod();
                        headername.setText("Needlessly Large Rod");
                        headerstat.setText("+ 20% Spell Damage");
                        rod.setColorFilter(null);
                        bf.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        recurve.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        tear.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        vest.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        cloak.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        belt.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        spatula.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        bf.setForeground(highlight);
                        recurve.setForeground(highlight);
                        rod.setForeground(clickhighlight);
                        tear.setForeground(highlight);
                        vest.setForeground(highlight);
                        cloak.setForeground(highlight);
                        belt.setForeground(highlight);
                        spatula.setForeground(highlight);
                        glove.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        glove.setForeground(highlight);
                        break;
                    case R.id.tear:
                        data.filterTear();
                        headername.setText("Tear of the Goddess");
                        headerstat.setText("+ 20 Mana");
                        tear.setColorFilter(null);
                        bf.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        recurve.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        rod.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        vest.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        cloak.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        belt.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        spatula.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        bf.setForeground(highlight);
                        recurve.setForeground(highlight);
                        rod.setForeground(highlight);
                        tear.setForeground(clickhighlight);
                        vest.setForeground(highlight);
                        cloak.setForeground(highlight);
                        belt.setForeground(highlight);
                        spatula.setForeground(highlight);
                        glove.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        glove.setForeground(highlight);
                        break;
                    case R.id.vest:
                        data.filterVest();
                        headername.setText("Chain Vest");
                        headerstat.setText("+ 25 Armor");
                        vest.setColorFilter(null);
                        bf.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        recurve.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        rod.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        tear.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        cloak.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        belt.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        spatula.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        bf.setForeground(highlight);
                        recurve.setForeground(highlight);
                        rod.setForeground(highlight);
                        tear.setForeground(highlight);
                        vest.setForeground(clickhighlight);
                        cloak.setForeground(highlight);
                        belt.setForeground(highlight);
                        spatula.setForeground(highlight);
                        glove.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        glove.setForeground(highlight);
                        break;
                    case R.id.cloak:
                        data.filterCloak();
                        headername.setText("Negatron Cloak");
                        headerstat.setText("+ 25 Magic Resist");
                        cloak.setColorFilter(null);
                        bf.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        recurve.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        rod.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        tear.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        vest.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        belt.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        spatula.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        bf.setForeground(highlight);
                        recurve.setForeground(highlight);
                        rod.setForeground(highlight);
                        tear.setForeground(highlight);
                        vest.setForeground(highlight);
                        cloak.setForeground(clickhighlight);
                        belt.setForeground(highlight);
                        spatula.setForeground(highlight);
                        glove.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        glove.setForeground(highlight);
                        break;
                    case R.id.belt:
                        data.filterBelt();
                        headername.setText("Giant's Belt");
                        headerstat.setText("+ 200 Health");
                        belt.setColorFilter(null);
                        bf.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        recurve.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        rod.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        tear.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        vest.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        cloak.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        spatula.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        bf.setForeground(highlight);
                        recurve.setForeground(highlight);
                        rod.setForeground(highlight);
                        tear.setForeground(highlight);
                        vest.setForeground(highlight);
                        cloak.setForeground(highlight);
                        belt.setForeground(clickhighlight);
                        spatula.setForeground(highlight);
                        glove.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        glove.setForeground(highlight);
                        break;
                    case R.id.spatula:
                        data.filterSpatula();
                        headername.setText("Spatula");
                        headerstat.setText("It must do something...");
                        spatula.setColorFilter(null);
                        bf.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        recurve.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        rod.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        tear.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        vest.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        cloak.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        belt.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        bf.setForeground(highlight);
                        recurve.setForeground(highlight);
                        rod.setForeground(highlight);
                        tear.setForeground(highlight);
                        vest.setForeground(highlight);
                        cloak.setForeground(highlight);
                        belt.setForeground(highlight);
                        spatula.setForeground(clickhighlight);
                        glove.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        glove.setForeground(highlight);
                        break;
                    case R.id.gloves:
                        data.filterGlove();
                        headername.setText("Sparring Gloves");
                        headerstat.setText("+ 10% Critical Strike Chance & Dodge Chance");
                        bf.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        recurve.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        rod.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        tear.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        vest.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        cloak.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        belt.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        spatula.setColorFilter(0xff999999, PorterDuff.Mode.MULTIPLY);
                        bf.setForeground(highlight);
                        recurve.setForeground(highlight);
                        rod.setForeground(highlight);
                        tear.setForeground(highlight);
                        vest.setForeground(highlight);
                        cloak.setForeground(highlight);
                        belt.setForeground(highlight);
                        spatula.setForeground(highlight);
                        glove.setColorFilter(null);
                        glove.setForeground(clickhighlight);
                    default:
                        break;
                }
            }
        };

        bf.setOnClickListener(listener);
        recurve.setOnClickListener(listener);
        rod.setOnClickListener(listener);
        tear.setOnClickListener(listener);
        vest.setOnClickListener(listener);
        cloak.setOnClickListener(listener);
        belt.setOnClickListener(listener);
        spatula.setOnClickListener(listener);
        glove.setOnClickListener(listener);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                bf.performClick();
            }
        }, 0);

        // Database instance
        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
        databaseAccess.open();
        items = new ArrayList<>();
        items = databaseAccess.getitems();
        databaseAccess.close();

        // Set data to listview
        data = new DataAdapter(getActivity(), items);
        mlistView = view.findViewById(R.id.listView);
        mlistView.setAdapter(data);

        return view;
    }
}



