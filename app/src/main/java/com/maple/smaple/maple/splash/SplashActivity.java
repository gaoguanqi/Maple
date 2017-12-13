package com.maple.smaple.maple.splash;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.maple.smaple.baselibrary.base.BaseActivity;
import com.maple.smaple.commonlibrary.retrofit.Observers.ProgressObserver;
import com.maple.smaple.commonlibrary.retrofit.RxHttp;
import com.maple.smaple.commonlibrary.retrofit.RxSchedulers;
import com.maple.smaple.maple.R;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;


public class SplashActivity extends BaseActivity {
    private static final String TAG = "RxPermissionTest";

    private Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       // startActivity(new Intent(this, HomeActivity.class));
        ctx = this;
        requestPermissions();

        //这边是随便填写的网络请求url
     /*   RxHttp.getInstance().getSyncServer().getLatestVersion("1", "1.0.0")
                .compose(RxSchedulers.observableIO2Main(this))
                .subscribe(new ProgressObserver<String>(this) {
                    @Override
                    public void onSuccess(String result) {
                        Toast.makeText(SplashActivity.this, "成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Throwable e, String errorMsg) {
                        Toast.makeText(SplashActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
                    }
                });*/

        RxHttp.getInstance().getSyncServer().updateVersion("com.bskj.healthymall")
                .compose(RxSchedulers.observableIO2Main(this))
                .subscribe(new ProgressObserver<String>(this) {
                    @Override
                    public void onSuccess(String result) {
                        Toast.makeText(SplashActivity.this, "成功"+result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Throwable e, String errorMsg) {
                        Toast.makeText(SplashActivity.this, "onFailure:"+errorMsg, Toast.LENGTH_SHORT).show();
                    }
                });
    }


    @Override
    protected boolean isImmersionBarEnabled() {
        return false;
    }

    private void requestPermissions() {
        RxPermissions rxPermission = new RxPermissions(this);
        rxPermission.requestEach(Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.READ_PHONE_STATE)
                .subscribe(new io.reactivex.functions.Consumer<Permission>() {
                    @Override
                    public void accept(Permission permission) throws Exception {
                        if (permission.granted) {
                            // 用户已经同意该权限
                            Log.d(TAG, permission.name + " is granted.");
                        } else if (permission.shouldShowRequestPermissionRationale) {
                            // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时，还会提示请求权限的对话框
                            Log.d(TAG, permission.name + " is denied. More info should be provided.");
                        } else {
                            // 用户拒绝了该权限，并且选中『不再询问』
                            Log.d(TAG, permission.name + " is denied.");
                        }
                    }
                });

    }


    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();

    }
}
