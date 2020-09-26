package comtechnobyte.example.fitnesscareapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public  class BmiAdapter extends RecyclerView.Adapter<BmiAdapter.MyViewHolder> {

    private Context context;
    private ArrayList date , gender, answer;

    BmiAdapter(Context context,
               ArrayList date,
               ArrayList gender,
               ArrayList answer) {

        this.context = context;
        this.date=date;
        this.gender=gender;
        this.answer=answer;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_list,parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.date.setText(String.valueOf(date.get(position)));
            holder.gender.setText(String.valueOf(gender.get(position)));
            holder.answer.setText(String.valueOf(answer.get(position)));
    }

    @Override
    public int getItemCount()  {
        return date.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView date, gender , answer;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
             date = itemView.findViewById(R.id.textdate);
             gender = itemView.findViewById(R.id.textgender);
             answer = itemView.findViewById(R.id.txtanswer);
        }
    }
}
