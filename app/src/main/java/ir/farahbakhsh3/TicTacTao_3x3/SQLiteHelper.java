package ir.Farahbakhsh3.TicTacTao_3x3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {
    public SQLiteHelper(@Nullable Context context) {
        super(context, "dbScores.sqlite3", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE [Scores](" +
                "[game_level] NVARCHAR(25)," +
                "[human] INT64," +
                "[draw] INT64," +
                "[ai] INT64)");

        //InitiateScores();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Scores");
    }

    public void DeleteScores() {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("Scores", null, null);

        db.close();
    }

    public void ResetScores() {
        DeleteScores();
        InitiateScores();
    }

    public void InitiateScores() {
        insert("beginner", 0, 0, 0);
        insert("easy", 0, 0, 0);
        insert("normal", 0, 0, 0);
        insert("hard", 0, 0, 0);
    }

    public void insert(String game_level, int human, int draw, int ai) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("game_level", game_level);
        cv.put("human", human);
        cv.put("draw", draw);
        cv.put("ai", ai);
        db.insert("Scores", null, cv);

        db.close();
    }

    public int[][] selectScores() {
        SQLiteDatabase db = getReadableDatabase();

        int[][] Scores = new int[4][3];
        int idx = 0;
        Cursor cursor = db.rawQuery("select * from Scores", null);
        if (cursor.moveToFirst())
            do {
                Scores[idx][0] = cursor.getInt(1);
                Scores[idx][1] = cursor.getInt(2);
                Scores[idx][2] = cursor.getInt(3);
                idx++;
            } while (cursor.moveToNext());

        db.close();
        return Scores;
    }

    public void setScore(int ii, int jj) {
        int[][] scores = selectScores();
        DeleteScores();

        scores[ii][jj]++;

        insert("beginner", scores[0][0], scores[0][1], scores[0][2]);
        insert("easy", scores[1][0], scores[1][1], scores[1][2]);
        insert("normal", scores[2][0], scores[2][1], scores[2][2]);
        insert("hard", scores[3][0], scores[3][1], scores[3][2]);
    }
}
