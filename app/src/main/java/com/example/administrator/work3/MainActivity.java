package com.example.administrator.work3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private Button calculatorButton;
    private EditText weightet;
    private CheckBox mancb;
    private CheckBox womancb;
    private TextView resulttv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculatorButton= (Button) findViewById(R.id.calculator);
        weightet= (EditText) findViewById(R.id.weight);
        mancb= (CheckBox) findViewById(R.id.man);
        womancb= (CheckBox) findViewById(R.id.woman);
        resulttv= (TextView) findViewById(R.id.result);
    }

    public void yunsuan(View view){
        if(!weightet.getText().toString().trim().equals("")){
            if (mancb.isChecked() || womancb.isChecked()){
                Double weight=Double.parseDouble(weightet.getText().toString());
                StringBuffer sb=new StringBuffer();
                sb.append("----------评估结果---------\n");
                if (mancb.isChecked()){
                    sb.append("男性标准身高：");
                    double result=170-(62-weight)/0.6;
                    sb.append((int)result+"（厘米）");
                }
                if (womancb.isChecked()){
                    sb.append("女性标准身高：");
                    double result=158-(52-weight)/0.5;
                    sb.append((int)result+"（厘米）");
                }
                resulttv.setText(sb.toString());
            }else {
                showMessage("请选择性别！");
            }
        }else {
            showMessage("请输入体重！");
        }
    }

    private void showMessage(String message) {
        AlertDialog alert=new AlertDialog.Builder(this).create();
        alert.setTitle("系统信息");
        alert.setMessage(message);
        alert.setButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,Menu.NONE,"退出");
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case 1:
                finish();
                break;
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
