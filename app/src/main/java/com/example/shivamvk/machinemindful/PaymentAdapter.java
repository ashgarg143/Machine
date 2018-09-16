package com.example.shivamvk.machinemindful;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.ViewHolder>{

    Context context;
    List<Payment> payments;

    public PaymentAdapter(Context context, List<Payment> paymentList) {
        this.context = context;
        this.payments = paymentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.payment_item_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Payment payment = payments.get(i);

        viewHolder.tvTotal.setText(payment.getTotal());
        viewHolder.tvDate.setText(payment.getDate().substring(0, 10));
        viewHolder.tvCustomer.setText(payment.getCustomer());

        if (payment.getStatus().equals("Paid")){
            viewHolder.tvStatus.setText(payment.getStatus());
            viewHolder.tvStatus.setTextColor(context.getResources().getColor(R.color.green));
        } else {
            viewHolder.tvStatus.setText(payment.getStatus());
            viewHolder.tvStatus.setTextColor(context.getResources().getColor(R.color.red));
        }
    }

    @Override
    public int getItemCount() {
        return payments.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvCustomer,tvStatus,tvDate,tvTotal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCustomer = itemView.findViewById(R.id.tv_payment_item_Customer);
            tvStatus = itemView.findViewById(R.id.tv_payment_item_status);
            tvDate = itemView.findViewById(R.id.tv_payment_item_date);
            tvTotal = itemView.findViewById(R.id.tv_payment_item_total);
        }
    }
}
