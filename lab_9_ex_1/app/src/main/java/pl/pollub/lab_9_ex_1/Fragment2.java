package pl.pollub.lab_9_ex_1;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment2 extends DialogFragment {
    EditText et;
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_2, viewGroup);
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        et = view.findViewById(R.id.editText);
        Button b = view.findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String country = et.getText().toString();
                Fragment1 fr1 = (Fragment1)
                        getFragmentManager().findFragmentById(R.id.list);
                if (!country.equals("")) {
                    fr1.cities.add(country);
                    fr1.adapter.notifyDataSetChanged();
                }
                getActivity().getSupportFragmentManager().beginTransaction()
                        .remove(Fragment2.this).commit();
            }
        });
    }
}