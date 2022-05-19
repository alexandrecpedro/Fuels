package com.app.fuels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    /** Attributes **/
    private TextInputEditText editPriceAlcohol, editPriceGasoline;
    private TextView textResult;

    /** Methods **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Instancing attributes
        editPriceAlcohol    = findViewById(R.id.editPriceAlcohol);
        editPriceGasoline   = findViewById(R.id.editPriceGasoline);
        textResult          = findViewById(R.id.textResult);
    }

    public void calculatePrice(View view) {
        // Recovering entered fuel prices
        String priceAlcohol  = editPriceAlcohol.getText().toString();
        String priceGasoline = editPriceGasoline.getText().toString();

        // Validating fields
        Boolean validatedFields = validateFields(priceAlcohol, priceGasoline);
        if (validatedFields) {
            // Convert string to numbers
            Double valueAlcohol = Double.parseDouble(priceAlcohol);
            Double valueGasoline = Double.parseDouble(priceGasoline);

            // Find out the best fuel for a vehicle
            /* If (valueAlcohol / valueGasoline) >= 0.7, gasoline is advantageous!
            * else, it's better to use alcohol! */
            Double result = valueAlcohol / valueGasoline;
            if ( result >= 0.7) {
                textResult.setText("Melhor utilizar Gasolina");
            } else {
                textResult.setText("Melhor utilizar Álcool");
            }

        } else {
            textResult.setText("Preencha os campos primeiro");
        }
    }

    private Boolean validateFields(String valueAlcohol, String valueGasoline) {
        Boolean validatedFields = true;

        if (valueAlcohol == null || valueAlcohol.isEmpty()) {
            validatedFields = false;
        } else if (valueGasoline == null || valueGasoline.isEmpty()) {
            validatedFields = false;
        }
        return validatedFields;
    }
}