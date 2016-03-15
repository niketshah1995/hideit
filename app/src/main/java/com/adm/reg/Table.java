package com.adm.reg;

import android.provider.BaseColumns;

/**
 * Created by Administrator on 12/30/2015.
 */
public class Table {
    public Table()
    {

    }
    public static abstract class TableInfo implements BaseColumns
    {
        public static final String DATABASENAME = "registerr_details.db";
        public static final String TABLENAME = "register_details_table";
        public static final String ID="id";
        public static final String FIRSTNAME = "firstnames";
        public static final String LASTNAME = "lastnames";
        public static final String EMAIL = "emailids";
        public static final String PHONENUMBER ="phonenos";
        public static final String PASSWORD="passwords";
    }
}
