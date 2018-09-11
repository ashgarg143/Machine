package com.example.shivamvk.machinemindful;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {

    Context context;
    List<Customer> customerList;

    public CustomerAdapter(Context context, List<Customer> customerList) {
        this.context = context;
        this.customerList = customerList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cutomer_item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Customer customer = customerList.get(i);
        viewHolder.tvListItem1.setText(customer.getName());
        viewHolder.tvListItem2.setText(customer.getSlug1());
    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvListItem1;
        TextView tvListItem2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvListItem1 = itemView.findViewById(R.id.tv_list_item_1);
            tvListItem2 = itemView.findViewById(R.id.tv_list_item_2);
        }
    }
}
