package lcy.android.retrofit_config.webservices;

import lcy.android.retrofit_config.models.GetModel;
import lcy.android.retrofit_config.models.PostModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by kaushik on 30/6/17.
 * The api service interface where we actually define the structure of the api
 * method types viz. GET POST PUT , request bidy, headers, query or path params
 * all the details are specified in this interface
 */

public interface ApiService {

    /**
     * a GET request that gets a list of users
     * page number as passed as a query param
     * the url will translate to http://yourserver.com/api/users?page=1
     * @param page
     * @return the response from the server in this case a list of users
     */
    @GET("/api/users")
    Call<GetModel> getUsers(@Query("page") String page);

    /**
     * POST request that creates a user
     * the data is passed in the form of json
     * @param request the json data containing the details of the user
     * @return the response from the server in this case the ide of the new user
     * along with other details
     */
    @POST("/api/users")
    Call<PostModel> createUser(@Body PostModel request);


}
