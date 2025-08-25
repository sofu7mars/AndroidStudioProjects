package pl.pollub.lab_11_zad_1;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView im1, im2, im3;
    TTSManager ttsManager = null;
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
        im1 = findViewById(R.id.imageButton);
        im2 = findViewById(R.id.imageButton2);
        im3 = findViewById(R.id.imageButton3);
        ttsManager = new TTSManager();
        ttsManager.init(this);

        im1.setOnClickListener(createClickListener("Яблоко"));
        im2.setOnClickListener(createClickListener("Грушка"));
        im3.setOnClickListener(createClickListener("Слива"));
    }
    View.OnClickListener createClickListener(final String text) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ttsManager.initQueue(text);
            }
        };
    }

    public void onDestroy() {
        super.onDestroy();;
        ttsManager.shutDown();;
    }
}