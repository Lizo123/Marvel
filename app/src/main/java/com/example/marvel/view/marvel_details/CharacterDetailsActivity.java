package com.example.marvel.view.marvel_details;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.example.marvel.network.AppConstants;
import com.example.marvel.view.BaseActivity;
import com.example.marvel.R;
import com.example.marvel.databinding.ActivityMarvelCharacterDetailsBinding;
import com.example.marvel.dependencies.components.CharactersComponent;
import com.example.marvel.models.Item;

import java.util.ArrayList;

public class CharacterDetailsActivity extends BaseActivity {

    ActivityMarvelCharacterDetailsBinding binding;
    CharactersComponent charactersComponent;
    CharactersDetailsActivityViewModel viewModel;
    MutableLiveData<ArrayList<Item>> comics = new MutableLiveData<>();
    MutableLiveData<ArrayList<Item>> series = new MutableLiveData<>();
    MutableLiveData<ArrayList<Item>> events = new MutableLiveData<>();
    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_marvel_character_details);
        binding.setActivity(this);

        //setup toolbar
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        viewModel = ViewModelProviders.of(this, getApplicationComponent().charactersDetailsViewModelFactory()).get(CharactersDetailsActivityViewModel.class);
        item = (Item) getIntent().getParcelableExtra("character");
        BindDetail(item);

        comics.observe(this, new Observer<ArrayList<Item>>() {
            @Override
            public void onChanged(ArrayList<Item> items) {
                setComicRecycler(items);
                viewModel.getSeries(series,viewModel.setURL(item.getSeries().getCollectionURI()));
            }
        });
        series.observe(this, new Observer<ArrayList<Item>>() {
            @Override
            public void onChanged(ArrayList<Item> items) {
                setSeriesRecycler(items);
                viewModel.getEvents(events,viewModel.setURL(item.getEvents().getCollectionURI()));
            }
        });
        events.observe(this, new Observer<ArrayList<Item>>() {
            @Override
            public void onChanged(ArrayList<Item> items) {
                setEventsRecycler(items);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }




    public void BindDetail(Item item)
    {
        binding.setModel(item);
        Glide.with(this)
                .load(item.getThumbnail().getPath()+"/landscape_amazing"+"."+item.getThumbnail().getExtension())
                .into(binding.image);
        viewModel.getComics(comics,viewModel.setURL(item.getComics().getCollectionURI()));

    }

    public void setComicRecycler(ArrayList<Item> items)
    {
        binding.comicsRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.comicsRecyclerView.setAdapter(new ThumbnailsAdapter(this,items));


    }
    public void setSeriesRecycler(ArrayList<Item> items)
    {
        binding.seriesRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.seriesRecyclerView.setAdapter(new ThumbnailsAdapter(this,items));
    }

    public void setEventsRecycler(ArrayList<Item> items)
    {
        binding.eventsRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.eventsRecyclerView.setAdapter(new ThumbnailsAdapter(this,items));
    }

    /**
     *  open each link
     */
    public void goToLink(String url)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        viewModel.destroyDispose();
    }
}
