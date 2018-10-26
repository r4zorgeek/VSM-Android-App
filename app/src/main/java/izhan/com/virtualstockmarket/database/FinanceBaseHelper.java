package izhan.com.virtualstockmarket.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.net.FileNameMap;

/**
 * Created by mane on 23/10/18.
 */

public class FinanceBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "finance1.db";

    public FinanceBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create users table
        db.execSQL(
                "create table " + FinanceSchema.UsersTable.NAME
        + "("
        + FinanceSchema.UsersTable.Cols.RId
        + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" + ","
        + FinanceSchema.UsersTable.Cols.UserName + " TEXT NOT NULL" + ","
        + FinanceSchema.UsersTable.Cols.HashPass + " TEXT NOT NULL" + ","
        + FinanceSchema.UsersTable.Cols.UserCash + " NUMERIC NOT NULL DEFAULT 10000.00" + ")"
        );

        // create purchase table
        db.execSQL(
                "create table " + FinanceSchema.PurchaseTable.NAME
        + "("
        + "_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" + ","
        + FinanceSchema.PurchaseTable.Cols.RId + " INTEGER NOT NULL" + ","
        + FinanceSchema.PurchaseTable.Cols.StockName + " TEXT NOT NULL" + ","
        + FinanceSchema.PurchaseTable.Cols.NofStocks + " INTEGER NOT NULL" + ","
        + FinanceSchema.PurchaseTable.Cols.StockPrice + " REAL NOT NULL"
        + ")"
        );

        // create history table
        db.execSQL(
                "create table " + FinanceSchema.HistoryTable.NAME
                + "("
                        + "_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" + ","
                        + FinanceSchema.HistoryTable.Cols.RId + " INTEGER NOT NULL" + ","
                        + FinanceSchema.HistoryTable.Cols.StockName + " TEXT" + ","
                        + FinanceSchema.HistoryTable.Cols.NofStocks + " INTEGER" + ","
                        + FinanceSchema.HistoryTable.Cols.StockPrice + " REAL" + ","
                        + FinanceSchema.HistoryTable.Cols.time + " TEXT" + ","
                        + FinanceSchema.HistoryTable.Cols.TyPurchase + " TEXT"
                + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
