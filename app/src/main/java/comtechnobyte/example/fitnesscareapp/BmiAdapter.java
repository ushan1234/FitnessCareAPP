package comtechnobyte.example.fitnesscareapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
    private ArrayList id, date , gender, answer, height, weight;
    private RecyclerView recyclerView;

    BmiAdapter(Context context, RecyclerView recyclerView, ArrayList date, ArrayList id, ArrayList gender, ArrayList height, ArrayList weight, ArrayList answer) {
        this.context = context;
        this.recyclerView = recyclerView;
        this.date=date;
        this.id = id;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.answer = answer;
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
                    Intent intent = new Intent(context, Report.class);
                    intent.putExtra("gender", gender.get(position).toString());
                    intent.putExtra("date", date.get(position).toString());
                    intent.putExtra("height", height.get(position).toString());
                    intent.putExtra("weight", weight.get(position).toString());
                    intent.putExtra("answer", answer.get(position).toString());
                    context.startActivity(intent);
                }
            });

            holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    final AlertDialog alertDialog = new AlertDialog.Builder(context)

                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("Delete")
                            .setMessage("Are you sure to delete")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //set what would happen when positive button is clicked
                                    Database database = new Database(context);
                                    database.deleteReport(String.valueOf(id.get(position)));
                                    dialogInterface.cancel();
                                }
                            })

                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                    //set what should happen when negative button is clicked
                                }
                            })
                            .show();




//                    date.remove(position);
//                    recyclerView.removeViewAt(position);
//                    notifyItemRemoved(position);
//                    notifyItemRangeChanged(position, date.size());
//                    notifyDataSetChanged();

                }
            });
    }

    @Override
    public int getItemCount()  {
        return date.size();
    }


}
