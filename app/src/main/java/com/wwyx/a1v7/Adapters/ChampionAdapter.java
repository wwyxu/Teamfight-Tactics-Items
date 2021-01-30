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

public class ChampionAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Champions> championsList;
    // Second arraylist to accept filtered entries
    private ArrayList<Champions> filteredList;

    public ChampionAdapter(Context context, ArrayList<Champions> championsList) {
        this.context = context;
        this.championsList = championsList;
        this.filteredList = new ArrayList<>();
        this.filteredList.addAll(championsList);
    }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public Object getItem(int position) { return filteredList.get(position); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Custom listview
        convertView = inflater.inflate(R.layout.list_champions, null);

        // Listview components
        TextView champion  = convertView.findViewById(R.id.nameofchampion);
        TextView traits  = convertView.findViewById(R.id.traits);
        TextView health  = convertView.findViewById(R.id.Health);
        TextView armor  = convertView.findViewById(R.id.Armor);
        TextView magicResist = convertView.findViewById(R.id.MagicResist);
        TextView attackDamage  = convertView.findViewById(R.id.AttackDamage);
        TextView attackSpeed  = convertView.findViewById(R.id.AttackSpeed);
        TextView Range = convertView.findViewById(R.id.Range);
        ImageView championIcon  = convertView.findViewById(R.id.championIcon);
        TextView abilityname  = convertView.findViewById(R.id.nameofAbility);
        TextView mana  = convertView.findViewById(R.id.mana);
        TextView abilitydescription = convertView.findViewById(R.id.abilityDescription);
        ImageView abilityIcon = convertView.findViewById(R.id.abilityIcon);

        // Remove listview component if entry is null, else set data to component
        Champions champions = filteredList.get(position);

        champion.setText(champions.getChampion());
        traits.setText(champions.getTraits());
        health.setText(champions.getHealth());
        armor.setText(champions.getArmor());
        magicResist.setText(champions.getMagicResist());
        attackDamage.setText(champions.getAttackDamage());
        attackSpeed.setText(champions.getAttackSpeed());
        Range.setText(champions.getRange());
        byte[] recordImage1 = champions.getChampIcon();
        Bitmap bitmap1 = BitmapFactory.decodeByteArray(recordImage1, 0, recordImage1.length);
        championIcon.setImageBitmap(bitmap1);
        abilityname.setText(champions.getAbility());
        mana.setText(champions.getMana());
        abilitydescription.setText(champions.getAbilityDescription());
        byte[] recordImage2 = champions.getAbilityIcon();
        Bitmap bitmap2 = BitmapFactory.decodeByteArray(recordImage2, 0, recordImage2.length);
        abilityIcon.setImageBitmap(bitmap2);

        return convertView;
    }

    @Override
    public int getCount() {
        return this.filteredList.size();
    }

    // Filter traits according to character input
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        filteredList.clear();
        if (charText.length() == 0) {
            filteredList.addAll(championsList);
        } else {
            filteredList.clear();
            for (Champions champions : championsList) {
                if (champions.getTag().toLowerCase(Locale.getDefault()).contains(charText)) {
                    filteredList.add(champions);
                }
            }
        }
        notifyDataSetChanged();
    }
}




