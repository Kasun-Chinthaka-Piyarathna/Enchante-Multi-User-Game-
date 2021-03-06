package com.example.kasunchinthaka.lastlastlast;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.shephertz.app42.paas.sdk.android.App42Exception;
import com.shephertz.app42.paas.sdk.android.game.Game;

import java.math.BigDecimal;
import java.util.ArrayList;

public class LeaderboardSample6 extends Activity implements AsyncApp42ServiceApi.App42ScoreBoardServiceListener{
    /**
     * The async service.
     */
    private AsyncApp42ServiceApi asyncService;

    /**
     * The progress dialog.
     */
    private ProgressDialog progressDialog;

    /**
     * The list.
     */
    ListView list;

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaderboard);
        list = (ListView) findViewById(R.id.leaderBoardList);
        asyncService = AsyncApp42ServiceApi.instance(this);



        progressDialog = ProgressDialog.show(this, "", "Saving Score..");
        progressDialog.setCancelable(true);
        asyncService.saveScoreForUser(Constants.App42GameName, Constants.UserName, new BigDecimal(USER.parameter), this);
    }

    /**
     * On previous clicked.
     *
     * @param view the view
     */
	/*public void onPreviousClicked(View view) {
		Intent mainIntent = new Intent(this, UploadSample.class);
		this.startActivity(mainIntent);
	}*/

    /**
     * On next clicked.
     *
     * @param view the view
     */
    public void onNextClicked(View view) {
        finish(); // add finish to finish current activity
        Intent mainIntent = new Intent(this, Level07.class);
        this.startActivity(mainIntent);
    }

    /**
     * On get score clicked.
     *
     * @param viewe the viewe
     */
    public void onGetScoreClicked(View view) {
        progressDialog = ProgressDialog.show(this, "", "Loading..");
        progressDialog.setCancelable(true);
        asyncService.getLeaderBoard(Constants.App42GameName, 10, this);
    }

    /**
     * On save score clicked.
     *
     * @param viewe the viewe
     */
    /*public void onSaveScoreClicked(View view) {
        progressDialog = ProgressDialog.show(this, "", "Saving Score..");
        progressDialog.setCancelable(true);
        asyncService.saveScoreForUser(Constants.App42GameName, Constants.UserName, new BigDecimal(30000), this); // must be a parameter
    }

    /* (non-Javadoc)
     * @see com.app42.android.sample.AsyncApp42ServiceApi.App42ScoreBoardServiceListener#onSaveScoreSuccess(com.shephertz.app42.paas.sdk.android.game.Game)
     */
    @Override
    public void onSaveScoreSuccess(Game response) {
        // TODO Auto-generated method stub
        progressDialog.dismiss();
        createAlertDialog("Score SuccessFully Saved, For UserName : " + response.getScoreList().get(0).getUserName()
                + " With Score : " + response.getScoreList().get(0).getValue());
    }

    /* (non-Javadoc)
     * @see com.app42.android.sample.AsyncApp42ServiceApi.App42ScoreBoardServiceListener#onSaveScoreFailed(com.shephertz.app42.paas.sdk.android.App42Exception)
     */
    @Override
    public void onSaveScoreFailed(App42Exception ex) {
        // TODO Auto-generated method stub
        progressDialog.dismiss();
        createAlertDialog("Exception Occurred : " + ex.getMessage());
    }

    /* (non-Javadoc)
     * @see com.app42.android.sample.AsyncApp42ServiceApi.App42ScoreBoardServiceListener#onLeaderBoardSuccess(com.shephertz.app42.paas.sdk.android.game.Game)
     */
    @Override
    public void onLeaderBoardSuccess(Game response) {
        // TODO Auto-generated method stub
        progressDialog.dismiss();
        ArrayList<String> rankList = new ArrayList<String>();
        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<String> scoreList = new ArrayList<String>();
        for (int i = 0; i < response.getScoreList().size(); i++) {
            int rank = i + 1;
            rankList.add(rank + "");
            String name = response.getScoreList().get(i).getUserName();
            nameList.add(name);
            BigDecimal scoreValue = response.getScoreList().get(i).getValue();
            scoreList.add(scoreValue + "");
        }
        LeaderboardAdapter adapter = new LeaderboardAdapter(LeaderboardSample6.this, nameList, rankList, scoreList);
        list.setAdapter(adapter);
    }


    /* (non-Javadoc)
     * @see com.app42.android.sample.AsyncApp42ServiceApi.App42ScoreBoardServiceListener#onLeaderBoardFailed(com.shephertz.app42.paas.sdk.android.App42Exception)
     */
    @Override
    public void onLeaderBoardFailed(App42Exception ex) {
        // TODO Auto-generated method stub
        progressDialog.dismiss();
        createAlertDialog("Exception Occurred : " + ex.getMessage());
    }

    /**
     * Creates the alert dialog.
     *
     * @param msg the msg
     */
    public void createAlertDialog(String msg) {
        AlertDialog.Builder alertbox = new AlertDialog.Builder(
                LeaderboardSample6.this);
        alertbox.setTitle("Response Message");
        alertbox.setMessage(msg);
        alertbox.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            // do something when the button is clicked
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        alertbox.show();
    }
    public void onBackPressed(){
        return;
    }


}
