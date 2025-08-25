package pl.pollub.lab_3_z1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class third_activity extends AppCompatActivity {
    int iteration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button b3 = findViewById(R.id.button2);
        TextView tv3 = findViewById(R.id.textView3);
        iteration = getIntent().getIntExtra("iteration", 0);
        tv3.setText("Iteration: " + String.valueOf(iteration));
    }
    /*public void finish(View v) {
        iteration = iteration + 1;
        Intent i = new Intent();
        i.putExtra("iteration", iteration);
        setResult(RESULT_OK, i);
        super.finish();
    }*/
    public void finish(View v) {
        iteration = iteration + 1;
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("iteration", iteration);
        startActivity(i);
    }
}