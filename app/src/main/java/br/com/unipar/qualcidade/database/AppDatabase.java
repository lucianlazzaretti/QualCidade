package br.com.unipar.qualcidade.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import br.com.unipar.qualcidade.dao.CidadeDao;
import br.com.unipar.qualcidade.entities.Cidade;


@Database(entities = {Cidade.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CidadeDao cidadeDao();

    public static AppDatabase getConnection(Context appContext) {
        return Room.databaseBuilder(appContext, AppDatabase.class, "qualcidade").build();
    }
}
