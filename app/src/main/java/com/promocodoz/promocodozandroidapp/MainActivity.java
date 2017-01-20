package com.promocodoz.promocodozandroidapp;

import com.promocodoz.sdk.Promocodoz;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mResultText;
    private EditText mPromocode;
    private Button mSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindView();
        setupSendAction();
    }

    private void setupSendAction() {
        mSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String promocode = mPromocode.getText().toString();
                sendPromocode(promocode);
            }
        });
    }

    private void sendPromocode(String promocode) {
        try {
            String result = Promocodoz.getInstance().reservePromocode(promocode);
            mResultText.setText(getDefault(result, "<<empty>>"));
        } catch (Throwable throwable) {
            mResultText.setText(getDefault(throwable.getMessage(), throwable.toString()));
        }
    }

    private void bindView() {
        mResultText = (TextView) findViewById(R.id.result);
        mPromocode = (EditText) findViewById(R.id.promocode);
        mSend = (Button) findViewById(R.id.send_code);
    }

    private String getDefault(@Nullable String input, String defaultString) {
        if (input == null || input.isEmpty()) {
            return defaultString;
        }
        return input;
    }
}
