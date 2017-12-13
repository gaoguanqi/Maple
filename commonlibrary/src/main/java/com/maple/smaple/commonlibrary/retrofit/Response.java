package com.maple.smaple.commonlibrary.retrofit;

/**
 * Created by JohnsonFan on 2017/9/29.
 */

public class Response<T> {

	public int status;//约定  -1为server返回数据异常  200为正常范围
	public String error;
	public T data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
