package izhan.com.virtualstockmarket.database;

/**
 * Created by mane on 23/10/18.
 */

public class FinanceSchema {
    public static final class UsersTable {
        public static final String NAME = "users";

        public static final class Cols {
            public static final String RId = "_id";
            public static final String UserName = "username";
            public static final String HashPass = "hash";
            public static final String UserCash = "cash";
        }
    }

    public static final class PurchaseTable {
        public static final String NAME = "purchase";

        public static final class Cols {
            public static final String RId = "user_id";
            public static final String StockName = "stockname";
            public static final String NofStocks = "nstocks";
            public static final String StockPrice = "price";
        }
    }

    public static final class HistoryTable {
        public static final String NAME = "history";

        public static final class Cols {
            public static final String RId = "user_id";
            public static final String StockName = "stockname";
            public static final String NofStocks = "nstocks";
            public static final String StockPrice = "price";
            public static final String time = "time";
            public static final String TyPurchase = "ty_purchase";
        }
    }
}
