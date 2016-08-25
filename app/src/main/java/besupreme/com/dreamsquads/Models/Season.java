package besupreme.com.dreamsquads.Models;

import android.os.Parcel;
import android.os.Parcelable;

import static besupreme.com.dreamsquads.Models.Game.*;

/**
 * Created by yinka_000 on 2016-08-11.
 */
public class Season implements Parcelable{
    private Game[] mSeasonGames;
    private double PPG;
    private double APG;
    private double RPG;
    private double TOV;
    private double fouls;
    private double BPG;
    private double plusMinus;
    private double MPG;
    private double Steals;
    private double FGPER;
    private double threePPER;
    private double FTPER;

    public Season(){}

    public String getPPGString(){
        return Math.round(PPG * 100.0)/100.0 +" Points per Game";
    }
    public String getAPGString(){
        return Math.round(APG * 100.0)/100.0 +" Assists per Game";
    }
    public String getRPGString(){
        return Math.round(RPG * 100.0)/100.0 +" Rebounds per Game";
    }
    public String getTOVString(){
        return Math.round(PPG * 100.0)/100.0 +" TOV per Game";
    }
    public String getFoulString(){
        return Math.round(fouls * 100.0)/100.0 +" Fouls per Game";
    }
    public String getBPGString(){
        return Math.round(BPG * 100.0)/100.0 +" Blocks per Game";
    }
    public String getPlusMinusString(){
        return Math.round(plusMinus * 100.0)/100.0 +" +/- Rating per Game";
    }
    public String getFGPerString(){
        return Math.round(FGPER * 100.0)/100.0 +" Poinst per Game";
    }
    public String getMPGString(){
        return Math.round(MPG * 100.0)/100.0 +" Minutes per Game";
    }
    public String getStealsString(){
        return Math.round(Steals * 100.0)/100.0 +" Steals per Game";
    }
    public String getThreePPERString(){
        return Math.round(threePPER * 100.0)/100.0 +" Poinst per Game";
    }

    public String getFTPERString(){
        return Math.round(FTPER * 100.0)/100.0 +" Poinst per Game";
    }


    public Game[] getSeasonGames() {
        return mSeasonGames;
    }

    public void setGame(int position, Game game){
        mSeasonGames[position] = game;
    }

    public void setSeasonGames(Game[] mSeasonGames) {
        this.mSeasonGames = mSeasonGames;
    }

    public double getPPG() {
        return PPG;
    }

    public void setPPG(double mPPG) {
        PPG = mPPG;
    }

    public double getAPG() {
        return APG;
    }

    public void setAPG(double mAPG) {
        APG = mAPG;
    }

    public double getRPG() {
        return RPG;
    }

    public void setRPG(double mRPG) {
        RPG = mRPG;
    }

    public double getTOV() {
        return TOV;
    }

    public void setTOV(double mTOV) {
        TOV = mTOV;
    }

    public double getFouls() {
        return fouls;
    }

    public void setFouls(double mFouls) {
        fouls = mFouls;
    }

    public double getBPG() {
        return BPG;
    }

    public void setBPG(double mBPG) {
        BPG = mBPG;
    }

    public double getPlusMinus() {
        return plusMinus;
    }

    public void setPlusMinus(double mPlusMinus) {
        plusMinus = mPlusMinus;
    }

    public double getMPG() {
        return MPG;
    }

    public void setMPG(double mMPG) {
        MPG = mMPG;
    }

    public double getSteals() {
        return Steals;
    }

    public void setSteals(double mSteals) {
        Steals = mSteals;
    }

    public double getFGPER() {
        return FGPER;
    }

    public void setFGPER(double mFGPER) {
        FGPER = mFGPER;
    }

    public double getThreePPER() {
        return threePPER;
    }

    public void setThreePPER(double mThreePPER) {
        threePPER = mThreePPER;
    }

    public double getFTPER() {
        return FTPER;
    }

    public void setFTPER(double mFTPER) {
        FTPER = mFTPER;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel mParcel, int mI) {
        mParcel.writeTypedArray(mSeasonGames,mI);
        mParcel.writeDouble(PPG);
        mParcel.writeDouble(APG);
        mParcel.writeDouble(RPG);
        mParcel.writeDouble(TOV);
        mParcel.writeDouble(fouls);
        mParcel.writeDouble(BPG);
        mParcel.writeDouble(plusMinus);
        mParcel.writeDouble(MPG);
        mParcel.writeDouble(Steals);
        mParcel.writeDouble(FGPER);
        mParcel.writeDouble(threePPER);
        mParcel.writeDouble(FTPER);
    }

    public static final Parcelable.Creator<Season> CREATOR
            = new Parcelable.Creator<Season>(){

        @Override
        public Season createFromParcel(Parcel mParcel) {
            return new Season(mParcel);
        }

        @Override
        public Season[] newArray(int mI) {
            return new Season[mI];
        }
    };


    public Season(Parcel mParcel) {
        mSeasonGames = mParcel.createTypedArray(Game.CREATOR);
        PPG = mParcel.readDouble();
        APG = mParcel.readDouble();
        RPG = mParcel.readDouble();
        TOV = mParcel.readDouble();
        fouls = mParcel.readDouble();
        BPG = mParcel.readDouble();
        plusMinus = mParcel.readDouble();
        MPG = mParcel.readDouble();
        Steals = mParcel.readDouble();
        FGPER = mParcel.readDouble();
        threePPER = mParcel.readDouble();
        FTPER = mParcel.readDouble();
    }
}
