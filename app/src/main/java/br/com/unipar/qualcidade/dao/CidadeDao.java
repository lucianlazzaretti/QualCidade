package br.com.unipar.qualcidade.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

import br.com.unipar.qualcidade.entities.Cidade;


@Dao
public interface CidadeDao {


    //@Query("SELECT * FROM cidades u where u.uf = :uf")
    //List<Cidade> findByUF(String uf);

    @Insert
    void insertAll(List<Cidade> cidades);
}



