package com.dcht69.lesson10k10fmvvm.presenter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dcht69.lesson10k10fmvvm.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnMainCallBack {
    public static final String TAG = MainActivity.class.getName();
    private EditText edtNumA, edtNumB;
    private TextView tvResult;
    private MainPresenter mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mainPresenter = App.getInstance().getPresenter(this);
        tvResult = findViewById(R.id.tv_result);
        edtNumA = findViewById(R.id.edt_num_a);
        edtNumB = findViewById(R.id.edt_num_b);
        findViewById(R.id.bt_cal_sum).setOnClickListener(this);

        tvResult.setText(String.format("KQ = %s", mainPresenter.getSum()));
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bt_cal_sum) {
            mainPresenter.calSum(edtNumA.getText().toString(), edtNumB.getText().toString());
        }
    }


    @Override
    public void updateResult(double rs) {
        tvResult.setText(String.format("KQ = %s", rs));
    }

    @Override
    public void notify(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}