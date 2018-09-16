package com.example.shivamvk.machinemindful;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class CustomerDetailsActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    TextView tvCustomerDetailsName;
    ImageView ivLocation, ivEdit, ivCall, ivMessage, ivMail;

    private String stName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);

        setTitle("Customer details");

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("CustomerActivity");
        setSupportActionBar(toolbar);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        tvCustomerDetailsName = findViewById(R.id.tv_customer_details_name);
        ivLocation = findViewById(R.id.iv_customer_details_location);
        ivCall = findViewById(R.id.iv_customer_details_call);
        ivEdit = findViewById(R.id.iv_customer_details_edit);
        ivMessage = findViewById(R.id.iv_customer_details_message);
        ivMail = findViewById(R.id.iv_customer_details_email);

        stName = getIntent().getStringExtra("name");

        tvCustomerDetailsName.setText(stName);

        ivLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lat = getIntent().getStringExtra("lat");
                String lon = getIntent().getStringExtra("lon");
                /*Uri geoLocation = Uri.parse("geo:" + lat + "," + lon + "?z=100");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(geoLocation);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }*/
                String uri = String.format(Locale.ENGLISH, "geo:%f,%f", 47.6, -122.3);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });

        ivCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile = getIntent().getStringExtra("mobile");
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + mobile));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        ivMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"shivam@mindfulmachine.in"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "This can be replaced by any subject!");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        ivMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri attachment = Uri.parse("8130583124");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setType("vnd.android-dir/mms-sms");
                intent.putExtra("address", "8130583124");
                intent.setData(Uri.parse("sms:"));  // This ensures only SMS apps respond
                intent.putExtra("sms_body", "Write your message here!");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
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

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0){
                CustomerActivityFragment fragment = new CustomerActivityFragment();
                Bundle bundle = new Bundle();
                String name = getIntent().getStringExtra("name");
                bundle.putString("name", name);
                fragment.setArguments(bundle);
                return fragment;
            } else {
                CustomerDetailsFragment fragment = new CustomerDetailsFragment();
                Bundle bundle = new Bundle();
                String email = getIntent().getStringExtra("email");
                String mobile = getIntent().getStringExtra("mobile");
                String address = getIntent().getStringExtra("address");
                String country = getIntent().getStringExtra("country");
                String state = getIntent().getStringExtra("state");
                String city = getIntent().getStringExtra("city");
                String area = getIntent().getStringExtra("area");
                String pincode = getIntent().getStringExtra("pincode");
                bundle.putString("email", email);
                bundle.putString("mobile", mobile);
                bundle.putString("address", address);
                bundle.putString("country", country);
                bundle.putString("state", state);
                bundle.putString("city", city);
                bundle.putString("area", area);
                bundle.putString("pincode", pincode);
                fragment.setArguments(bundle);
                return fragment;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
