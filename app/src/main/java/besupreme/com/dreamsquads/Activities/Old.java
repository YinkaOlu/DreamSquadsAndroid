package besupreme.com.dreamsquads.Activities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import besupreme.com.dreamsquads.Fragments.TeamGridFragment;
import besupreme.com.dreamsquads.Models.Player;
import besupreme.com.dreamsquads.Models.Team;
import besupreme.com.dreamsquads.Models.Teams;
import besupreme.com.dreamsquads.R;
import besupreme.com.dreamsquads.Adapors.TeamLogoAdapter;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Old extends AppCompatActivity {
    private static final String TAG = Old.class.getSimpleName();
    private static final String TEAM_URL = "https://fantasy-app.herokuapp.com/api/team";
    private static final String ROSTER_URL = "https://fantasy-app.herokuapp.com/api/findRoster/";
    private GridView mGridView;



    private Team[] mTeams;
    private String mSelectedTeamID;

    private TeamGridFragment teamGridFragment = new TeamGridFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();


        setTitle("Choose a Team");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentHolder, teamGridFragment, null);
        fragmentTransaction.addToBackStack("Team Grid Fragment");
        fragmentTransaction.commit();


        getTeams();

        //mGridView = (GridView) findViewById(R.id.gridView);
        mGridView.setAdapter(new TeamLogoAdapter(this) );

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(Old.this, Teams.TEAM_NAMES[position], Toast.LENGTH_SHORT).show();
                
                getRoster( getTeamID( Teams.TEAM_NAMES[position] ) );

            }
        });


    }

    private void getRoster(String mTeamID) {
        Log.i(TAG,"Roster Check");

        
        if( isNetworkAvailable() ){
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(ROSTER_URL + mTeamID).build();

            Call call = client.newCall(request);

            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String rosterJSON = response.body().string();
                    Log.i(TAG,rosterJSON);
                    try {
                        parseROSTERJSON(rosterJSON);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void parseROSTERJSON(String mRosterJSON) throws JSONException {
        Log.i(TAG, "Parsing Roster JSON");
        JSONArray rosterJSONArray = new JSONArray(mRosterJSON);

        Player[] rosterArray = new Player[rosterJSONArray.length()];

        for(int i  = 0; i < rosterJSONArray.length(); i++ ){
            JSONObject jsonPlayer = rosterJSONArray.getJSONObject(i);
            Player player = new Player();

            player.setPlayer_id(jsonPlayer.getString("_id"));

            if( jsonPlayer.has("player_draft") ){
                player.setDraft_year(jsonPlayer.getString("player_draft"));
            }

            if( jsonPlayer.has("player_first_name") ){
                player.setFirst_name(jsonPlayer.getString("player_first_name"));
            }

            if( jsonPlayer.has("player_last_name") ){
                player.setLast_name(jsonPlayer.getString("player_last_name"));
            }

            if( jsonPlayer.has("player_number") ){
                player.setPlayer_number(jsonPlayer.getInt("player_number"));
            }

            if( jsonPlayer.has("player_number") ){
                player.setPlayer_number(jsonPlayer.getInt("player_number"));
            }

            if( jsonPlayer.has("player_position") ){
                player.setPosition(jsonPlayer.getString("player_position"));
            }

            if( jsonPlayer.has("player_preNBA_team") ){
                player.setPreNBA_team(jsonPlayer.getString("player_preNBA_team"));
            }

            if( jsonPlayer.has("player_NBA_start") ){
                player.setStart_date(jsonPlayer.getString("player_NBA_start"));
            }
            if( jsonPlayer.has("player_weight") ){
                player.setWeight(jsonPlayer.getInt("player_weight"));
            }
            if( jsonPlayer.has("player_height") ){
                player.setHeight(jsonPlayer.getInt("player_height"));
            }
            if( jsonPlayer.has("player_birthDate") ){
                player.setBirthDate(jsonPlayer.getString("player_birthDate"));
            }

        }
    }

    private String getTeamID(String teamName) {

        String selectedTeamID = "0";
        Log.i(TAG, " Getting Team Idea");
        for(Team team : mTeams){

            if(team.getTeamName().equals(teamName) ){
                mSelectedTeamID = team.getTeamID();
                Log.i(TAG, team.getTeamName() + " has id "+ team.getTeamID() );
                
                selectedTeamID = team.getTeamID();
            }
        }
        return selectedTeamID;
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
    private String getTeams(){
        Log.i(TAG, "Getting Team ID" );

        String teamIDJSON = "";

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
        return teamIDJSON;
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
