package com.wwyx.a1v7.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.wwyx.a1v7.Adapters.Champions;
import com.wwyx.a1v7.Adapters.Items;
import com.wwyx.a1v7.Adapters.Traits;
import java.util.ArrayList;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    // Fetching item entries
    public ArrayList<Items> getitems() {
        ArrayList<Items> itemsList = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM Items", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String name = cursor.getString(0);
            String base = cursor.getString(1);
            String stats = cursor.getString(2);
            String description = cursor.getString(3);
            byte[] img = cursor.getBlob(4);

            cursor.moveToNext();

            Items items = new Items(name, base, stats, description, img);
            itemsList.add(items);
        }
        cursor.close();
        return itemsList;
    }

    //Fetching champion entries
    public ArrayList<Champions> getchampions() {
        ArrayList<Champions> championsList = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM Champions", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String champion = cursor.getString(0);
            String traits = cursor.getString(2);
            String ability = cursor.getString(3);
            String abilityDescription = cursor.getString(4);
            String health = cursor.getString(6);
            String mana = cursor.getString(7);
            String armor = cursor.getString(8);
            String magicResist = cursor.getString(9);
            String attackDamage = cursor.getString(10);
            String attackSpeed = cursor.getString(11);
            String range = cursor.getString(12);
            String tag = cursor.getString(13);
            byte[] champIcon = cursor.getBlob(1);
            byte[] abilityIcon = cursor.getBlob(5);

            cursor.moveToNext();

            Champions champions = new Champions(champion, traits, ability, abilityDescription, health, mana, armor,
                    magicResist, attackDamage, attackSpeed, range, tag, champIcon, abilityIcon);
            championsList.add(champions);
        }
        cursor.close();
        return championsList;
    }

    // Fetching trait entries
    public ArrayList<Traits> gettraits() {
        ArrayList<Traits> traitsList = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM Traits", null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String tname = cursor.getString(1);
            String tdescription = cursor.getString(2);
            String benefit = cursor.getString(3);
            String type = cursor.getString(5);
            String tag = cursor.getString(6);
            byte[] icon = cursor.getBlob(0);
            byte[] champions = cursor.getBlob(4);

            cursor.moveToNext();

            Traits traits = new Traits(tname, tdescription, benefit, type, tag, icon, champions);
            traitsList.add(traits);
        }
        cursor.close();
        return traitsList;
    }
}