package com.vijay.captcha1;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class CaptchatestActivity extends Activity {

    ImageView im, btn;
    Button validate;
    EditText captcha_input;
    Captcha c;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c = new MathCaptcha(400, 100, MathCaptcha.MathOptions.PLUS_MINUS_MULTIPLY);

        im = findViewById(R.id.imageView);
        btn = findViewById(R.id.refresh);
        captcha_input = findViewById(R.id.captcha_input);
        validate = findViewById(R.id.validate);

        im.setImageBitmap(c.image);
        im.setLayoutParams(new LinearLayout.LayoutParams(c.getWidth() * 2, c.height * 2));

        btn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                c = new MathCaptcha(400, 100, MathCaptcha.MathOptions.PLUS_MINUS_MULTIPLY);
                im.setImageBitmap(c.image);
                im.setLayoutParams(new LinearLayout.LayoutParams(c.getWidth() * 2, c.height * 2));

                Log.e("c.answer--> ", c.answer);
            }
        });

        validate.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("captcha_input  ", captcha_input.getText().toString());
                Log.e("c.answer  ", c.answer);

                if (captcha_input.getText().toString().equals(c.answer)) {
                    Toast.makeText(CaptchatestActivity.this, "validate", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CaptchatestActivity.this, "invalidate", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}