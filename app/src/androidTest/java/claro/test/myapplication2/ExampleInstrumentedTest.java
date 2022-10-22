package claro.test.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.widget.Button;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpStatus;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpGet;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpUriRequest;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

import claro.test.myapplication2.interfaces.CountryService;
import retrofit2.Retrofit;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private MainActivity mainActivity;
    private Intent mIntent;

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("claro.test.myapplication2", appContext.getPackageName());
    }

    @Test
    public void givenGoodResponse_whenCountriesInfoIsRetrived_then200IsReceived() throws IOException {

    }

    @Before
    public void setUp() {
        mIntent = new Intent(InstrumentationRegistry.getInstrumentation().getTargetContext(),ApiScreen
              .class);
        mainActivity.startActivity(mIntent);
    }

    @Test
    public void testNextActivityLauchWithIntent() {
        mainActivity.startActivity(mIntent);
        Button lauchButton = mainActivity.findViewById(R.id.btnApiScreen);
        lauchButton.performClick();


    }
}