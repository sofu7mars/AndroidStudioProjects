package pl.pollub.lab_10_zad_2;

import android.animation.ObjectAnimator;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import static java.lang.Math.round;
import static java.lang.Math.toDegrees;
public class MainActivity extends AppCompatActivity implements
        SensorEventListener {
    TextView tv1;
    SensorManager sensorManager;
    Sensor accelerometer, magneticField;
    float[] mAccelerometerData = new float[3];
    float[] mMagnetometerData = new float[3];
    float[] rotationMatrix = new float[9];
    ImageView im3;
    float resultAzimuth, azimuth;
    String strona;

    float[] orientationValues = new float[3];
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textView);
        im3 = findViewById(R.id.imageView3);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            mAccelerometerData = event.values.clone();
        } else {
            mMagnetometerData = event.values.clone();
        }
        SensorManager.getRotationMatrix(rotationMatrix,null,
                mAccelerometerData, mMagnetometerData);
        SensorManager.getOrientation(rotationMatrix, orientationValues);
        azimuth = round(toDegrees(orientationValues[0]));
        if (azimuth < 0) {
            azimuth += 360;
        }

        if (azimuth >= 255 && azimuth <= 285) {
            strona = "Zachód";
        } else if (azimuth >= 345 || azimuth <= 15) {
            strona = "Północ";
        } else if (azimuth >= 75 && azimuth <= 105) {
            strona = "Wschód";
        } else if (azimuth >= 165 && azimuth <= 195) {
            strona = "Południe";
        } else if (azimuth > 285 && azimuth < 345) {
            strona = "Północny zachód";
        } else if (azimuth > 15 && azimuth < 75) {
            strona = "Północny wschód";
        } else if (azimuth > 105 && azimuth < 165) {
            strona = "Południowy wschód";
        } else if (azimuth > 195 && azimuth < 285) {
            strona = "Południowy zachód";
        }


        tv1.setText("Azimuth: " +
                String.valueOf(azimuth) + " º " + strona);
                float currentRotation = im3.getRotation();
                float delta = ((azimuth - currentRotation + 540) % 360) - 180;
                ObjectAnimator animator = ObjectAnimator.ofFloat(im3, "rotation",
                        currentRotation, currentRotation + delta);
                animator.setDuration(300);
                animator.setInterpolator(new LinearInterpolator());
                animator.start();
    }
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    protected void onResume() {
        super.onResume();
        accelerometer =
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer,
                SensorManager.SENSOR_DELAY_NORMAL, SensorManager.SENSOR_DELAY_UI);
        magneticField =
                sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sensorManager.registerListener(this, magneticField,
                SensorManager.SENSOR_DELAY_NORMAL, SensorManager.SENSOR_DELAY_UI);
    }
}