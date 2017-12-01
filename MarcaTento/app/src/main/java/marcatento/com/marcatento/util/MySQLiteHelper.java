package marcatento.com.marcatento.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fernando on 24/11/17.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "Truco.db";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateTableTbTruco = "CREATE TABLE IF NOT EXISTS tb_truco ("
                + "pk_id integer PRIMARY KEY AUTOINCREMENT,"
                + "vencedor integer NOT NULL"
                + "pontosNos integer NOT NULL"
                + "pontosEles integer NOT NULL"
                + "duracao varchar(6) NOT NULL);";

        db.execSQL(sqlCreateTableTbTruco);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tb_funcionario table if existed
        //db.execSQL("DROP TABLE IF EXISTS tb_funcionario");

        // create fresh tb_funcionario table
        //this.onCreate(db);
    }
}
