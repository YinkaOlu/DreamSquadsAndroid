package besupreme.com.dreamsquads.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yinka_000 on 2016-08-10.
 */
public class Player implements Parcelable{
    private String player_id;
    private String preNBA_team;
    private String draft_year;
    private String start_date;
    private String position;
    private int player_number = 999;
    private String last_name;
    private String first_name;

    private int weight;
    private int height;

    private String birthDate;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int mWeight) {
        weight = mWeight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int mHeight) {
        height = mHeight;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String mBirthDate) {
        birthDate = mBirthDate;
    }

    public String getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(String mPlayer_id) {
        player_id = mPlayer_id;
    }

    public String getPreNBA_team() {
        return preNBA_team;
    }

    public void setPreNBA_team(String mPreNBA_team) {
        preNBA_team = mPreNBA_team;
    }

    public String getDraft_year() {
        return draft_year;
    }

    public void setDraft_year(String mDraft_year) {
        draft_year = mDraft_year;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String mStart_date) {
        start_date = mStart_date;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String mPosition) {
        position = mPosition;
    }

    public int getPlayer_number() {
        return player_number;
    }

    public void setPlayer_number(int mPlayer_number) {
        player_number = mPlayer_number;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String mLast_name) {
        last_name = mLast_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String mFirst_name) {
        first_name = mFirst_name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel mParcel, int mI) {
        mParcel.writeString(player_id);
        mParcel.writeString(preNBA_team);
        mParcel.writeString(draft_year);
        mParcel.writeString(start_date);
        mParcel.writeString(position);
        mParcel.writeInt(player_number);
        mParcel.writeString(last_name);
        mParcel.writeString(first_name);
        mParcel.writeInt(weight);
        mParcel.writeInt(height);
        mParcel.writeString(birthDate);
    }

    public static final Parcelable.Creator<Player> CREATOR
            = new Parcelable.Creator<Player>(){

        @Override
        public Player createFromParcel(Parcel mParcel) {
            return new Player(mParcel);
        }

        @Override
        public Player[] newArray(int mI) {
            return new Player[mI];
        }
    };

    public Player(){}

    public Player(Parcel mParcel){
        player_id = mParcel.readString();
        preNBA_team = mParcel.readString();
        draft_year = mParcel.readString();
        start_date = mParcel.readString();
        position = mParcel.readString();
        player_number = mParcel.readInt();
        last_name = mParcel.readString();
        first_name = mParcel.readString();

        weight = mParcel.readInt();
        height = mParcel.readInt();

        birthDate = mParcel.readString();
    }

}
