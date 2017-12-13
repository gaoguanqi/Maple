package com.maple.smaple.commonlibrary.retrofit.Observers;



import android.util.Log;

import com.maple.smaple.commonlibrary.retrofit.Response;
import com.maple.smaple.commonlibrary.retrofit.RxExceptionUtil;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by JohnsonFan on 2017/9/29.
 */

public abstract class BaseObserver<T> implements Observer<Response<T>> {

	@Override
	public final void onNext(@NonNull Response<T> result) {
		Log.e("TAG",result.getStatus()+"");
		if (result.getStatus() == -1) {
			onFailure(new Exception(result.getError()),  result.getError());
		} else {
			onSuccess(result.getData());
		}
	}

	@Override
	public void onError(@NonNull Throwable e) {
		onFailure(e, RxExceptionUtil.exceptionHandler(e));
	}



	@Override
	public void onComplete() {

	}

	@Override
	public void onSubscribe(@NonNull Disposable d) {

	}

	public abstract void onSuccess(T result);

	public abstract void onFailure(Throwable e, String errorMsg);
}
