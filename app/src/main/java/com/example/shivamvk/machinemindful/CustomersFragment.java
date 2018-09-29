package com.example.shivamvk.machinemindful;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
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

public class CustomersFragment extends Fragment {

    private List<Customer> customerList;

    private RecyclerView rvCustomers;
    private ProgressBar pbCustomers;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_customers, null, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Customers");

        pbCustomers = view.findViewById(R.id.pb_customers);
        rvCustomers = view.findViewById(R.id.rv_customers);

        rvCustomers.setHasFixedSize(true);
        rvCustomers.setLayoutManager(new LinearLayoutManager(getContext()));

        customerList = new ArrayList<>();

        loadCustomers();
    }

    private void loadCustomers() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                API.CUSTOMERS_LIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i=0; i<jsonArray.length(); i++){
                                JSONObject object = jsonArray.getJSONObject(i);
                                String id = object.getString("id");
                                String name = object.getString("name");
                                String slug1 = object.getString("slug1");
                                String customercode = "bh";
                                String salemanager = "gkh";
                                String status = object.getString("status");
                                String address = object.getString("address");
                                String pincode = object.getString("pincode");
                                String country = object.getString("country");
                                String city = object.getString("city");
                                String state = object.getString("state");
                                String area = "dfhch";
                                String latitude = object.getString("lattitude");
                                String longitude = object.getString("longitude");
                                String email = object.getString("email");
                                String mobile = object.getString("mobile");
                                String team = "Scda";
                                Customer customer = new Customer(
                                        id,
                                        name,
                                        slug1,
                                        customercode,
                                        salemanager,
                                        status,
                                        address,
                                        pincode,
                                        country,
                                        city,
                                        state,
                                        area,
                                        latitude,
                                        longitude,
                                        email,
                                        mobile,
                                        team
                                );

                                customerList.add(customer);
                            }
                            CustomerAdapter adapter = new CustomerAdapter(getContext(), customerList);
                            rvCustomers.setAdapter(adapter);
                            pbCustomers.setVisibility(View.GONE);
                        } catch (Exception e) {
                            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json; charset=UTF-8");
                headers.put("Authorization", "token 0ee1248c5a84e8b1e36a8a15da48c0bb7580926c");
                return headers;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);

        /*Customer customerName = new Customer(
                "1",
                "A S H Sales",
                "sf",
                "fa",
                "af",
                "ad",
                "ad",
                "ad",
                "Inida",
                "Gujarat",
                "Kodinar",
                "ad",
                "Ad",
                "ad",
                "Ad",
                "ad",
                "Ad"
        );

        Customer customer1 = new Customer(
                "1",
                "A S H Sales",
                "sf",
                "fa",
                "af",
                "ad",
                "ad",
                "ad",
                "Inida",
                "Gujarat",
                "Kodinar",
                "ad",
                "Ad",
                "ad",
                "Ad",
                "ad",
                "Ad"
        );

        Customer customer2 = new Customer(
                "1",
                "A S H Sales",
                "sf",
                "fa",
                "af",
                "ad",
                "ad",
                "ad",
                "Inida",
                "Gujarat",
                "Kodinar",
                "ad",
                "Ad",
                "ad",
                "Ad",
                "ad",
                "Ad"
        );

        customerList.add(customerName);
        customerList.add(customer1);
        customerList.add(customer2);

        CustomerAdapter adapter = new CustomerAdapter(getContext(), customerList);
        rvCustomers.setAdapter(adapter);
        pbCustomers.setVisibility(View.GONE);*/
    }
}
