import android.app.Application;

public class MyCustomApplication extends Application {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		PopdeemSDK.initializeSDK(this);
	}

}