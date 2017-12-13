package com.maple.smaple.commonlibrary.retrofit.ApiService;


import com.maple.smaple.commonlibrary.retrofit.Response;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

	@GET("mobile/version?a=version")  //com.bskj.healthymall
	Observable<Response<String>> updateVersion (@Query("packname") String packname);
}
