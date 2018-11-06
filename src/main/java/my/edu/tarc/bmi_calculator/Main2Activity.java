package my.edu.tarc.bmi_calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        if(intent.hasExtra(MainActivity.TAG_BMI)){
            TextView textViewBMI;
            ImageView imageViewBMI;
            textViewBMI = findViewById(R.id.textViewBMI);
            imageViewBMI = findViewById(R.id.imageViewBMI);
            String BMI = intent.getStringExtra(MainActivity.TAG_BMI);
            float valueBMI = Float.valueOf(BMI);
            if(valueBMI < 18.5) {
                textViewBMI.setText("Your BMI is " + BMI + ", you are underweight!");
                imageViewBMI.setImageResource(R.drawable.under);
            }else if(valueBMI < 30) {
                textViewBMI.setText("Your BMI is " + BMI + ", you are normal!");
                imageViewBMI.setImageResource(R.drawable.normal);
            }else{
                textViewBMI.setText("Your BMI is " + BMI + ", you are overweight!");
                imageViewBMI.setImageResource(R.drawable.over);
            }
        }
    }

    public void returnMenu(View view) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }
}
