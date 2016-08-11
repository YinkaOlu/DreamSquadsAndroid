package besupreme.com.dreamsquads.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import besupreme.com.dreamsquads.Activities.MainActivity;
import besupreme.com.dreamsquads.Adaptors.TeamLogoAdapter;
import besupreme.com.dreamsquads.Models.Player;
import besupreme.com.dreamsquads.Models.Roster;
import besupreme.com.dreamsquads.Models.Team;
import besupreme.com.dreamsquads.Models.Teams;
import besupreme.com.dreamsquads.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yinka_000 on 2016-08-10.
 */
public class TeamGridFragment extends Fragment{
    private static final String TAG = TeamGridFragment.class.getSimpleName();
    private TextView test;
    private GridView mGridView;

    private FragmentActivity myContext;

    private RosterFragment rosterFragment = new RosterFragment();

    private FragmentManager mFragmentManager;

    private static final String ROSTER_URL = "https://fantasy-app.herokuapp.com/api/findRoster/";

    @Override
    public void onAttach(Activity activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team_grid,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        mGridView = (GridView) getView().findViewById(R.id.gridView);
        mGridView.setAdapter(new TeamLogoAdapter(getContext()) );

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Toast.makeText(getContext(), Teams.TEAM_NAMES[position], Toast.LENGTH_SHORT).show();

                getRoster( getTeamID( Teams.TEAM_NAMES[position] ) );

            }
        });

    }

    private void getRoster(String mTeamID) {
        Log.i(TAG,"Roster Check");

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

    private String getTeamID(String teamName) {

        String selectedTeamID = "0";
        Log.i(TAG, " Getting Team Idea");
        for(Team team : MainActivity.mTeams){

            if(team.getTeamName().equals(teamName) ){
                Log.i(TAG, team.getTeamName() + " has id "+ team.getTeamID() );

                selectedTeamID = team.getTeamID();
                Roster.TEAM = team;
            }
        }
        return selectedTeamID;
    }

    private void parseROSTERJSON(String mRosterJSON) throws JSONException {
        Log.i(TAG, "Parsing Roster JSON");
        JSONArray rosterJSONArray = new JSONArray(mRosterJSON);

        Roster.roster = new Player[rosterJSONArray.length()];

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

            Log.i( TAG, player.getFirst_name()+" "+player.getLast_name() );
            Roster.roster[i] = player;
        }
        setupRosterFragment();
    }

    private void setupRosterFragment() {
        FragmentManager fragManager = myContext.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentHolder, rosterFragment, null);
        fragmentTransaction.addToBackStack("Roster Fragment");
        fragmentTransaction.commit();

    }

}
