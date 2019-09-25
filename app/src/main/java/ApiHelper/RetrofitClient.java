package ApiHelper;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    private BaseApiService uploadInterface;
    public static final String BASE_URL_API = "https://api.surat.com/";

    public static Retrofit getClient(String BASE_URL_API)
    {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();

        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }

        return  retrofit;
    }

    private static Retrofit getClient()
    {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL_API)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }

    public static BaseApiService getApiServices()
    {
        return getClient().create(BaseApiService.class);
    }

}
