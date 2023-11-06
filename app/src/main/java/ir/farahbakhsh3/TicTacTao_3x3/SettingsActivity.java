package ir.Farahbakhsh3.TicTacTao_3x3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void btnOK_click(View view) {
        Intent GoActivity = new Intent(SettingsActivity.this, BoardActivity.class);
        RadioButton radioButton_OnePlayer = (RadioButton) findViewById(R.id.radioButton_OnePlayer);
        RadioButton radioButton_TwoPlayer = (RadioButton) findViewById(R.id.radioButton_TwoPlayer);

        RadioButton radioButton_game_level_beginner = (RadioButton) findViewById(R.id.radioButton_game_level_beginner);
        RadioButton radioButton_game_level_easy = (RadioButton) findViewById(R.id.radioButton_game_level_easy);
        RadioButton radioButton_game_level_normal = (RadioButton) findViewById(R.id.radioButton_game_level_normal);
        RadioButton radioButton_game_level_hard = (RadioButton) findViewById(R.id.radioButton_game_level_hard);

        GoActivity.putExtra(getString(R.string.game_level),
                radioButton_game_level_beginner.isChecked() ? BoardActivity.GAME_LEVEL_BEGINNER
                        : radioButton_game_level_easy.isChecked() ? BoardActivity.GAME_LEVEL_EASY
                        : radioButton_game_level_normal.isChecked() ? BoardActivity.GAME_LEVEL_NORMAL
                        : BoardActivity.GAME_LEVEL_HARD);
        GoActivity.putExtra(getString(R.string.play_type),
                radioButton_OnePlayer.isChecked() ? BoardActivity.ONE_PLAYER
                        : BoardActivity.TWO_PLAYER);
        startActivity(GoActivity);
    }

    public void btnReport_click(View view) {
        Intent GoActivity = new Intent(SettingsActivity.this, ReportsActivity.class);
        startActivity(GoActivity);
    }
}