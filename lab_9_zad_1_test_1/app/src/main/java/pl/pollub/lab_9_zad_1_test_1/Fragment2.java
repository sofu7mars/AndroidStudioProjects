package pl.pollub.lab_9_zad_1_test_1;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class Fragment2 extends Fragment {
    private int selectedPosition = -1;
    private int prevPosition = -1;
    int[] images = {R.drawable.poland, R.drawable.denmark, R.drawable.france};
    int[] hymn = {R.raw.poland, R.raw.denmark, R.raw.france};
    MediaPlayer mp;
    double StartTime;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;


    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public Fragment2() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        getParentFragmentManager().setFragmentResultListener("data",
                this,
                            (requestKey, bundle) -> {
                                selectedPosition = bundle.getInt("position", 0);
                    }
                );
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_3, container, false);

    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button1 = view.findViewById(R.id.button1);
        Button button2 = view.findViewById(R.id.button2);
        Button button3 = view.findViewById(R.id.button3);
        ImageView im1 = view.findViewById(R.id.imageView2);
        button2.setOnClickListener(v -> {
            if (mp != null && mp.isPlaying()) {
                StartTime = mp.getCurrentPosition();
                mp.pause();
            }
        });
        button1.setOnClickListener(v -> {
            if (mp == null) {
                //mp = new MediaPlayer.create(this, R.raw.sofia);
                mp = MediaPlayer.create(requireContext(), hymn[selectedPosition]);
                prevPosition = selectedPosition;
                im1.setImageResource(images[selectedPosition]);

            } else if (prevPosition != selectedPosition) {
                StartTime = 0;
                mp.stop();
                mp = MediaPlayer.create(requireContext(), hymn[selectedPosition]);
                im1.setImageResource(images[selectedPosition]);
            }
            if (!mp.isPlaying()) {
                mp.seekTo((int) StartTime);
                mp.start();
            }
        });
        button3.setOnClickListener(v -> {
            if (mp != null && mp.isPlaying()) {
                StartTime = 0;
                mp.stop();
                mp = null;

            }
        });
    }
}