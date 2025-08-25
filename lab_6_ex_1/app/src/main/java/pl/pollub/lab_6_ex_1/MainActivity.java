package pl.pollub.lab_6_ex_1;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView iv1;
    AudioAttributes audioAttributes;
    SoundPool mySound;
    int bugleSound, fluteSound;
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
        iv1 = findViewById(R.id.imageView);
        audioAttributes = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_GAME)
                .build();
        mySound = new SoundPool.Builder()
                .setMaxStreams(2)
                .setAudioAttributes(audioAttributes)
                .build();
        bugleSound = mySound.load(this, R.raw.reveille, 1);
        fluteSound = mySound.load(this, R.raw.rhapsody, 1);

    }
    public void play(View v) {
        if (v.equals(iv1)) {
            mySound.play(bugleSound, 0.9f, 0.9f, 1, 0, 1);

        } else {
            mySound.play(fluteSound, 0.9f, 0.9f, 1, 0, 1);

        }
    }
}