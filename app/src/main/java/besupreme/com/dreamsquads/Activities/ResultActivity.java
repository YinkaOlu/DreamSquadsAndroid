package besupreme.com.dreamsquads.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import besupreme.com.dreamsquads.Adaptors.ResultAdaptor;
import besupreme.com.dreamsquads.Models.Player;
import besupreme.com.dreamsquads.Models.Roster;
import besupreme.com.dreamsquads.Models.Season;
import besupreme.com.dreamsquads.R;

public class ResultActivity extends AppCompatActivity {

    private static final String TAG = ResultActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent inputIntent = getIntent();
        Season season = inputIntent.getParcelableExtra("season_object");
        Player mPlayer = inputIntent.getParcelableExtra("player_object");

        LinearLayout wraperLayout = (LinearLayout) findViewById(R.id.wraperLayout);
        wraperLayout.setBackgroundColor( Color.parseColor( "#"+Roster.TEAM.getSecondaryColour() ) );

        LinearLayout playerLayout = (LinearLayout) findViewById(R.id.resultPlayerLayout);
        playerLayout.setBackgroundColor( Color.parseColor( "#"+ Roster.TEAM.getSecondaryColour() ) );

        ImageView playerImage = (ImageView) findViewById(R.id.resultPlayerImage);

        String urlPlayerName = mPlayer.getFirst_name() + "%20"+ mPlayer.getLast_name();
        String profileURL = "https://fantasy-app.herokuapp.com/images/profilePics/"+urlPlayerName+".png";
        Log.i("IMAGE URL", profileURL);
        Picasso.with(this)
                .load(profileURL)
                .into(playerImage);

        TextView playerName = (TextView) findViewById(R.id.resultPlayerName);
        playerName.setText(mPlayer.getFirst_name()+" "+mPlayer.getLast_name());

        TextView playerNum = (TextView) findViewById(R.id.resultPlayerNum);
        playerNum.setText(mPlayer.getPlayer_number()+"");

        TextView playerPosition = (TextView) findViewById(R.id.resultPlayerPosition);
        playerPosition.setText(mPlayer.getPosition());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.result_list);

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayoutManager);

        ResultAdaptor resultAdaptor = new ResultAdaptor(season, ResultActivity.this);
        recyclerView.setAdapter(resultAdaptor);
    }
}
