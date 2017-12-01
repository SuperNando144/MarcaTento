package marcatento.com.marcatento.dao;


import marcatento.com.marcatento.model.Truco;
import marcatento.com.marcatento.util.MySQLiteHelper;
import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
/**
 * Created by fernando on 24/11/17.
 */

public class TrucoDAO {

    private SQLiteDatabase db = null;
    private MySQLiteHelper mySQLiteHelper = null;

    public TrucoDAO(Context context) {
        mySQLiteHelper = new MySQLiteHelper(context);
    }

    public long gravar(Truco truco) throws SQLException {
        // 1. recupera a referencia do db
        this.db = mySQLiteHelper.getWritableDatabase();

        // 2. preparar uma ContentValues com os parametros para insert
        ContentValues cv = new ContentValues();
        cv.put("vencedor", truco.getVencedor());
        cv.put("pontosNos", truco.getPontosNos());
        cv.put("pontosEles", truco.getPontosEles());
        cv.put("duracao", truco.getDuracao());
        // 3. realizar o insert
        long retorno = db.insert("tb_truco", null, cv);

        // 4. fechar o banco e dar o retorno
        db.close();
        return retorno;
    }

    public ArrayList<Truco> recuperarTodos() {
        ArrayList<Truco> funcList = new ArrayList<Truco>();

        // 1. construir a query
        String query = "SELECT  * FROM tb_truco";

        // 2. recupera a referencia do db
        this.db = mySQLiteHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. para cada registro, transformar em objeto (do tipo Funcionario) e
        // adicionar a lista
        if (cursor.moveToFirst()) {
            do {
                Truco truco = new Truco();
                truco.setPk_id(Integer.parseInt(cursor.getString(0)));
                truco.setVencedor(Integer.parseInt(cursor.getString(1)));
                truco.setPontosNos(Integer.parseInt(cursor.getString(2)));
                truco.setPontosEles(Integer.parseInt(cursor.getString(3)));
                truco.setDuracao(cursor.getString(4));
                // 3.1. adicionar o func a lista de funcionarios
                funcList.add(truco);
            } while (cursor.moveToNext());
        }

        // 4. fechar o banco e dar o retorno
        db.close();
        return funcList;
    }

    public Truco recuperarUm(int pk_id) {
        Truco truco = null;

        // 1. construir a query
        String query = "SELECT  * FROM tb_truco WHERE pk_id = " + pk_id;

        // 2. recupera a referencia do db
        this.db = mySQLiteHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. recuperar o registro e transformar em objeto de Funcionario
        if (cursor != null){
            cursor.moveToFirst();
            truco = new Truco();
            truco.setPk_id(Integer.parseInt(cursor.getString(0)));
            truco.setVencedor(Integer.parseInt(cursor.getString(1)));
            truco.setPontosNos(Integer.parseInt(cursor.getString(2)));
            truco.setPontosEles(Integer.parseInt(cursor.getString(3)));
            truco.setDuracao(cursor.getString(4));
        }

        // 4. fechar o banco e dar o retorno
        db.close();
        return truco;
    }

    public int alterar(Truco truco) throws SQLException {
        // 1. recupera a referencia do db
        this.db = mySQLiteHelper.getWritableDatabase();

        // 2. preparar uma ContentValues com os parametros para insert
        ContentValues cv = new ContentValues();
        cv.put("vencedor", truco.getVencedor());
        cv.put("pontosNos", truco.getPontosNos());
        cv.put("pontosEles", truco.getPontosEles());
        cv.put("duracao", truco.getDuracao());

        // 3. realizar o update
        int retorno = db.update("tb_truco", cv, "pk_truco = ?",
                new String[] { String.valueOf(truco.getPk_id()) });

        // 4. fechar o banco e dar o retorno
        db.close();
        return retorno;
    }

    public int deletar(Truco truco) throws SQLException {
        // 1. recupera a referencia do db
        this.db = mySQLiteHelper.getWritableDatabase();

        // 2. realizar o delete
        int retorno = db.delete("tb_truco", "pk_truco = ?",
                new String[] { String.valueOf(truco.getPk_id()) });

        // 3. fechar o banco e dar o retorno
        db.close();
        return retorno;
    }
}
