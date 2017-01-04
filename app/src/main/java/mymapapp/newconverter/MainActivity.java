package mymapapp.newconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;



public class MainActivity extends AppCompatActivity {

    private static String PARAMS;
    private static String CONV_URL = "http://api.fixer.io/latest?base=USD&symbols=GBP,EUR,JPY"; //


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final Button btnconvert = (Button)findViewById(R.id.btnconvert);
        final TextView result = (TextView)findViewById(R.id.result);
        final Spinner fromspin =(Spinner)findViewById(R.id.from);
        final Spinner tospin =(Spinner)findViewById(R.id.to);
        final EditText curriency = (EditText)findViewById(R.id.currency);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.conversions, android.R.layout.simple_spinner_item);

        fromspin.setAdapter(adapter);
        tospin.setAdapter(adapter);



        btnconvert.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String from = fromspin.getSelectedItem().toString();
                String to = tospin.getSelectedItem().toString();
                Double dollar = Double.parseDouble(curriency.getText().toString());
                FetchConversionRateTask task = new FetchConversionRateTask(result, dollar);
                    result.setText("fetching ...");
                    task.execute(from, to);


            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //adds items on the for action_setting on menu.xml
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        //gets the item from the menu.xml
        int id = item.getItemId();
        if (id == R.id.action_settings)
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


