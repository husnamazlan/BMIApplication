package net.nadhkan.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button calculate;
    private Button about;
    private EditText weight, height;
    private TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        about = (Button) findViewById(R.id.btnAbout);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                openMainActivity2();
            }
        });


        calculate=findViewById(R.id.btnCalculate);
        weight = findViewById(R.id.etWeight);
        height = findViewById(R.id.etHeight);
        results = findViewById(R.id.tvResults);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String getW=weight.getText().toString();
                String getH=height.getText().toString();

                float W=Float.parseFloat(getW);
                float H=Float.parseFloat(getH);

                float newH = H/100;
                float bmi = W/(newH*newH);

                if(bmi<18.5)
                {
                    results.setText("Underweight \n Your Health Risk: Malnutrition Risk");
                }

                else if (bmi>18.5 && bmi<24.9)
                {
                    results.setText("Underweight \n Your Health Risk: Low Risk");
                }

                else if (bmi>25 && bmi<29.9)
                {
                    results.setText("Overweight \n Your Health Risk: Enchanced Risk");
                }

                else if (bmi>30 && bmi<34.9)
                {
                    results.setText("Moderately Obese \n Your Health Risk: Medium Risk");
                }

                else if (bmi>35 && bmi<39.9)
                {
                    results.setText("Severely Obese \n Your Health Risk: High Risk");
                }

                else
                {
                    results.setText("Very Severely Obese \n Your Health Risk: Very High Risk");
                }
            }
        });
    }

    public void openMainActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}