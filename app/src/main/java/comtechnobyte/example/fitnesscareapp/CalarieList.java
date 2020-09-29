package comtechnobyte.example.fitnesscareapp;



import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

public class CalarieList extends ArrayAdapter<CalHelper> {

    private Activity context;
    private List<CalHelper> healthList;

    public CalarieList(@NonNull Activity context, List<CalHelper> healthList) {
        super(context, R.layout.activity_calarie_list, healthList);

        this.context = context;
        this.healthList = healthList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        @SuppressLint("ViewHolder") View listViewItem=inflater.inflate(R.layout.activity_calarie_list,null,true);

        TextView textViewBlood=(TextView) listViewItem.findViewById(R.id.textViewBlood);
        TextView textViewGender=(TextView) listViewItem.findViewById(R.id.textViewGender);
        TextView textViewPressure=(TextView) listViewItem.findViewById(R.id.textViewPressure);
        TextView textViewSugar=(TextView) listViewItem.findViewById(R.id.textViewSugar);
        TextView textViewCholesterol=(TextView) listViewItem.findViewById(R.id.textViewCholesterol);
        TextView textViewDate=(TextView) listViewItem.findViewById(R.id.textViewDate);

        CalHelper addhelper=healthList.get(position);

        textViewBlood.setText(addhelper.getBlood());
        textViewGender.setText(addhelper.getGender());
        textViewPressure.setText(addhelper.getPressure());
        textViewSugar.setText(addhelper.getSugar());
        textViewCholesterol.setText(addhelper.getCholesterol());
        textViewDate.setText(addhelper.getDate());

        return listViewItem;

    }
}