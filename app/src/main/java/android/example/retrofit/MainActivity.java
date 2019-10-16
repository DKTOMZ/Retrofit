package android.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MyAdapter myAdapter;
    private RecyclerView myRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Handler for RetrofitInstance Interface//

        GetData service = RetrofitClient.getRetrofitinstance().create(GetData.class);

        Call<List<RetroUsers>> call = service.getAllUsers();

        //Execute request synchronously//

        call.enqueue(new Callback<List<RetroUsers>>() {

            @Override

            //Handle a successful response//

            public void onResponse(Call<List<RetroUsers>> call, Response<List<RetroUsers>> response){
                loadDataList(response.body());
            }

            @Override

            //Handling execution failures//

            public void onFailure(Call<List<RetroUsers>> call, Throwable throwable){
                //If request fails, display this toast//
                Toast.makeText(MainActivity.this, "Unable to load users", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //List of retrieved data//

    private void loadDataList(List<RetroUsers> usersList) {

        //reference to the RecyclerView//

        myRecyclerView = findViewById(R.id.myRecyclerView);
        myAdapter = new MyAdapter(usersList);

        //LinearLayoutManager with default vertical orientation//

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        myRecyclerView.setLayoutManager(layoutManager);

        //Adapter to the RecyclerView//

        myRecyclerView.setAdapter(myAdapter);
    }
}
