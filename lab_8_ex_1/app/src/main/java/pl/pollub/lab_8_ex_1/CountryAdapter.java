package pl.pollub.lab_8_ex_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends ArrayAdapter<Country> {
    private Context myContext;
    private List<Country> countriesList;

    public CountryAdapter(Context context, ArrayList<Country> list) {
        super(context, 0, list);
        myContext = context;
        countriesList = list;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(myContext).
                    inflate(R.layout.list_item,parent,false);
        Country currentCountry = countriesList.get(position);
        ImageView iv = listItem.findViewById(R.id.imageView);
        iv.setImageResource(currentCountry.getPhoto());
        TextView tv1 = listItem.findViewById(R.id.textView);
        tv1.setText(currentCountry.getName());
        TextView tv2 = listItem.findViewById(R.id.textView2);
        tv2.setText(currentCountry.getMail());
        TextView tv3 = listItem.findViewById(R.id.textView3);
        tv3.setText(currentCountry.getPhone());
        return listItem;
    }

}
