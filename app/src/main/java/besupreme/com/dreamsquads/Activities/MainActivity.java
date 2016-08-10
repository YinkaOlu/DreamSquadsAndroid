package besupreme.com.dreamsquads.Activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import besupreme.com.dreamsquads.Adapors.TeamLogoAdapter;
import besupreme.com.dreamsquads.Fragments.SplashFragment;
import besupreme.com.dreamsquads.Fragments.TeamGridFragment;
import besupreme.com.dreamsquads.Models.Player;
import besupreme.com.dreamsquads.Models.Team;
import besupreme.com.dreamsquads.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by yinka_000 on 2016-08-09.
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private static final String TEAM_URL = "https://fantasy-app.herokuapp.com/api/team";
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    private GridView mGridView;

    public static Team[] mTeams;
    private String mSelectedTeamID;

    private TextView stat_check_title;
    private Button begin_button;

    private TeamGridFragment teamGridFragment = new TeamGridFragment();
    private SplashFragment splashFragment = new SplashFragment();

    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentHolder, splashFragment, null);
        fragmentTransaction.addToBackStack("Splash Fragment");
        fragmentTransaction.commit();
        getSupportFragmentManager().executePendingTransactions();

        getTeams();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                stat_check_title = (TextView) findViewById(R.id.stat_check_title);
                stat_check_title.setVisibility(View.VISIBLE);

                begin_button = (Button) findViewById(R.id.begin_button);
                begin_button.setVisibility(View.VISIBLE);

                begin_button.setOnClickListener(startTeamFragment);

            }
        }, SPLASH_TIME_OUT);
    }

View.OnClickListener startTeamFragment = new View.OnClickListener() {
    @Override
    public void onClick(View mView) {
        Toast.makeText(MainActivity.this, "Getting Teams", Toast.LENGTH_SHORT).show();
        setTeamGridFragment();
    }
};

    private void setTeamGridFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentHolder, teamGridFragment, null);
        fragmentTransaction.addToBackStack("Team Grid Fragment");
        fragmentTransaction.commit();

        /*                mGridView = (GridView) findViewById(R.id.gridView);
                mGridView.setAdapter(new TeamLogoAdapter(MainActivity.this) );*/
    }







    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isNetworkAvailable = false;

        if (networkInfo != null && networkInfo.isConnected()) {
            isNetworkAvailable = true;
        }
        return isNetworkAvailable;
    }
    private void getTeams(){
        Log.i(TAG, "Getting Teams" );

        if( isNetworkAvailable() ){
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(TEAM_URL).build();

            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    Log.i(TAG, "Response" );
                    String teamJSON = response.body().string();
                    Log.i(TAG,teamJSON);
                    try {
                        parseTEAMJSON(teamJSON);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }


    private void parseTEAMJSON(String teamJSON) throws JSONException {

        Log.i(TAG, "Parsing Team JSON");
        JSONArray teamJSONArray = new JSONArray(teamJSON);

        Team[] teamArray = new Team[teamJSONArray.length()];

        mTeams = new Team[teamJSONArray.length()];

        for(int i = 0; i < teamJSONArray.length(); i++){
            JSONObject jsonTeam = teamJSONArray.getJSONObject(i);
            Team team = new Team();
            team.setTeamID( jsonTeam.getString("_id") );
            team.setTeamName( jsonTeam.getString("team_name") );
            team.setPrimaryColour( jsonTeam.getString("teamPrimaryColour") );
            if( jsonTeam.has("teamSecondaryColour") ){
                team.setSecondaryColour( jsonTeam.getString("teamSecondaryColour") );
            }

            if( jsonTeam.has("teamTertiaryColour") ){
                team.setTertiaryColour( jsonTeam.getString("teamTertiaryColour") );
            }

            Log.i(TAG, team.getTeamName() + ": " +team.getTeamID());

            mTeams[i] = team;
        }
    }

}
