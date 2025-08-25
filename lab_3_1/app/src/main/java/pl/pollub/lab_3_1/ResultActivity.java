package pl.pollub.lab_3_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class ResultActivity extends AppCompatActivity {
    String name;
    int age, yearOfBirth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView tv1 = findViewById(R.id.textView);
        TextView tv2 = findViewById(R.id.textView2);
        name = getIntent().getStringExtra("name");
        age = getIntent().getIntExtra("age", 0);
        tv1.setText("Hello " + name);
        tv2.setText("You are " + String.valueOf(age) + " years old");
    }
    public void finish() {
        Intent i = new Intent();
        i.putExtra("name", name);
        yearOfBirth = Calendar.getInstance().get(Calendar.YEAR) - age;
        i.putExtra("year", yearOfBirth);
        setResult(RESULT_OK, i);
        super.finish();
    }
}

