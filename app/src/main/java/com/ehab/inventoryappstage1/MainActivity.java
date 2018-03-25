package com.ehab.inventoryappstage1;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import com.ehab.inventoryappstage1.data.StoreDBHelper;
import com.ehab.inventoryappstage1.data.StoreContract.InventoryEntry;

import static com.ehab.inventoryappstage1.data.StoreContract.InventoryEntry.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showInventoryTableRowCount();

    }

    private void showInventoryTableRowCount() {
        StoreDBHelper mDbHelper = new StoreDBHelper(this);

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCT_NAME, "Processor");
        values.put(COLUMN_PRICE, 300);
        values.put(COLUMN_QUANTITY, 20);
        values.put(COLUMN_SUPPLIER_NAME, "MGM");
        values.put(COLUMN_SUPPLIER_PHONE, 012345);
        values.put(COLUMN_SUPPLIER_COUNTRY, "US");

        db.insert(InventoryEntry.TABLE_NAME, null, values);
        String[] projection = {
                InventoryEntry._ID,
                InventoryEntry.COLUMN_PRODUCT_NAME,
                InventoryEntry.COLUMN_PRICE,
                InventoryEntry.COLUMN_QUANTITY,
                InventoryEntry.COLUMN_SUPPLIER_NAME };

        Cursor cursor = db.query(InventoryEntry.TABLE_NAME, projection, null, null, null, null, null);
        int nameColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_PRODUCT_NAME);
        int priceColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_PRICE);

        try {
            TextView dbTextView = (TextView) findViewById(R.id.databaseInfomationTextView);
            dbTextView.setText("Number of rows in the table: " + cursor.getCount());
            while(cursor.moveToNext()){
                String currentProductName = cursor.getString(nameColumnIndex);
                int currentProductPrice = cursor.getInt(priceColumnIndex);
                dbTextView.append("\n" + currentProductName + " " + currentProductPrice);
            }
        } finally {
            cursor.close();
        }
    }
}
