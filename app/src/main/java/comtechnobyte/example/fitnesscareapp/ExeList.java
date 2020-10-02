package comtechnobyte.example.fitnesscareapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ExeList extends ArrayAdapter<ExeHelper> {

private Activity context;
private List<ExeHelper> ExeList;

public ExeList(Activity context,List<ExeHelper> ExeList){
    super(context, R.layout.list, ExeList);

    this.context=context;
    this.ExeList=ExeList;

}

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem=inflater.inflate(R.layout.list,null,true);

        TextView textViewBmi=(TextView) listViewItem.findViewById(R.id.textViewbmi);
        TextView textViewDate=(TextView) listViewItem.findViewById(R.id.textViewdate);

        ExeHelper addhelper=ExeList.get(position);

        textViewBmi.setText(addhelper.getPressure());
        textViewDate.setText(addhelper.getDate());

        return listViewItem;
    }

}
