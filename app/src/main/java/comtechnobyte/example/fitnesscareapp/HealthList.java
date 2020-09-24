package comtechnobyte.example.fitnesscareapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class HealthList extends ArrayAdapter<addHelper> {


    private Activity context;
    private List<addHelper> healthList;

    public HealthList(@NonNull Activity context, List<addHelper> healthList) {
        super(context, R.layout.health_list, healthList);

        this.context = context;
        this.healthList = healthList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        View listViewItem=inflater.inflate(R.layout.health_list,null,true);

        TextView textViewBlood=(TextView) listViewItem.findViewById(R.id.textViewBlood);
        TextView textViewGender=(TextView) listViewItem.findViewById(R.id.textViewGender);
        TextView textViewPressure=(TextView) listViewItem.findViewById(R.id.textViewPressure);
        TextView textViewSugar=(TextView) listViewItem.findViewById(R.id.textViewSugar);
        TextView textViewCholesterol=(TextView) listViewItem.findViewById(R.id.textViewCholesterol);
        TextView textViewDate=(TextView) listViewItem.findViewById(R.id.textViewDate);

        addHelper addhelper=healthList.get(position);

        textViewBlood.setText(addhelper.getBlood());
        textViewGender.setText(addhelper.getGender());
        textViewPressure.setText(addhelper.getPressure());
        textViewSugar.setText(addhelper.getSugar());
        textViewCholesterol.setText(addhelper.getCholesterol());
        textViewDate.setText(addhelper.getDate());

        return listViewItem;

    }
}
