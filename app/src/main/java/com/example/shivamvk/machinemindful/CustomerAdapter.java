package com.example.shivamvk.machinemindful;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
        final Customer customer = customerList.get(i);
        viewHolder.tvListItem1.setText(customer.getName());
        String address = customer.getCity()+", "+customer.getState()+", "+customer.getCountry();
        viewHolder.tvListItem2.setText(address);

        viewHolder.llCustomerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CustomerDetailsActivity.class);
                intent.putExtra("id", customer.getId());
                intent.putExtra("name", customer.getName());
                intent.putExtra("lat", customer.getLatitude());
                intent.putExtra("lon", customer.getLongitude());
                intent.putExtra("mobile", customer.getMobile());
                intent.putExtra("email", customer.getEmail());
                intent.putExtra("address", customer.getAddress());
                intent.putExtra("country", customer.getCountry());
                intent.putExtra("state", customer.getState());
                intent.putExtra("city", customer.getCity());
                intent.putExtra("area", customer.getArea());
                intent.putExtra("pincode", customer.getPincode());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvListItem1;
        TextView tvListItem2;
        LinearLayout llCustomerLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            llCustomerLayout = itemView.findViewById(R.id.ll_cutomer_item);
            tvListItem1 = itemView.findViewById(R.id.tv_list_item_1);
            tvListItem2 = itemView.findViewById(R.id.tv_list_item_2);
        }
    }
}
