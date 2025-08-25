package pl.pollub.lab_7_ex_1;

import android.content.ClipData;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ImageView apple, basket;
    private TextView tv1, tv2;
    int sucCount, unsucCount;
    AudioAttributes audioAttributes;
    SoundPool mySound;
    int winSound, loseSound;
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

        apple = findViewById(R.id.imageView);
        basket = findViewById(R.id.imageView2);
        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView4);
        audioAttributes = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_GAME)
                                .build();
        mySound = new SoundPool.Builder()
                .setMaxStreams(1)
                        .setAudioAttributes(audioAttributes)
                                .build();
        winSound = mySound.load(this, R.raw.win, 1);
        loseSound = mySound.load(this, R.raw.lose, 1);


        apple.setOnTouchListener( new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(apple);
                v.startDragAndDrop(data, shadow, null, 0);

                return true;
            }
        });
        basket.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                if (event.getAction() == DragEvent.ACTION_DROP) {
                    sucCount = sucCount + 1;
                    tv2.setText("Successful drops: " + String.valueOf(sucCount));
                    mySound.play(winSound, 0.9f, 0.9f, 1, 0, 1);
                } else if (event.getAction() == DragEvent.ACTION_DRAG_ENDED) {
                    if (!event.getResult()) {
                        unsucCount = unsucCount + 1;
                        tv1.setText("Unsuccessful drops: " + String.valueOf(unsucCount));
                        mySound.play(loseSound, 0.9f, 0.9f, 1, 0, 1);
                    }

                }
                return true;
            }
        });
    }
}