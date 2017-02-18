package cn.jianke.aspectjdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * @className: AspectJActivity
 * @classDescription: 测试AspectJ页面实例
 * @author: leibing
 * @createTime: 2017/2/18
 */
public class AspectJActivity extends AppCompatActivity implements View.OnClickListener{
    // 统计显示
    private TextView aspectTv;
    // 统计数
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // findView
        aspectTv = (TextView) findViewById(R.id.tv_aspect);
        // onClick
        findViewById(R.id.btn_aspect).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        new AspectJClass().doSomeThing();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_aspect:
                count ++;
                aspectTv.setText(count + "");
                break;
        }
    }
}
