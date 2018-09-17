package com.example.shivamvk.machinemindful;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class LogsAdapter extends RecyclerView.Adapter<LogsAdapter.ViewHolder>{

    List<Logs> logsList;
    Context context;

    public LogsAdapter(List<Logs> logsList, Context context) {
        this.logsList = logsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.log_item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Logs logs = logsList.get(i);

        String name = logs.getCustomer();
        String date = logs.getDate().substring(0,10);
        String time = logs.getDate().substring(11, 19);
        String message = logs.getMessage();

        viewHolder.tvLogMain.setText(message);
        viewHolder.tvLogSub.setText("done by " + name + " on " + date + " " + time);
    }

    @Override
    public int getItemCount() {
        return logsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvLogMain;
        TextView tvLogSub;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvLogMain = itemView.findViewById(R.id.tv_log_main_heading);
            tvLogSub = itemView.findViewById(R.id.tv_log_sub_heading);
        }
    }
}
