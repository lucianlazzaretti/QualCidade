package br.com.unipar.qualcidade.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "estados")
public class Estado {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String nome;

    @ColumnInfo
    private String uff;

    public Estado(int id,String uf, String nome) {
        this.id = id;
        this.nome = nome;
        this.uff = uf;
    }



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
    public String getUff() {return uff;}
    public void setUff(String uf) { this.uff = uf;}
}
