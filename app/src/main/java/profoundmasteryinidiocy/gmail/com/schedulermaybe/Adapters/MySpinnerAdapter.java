package profoundmasteryinidiocy.gmail.com.schedulermaybe.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import profoundmasteryinidiocy.gmail.com.schedulermaybe.R;
import java.util.List;

public class MySpinnerAdapter extends ArrayAdapter<String> {
    // Initialise custom font, for example:
    Typeface font = Typeface.createFromAsset(getContext().getAssets(),
            "font/open_sans.ttf");

    // (In reality I used a manager which caches the Typeface objects)
    // Typeface font = FontManager.getInstance().getFont(getContext(), BLAMBOT);

    private MySpinnerAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
    }

    // Affects default (closed) state of the spinner
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) super.getView(position, convertView, parent);
        view.setTypeface(font);
//        view.setTextSize();
        return view;
    }

    // Affects opened state of the spinner
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) super.getDropDownView(position, convertView, parent);
        view.setTypeface(font);
        view.setBackgroundColor(ContextCompat.getColor(super.getContext(), R.color.Indigo));
        return view;
    }
}
