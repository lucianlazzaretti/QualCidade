package br.com.unipar.qualcidade.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "cidades")
public class Cidade {

    public static final String ID = "id";
    public static final String NOME = "nome";



    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    private int id;

    @ColumnInfo(name = NOME)
    private String nome;



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

}

