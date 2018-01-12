package com.example.android.phonenumberspinner;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public String mSpinnerLabel = "";
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create the spinner agan
        Spinner spinner = (Spinner) findViewById(R.id.label_spiner);
        if(spinner != null){
            spinner.setOnItemSelectedListener(this);
        }
        //	Create	ArrayAdapter	using	the	string	array	and	default	spinner	layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);
        //S
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Appply the adapter to spinner
        if(spinner != null){
            spinner.setAdapter(adapter);
        }


    }

    public void showText(View view){
        EditText editText = (EditText) findViewById(R.id.editText_Phone);

        if (editText != null){
            String showString = (editText.getText().toString() + " - " + mSpinnerLabel);
            Toast.makeText(this, showString, Toast.LENGTH_SHORT).show();
            TextView viewTeks = (TextView) findViewById(R.id.text_phonelabel);
            viewTeks.setText(showString);

        }
    }



    public  void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
        mSpinnerLabel = adapterView.getItemAtPosition(i).toString();
        showText(view);
    }

    public void onNothingSelected(AdapterView<?> adapterView){
        Log.d(TAG, "onNothingSelected");
    }
}
