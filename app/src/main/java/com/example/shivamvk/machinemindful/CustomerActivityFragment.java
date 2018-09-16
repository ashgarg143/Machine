package com.example.shivamvk.machinemindful;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class CustomerActivityFragment extends Fragment {

    String name;

    ImageView ivCollectPayment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        name = getArguments().getString("name");
        return inflater.inflate(R.layout.fragment_customer_activity, null, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ivCollectPayment = view.findViewById(R.id.iv_customer_details_collect_payment);
        ivCollectPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddPaymentActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

    }
}
