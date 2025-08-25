package pl.pollub.lab_6_zad_1;

import android.media.DrmInitData;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    RadioButton rb1, rb2, rb3;
    private MediaPlayer mp;
    Button b1;


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
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);

        b1 = findViewById(R.id.button);



    }
    public void playMusic(View v) {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
        if (rb1.isChecked()) {

            mp = MediaPlayer.create(this, R.raw.clip_1);

        } else if (rb2.isChecked()) {
            mp = MediaPlayer.create(this, R.raw.cli_2_1);

        } else if (rb3.isChecked()) {
            mp = MediaPlayer.create(this, R.raw.clip_3);
        }

        if (mp != null) {
            mp.start();
        }
    }



}