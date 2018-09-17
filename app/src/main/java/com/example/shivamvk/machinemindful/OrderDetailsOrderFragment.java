package com.example.shivamvk.machinemindful;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OrderDetailsOrderFragment extends Fragment {

    String id,date, customerName;

    TextView tvOrderDetailsId,tvOrderDetailDate, tvOrderDetailCustomer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        id = getArguments().getString("id");
        date = getArguments().getString("date");
        customerName = getArguments().getString("customerName");
        return inflater.inflate(R.layout.fragment_order_order_details, null, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvOrderDetailsId = view.findViewById(R.id.tv_order_details_id);
        tvOrderDetailDate = view.findViewById(R.id.tv_order_details_date);
        tvOrderDetailCustomer = view.findViewById(R.id.tv_order_details_customer);

        tvOrderDetailsId.setText("#"+id);
        tvOrderDetailDate.setText(date);
        tvOrderDetailCustomer.setText(customerName);


    }
}
