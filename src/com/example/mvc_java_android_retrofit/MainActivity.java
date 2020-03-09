package com.example.mvc_java_android_retrofit;

import io.reactivex.Observable;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.adapter.rxjava2.*;

import com.example.mvc_java_android_retrofit.RetrofitApi;

//Retrofit requires at minimum Java 7 or Android 2.3.

//https://www.vogella.com/tutorials/Retrofit/article.html
public class MainActivity extends Activity {

	private RetrofitApi retrofitApi;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Retrofit retrofit = new Retrofit.Builder()
	    .baseUrl("http://javarestjson.herokuapp.com/api")
	    .addConverterFactory(GsonConverterFactory.create())
	    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
	    .build();
		
		this.retrofitApi = retrofit.create(RetrofitApi.class);
		
		//https://www.baeldung.com/retrofit-rxjava
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
