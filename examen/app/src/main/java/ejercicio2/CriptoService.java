package ejercicio2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CriptoService {
    private static CriptoService instancia;
    private static CriptoRepo repo;

    private CriptoService(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("http://192.168.20.205:8000/").
                addConverterFactory(GsonConverterFactory.create()).build();
        repo=retrofit.create(CriptoRepo.class);
    }

    public static CriptoRepo getRepo(){
        return repo;
    }

    public static CriptoService getInstance(){
        if(instancia==null){
            instancia=new CriptoService();
        }
        return instancia;
    }
}
