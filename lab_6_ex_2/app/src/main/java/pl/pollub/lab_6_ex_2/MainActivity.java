package pl.pollub.lab_6_ex_2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageButton ib1, ib2, ib3;
    MediaPlayer mp;
    double StartTime;
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
        ib1 = findViewById(R.id.imageButton);
        ib2 = findViewById(R.id.imageButton2);
        ib3 = findViewById(R.id.imageButton3);

        //ib1.setOnClickListener(this);
        //ib2.setOnClickListener(this);
        //ib3.setOnClickListener(this);


    }

    public void onClick(View v) {
        if (v.equals(ib1))  {
            if (mp != null && mp.isPlaying()) {
                StartTime = mp.getCurrentPosition();
                mp.pause();
            }
        } else if (v.equals(ib2)) {
            if (mp == null) {
                //mp = new MediaPlayer.create(this, R.raw.sofia);
                mp = MediaPlayer.create(this, R.raw.sofia);

            }
            if (!mp.isPlaying()) {
                mp.seekTo((int) StartTime);
                mp.start();
            }
        } else {
            if (mp != null && mp.isPlaying()) {
                StartTime = 0;
                mp.stop();
                mp = null;
            }
        }
    }
}