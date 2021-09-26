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
    AreaConverter areaConverter;
    VolumeConverter volumeConverter;
    LengthConverter lengthConverter;
    AngleConverter angleConverter;

    int spinnerConvertedToIndex,
        spinnerConvertedFromIndex,
        spinnerConversionTypeIndex;

    boolean isDecimalEntered;

    Spinner spinnerConvertedFrom,
            spinnerConvertedTo,
            spinnerConversionType;

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

    String[] converterTypes = {
      "Area",
      "Volume",
      "Length",
      "Angle"
    };

    ArrayAdapter<String> converterAdapter;

    /*
    *
    * This function is setting the string into the editTextConvertedTo edit text field
    *
    */
    public void setResult(String result) {
        if (!editTextConvertedFrom.getText().toString().isEmpty()) {
            editTextConvertedTo.setText(result);
        }
    }

    /*
    *
    * This function is setting the the text according the selected spinner type so the result would be according to the selected type and conversions
    *
    */
    private void convert() {
        switch(spinnerConversionTypeIndex) {
            case 0:
                setResult(
                        areaConverter.getResult(
                                Double.parseDouble(editTextConvertedFrom.getText().toString()),
                                spinnerConvertedFromIndex,
                                spinnerConvertedToIndex)
                );
                break;
            case 1:
                setResult(
                        volumeConverter.getResult(
                                Double.parseDouble(editTextConvertedFrom.getText().toString()),
                                spinnerConvertedFromIndex,
                                spinnerConvertedToIndex)
                );
                break;
            case 2:
                setResult(
                        lengthConverter.getResult(
                                Double.parseDouble(
                                        editTextConvertedFrom.getText().toString()),
                                        spinnerConvertedFromIndex,
                                        spinnerConvertedToIndex)
                );
                break;
            case 3:
                setResult(
                        angleConverter.getResult(
                                Double.parseDouble(editTextConvertedFrom.getText().toString()),
                                spinnerConvertedFromIndex,
                                spinnerConvertedToIndex)
                );
                break;
        }
    }

    /*
    *
    * This function is setting up the adapter according to the need of which type of conversion is selected
    *
    */
    private void setAdapter(String[] arrays) {
        converterAdapter = new ArrayAdapter<>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,arrays);

        spinnerConvertedFrom.setAdapter(converterAdapter);
        spinnerConvertedTo.setAdapter(converterAdapter);
    }

    /*
     *
     * This function is setting up the adapter
     *
     */
    private void setSpinners() {
        switch(spinnerConversionTypeIndex) {
            case 0:
                setAdapter(AreaConverter.areaTypes); break;
            case 1:
                setAdapter(VolumeConverter.volumeTypes); break;
            case 2:
                setAdapter(LengthConverter.lengthTypes); break;
            case 3:
                setAdapter(AngleConverter.angleTypes); break;
        }
    }

    private void setFullText() {
        String convertFromText = "Convert From: ";
        String convertToText = "Convert To: ";
        switch(spinnerConversionTypeIndex) {
            case 0:
                convertFromText += areaConverter.getFullName(spinnerConvertedFromIndex);
                convertToText += areaConverter.getFullName(spinnerConvertedToIndex);
                textViewConvertedFrom.setText(convertFromText);
                textViewConvertedTo.setText(convertToText);
                break;
            case 1:
                convertFromText += volumeConverter.getFullName(spinnerConvertedFromIndex);
                convertToText += volumeConverter.getFullName(spinnerConvertedToIndex);
                textViewConvertedFrom.setText(convertFromText);
                textViewConvertedTo.setText(convertToText);
                break;
            case 2:
                convertFromText += lengthConverter.getFullName(spinnerConvertedFromIndex);
                convertToText += lengthConverter.getFullName(spinnerConvertedToIndex);
                textViewConvertedFrom.setText(convertFromText);
                textViewConvertedTo.setText(convertToText);
                break;
            case 3:
                convertFromText += angleConverter.getFullName(spinnerConvertedFromIndex);
                convertToText += angleConverter.getFullName(spinnerConvertedToIndex);
                textViewConvertedFrom.setText(convertFromText);
                textViewConvertedTo.setText(convertToText);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isDecimalEntered = false;

        areaConverter = new AreaConverter();
        volumeConverter = new VolumeConverter();
        lengthConverter = new LengthConverter();
        angleConverter = new AngleConverter();

        ArrayAdapter<String> converterTypeAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,converterTypes);

        spinnerConvertedFrom = findViewById(R.id.spinner_converted_from);
        spinnerConvertedTo = findViewById(R.id.spinner_converted_to);
        spinnerConversionType = findViewById(R.id.converter_type_spinner);

        spinnerConversionType.setAdapter(converterTypeAdapter);

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
                    convert();
                }
            }
        });

        spinnerConvertedFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerConvertedFromIndex = i;

                if (!editTextConvertedFrom.getText().toString().isEmpty()) {
                    convert();
                }
                setFullText();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });

        spinnerConvertedTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                spinnerConvertedToIndex = i;
                if (!editTextConvertedFrom.getText().toString().isEmpty()) {
                    convert();
                }
               setFullText();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });

        spinnerConversionType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerConversionTypeIndex = i;
                spinnerConvertedToIndex = 0;
                spinnerConvertedFromIndex = 0;
                setSpinners();
                setFullText();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });


        editTextConvertedFrom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!editTextConvertedFrom.getText().toString().isEmpty()) {
                    convert();
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!editTextConvertedFrom.getText().toString().isEmpty()) {
                    convert();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editTextConvertedFrom.getText().toString().isEmpty()) {
                    convert();
                }
            }
        });
    }
}