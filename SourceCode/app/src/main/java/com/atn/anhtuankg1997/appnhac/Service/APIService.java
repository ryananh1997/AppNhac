package com.atn.anhtuankg1997.appnhac.Service;

public class APIService {

    private static String base_url = "https://ryananh1997.000webhostapp.com/Server/";

    public static Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }

}
