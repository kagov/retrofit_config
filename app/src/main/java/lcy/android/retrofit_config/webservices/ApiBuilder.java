package lcy.android.retrofit_config.webservices;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The Primary retrofit builder class
 * all the api calls are passed through this builder.
 * It contains a main builder method the returns an instance of Retrofit
 */
public class ApiBuilder {


    /**
     * The builder method
     * @param baseUrl the web service base url. This can be passed dynamically as below
     *                or can be specified in this class only
     * @return The Retrofit builder
     */
    public static Retrofit builder(final String baseUrl) {

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();
    }

    /**
     * buuilds the okhttp3 client that retrofit uses
     * additionally an interceptor is configured for logging purposes
     * and a connection timeout of 5 mins is set. This can be changes as per requirement
     * @return the {@link OkHttpClient}
     */
    private static OkHttpClient getClient() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient()
                .newBuilder()
                .addInterceptor(logging)
                .connectTimeout(5, TimeUnit.MINUTES).build();

    }

}
