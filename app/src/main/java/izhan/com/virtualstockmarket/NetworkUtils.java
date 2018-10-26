package izhan.com.virtualstockmarket;

import android.net.Uri;
import android.util.Log;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by mane on 21/10/18.
 */

public class NetworkUtils {
    // Base URL for Stock API.
    private static final String STOCK_BASE_URL =  "https://www.alphavantage.co/query?";
    // Parameter for the Stock Function.
    private static final String QUERY_PARAM = "function";
    // Parameter for stock symbol.
    private static final String STOCK_SYMBOL = "symbol";
    // Parameter for interval.
    private static final String TIME_INTERVAL = "interval";
    // Parameter for api key.
    private static final String API_KEY = "apikey";
    // Parameter for data type.
    private static final String DATA_TYPE = "datatype";


    static String getStockPrice(String queryString) throws Exception {
        CSVReader csvReader;
        URL requestUrl;
        HttpsURLConnection urlConnection = null;
        BufferedReader reader = null;
        String stockPrice = null;


        // Building API Url.
        Uri builtURI = Uri.parse(STOCK_BASE_URL).buildUpon()
                .appendQueryParameter(QUERY_PARAM, "TIME_SERIES_INTRADAY")
                .appendQueryParameter(STOCK_SYMBOL, queryString)
                .appendQueryParameter(TIME_INTERVAL, "1min")
                .appendQueryParameter(API_KEY, "6UE3WHYK7LBGQ1UF")
                .appendQueryParameter(DATA_TYPE, "csv")
                .build();

        requestUrl = new URL(builtURI.toString());

        urlConnection = (HttpsURLConnection) requestUrl.openConnection();
        reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        csvReader = new CSVReader(reader);
        String[] record = null;
        record = csvReader.readNext();
        record = csvReader.readNext();

        stockPrice = record[4];
        Log.d("Price", record[4]);

        return stockPrice;
    }

}
