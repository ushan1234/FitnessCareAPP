package comtechnobyte.example.fitnesscareapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public  class BmiAdapter extends RecyclerView.Adapter<BmiAdapter.MyViewHolder> {

    private Context context;
    private ArrayList date , gender, answer;
    ArrayList id;
    private RecyclerView recyclerView;

    BmiAdapter(Context context, RecyclerView recyclerView, ArrayList date, ArrayList id) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.date=date;
        this.id = id;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView date, gender , answer;
        ImageView deleteBtn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.txtdate_list);
            deleteBtn = itemView.findViewById(R.id.deletebtn_list);
//            gender = itemView.findViewById(R.id.txtgender_list);
//            answer = itemView.findViewById(R.id.txtanswer_list);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout_list,parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
            holder.date.setText(String.valueOf(date.get(position)));
//            holder.gender.setText(String.valueOf(gender.get(position)));
//            holder.answer.setText(String.valueOf(answer.get(position)));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, ""+id.get(position), Toast.LENGTH_SHORT).show();
                }
            });

            holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Database database = new Database(context);
                    database.deleteReport(String.valueOf(id.get(position)));

                    date.remove(position);
                    recyclerView.removeViewAt(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, date.size());
                    notifyDataSetChanged();

                }
            });
    }

    @Override
    public int getItemCount()  {
        return date.size();
    }


}
