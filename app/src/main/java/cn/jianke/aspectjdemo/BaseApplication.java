package cn.jianke.aspectjdemo;

import android.app.Application;
import cn.jianke.library.LibrarySDK;

/**
 * @className: BaseApplication
 * @classDescription: 应用基类
 * @author: leibing
 * @createTime: 2017/2/18
 */
public class BaseApplication extends Application{
    // sington
    private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        // init
        LibrarySDK.init();
    }

    /**
     * get sington
     * @author leibing
     * @createTime 2017/2/18
     * @lastModify 2017/2/18
     * @param
     * @return
     */
    public static BaseApplication getInstance(){
        if (instance == null){
            synchronized (BaseApplication.class){
                if (instance == null)
                    instance = new BaseApplication();
            }
        }

        return instance;
    }
}
