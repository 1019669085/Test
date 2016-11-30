package com.test.one;

import java.util.Map;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.QueryMap;

public interface IBean {
	@GET("ddd")
	Call<Bean> getBean(@QueryMap Map<String, String> map);
}
