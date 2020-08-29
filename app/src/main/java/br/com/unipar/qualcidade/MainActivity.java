package br.com.unipar.qualcidade;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import br.com.unipar.qualcidade.adapter.CidadeAdapter;
import br.com.unipar.qualcidade.dao.CidadeDao;
import br.com.unipar.qualcidade.database.RoomDatabaseOpenHelper;
import br.com.unipar.qualcidade.entities.Cidade;
import br.com.unipar.qualcidade.entities.Estado;
import br.com.unipar.qualcidade.rest.CidadeService;
import br.com.unipar.qualcidade.service.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private Spinner sp;
    private ListView cidade;
    private  List<Cidade> listacidades = new ArrayList<Cidade>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.cidade = findViewById(R.id.lstCidades);




        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cities, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp = (Spinner) findViewById(R.id.selecao);
        sp.setAdapter(adapter);

        final Context context = this;

        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new Estado[]{
                new Estado(11, "RO", "Rondônia"),
                new Estado(12, "AC","Acre"),
                new Estado(13, "AM","Amazonas"),
                new Estado(14,"RR", "Roraima"),
                new Estado(15, "PA","Pará"),
                new Estado(16,"AP", "Amapá"),
                new Estado(17, "TO","Tocantins"),
                new Estado(21,"MA", "Maranhão"),
                new Estado(22, "PI","Piauí"),
                new Estado(23, "CE","Ceará"),
                new Estado(24, "RN","Rio Grande do Norte"),
                new Estado(25, "PB","Paraíba"),
                new Estado(26, "PE","Pernambuco"),
                new Estado(27, "AL","Alagoas"),
                new Estado(28, "SE","Sergipe"),
                new Estado(29, "BA","Bahia"),
                new Estado(31, "MG","Minas Gerais"),
                new Estado(32, "ES","Espírito Santo"),
                new Estado(33, "RJ","Rio de Janeiro"),
                new Estado(35, "SP","São Paulo"),
                new Estado(41, "PR","Paraná"),
                new Estado(42, "SC","Santa Catarina"),
                new Estado(43, "RS","Rio Grande do Sul"),
                new Estado(50, "MS","Mato Grosso do Sul"),
                new Estado(51, "MT","Mato Grosso"),
                new Estado(52, "GO","Goiás"),
                new Estado(53, "DF","Distrito Federal")
        });


        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int nome, long id) {
                CidadeDao cidadeDao = RoomDatabaseOpenHelper.getDatabase(new WeakReference<>(context)).cidadeDao();
                Log.d(">>>>>>>>",sp.getSelectedItem().toString());
                int temp = 0;
                if(sp.getSelectedItem().toString().equals("Rondônia")){ temp = 11; }
                else if(sp.getSelectedItem().toString().equals("Acre")){ temp = 12; }
                else if(sp.getSelectedItem().toString().equals("Amazonas")){ temp = 13; }
                else if(sp.getSelectedItem().toString().equals("Roraima")){ temp = 14; }
                else if(sp.getSelectedItem().toString().equals("Pará")){ temp = 15; }
                else if(sp.getSelectedItem().toString().equals("Amapá")){ temp = 16; }
                else if(sp.getSelectedItem().toString().equals("Tocantins")){ temp = 17; }
                else if(sp.getSelectedItem().toString().equals("Maranhão")){ temp = 21; }
                else if(sp.getSelectedItem().toString().equals("Piauí")){ temp = 22; }
                else if(sp.getSelectedItem().toString().equals("Ceará")){ temp = 23; }
                else if(sp.getSelectedItem().toString().equals("Rio Grande do Norte")){ temp = 24; }
                else if(sp.getSelectedItem().toString().equals("Paraíba")){ temp = 25; }
                else if(sp.getSelectedItem().toString().equals("Pernambuco")){ temp = 26; }
                else if(sp.getSelectedItem().toString().equals("Alagoas")){ temp = 27; }
                else if(sp.getSelectedItem().toString().equals("Sergipe")){ temp = 28; }
                else if(sp.getSelectedItem().toString().equals("Bahia")){ temp = 29; }
                else if(sp.getSelectedItem().toString().equals("Minas Gerais")){ temp = 31; }
                else if(sp.getSelectedItem().toString().equals("Espírito Santo")){ temp = 32; }
                else if(sp.getSelectedItem().toString().equals("Rio de Janeiro")){ temp = 33; }
                else if(sp.getSelectedItem().toString().equals("São Paulo")){ temp = 35; }
                else if(sp.getSelectedItem().toString().equals("Paraná")){ temp = 41; }
                else if(sp.getSelectedItem().toString().equals("Santa Catarina")){ temp = 42; }
                else if(sp.getSelectedItem().toString().equals("Rio Grande do Sul")){ temp = 43; }
                else if(sp.getSelectedItem().toString().equals("Mato Grosso do Sul")){ temp = 50; }
                else if(sp.getSelectedItem().toString().equals("Mato Grosso")){ temp = 51; }
                else if(sp.getSelectedItem().toString().equals("Goiás")){ temp = 52; }
                else if(sp.getSelectedItem().toString().equals("Distrito Federal")){ temp = 53; }
                //  Estado estado = (Estado) sp.getSelectedItem();
                // Log.d(">>>>>>>><<<<<<<<<",estado.getUff());
                //List<Cidade> cidades = cidadeDao.findByUF(estado.getUff());

                    listarMunicipio(temp);

               // cidadeService.findAll(temp);
               // Log.d(">>>", String.valueOf(temp));

            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
    public void listarMunicipio(int temp){
        CidadeService cidadeService = RetrofitService.getInstance().create(CidadeService.class);
        Log.d(">>>", String.valueOf(temp));
        //Get context
        final WeakReference<Context> weakReference = new WeakReference(this);

        //Chamada http
       cidadeService.groupList(temp).enqueue(new Callback<List<Cidade>>() {
           @Override
           public void onResponse(Call<List<Cidade>> call, Response<List<Cidade>> response) {
               CidadeAdapter cidadeAdapter = new CidadeAdapter(response.body(), weakReference);
               Log.d("<<<<<<<",cidadeAdapter.toString());
               cidade.setAdapter(cidadeAdapter);
           }

           @Override
           public void onFailure(Call<List<Cidade>> call, Throwable t) {
               Toast.makeText(weakReference.get(), "Não foi possível carregar as cidades.", Toast.LENGTH_LONG).show();
           }
       });

    }

}




