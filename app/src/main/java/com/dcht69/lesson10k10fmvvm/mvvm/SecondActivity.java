package com.dcht69.lesson10k10fmvvm.mvvm;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.lifecycle.ViewModelProvider;

import com.dcht69.lesson10k10fmvvm.R;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = SecondActivity.class.getName();
    private EditText edtNumA, edtNumB;
    private TextView tvResult;
    private SecondViewModel viewModel;
    private SwitchCompat swLang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        viewModel = new ViewModelProvider(this).get(SecondViewModel.class);
        tvResult = findViewById(R.id.tv_result);
        edtNumA = findViewById(R.id.edt_num_a);
        edtNumB = findViewById(R.id.edt_num_b);


        swLang = findViewById(R.id.sw_lang);
        swLang.setOnClickListener(this);


        findViewById(R.id.bt_cal_sum).setOnClickListener(this);

        // đăng kí quan sát
        viewModel.getResult().observeForever(value -> tvResult.setText(value));
        viewModel.getMsg().observeForever(value -> {
            if (value != null) {
                Toast.makeText(SecondActivity.this, value, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bt_cal_sum) {
            viewModel.calSum(edtNumA.getText().toString(), edtNumB.getText().toString());
        } else if (view.getId() == R.id.sw_lang) {
            viewModel.setLangEn(swLang.isChecked());

        }
    }


}