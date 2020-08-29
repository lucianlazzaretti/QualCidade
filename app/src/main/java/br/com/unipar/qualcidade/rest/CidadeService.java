package br.com.unipar.qualcidade.rest;
import java.util.List;

import br.com.unipar.qualcidade.entities.Cidade;
import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.http.Path;

public interface CidadeService {

    @GET("/api/v1/localidades/estados/{UF}/municipios")
    Call<List<Cidade>>  groupList(@Path("UF") int groupId);
            //Call<List<Cidade>>  findAll(@Path("UF") Long uf); //findAll(int UF);

}
