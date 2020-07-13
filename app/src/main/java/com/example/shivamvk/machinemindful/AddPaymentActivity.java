package com.example.shivamvk.machinemindful;

import android.app.ProgressDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class AddPaymentActivity extends AppCompatActivity {

    Spinner spPaymentType;
    EditText etName,etDate,etAmount,etDesc;

    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_payment);

        setTitle("Add Payment");

        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        etName = findViewById(R.id.et_add_payment_customer_name);
        etAmount = findViewById(R.id.et_add_payment_customer_amount);
        etDesc = findViewById(R.id.et_add_payment_customer_description);

        spPaymentType = findViewById(R.id.sp_add_payment_type);

        setUpSpinner();

        name = getIntent().getStringExtra("name");
        etName.setText(name);
        etName.setFocusable(false);

        FloatingActionButton fabAddPaymentAPI = findViewById(R.id.fab_add_Payment_api);
        fabAddPaymentAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog progressDialog = new ProgressDialog(AddPaymentActivity.this);
                progressDialog.setMessage("Adding payment...");
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.setCancelable(false);
                progressDialog.show();
                String url = API.ADD_PAYMENT;

                StringRequest stringRequest = new StringRequest(Request.Method.POST,
                        url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                progressDialog.dismiss();
                                Toast.makeText(AddPaymentActivity.this, "Location shared!", Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                progressDialog.dismiss();
                                Toast.makeText(AddPaymentActivity.this, "API error!", Toast.LENGTH_SHORT).show();
                            }
                        }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("Content-Type", "application/x-www-form-urlencoded");
                        params.put("amount", "123");
                        params.put("description", "Vdf");
                        params.put("customer", "1");
                        return params;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String> headers = new HashMap<>();
                        headers.put("Content-Type", "application/json; charset=UTF-8");
                        headers.put("Authorization", "token 0ee1248c5a84e8b1e36a8a15da48c0bb7580926c");
                        return headers;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(AddPaymentActivity.this);
                requestQueue.add(stringRequest);
            }
        });
    }

    private void setUpSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter paymentSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.payment_type, android.R.layout.simple_dropdown_item_1line);

        // Specify dropdown layout style - simple list view with 1 item per line
        paymentSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        spPaymentType.setAdapter(paymentSpinnerAdapter);

        // Set the integer mSelected to the constant values
        spPaymentType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {

                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
