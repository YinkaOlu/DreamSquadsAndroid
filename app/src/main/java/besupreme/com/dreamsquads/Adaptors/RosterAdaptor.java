package besupreme.com.dreamsquads.Adaptors;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import besupreme.com.dreamsquads.Activities.ResultActivity;
import besupreme.com.dreamsquads.Models.Game;
import besupreme.com.dreamsquads.Models.Player;
import besupreme.com.dreamsquads.Models.Roster;
import besupreme.com.dreamsquads.Models.Season;
import besupreme.com.dreamsquads.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yinka_000 on 2016-08-10.
 */
public class RosterAdaptor extends RecyclerView.Adapter<RosterAdaptor.ListViewHolder>{
    private static final String TAG = RosterAdaptor.class.getSimpleName();
    private Player[] mPlayers;
    private Context mContext;

    private String playerName;

    private Season season = new Season();

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.roster_list_item, parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, final int position) {
        String urlPlayerName = mPlayers[position].getFirst_name() + "%20"+ mPlayers[position].getLast_name();
        String profileURL = "https://fantasy-app.herokuapp.com/images/profilePics/"+urlPlayerName+".png";
        Log.i("IMAGE URL", profileURL);
        Picasso.with(mContext)
                .load(profileURL)
                .into(holder.profileImage);
        Log.i("Team Color: ", Roster.TEAM.getPrimaryColour());
        holder.playerLayout.setBackgroundColor( Color.parseColor( "#"+Roster.TEAM.getSecondaryColour() ) );

        playerName = mPlayers[position].getFirst_name() + " "+ mPlayers[position].getLast_name();
        holder.playerNameText.setText(playerName);

        if( mPlayers[position].getPlayer_number() != 999 ){
            holder.playerNumberText.setText( mPlayers[position].getPlayer_number() + "");
        }

        if( mPlayers[position].getPosition() != null ){
            holder.playerPositionText.setText( mPlayers[position].getPosition() );
        }

        holder.getStatsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View mView) {
                getSeasonStats(mPlayers[position]);
            }
        });
    }

    private void getSeasonStats(final Player mPlayer) {
        String seasonStatURL = "https://fantasy-app.herokuapp.com/calculate/seasonStats/"+ mPlayer.getPlayer_id();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(seasonStatURL).build();

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
                    parseSeasonJSON(teamJSON, mPlayer);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void parseSeasonJSON(String mSeasonJSON, Player player) throws JSONException {
        Log.i(TAG, "Parsing Season JSON");
        JSONObject seasonJSON = new JSONObject(mSeasonJSON);

        season.setPPG( seasonJSON.getDouble("PPG") );
        season.setAPG( seasonJSON.getDouble("APG") );
        season.setRPG( seasonJSON.getDouble("RPG") );
        season.setTOV( seasonJSON.getDouble("TOV") );
        season.setFouls( seasonJSON.getDouble("Fouls") );
        season.setBPG( seasonJSON.getDouble("BPG") );
        //season.setPlusMinus( seasonJSON.getDouble("plusMinus") );
        season.setMPG( seasonJSON.getDouble("MPG") );
        season.setSteals( seasonJSON.getDouble("Steals") );
        season.setFGPER( seasonJSON.getDouble("FGPer") );
        season.setThreePPER( seasonJSON.getDouble("threePPer") );
        season.setFTPER( seasonJSON.getDouble("FTPer") );

        getSeasonGames(player);

    }

    private void getSeasonGames(final Player mPlayer) {
        String seasonStatURL = "https://fantasy-app.herokuapp.com/api/findGames/"+ mPlayer.getPlayer_id();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(seasonStatURL).build();

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
                    parseSeasonGames(teamJSON);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void parseSeasonGames(String seasonGamesJSON) throws JSONException {
        Log.i(TAG, "Parsing Season Games");
        JSONArray seasonGameJSONArray = new JSONArray(seasonGamesJSON);

        season.setSeasonGames(new Game[seasonGameJSONArray.length()]);

        for(int i = 0; i < seasonGameJSONArray.length(); i++){
            JSONObject jsonGame = seasonGameJSONArray.getJSONObject(i);
            Game game = new Game();

            game.setAssists( jsonGame.getInt("AST") );
            game.setBlocks( jsonGame.getInt("BLK") );
            game.setDate( jsonGame.getString("game_Date"));
            game.setDRB(jsonGame.getInt("DRB"));
            game.setFGA(jsonGame.getInt("FGA"));
            game.setFGM(jsonGame.getInt("FGM"));
            game.setFouls(jsonGame.getInt("Fouls"));
            game.setFTA(jsonGame.getInt("FTA"));
            game.setFTM(jsonGame.getInt("FTM"));
            game.setMinutes(jsonGame.getInt("minutes_played"));
            game.setORB(jsonGame.getInt("ORB"));
            //game.setPlusMinus(jsonGame.getInt("plusMinus"));
            game.setPTS(jsonGame.getInt("PTS"));
            game.setSteals(jsonGame.getInt("STL"));
            game.setThrees_made(jsonGame.getInt("threes_made"));
            game.setThrees_attempted(jsonGame.getInt("threes_attempted"));
            game.setTurnovers(jsonGame.getInt("TOV"));

            season.setGame(i, game);
        }

        Intent intent = new Intent(mContext, ResultActivity.class);
        intent.putExtra("season_object", season);
        mContext.startActivity(intent);
        //Pass Season



    }

    public RosterAdaptor(Player[] players, Context context){
        mPlayers = players;
        mContext = context;
    }

    @Override
    public int getItemCount() {
        return mPlayers.length;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        private ImageView profileImage;
        private TextView playerNameText;
        private TextView playerNumberText;
        private TextView playerPositionText;
        private RelativeLayout playerLayout;
        private Button getStatsBtn;

        public ListViewHolder(View itemView) {
            super(itemView);

            profileImage = (ImageView) itemView.findViewById(R.id.player_profile);
            playerNameText = (TextView) itemView.findViewById(R.id.player_name_text);
            playerNumberText = (TextView) itemView.findViewById(R.id.player_number_text);
            playerPositionText = (TextView) itemView.findViewById(R.id.player_position_text);
            playerLayout = (RelativeLayout) itemView.findViewById(R.id.playerItem);
            getStatsBtn = (Button) itemView.findViewById(R.id.get_stats_btn);
        }
    }

}
