package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Converter converter;

    int spinnerConvertedToIndex,
        spinnerConvertedFromIndex;

    boolean isDecimalEntered;

    Spinner spinnerConvertedFrom,
            spinnerConvertedTo;

    EditText editTextConvertedFrom,
             editTextConvertedTo;

    TextView textViewConvertedFrom,
             textViewConvertedTo;

    Button button0, button1, button2,
           button3, button4, button5,
           button6, button7, button8,
           button9, buttonBackspace, buttonAC,
           buttonDecimal;

    String text;

    String[] areaTypes = {
            "Sq. mm",
            "Sq. cm",
            "Sq. in",
            "Sq. feet",
            "Sq. m",
            "Sq. km",
            "Sq. miles",
            "Sq. yards",
            "Hectares",
            "Acres"
    };

    String[] areaTypesFullNames = {
            "Square millimeters",
            "Square centimeters",
            "Square inches",
            "Square feet",
            "Square meters",
            "Square kilometers",
            "Square miles",
            "Square yards",
            "Hectares",
            "Acres"
    };

    private void calculateArea() {
        if (!editTextConvertedFrom.getText().toString().isEmpty()) {
            editTextConvertedTo.setText(converter.getResult(Double.parseDouble(editTextConvertedFrom.getText().toString()), spinnerConvertedFromIndex, spinnerConvertedToIndex));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isDecimalEntered = false;
        converter = new Converter();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, areaTypes);
        spinnerConvertedFrom = findViewById(R.id.spinner_converted_from);
        spinnerConvertedTo = findViewById(R.id.spinner_converted_to);

        spinnerConvertedFrom.setAdapter(adapter);
        spinnerConvertedTo.setAdapter(adapter);
        editTextConvertedTo = findViewById(R.id.edit_text_converted_to);
        editTextConvertedFrom = findViewById(R.id.edit_text_converted_from);

        textViewConvertedFrom = findViewById(R.id.converted_from_full_name);
        textViewConvertedTo = findViewById(R.id.converted_to_full_name);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonBackspace = findViewById(R.id.button_backspace);
        buttonAC = findViewById(R.id.button_ac);
        buttonDecimal = findViewById(R.id.button_decimal);

        button0.setOnClickListener(view -> {
            if (!editTextConvertedFrom.getText().toString().isEmpty()) {
                text = editTextConvertedFrom.getText().toString()+"0";
                editTextConvertedFrom.setText(text);
            }
        });

        button1.setOnClickListener(view -> {
            text = editTextConvertedFrom.getText().toString()+"1";
            editTextConvertedFrom.setText(text);
        });

        button2.setOnClickListener(view -> {
            text = editTextConvertedFrom.getText().toString()+"2";
            editTextConvertedFrom.setText(text);
        });

        button3.setOnClickListener(view -> {
            text = editTextConvertedFrom.getText().toString()+"3";
            editTextConvertedFrom.setText(text);
        });

        button4.setOnClickListener(view -> {
            text = editTextConvertedFrom.getText().toString()+"4";
            editTextConvertedFrom.setText(text);
        });

        button5.setOnClickListener(view -> {
            text = editTextConvertedFrom.getText().toString()+"5";
            editTextConvertedFrom.setText(text);
        });

        button6.setOnClickListener(view -> {
            text = editTextConvertedFrom.getText().toString()+"6";
            editTextConvertedFrom.setText(text);
        });

        button7.setOnClickListener(view -> {
            text = editTextConvertedFrom.getText().toString()+"7";
            editTextConvertedFrom.setText(text);
        });

        button8.setOnClickListener(view -> {
            text = editTextConvertedFrom.getText().toString()+"8";
            editTextConvertedFrom.setText(text);
        });

        button9.setOnClickListener(view -> {
            text = editTextConvertedFrom.getText().toString()+"9";
            editTextConvertedFrom.setText(text);
        });

        buttonDecimal.setOnClickListener(view -> {
            if (!isDecimalEntered) {
                if (editTextConvertedFrom.getText().toString().isEmpty()) {
                    text = editTextConvertedFrom.getText().toString()+"0.";
                }
                else {
                    text = editTextConvertedFrom.getText().toString()+".";
                }
                isDecimalEntered = true;
                editTextConvertedFrom.setText(text);
            }
        });

        buttonAC.setOnClickListener(view -> {
            isDecimalEntered = false;
            editTextConvertedFrom.setText(null);
            editTextConvertedTo.setText(null);
        });

        buttonBackspace.setOnClickListener(view -> {
           if(!editTextConvertedFrom.getText().toString().isEmpty()) {
                text = editTextConvertedFrom.getText().toString();
                text = new StringBuffer().append(text).deleteCharAt(text.length()-1).toString();
                editTextConvertedFrom.setText(text);
                if (!text.contains(".")) {
                    isDecimalEntered = false;
                }
                if (text.equals("0")||text.isEmpty()) {
                    editTextConvertedFrom.setText(null);
                    editTextConvertedTo.setText(null);
                }
                else {
                    calculateArea();
                }
            }
        });

        spinnerConvertedFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerConvertedFromIndex = i;
                text = "Convert from: " + areaTypesFullNames[i];
                if (!editTextConvertedFrom.getText().toString().isEmpty()) {
                    calculateArea();
                }
                textViewConvertedFrom.setText(text);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                adapterView.setSelection(1);
                textViewConvertedFrom.setText(areaTypesFullNames[0]);
            }
        });

        spinnerConvertedTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                text = "Convert to: " + areaTypesFullNames[i];
                spinnerConvertedToIndex = i;
                if (!editTextConvertedFrom.getText().toString().isEmpty()) {
                    calculateArea();
                }
                textViewConvertedTo.setText(text);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                adapterView.setSelection(2);
                textViewConvertedTo.setText(areaTypesFullNames[1]);
            }
        });


        editTextConvertedFrom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!editTextConvertedFrom.getText().toString().isEmpty()) {
                    calculateArea();
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!editTextConvertedFrom.getText().toString().isEmpty()) {
                    calculateArea();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editTextConvertedFrom.getText().toString().isEmpty()) {
                    calculateArea();
                }
            }
        });
    }
}