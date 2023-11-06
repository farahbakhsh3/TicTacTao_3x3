package ir.Farahbakhsh3.TicTacTao_3x3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ReportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        ShowScores();
    }

    public void ShowScores(){
        SQLiteHelper sql = new SQLiteHelper(getApplicationContext());
        int[][] Scores = sql.selectScores();
        TextView txt02 = findViewById(R.id.txt02);
        TextView txt03 = findViewById(R.id.txt03);
        TextView txt04 = findViewById(R.id.txt04);
        TextView txt12 = findViewById(R.id.txt12);
        TextView txt13 = findViewById(R.id.txt13);
        TextView txt14 = findViewById(R.id.txt14);
        TextView txt22 = findViewById(R.id.txt22);
        TextView txt23 = findViewById(R.id.txt23);
        TextView txt24 = findViewById(R.id.txt24);
        TextView txt32 = findViewById(R.id.txt32);
        TextView txt33 = findViewById(R.id.txt33);
        TextView txt34 = findViewById(R.id.txt34);

        txt02.setText(Scores[0][0]+"");
        txt03.setText(Scores[0][1]+"");
        txt04.setText(Scores[0][2]+"");
        txt12.setText(Scores[1][0]+"");
        txt13.setText(Scores[1][1]+"");
        txt14.setText(Scores[1][2]+"");
        txt22.setText(Scores[2][0]+"");
        txt23.setText(Scores[2][1]+"");
        txt24.setText(Scores[2][2]+"");
        txt32.setText(Scores[3][0]+"");
        txt33.setText(Scores[3][1]+"");
        txt34.setText(Scores[3][2]+"");
    }

    public boolean ResetScores(MenuItem menuItem){
        SQLiteHelper sql = new SQLiteHelper(getApplicationContext());
        sql.ResetScores();
        ShowScores();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem reportItem = menu.add(R.string.reset_report);
        reportItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        reportItem.setOnMenuItemClickListener(this::ResetScores);
        return true;
    }
}