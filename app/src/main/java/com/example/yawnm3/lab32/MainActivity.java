package com.example.yawnm3.lab32;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private CheckBox checkBoxSmoker;
    private RadioButton radioButtonMale, radioButtonFemale;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerAge = (Spinner) findViewById(R.id.spinnerAge);
        radioGroupGender = (RadioGroup) findViewById(R.id.radioGroupGender);
        radioButtonMale = (RadioButton) findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton) findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = (CheckBox) findViewById(R.id.checkBox);
        textViewPremium = (TextView) findViewById(R.id.textViewPremium);

        //Create the adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.age_group, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerAge.setOnItemSelectedListener(this);
        spinnerAge.setAdapter(adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    Toast.makeText(this, "Position:" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view)
    {
        double premium = 0.0;
        int pos;
        pos = spinnerAge.getSelectedItemPosition();

        int indexGender;
        indexGender = radioGroupGender.getCheckedRadioButtonId();
        if(indexGender == R.id.radioButtonMale)
        {
            premium = calculateMalePremium(pos);
        }
        else
        {
            premium = calculateFemalePremium(pos);
        }



        //Display premium
        textViewPremium.setText(getString(R.string.premium) + premium);
    }

    public boolean isSmoker()
    {
        if(checkBoxSmoker.isChecked())
            return true;
        else
            return false;
    }

    public double calculateMalePremium(int pos)
    {
        double totalPremium = 0.0;

        switch(pos) {
            case 0:
                totalPremium += 50.0;
                break;
            case 1:
                totalPremium += 55.0;
                break;
            case 2:
                totalPremium += 110.0;
                break;
            case 3:
                totalPremium += 170.0;
                if (isSmoker()) {
                    totalPremium += 100.0;
                }
                break;
            case 4:
                totalPremium += 220.0;
                if (isSmoker()) {
                    totalPremium += 150.0;
                }
                break;
            case 5:
                totalPremium += 210.0;
                if (isSmoker()) {
                    totalPremium += 150.0;
                }
                break;
            case 6:
                totalPremium += 200.0;
                if (isSmoker()) {
                    totalPremium += 250.0;
                }
                break;
            case 7:
                totalPremium += 250.0;
                if (isSmoker()) {
                    totalPremium += 100;
                }
                break;
            default:
                break;
        }

        return totalPremium;
    }

    public double calculateFemalePremium(int pos)
    {
        double totalPremium = 0.0;

        switch(pos) {
            case 0:
                totalPremium += 50.0;
                break;
            case 1:
                totalPremium += 55.0;
                break;
            case 2:
                totalPremium += 60.0;
                break;
            case 3:
                totalPremium += 70.0;
                if (isSmoker()) {
                    totalPremium += 100.0;
                }
                break;
            case 4:
                totalPremium += 120.0;
                if (isSmoker()) {
                    totalPremium += 150.0;
                }
                break;
            case 5:
                totalPremium += 160.0;
                if (isSmoker()) {
                    totalPremium += 150.0;
                }
                break;
            case 6:
                totalPremium += 200.0;
                if (isSmoker()) {
                    totalPremium += 250.0;
                }
                break;
            case 7:
                totalPremium += 250.0;
                if (isSmoker()) {
                    totalPremium += 100;
                }
                break;
            default:
                break;
        }

        return totalPremium;
    }
}
