package besupreme.com.dreamsquads.Adaptors;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import besupreme.com.dreamsquads.Models.Player;
import besupreme.com.dreamsquads.Models.Roster;
import besupreme.com.dreamsquads.R;

/**
 * Created by yinka_000 on 2016-08-10.
 */
public class RosterAdaptor extends RecyclerView.Adapter<RosterAdaptor.ListViewHolder> implements View.OnClickListener{
    private Player[] mPlayers;
    private Context mContext;

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.roster_list_item, parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        String urlPlayerName = mPlayers[position].getFirst_name() + "%20"+ mPlayers[position].getLast_name();
        String profileURL = "https://fantasy-app.herokuapp.com/images/profilePics/"+urlPlayerName+".png";
        Log.i("IMAGE URL", profileURL);
        Picasso.with(mContext)
                .load(profileURL)
                .into(holder.profileImage);
        Log.i("Team Color: ", Roster.TEAM.getPrimaryColour());
        holder.playerLayout.setBackgroundColor( Color.parseColor( "#"+Roster.TEAM.getSecondaryColour() ) );

        String playerName = mPlayers[position].getFirst_name() + " "+ mPlayers[position].getLast_name();
        holder.playerNameText.setText(playerName);

        if( mPlayers[position].getPlayer_number() != 999 ){
            holder.playerNumberText.setText( mPlayers[position].getPlayer_number() + "");
        }

        if( mPlayers[position].getPosition() != null ){
            holder.playerPositionText.setText( mPlayers[position].getPosition() );
        }
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
        private ActionBar bar;
        private ImageView profileImage;
        private TextView playerNameText;
        private TextView playerNumberText;
        private TextView playerPositionText;
        private RelativeLayout playerLayout;

        public ListViewHolder(View itemView) {
            super(itemView);

            profileImage = (ImageView) itemView.findViewById(R.id.player_profile);
            playerNameText = (TextView) itemView.findViewById(R.id.player_name_text);
            playerNumberText = (TextView) itemView.findViewById(R.id.player_number_text);
            playerPositionText = (TextView) itemView.findViewById(R.id.player_position_text);
            playerLayout = (RelativeLayout) itemView.findViewById(R.id.playerItem);
        }
    }

    @Override
    public void onClick(View mView) {

    }

}
