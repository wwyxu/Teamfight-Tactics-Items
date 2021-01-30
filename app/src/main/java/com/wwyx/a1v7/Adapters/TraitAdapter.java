package com.wwyx.a1v7.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.wwyx.a1v7.R;
import java.util.ArrayList;
import java.util.Locale;

public class TraitAdapter extends BaseAdapter {

    private Context mcontext;
    private ArrayList<Traits> traitsList;
    // Second arraylist to accept filtered entries
    private ArrayList<Traits> filteredtraitsList;

    public TraitAdapter(Context mcontext, ArrayList<Traits> traitsList) {
        this.mcontext = mcontext;
        this.traitsList = traitsList;
        this.filteredtraitsList = new ArrayList<>();
        this.filteredtraitsList.addAll(traitsList);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return filteredtraitsList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Custom listview
        convertView = inflater.inflate(R.layout.list_traits, null);

        // Listview components
        TextView name1 = convertView.findViewById(R.id.name);
        TextView description1 = convertView.findViewById(R.id.description);
        TextView benefit1 = convertView.findViewById(R.id.benefit);
        ImageView icon1 = convertView.findViewById(R.id.icon);
        ImageView champions1 = convertView.findViewById(R.id.champions);

        // Remove listview component if entry is null, else set data to component
        Traits traits = filteredtraitsList.get(position);
        name1.setText(traits.getTname());
        if (traits.getTdescription() == null) {
            description1.setVisibility(View.GONE);
        } else description1.setText(traits.getTdescription());
        if (traits.getBenefit() == null) {
            benefit1.setVisibility(View.GONE);
        } else benefit1.setText(traits.getBenefit());
        byte[] recordImage1 = traits.getIcon();
        Bitmap bitmap1 = BitmapFactory.decodeByteArray(recordImage1, 0, recordImage1.length);
        icon1.setImageBitmap(bitmap1);
        byte[] recordImage2 = traits.getChampions();
        Bitmap bitmap2 = BitmapFactory.decodeByteArray(recordImage2, 0, recordImage2.length);
        champions1.setImageBitmap(bitmap2);

        return convertView;
    }

    @Override
    public int getCount() {
        return this.filteredtraitsList.size();
    }

    // Filter traits according to character input
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        filteredtraitsList.clear();
        if (charText.length() == 0) {
            filteredtraitsList.addAll(traitsList);
        } else {
            filteredtraitsList.clear();
            for (Traits traits : traitsList) {
                if (traits.getTag().toLowerCase(Locale.getDefault()).contains(charText) ||
                        traits.getType().toLowerCase(Locale.getDefault()).matches(charText)) {
                    filteredtraitsList.add(traits);
                }
            }
        }
        notifyDataSetChanged();
    }
}




