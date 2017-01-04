package mymapapp.newconverter;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Scanner;

//used the code from the example to get the conversion
public class FetchConversionRateTask extends AsyncTask<String, String, Double> {


    private static final String CONV_LOOKUP = "ConversionLookup";
    private TextView txtView;

    FetchConversionRateTask(TextView _t, Double dollar) {
        txtView = _t;
    }


    @Override
    protected Double doInBackground(String... currencies) {

        String from = currencies[0];
        String to = currencies[1];

        Scanner scanner = null;
        HttpURLConnection conn = null;
        StringBuilder jsonSB;

        try {
            URL url = new URL("http://api.fixer.io/latest?base=USD&symbols=" + from + "," + to);
            jsonSB = new StringBuilder();
            publishProgress("opening connection");
            conn = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(conn.getInputStream());
            scanner = new Scanner(in);

            // process entire stream
            while (scanner.hasNext()) jsonSB.append(scanner.nextLine());

            String msg = "(" + conn.getResponseCode() +  "):" + conn.getResponseMessage();
            Log.v(CONV_LOOKUP, "Response" + msg);
            publishProgress(msg);
            // TODO handle non-200 errors here

        } catch (IOException e) {
            Log.e(CONV_LOOKUP, e.getMessage());
            return Double.valueOf(-1.0D);
        } finally {
            if (scanner != null) scanner.close();
            if (conn != null) conn.disconnect();
        }

        Double rate = null;
        try {
            rate = new JSONObject(jsonSB.toString()).getJSONObject("rates").getDouble(to);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.v(CONV_LOOKUP, jsonSB.toString());
        return Double.parseDouble(rate.toString());
    }

    protected void onProgressUpdate(String status) {
        txtView.setText(status);
    }

    @Override
    protected void onPostExecute(Double result) {
        txtView.setText(new DecimalFormat("###.####").format(result));
    }


}