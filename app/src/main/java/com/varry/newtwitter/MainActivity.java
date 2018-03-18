package com.varry.newtwitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineRecyclerViewAdapter;
import com.twitter.sdk.android.tweetui.UserTimeline;

public class MainActivity extends AppCompatActivity {

    private TwitterLoginButton twitterLoginButton;
    private TextView textView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Twitter.initialize(this);

        showFuck();

    }

    private void showFuck() {
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final UserTimeline searchTimeline = new UserTimeline.Builder()
                .screenName("varry123_g")
                .maxItemsPerRequest(50)
                .build();

        final TweetTimelineRecyclerViewAdapter adapter =
                new TweetTimelineRecyclerViewAdapter.Builder(this)
                        .setTimeline(searchTimeline)
                        .setViewStyle(R.style.tw__TweetLightWithActionsStyle)
                        .build();

        recyclerView.setAdapter(adapter);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        twitterLoginButton.onActivityResult(requestCode, resultCode, data);
    }



}
