package com.example.shivamvk.machinemindful;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaymentFragment extends Fragment {

    RecyclerView rvPayment;
    ProgressBar pbPayment;
    List<Payment> paymentList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_payment, null, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Payment Collection");

        pbPayment = view.findViewById(R.id.pb_payment);
        rvPayment = view.findViewById(R.id.rv_payment);

        rvPayment.setHasFixedSize(true);
        rvPayment.setLayoutManager(new LinearLayoutManager(getContext()));

        paymentList = new ArrayList<>();

        loadPayment();

        FloatingActionButton fabAddPayment = view.findViewById(R.id.fab_add_payment);
        fabAddPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), AddPaymentActivity.class));
            }
        });
    }

    private void loadPayment() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                API.PAYMENTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Payment payment = new Payment(
                                        jsonObject.getString("customer"),
                                        jsonObject.getString("date"),
                                        jsonObject.getString("description"),
                                        jsonObject.getString("amount")
                                );
                                paymentList.add(payment);

                            }
                            PaymentAdapter adapter = new PaymentAdapter(getContext(),paymentList);
                            rvPayment.setAdapter(adapter);
                            pbPayment.setVisibility(View.GONE);
                        } catch (JSONException e) {
                            Toast.makeText(getContext(),e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "API is giving any data or server is down!", Toast.LENGTH_SHORT).show();
                    }

                }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json; charset=UTF-8");
                headers.put("Authorization", "token 0ee1248c5a84e8b1e36a8a15da48c0bb7580926c");
                return headers;
            }};

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);

        /*Payment payment = new Payment(
                "Raju Agency",
                "13-08-2018",
                "Confirmed",
                "11000.00"
        );

        paymentList.add(payment);
        paymentList.add(payment);
        paymentList.add(payment);
        paymentList.add(payment);
        paymentList.add(payment);

        PaymentAdapter adapter = new PaymentAdapter(getContext(),paymentList);
        rvPayment.setAdapter(adapter);
        pbPayment.setVisibility(View.GONE);*/
    }
}
