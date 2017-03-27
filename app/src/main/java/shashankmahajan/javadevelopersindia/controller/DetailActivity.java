package shashankmahajan.javadevelopersindia.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import shashankmahajan.javadevelopersindia.R;

/**
 * Created by shashankmahajan on 27/03/17.
 */

public class DetailActivity extends AppCompatActivity {

    TextView Link,Username;
    Toolbar mActionBarToolbar;
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView = (ImageView) findViewById(R.id.user_image_header);
        Username = (TextView) findViewById(R.id.username);
        Link = (TextView) findViewById(R.id.link);

        String userName = getIntent().getExtras().getString("login");
        String avatarUrl = getIntent().getExtras().getString("avatar_url");
        String link = getIntent().getExtras().getString("html_url");

        Link.setText(link);
        Linkify.addLinks(Link,Linkify.WEB_URLS);


        Username.setText(userName);
        Glide.with(this)
                .load(avatarUrl)
                .placeholder(R.mipmap.ic_launcher)
                .into(imageView);
        getSupportActionBar().setTitle("User's Details ");

    }
    private Intent createShareForcecast(){
        String userName = getIntent().getExtras().getString("login");
        String avatarUrl = getIntent().getExtras().getString("link");

        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText("Check out this app")
                .getIntent();



        return shareIntent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail,menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        menuItem.setIntent(createShareForcecast());

        return true ;


    }
}
