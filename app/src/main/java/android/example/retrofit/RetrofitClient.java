package android.example.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;

    //Defining base URL//

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    //Creating retrofit instance

    public static Retrofit getRetrofitinstance(){
        if(retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)

                    //Adding converter//

                    .addConverterFactory(GsonConverterFactory.create())

                    //Building Retrofit instance//
                    .build();
        }
        return retrofit;
    }
}
