package lcy.android.retrofit_config;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import lcy.android.retrofit_config.models.GetModel;
import lcy.android.retrofit_config.models.PostModel;
import lcy.android.retrofit_config.webservices.ApiBuilder;
import lcy.android.retrofit_config.webservices.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button get , post;

    private TextView getRes, postRes;

    private EditText name , job;

    private static final String BASE_URL = "https://reqres.in";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getRes = (TextView) findViewById(R.id.get_res) ;
        postRes = (TextView) findViewById(R.id.post_res) ;

        get = (Button) findViewById(R.id.get_btn);
        post = (Button) findViewById(R.id.post_btn);

        name = (EditText) findViewById(R.id.name);
        job = (EditText) findViewById(R.id.job);

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiService service = ApiBuilder.builder(BASE_URL).create(ApiService.class);
                Call<GetModel> response = service.getUsers("2");

                response.enqueue(new Callback<GetModel>() {
                    @Override
                    public void onResponse(Call<GetModel> call, Response<GetModel> response) {
                        getRes.setText(response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<GetModel> call, Throwable t) {

                    }
                });
            }
        });

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PostModel model = new PostModel();
                model.setName(name.getText().toString());
                model.setJob(job.getText().toString());
                ApiService service = ApiBuilder.builder(BASE_URL).create(ApiService.class);
                Call<PostModel> response = service.createUser(model);

                response.enqueue(new Callback<PostModel>() {
                    @Override
                    public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                        postRes.setText(response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<PostModel> call, Throwable t) {

                    }
                });
            }
        });
    }
}
