package android.example.retrofit;

import com.google.gson.annotations.SerializedName;

public class RetroUsers {

    //Giving the field a custom name//

    @SerializedName("name")
    private String name;

    public RetroUsers(String name){
        this.name = name;
    }

    //Retrieve data using getter/setter methods//

    public String getUser(){
        return name;
    }

    public void setUser(String name){
        this.name = name;
    }
}
