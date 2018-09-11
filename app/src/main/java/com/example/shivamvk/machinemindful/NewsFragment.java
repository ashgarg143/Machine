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

public class NewsFragment extends Fragment {

    private RecyclerView rvNews;
    private ProgressBar pbNews;
    private List<News> newsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news,null,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pbNews = view.findViewById(R.id.pb_news);
        rvNews = view.findViewById(R.id.rv_news);

        rvNews.setHasFixedSize(true);
        rvNews.setLayoutManager(new LinearLayoutManager(getContext()));

        newsList = new ArrayList<>();

        loadNews();

    }

    private void loadNews() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                API.NEWS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                                JSONArray jsonArray = new JSONArray(response);
                                for (int i=0;i<jsonArray.length();i++){

                                    JSONObject object = jsonArray.getJSONObject(i);
                                    News news = new News(object.getString("id")
                                            ,object.getString("date")
                                            ,object.getString("slug")
                                            ,object.getString("title")
                                            ,object.getString("body")
                                            ,object.getString("expiry_date")
                                    );

                                    newsList.add(news);

                                }

                                NewsAdapter adapter = new NewsAdapter(getContext(),newsList);
                                rvNews.setAdapter(adapter);
                                pbNews.setVisibility(View.GONE);
                        } catch (JSONException e) {
                            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                },
               new Response.ErrorListener(){
                   @Override
                   public void onErrorResponse(VolleyError error) {

                   }

        }) {
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
    }
}
