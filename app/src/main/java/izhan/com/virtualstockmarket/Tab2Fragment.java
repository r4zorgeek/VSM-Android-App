package izhan.com.virtualstockmarket;

import android.hardware.input.InputManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by mane on 20/10/18.
 */

public class Tab2Fragment extends Fragment {
    private EditText mEditText;
    private TextView mTextView;
    private Button mButton;
    // private FetchStock mFetchStock;
    public static Double stockPrice;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        mEditText = (EditText) view.findViewById(R.id.quoteStockName);
        mTextView = (TextView) view.findViewById(R.id.displayStockPrice);
        mButton = (Button) view.findViewById(R.id.quoteGetStockName);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getStockPrice();
                InputMethodManager imm = (InputMethodManager) getContext().getSystemService(MainActivity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                if (stockPrice != null) {
                    Log.d("Double Stock P", stockPrice.toString());
                }

            }
        });

        return view;
    }

    public void getStockPrice() {
        String queryString = mEditText.getText().toString();
        new FetchStock(mTextView).execute(queryString);
    }
}
