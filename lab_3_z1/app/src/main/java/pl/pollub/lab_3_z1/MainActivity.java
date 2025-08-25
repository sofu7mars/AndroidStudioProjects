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

public class MainActivity extends AppCompatActivity {
    int iteration = 0;
    private static final int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button b1 = findViewById(R.id.button);
        TextView tv1 = findViewById(R.id.textView2);
        iteration = getIntent().getIntExtra("iteration", 0);
        tv1.setText("Iteration: " + String.valueOf(iteration));
    }
    public void startIntent(View v) {
        iteration = iteration + 1;
        Intent i = new Intent(this, second_activity.class);
        i.putExtra("iteration", iteration);
        startActivity(i);

    }

}