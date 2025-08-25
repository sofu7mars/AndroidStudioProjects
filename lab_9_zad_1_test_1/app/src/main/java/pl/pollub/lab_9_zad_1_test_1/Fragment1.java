package pl.pollub.lab_9_zad_1_test_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends ListFragment {
    ArrayList<String> countries = new ArrayList<>(Arrays.asList("Poland", "Denmark", "France"));
    ArrayAdapter<String> adapter;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    public Fragment1() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, viewGroup, false);
        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, countries);
        setListAdapter(adapter);
        return view;
    }
    public void onListItemClick(ListView listView, View view, int position, long id) {
        Bundle result = new Bundle();
        result.putInt("position", position);
        getParentFragmentManager().setFragmentResult("data", result);
        getListView().setSelector(android.R.color.holo_blue_dark);

    }
}