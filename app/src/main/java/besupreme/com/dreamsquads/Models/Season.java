package besupreme.com.dreamsquads.Models;

/**
 * Created by yinka_000 on 2016-08-11.
 */
public class Season {
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
}
