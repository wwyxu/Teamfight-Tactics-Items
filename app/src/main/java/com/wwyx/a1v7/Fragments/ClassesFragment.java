package com.wwyx.a1v7.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.wwyx.a1v7.Database.DatabaseAccess;
import com.wwyx.a1v7.R;
import com.wwyx.a1v7.Adapters.TraitAdapter;
import com.wwyx.a1v7.Adapters.Traits;
import java.util.ArrayList;

public class ClassesFragment extends Fragment {

    private View view;
    private ListView listView;
    private TraitAdapter data;
    private ArrayList<Traits> traits;
    private SearchView searchView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_classes, container, false);

        searchView = view.findViewById(R.id.searchText);

        // Database instance
        final DatabaseAccess databaseAccess = DatabaseAccess.getInstance(getActivity());
        databaseAccess.open();
        traits = new ArrayList<>();
        traits = databaseAccess.gettraits();
        databaseAccess.close();

        // Set data to listview
        data = new TraitAdapter(getActivity(), traits);
        listView = view.findViewById(R.id.traitlistView);
        listView.setAdapter(data);

        // Search View and Customization
        int id = searchView.getContext()
                .getResources()
                .getIdentifier("android:id/search_src_text", null, null);
        TextView textView = searchView.findViewById(id);
        textView.setTextColor(Color.GRAY);
        textView.setHintTextColor(Color.GRAY);

        int magId = searchView.getContext().getResources().getIdentifier("android:id/search_mag_icon", null, null);
        ImageView magImage = searchView.findViewById(magId);
        magImage.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.search));

        int closeButtonId = searchView.getContext().getResources().getIdentifier("android:id/search_close_btn", null, null);
        ImageView closeButtonImage = searchView.findViewById(closeButtonId);
        closeButtonImage.setImageDrawable(ContextCompat.getDrawable(getActivity(),R.drawable.ic_close_black_24dp));

        searchView.setQueryHint("Search for champions or traits");

        // Filter data from keyboard input
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String txt) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String txt) {
                if (TextUtils.isEmpty(txt)) {
                    data.filter("");
                    listView.clearTextFilter();
                } else {
                    data.filter(txt);
                }
                return true;
            }
        });

        return view;
    }
}

