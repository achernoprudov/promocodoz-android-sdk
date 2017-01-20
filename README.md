# Promocodoz android SDK

Android SDK for http://promocodoz.com/


To use SDK firstly you need to set your own config:


```
import com.promocodoz.sdk.Promocodoz;
import com.promocodoz.sdk.utils.Config;



Config.Builder builder = new Config.Builder();
builder.setAccountSid(yourAccoundSid);
builder.setSecretToken(yourSecretToken);

Config config = builder.build();
Promocodoz.getInstance().setConfig(config);
```


When your config is ready you could to reserve promocode from server:

```
import com.promocodoz.sdk.Promocodoz;
import com.promocodoz.sdk.utils.Config;

try {
    String promocodeValue = Promocodoz.getInstance().reservePromocode(promocode);
    // parse reserved promocode value
} catch (Throwable throwable) {
    // show message to UI
    Toast.makeToast(this, throwable.getMessage(), SHORT)
}
```