package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.uas.model.Result;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";
    String title, overview, image;
    ImageView imgDetail;
    TextView tvTitle, tvDetail;
    Result result;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        tvTitle = findViewById(R.id.titleDetailMovie);
        tvDetail = findViewById(R.id.tvDetailDescription);
        imgDetail = findViewById(R.id.imgDetailMovie);
        button = findViewById(R.id.rentButton);

        result = getIntent().getParcelableExtra(EXTRA_MOVIE);

        title = result.getOriginalTitle();
        overview = result.getOverview();
        image = result.getPosterPath();

        tvTitle.setText(title);
        tvDetail.setText(overview);
        Glide.with(getApplicationContext()).load("https://image.tmdb.org/t/p/w185" + image).into(imgDetail);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RentActivity.class);
                startActivity(intent);
            }
        });

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return super.onSupportNavigateUp();
    }
}