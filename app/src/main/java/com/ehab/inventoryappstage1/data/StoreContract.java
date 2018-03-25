package com.ehab.inventoryappstage1.data;

import android.provider.BaseColumns;

/**
 * Created by ehabhamdy on 3/25/18.
 */

public class StoreContract {
    public static final class InventoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "inventory";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_PRODUCT_NAME = "product_name";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_QUANTITY = "current_stock";
        public static final String COLUMN_SUPPLIER_NAME = "supplier_name";
        public static final String COLUMN_SUPPLIER_PHONE = "supplier_phone";
        public static final String COLUMN_SUPPLIER_COUNTRY = "supplier_country";
    }
}
