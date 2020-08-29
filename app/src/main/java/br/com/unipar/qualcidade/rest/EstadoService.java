package br.com.unipar.qualcidade.rest;

import java.util.List;

import br.com.unipar.qualcidade.entities.Estado;
import retrofit2.Call;
import retrofit2.http.GET;

public interface EstadoService {

    @GET("/api/v1/localidades/estados")
    Call<List<Estado>> findAll();
}