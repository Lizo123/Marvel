package com.example.thespa.view.offers;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.domain.entities.Offer;
import com.example.domain.usecases.DefaultObserver;
import com.example.domain.usecases.offerusecases.GetAllOffersUseCase;
import com.example.thespa.R;
import com.example.thespa.databinding.ActivityOffersBinding;
import com.example.thespa.dependencies.AndroidApplication;
import com.example.thespa.dependencies.OfferComponent;
import com.example.thespa.view.carts.CartActivity;

import java.util.ArrayList;

import javax.inject.Inject;

public class OffersActivity extends AppCompatActivity {

    OffersAdapter offersAdapter;
    RecyclerView offers_recycler;
    Toolbar toolbar;
    ImageView cartBar;
    OfferComponent offerComponent;
    @Inject
    GetAllOffersUseCase getAllOffersUseCase;
    ActivityOffersBinding activityOffersBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initializeInjector();
        super.onCreate(savedInstanceState);
        activityOffersBinding = DataBindingUtil.setContentView(this, R.layout.activity_offers);


        setSupportActionBar(activityOffersBinding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getAllOffersUseCase.execute(new getAllOffersObserver(), "en");
        cartBar = activityOffersBinding.cart;
        offers_recycler = activityOffersBinding.offersRecycler;


        cartBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCartActivity();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
