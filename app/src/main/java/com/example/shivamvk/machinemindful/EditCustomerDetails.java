package com.example.shivamvk.machinemindful;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class EditCustomerDetails extends AppCompatActivity {

    EditText etName,etEmail,etMobile,etAddress,etCountry,etState,etCity,etArea,etPincode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_customer_details);

        setTitle("Edit Profile");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        String id = getIntent().getStringExtra("id");
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String mobile = getIntent().getStringExtra("mobile");
        String address = getIntent().getStringExtra("address");
        String country = getIntent().getStringExtra("country");
        String state = getIntent().getStringExtra("state");
        String city = getIntent().getStringExtra("city");
        String area = getIntent().getStringExtra("area");
        String pincode = getIntent().getStringExtra("pincode");

        etPincode = findViewById(R.id.et_customer_detail_pincode);
        etArea = findViewById(R.id.et_customer_detail_area);
        etState = findViewById(R.id.et_customer_detail_state);
        etCountry = findViewById(R.id.et_customer_details_country);
        etMobile = findViewById(R.id.et_customer_details_mobile);
        etAddress = findViewById(R.id.et_customer_details_address);
        etEmail = findViewById(R.id.et_customer_details_email);
/*
        etName = findViewById(R.id.et_cusn);
*/
        etCity = findViewById(R.id.et_customer_detail_city);

        /*etName.setText(name);*/
        etEmail.setText(email);
        etAddress.setText(address);
        etMobile.setText(mobile);
        etCountry.setText(country);
        etState.setText(state);
        etCity.setText(city);
        etArea.setText(area);
        etPincode.setText(pincode);
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
