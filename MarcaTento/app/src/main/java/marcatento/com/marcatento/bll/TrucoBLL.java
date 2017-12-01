package marcatento.com.marcatento.bll;

/**
 * Created by fernando on 24/11/17.
 */

import java.util.ArrayList;
import android.content.Context;
import android.database.SQLException;
import marcatento.com.marcatento.dao.TrucoDAO;
import marcatento.com.marcatento.model.Truco;

public class TrucoBLL {

    protected TrucoDAO trucoDAO = null;

    public TrucoBLL(Context context) {
        trucoDAO = new TrucoDAO(context);
    }



    public long gravar(Truco truco) throws SQLException {
        return trucoDAO.gravar(truco);
    }

    public ArrayList<Truco> recuperarTodos() {
        return trucoDAO.recuperarTodos();
    }

    public Truco recuperarUm(int pk_id) {
        return trucoDAO.recuperarUm(pk_id);
    }

    public int alterar(Truco truco) throws SQLException {
        return trucoDAO.alterar(truco);
    }

    public int deletar(Truco truco) throws SQLException {
        return trucoDAO.deletar(truco);
    }
}
