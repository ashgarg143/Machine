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

public class OrdersFragment extends Fragment {

    RecyclerView rvOrders;
    ProgressBar pbOrders;
    List<Order> orderList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_orders, null, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Orders");

        pbOrders = view.findViewById(R.id.pb_orders);
        rvOrders = view.findViewById(R.id.rv_orders);

        rvOrders.setHasFixedSize(true);
        rvOrders.setLayoutManager(new LinearLayoutManager(getContext()));

        orderList = new ArrayList<>();

        loadOrders();
    }

    private void loadOrders() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                API.ORDERS_LIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for(int i=0;i<jsonArray.length();i++){
                                ArrayList<LineItemOrder> itemOrders = new ArrayList<>();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                JSONArray lineOrders = jsonObject.getJSONArray("line_item_orders");
                                for (int j = 0; j < lineOrders.length(); j++) {
                                    JSONObject lineOrder = lineOrders.getJSONObject(j);
                                    LineItemOrder itemOrder = new LineItemOrder(
                                            lineOrder.getString("id"),
                                            lineOrder.getString("quantity"),
                                            lineOrder.getString("price"),
                                            lineOrder.getString("total"),
                                            lineOrder.getString("order"),
                                            lineOrder.getString("product")
                                    );
                                    itemOrders.add(itemOrder);
                                }
                                JSONObject customerJSONObject = jsonObject.getJSONObject("customer");

                                Order order = new Order(
                                        jsonObject.getString("id"),
                                        customerJSONObject.getString("name"),
                                        jsonObject.getString("date"),
                                        "(" + jsonObject.getString("remark") + ")",
                                        jsonObject.getString("total"),
                                        itemOrders
                                );
                                orderList.add(order);

                            }
                            OrderAdapter adapter = new OrderAdapter(getContext(),orderList);
                            rvOrders.setAdapter(adapter);
                            pbOrders.setVisibility(View.GONE);
                        } catch (JSONException e) {
                            Toast.makeText(getContext(),e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

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

        /*Order order = new Order(
                "488",
                "22-08-2018",
                "(Pending)",
                "df",
                "fgh",
                "dg",
                "Dg",
                "44441.00",
                "Sfvs",
                "Kanhaiya Distributors",
                "ASD"
        );
        orderList.add(order);
        orderList.add(order);
        orderList.add(order);
        orderList.add(order);
        orderList.add(order);

        OrderAdapter adapter = new OrderAdapter(getContext(),orderList);
        rvOrders.setAdapter(adapter);
        pbOrders.setVisibility(View.GONE);*/
    }
}
