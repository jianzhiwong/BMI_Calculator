package my.edu.tarc.bmi_calculator;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG_BMI = "my.edu.tarc.bmi_calculator.BMI";
    private static final int REQUEST_REPLY_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkBMI(View view) {
        EditText editWeight;
        editWeight = findViewById(R.id.textWeight);
        EditText editHeight;
        editHeight = findViewById(R.id.textHeight);
        if(TextUtils.isEmpty(editWeight.getText())) {
            editWeight.setError(getString(R.string.error_message));
            return;
        }else if(TextUtils.isEmpty(editHeight.getText())){
            editHeight.setError(getString(R.string.error_message));
            return;
        }

        //Explicit Intent
        Intent intent = new Intent(this, Main2Activity.class);
        float height;
        height = Float.valueOf(editHeight.getText().toString())/100;
        float weight;
        weight = Float.valueOf(editWeight.getText().toString());
        float BMI;
        BMI = weight/(height*height);

        intent.putExtra(TAG_BMI, String.format("%.2f", BMI));
        startActivityForResult(intent,REQUEST_REPLY_CODE);
    }
}
