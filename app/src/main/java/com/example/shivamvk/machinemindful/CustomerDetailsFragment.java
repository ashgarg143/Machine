package com.example.shivamvk.machinemindful;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CustomerDetailsFragment extends Fragment {

    String email, mobile, country, address, state, city, area, pincode;

    TextView tvDetailEmail,tvDetailMobile,tvDetailAddress,tvDetailCountry,tvDetailState,tvDetailCity,tvDetailArea,tvDetailPinCode;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        email = getArguments().getString("email");
        mobile = getArguments().getString("mobile");
        country = getArguments().getString("country");
        address = getArguments().getString("address");
        state = getArguments().getString("state");
        city = getArguments().getString("city");
        area = getArguments().getString("area");
        pincode = getArguments().getString("pincode");
        return inflater.inflate(R.layout.fragment_customer_details, null, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvDetailEmail = view.findViewById(R.id.tv_customer_details_email);
        tvDetailMobile = view.findViewById(R.id.tv_customer_details_mobile);
        tvDetailAddress = view.findViewById(R.id.tv_customer_details_address);
        tvDetailCountry = view.findViewById(R.id.tv_customer_details_country);
        tvDetailState = view.findViewById(R.id.tv_customer_detail_state);
        tvDetailCity = view.findViewById(R.id.tv_customer_detail_city);
        tvDetailArea = view.findViewById(R.id.tv_customer_detail_area);
        tvDetailPinCode = view.findViewById(R.id.tv_customer_detail_pincode);

        tvDetailEmail.setText(email);
        tvDetailMobile.setText(mobile);
        tvDetailAddress.setText(address);
        tvDetailCountry.setText(country);
        tvDetailState.setText(state);
        tvDetailCity.setText(city);
        tvDetailArea.setText(area);
        tvDetailPinCode.setText(pincode);
    }
}
