package pl.pollub.lab_11_ex_1;

import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ImageButton speak;
    EditText editText;
    TTSManager ttsManager = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ttsManager = new TTSManager();
        ttsManager.init(this);
        editText = findViewById(R.id.editTextText);
        speak = findViewById(R.id.imageButton);
        speak.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String text = editText.getText().toString();
                ttsManager.initQueue(text);
            }
        });
    }
    public void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }
}