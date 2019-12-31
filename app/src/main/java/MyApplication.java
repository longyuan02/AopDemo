import android.app.Application;

public class MyApplication extends Application {
    public static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        this.myApplication = this;
    }

    public static MyApplication getInstance() {
        return myApplication;
    }
}
