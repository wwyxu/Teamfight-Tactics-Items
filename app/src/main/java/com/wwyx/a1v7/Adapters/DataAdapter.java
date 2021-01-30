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

public class DataAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Items> itemsList;
    // Second arraylist to accept filtered entries
    private ArrayList<Items> filteredList;

    public DataAdapter(Context context, ArrayList<Items> itemslist) {
        this.context = context;
        this.itemsList = itemslist;
        this.filteredList = new ArrayList<>();
        this.filteredList.addAll(itemslist);
    }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public Object getItem(int position) { return filteredList.get(position); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // Custom listview
        convertView = inflater.inflate(R.layout.list_items, null);

        // Listview components
        TextView name1 = convertView.findViewById(R.id.nameofitem);
        TextView stats1 = convertView.findViewById(R.id.stats);
        TextView description1 = convertView.findViewById(R.id.description);
        ImageView img1 = convertView.findViewById(R.id.completeitem);

        // Remove listview component if entry is null, else set data to component
        Items items = filteredList.get(position);

        name1.setText(items.getName());
        if(items.getStats() ==null ){ stats1.setVisibility(View.GONE); } else stats1.setText(items.getStats());
        if (items.getDescription() ==null ){description1.setVisibility(View.GONE);} else description1.setText(items.getDescription());
        byte[] recordImage = items.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(recordImage, 0, recordImage.length);
        img1.setImageBitmap(bitmap);

        return convertView;
    }

    @Override
    public int getCount() {
        return this.filteredList.size();
    }

    public void noFilter() {
        filteredList = itemsList;
        notifyDataSetChanged();
    }

    // Data filter logic
    private void filterItem(String base) {
        filteredList = new ArrayList<>();
        for (Items item : itemsList) {
            if (item.base.matches(base)) {
                filteredList.add(item);
            }
        }
        notifyDataSetChanged();
    }

    public void filterBF() {
        filterItem(".*Sword.*");
    }

    public void filterRecurve() {
        filterItem(".*Bow.*");
    }

    public void filterRod() {
        filterItem(".*Rod.*");
    }

    public void filterTear() {
        filterItem(".*Tear.*");
    }

    public void filterVest() {
        filterItem(".*Vest.*");
    }

    public void filterCloak() {
        filterItem(".*Cloak.*");
    }

    public void filterBelt() {
        filterItem(".*Belt.*");
    }

    public void filterSpatula() {
        filterItem(".*Spatula.*");
    }

    public void filterGlove() {
        filterItem(".*Gloves.*");
    }

    // Data filter logic
    private void filterCItem(String name) {
        filteredList = new ArrayList<>();
        for (Items item : itemsList) {
            if (item.name.contains(name)) {
                filteredList.add(item);
            }
        }
        notifyDataSetChanged();
    }

    public void filterBotrk() { filterCItem("Blade of the Ruined King"); }

    public void filterBt() {
        filterCItem("Bloodthirster");
    }

    public void filterCblade() {
        filterCItem("Runaan's Hurricane");
    }

    public void filterDark() {
        filterCItem("Mage's Cap");
    }

    public void filterClaw() {
        filterCItem("Dragon's Claw");
    }

    public void filterFon() {
        filterCItem("Force of Nature");
    }

    public void filterHeart() {
        filterCItem("Frozen Heart");
    }

    public void filterMallet() {
        filterCItem("Frozen Mallet");
    }

    public void filterGa() {
        filterCItem("Guardian Angel");
    }

    public void filterGuinsoos() {
        filterCItem("Guinsoo's Rageblade");
    }

    public void filterGunblade() {
        filterCItem("Hextech Gunblade");
    }

    public void filterHush() {
        filterCItem("Hush");
    }

    public void filterIe() {
        filterCItem("Infinity Edge");
    }

    public void filterIonic() {
        filterCItem("Ionic Spark");
    }

    public void filterKnight() {
        filterCItem("Warden's Mail");
    }

    public void filterLocket() {
        filterCItem("Locket of the Iron Solari");
    }

    public void filterLudens() {
        filterCItem("Luden's Echo");
    }

    public void filterMorello() {
        filterCItem("Morellonomicon");
    }

    public void filterPd() {
        filterCItem("Phantom Dancer");
    }

    public void filterDeathcap() {
        filterCItem("Rabadon's Deathcap");
    }

    public void filterFirecannon() {
        filterCItem("Rapid Firecannon");
    }

    public void filterRedbuff() {
        filterCItem("Red Buff");
    }

    public void filterRedemption() {
        filterCItem("Redemption");
    }

    public void filterTalisman() {
        filterCItem("Talisman of Light");
    }

    public void filterSeraphs() {
        filterCItem("Seraph's Embrace");
    }

    public void filterShojin() {
        filterCItem("Spear of Shojin");
    }

    public void filterShiv() {
        filterCItem("Statikk Shiv");
    }

    public void filterSwordbreak() {
        filterCItem("Sword Breaker");
    }

    public void filterThornmail() {
        filterCItem("Thornmail");
    }

    public void filterTitanic() {
        filterCItem("Titanic Hydra");
    }

    public void filterWarmogs() {
        filterCItem("Warmog's Armor");
    }

    public void filteryoumuus() {
        filterCItem("Youmuu's Ghostblade");
    }

    public void filterYuumi() {
        filterCItem("Inferno Cinder");
    }

    public void filterZekes() {
        filterCItem("Zeke's Herald");
    }

    public void filterZephyr() {
        filterCItem("Zephyr");
    }

    public void filterDeathblade() {
        filterCItem("Deathblade");
    }

    public void filterGiantslayer() {
        filterCItem("Giant Slayer");
    }

    public void filterRepeating() {
        filterCItem("Repeating Crossbow");
    }

    public void filterJeweled() {
        filterCItem("Jeweled Gauntlet");
    }

    public void filterJustice() {
        filterCItem("Hand of Justice");
    }

    public void filterIceborne() {
        filterCItem("Iceborne Gauntlet");
    }

    public void filterQuicksilver() {
        filterCItem("Quicksilver");
    }

    public void filterTrap() {
        filterCItem("Trap Claw");
    }

    public void filterMitten() {
        filterCItem("Berserker Axe");
    }

    public void filterthiefs() {
        filterCItem("Thief's Gloves");
    }
}





