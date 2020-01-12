package com.example.boatcheck.Emulator;

import com.example.boatcheck.ConfigRetrofit.APIUtils;
import com.example.boatcheck.ConfigRetrofit.DataClient;
import com.example.boatcheck.User;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataShip {
  public static void main(String [] args ){
    Timer timer =new Timer();
    TimerTask task =new TestData();
    timer.scheduleAtFixedRate(task,new Date(),2000);
    //
  }
}
class TestData  extends TimerTask{

  @Override
  public void run() {
    DataClient dataClient = APIUtils.getData();
    Gialap gialap = new Gialap("1", "123");
    retrofit2.Call<String> callback = dataClient.gialapcau(gialap);
    callback.enqueue(new Callback<String>() {
      @Override
      public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful() && response.body().equals("SUCCESS")) {
          System.out.println("success ... ");
        }
      }

      @Override
      public void onFailure(Call<String> call, Throwable t) {
        System.out.println("Error ...");
      }
    });
  }
}
