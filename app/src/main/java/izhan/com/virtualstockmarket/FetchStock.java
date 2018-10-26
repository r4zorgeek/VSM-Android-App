package izhan.com.virtualstockmarket;

import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.nio.DoubleBuffer;

/**
 * Created by mane on 21/10/18.
 */

public class FetchStock extends AsyncTask<String, Void, String> {
    private WeakReference<TextView> mTextView;
    private static String stockPrice;


    FetchStock(TextView displayStockPrice) {
        this.mTextView = new WeakReference<>(displayStockPrice);
    }


    @Override
    protected String doInBackground(String... strings) {
        try {
            stockPrice = NetworkUtils.getStockPrice(strings[0]);
            return stockPrice;
        }
        catch (Exception e) {}
        return stockPrice;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mTextView.get().setText("Price is: " + s);
        Tab2Fragment.stockPrice = Double.parseDouble(s);
    }

    /*
    public String getPrice() {
        return stockPrice;
    }
    */
}
