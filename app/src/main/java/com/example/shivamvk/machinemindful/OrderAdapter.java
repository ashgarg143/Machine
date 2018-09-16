package com.example.shivamvk.machinemindful;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private Context context;
    private List<Order> orderList;

    public OrderAdapter(Context context, List<Order> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_item_layout,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final Order order = orderList.get(i);

        viewHolder.tvOrderItemId.setText("#1");
        viewHolder.tvORderItemStatus.setText(order.getRemark());
        viewHolder.tvOrderItemDate.setText(order.getDate().substring(0,10));
        viewHolder.tvORderItemCustomer.setText(order.getCustomer());
        viewHolder.tvORderItemPrice.setText(order.getTotal());

        viewHolder.llOrderItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, OrderDetailsActivity.class);
                intent.putExtra("date", order.getDate());
                intent.putExtra("customer", order.getCustomer());
                Bundle bundle = new Bundle();
                intent.putExtra("bundle", bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvOrderItemId,tvORderItemStatus,tvOrderItemDate,tvORderItemCustomer,tvORderItemPrice;
        private LinearLayout llOrderItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            llOrderItem = itemView.findViewById(R.id.ll_order_item);
            tvOrderItemId = itemView.findViewById(R.id.tv_order_item_id);
            tvOrderItemDate = itemView.findViewById(R.id.tv_order_item_date);
            tvORderItemCustomer = itemView.findViewById(R.id.tv_order_item_customer);
            tvORderItemStatus = itemView.findViewById(R.id.tv_order_item_status);
            tvORderItemPrice = itemView.findViewById(R.id.tv_order_item_total);

        }
    }
}
