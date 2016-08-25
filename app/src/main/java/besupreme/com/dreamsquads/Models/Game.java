package besupreme.com.dreamsquads.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yinka_000 on 2016-08-11.
 */
public class Game implements Parcelable{
    private int plusMinus;
    private int PTS;
    private int fouls;
    private int turnovers;
    private int blocks;
    private int steals;
    private int assists;
    private int DRB;
    private int ORB;
    private int FTA = 0;
    private int FTM;
    private int threes_attempted = 0;
    private int threes_made;
    private int FGA = 0;
    private int FGM;
    private int minutes;
    private String date;

    public Game(){}

    public int getPlusMinus() {
        return plusMinus;
    }

    public void setPlusMinus(int mPlusMinus) {
        plusMinus = mPlusMinus;
    }

    public int getPTS() {
        return PTS;
    }

    public void setPTS(int mPTS) {
        PTS = mPTS;
    }

    public int getFouls() {
        return fouls;
    }

    public void setFouls(int mFouls) {
        fouls = mFouls;
    }

    public int getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(int mTurnovers) {
        turnovers = mTurnovers;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int mBlocks) {
        blocks = mBlocks;
    }

    public int getSteals() {
        return steals;
    }

    public void setSteals(int mSteals) {
        steals = mSteals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int mAssists) {
        assists = mAssists;
    }

    public int getDRB() {
        return DRB;
    }

    public void setDRB(int mDRB) {
        DRB = mDRB;
    }

    public int getORB() {
        return ORB;
    }

    public void setORB(int mORB) {
        ORB = mORB;
    }

    public int getFTA() {
        return FTA;
    }

    public void setFTA(int mFTA) {
        FTA = mFTA;
    }

    public int getFTM() {
        return FTM;
    }

    public void setFTM(int mFTM) {
        FTM = mFTM;
    }

    public int getThrees_attempted() {
        return threes_attempted;
    }

    public void setThrees_attempted(int mThrees_attempted) {
        threes_attempted = mThrees_attempted;
    }

    public int getThrees_made() {
        return threes_made;
    }

    public void setThrees_made(int mThrees_made) {
        threes_made = mThrees_made;
    }

    public int getFGA() {
        return FGA;
    }

    public void setFGA(int mFGA) {
        FGA = mFGA;
    }

    public int getFGM() {
        return FGM;
    }

    public void setFGM(int mFGM) {
        FGM = mFGM;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int mMinutes) {
        minutes = mMinutes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String mDate) {
        date = mDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel mParcel, int mI) {
        mParcel.writeInt(plusMinus);
        mParcel.writeInt(PTS);
        mParcel.writeInt(fouls);
        mParcel.writeInt(turnovers);
        mParcel.writeInt(blocks);
        mParcel.writeInt(steals);
        mParcel.writeInt(assists);
        mParcel.writeInt(DRB);
        mParcel.writeInt(ORB);
        mParcel.writeInt(FTA);
        mParcel.writeInt(FTM);
        mParcel.writeInt(threes_attempted);
        mParcel.writeInt(threes_made);
        mParcel.writeInt(FGA);
        mParcel.writeInt(FGM);
        mParcel.writeInt(minutes);
        mParcel.writeString(date);
    }

    public static final Parcelable.Creator<Game> CREATOR
            = new Parcelable.Creator<Game>(){

        @Override
        public Game createFromParcel(Parcel mParcel) {
            return new Game(mParcel);
        }

        @Override
        public Game[] newArray(int mI) {
            return new Game[mI];
        }
    };

    private Game(Parcel mParcel) {
         plusMinus = mParcel.readInt();
         PTS= mParcel.readInt();
         fouls= mParcel.readInt();
         turnovers= mParcel.readInt();
         blocks= mParcel.readInt();
         steals= mParcel.readInt();
         assists= mParcel.readInt();
         DRB= mParcel.readInt();
         ORB= mParcel.readInt();
         FTA= mParcel.readInt();
         FTM= mParcel.readInt();
         threes_attempted= mParcel.readInt();
         threes_made= mParcel.readInt();
         FGA= mParcel.readInt();
         FGM= mParcel.readInt();
         minutes= mParcel.readInt();
         date= mParcel.readString();
    }


}
