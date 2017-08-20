package com.example.slidingbutton1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Adapter.IonSlidingViewClickListener {

    private RecyclerView mRecyclerView;

    private Adapter mAdapter;

    private final String TAG = "test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.slidingbutton1.R.layout.activity_main);

        initView();
        setAdapter();

    }

    private void initView(){
        mRecyclerView = (RecyclerView) findViewById(com.example.slidingbutton1.R.id.recyclerview);
    }

    private void setAdapter(){

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));//设置布局管理器
        mRecyclerView.setAdapter(mAdapter = new Adapter(this));//设置适配器
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());//设置控制Item增删的动画

    }


    /**
     * item(提醒)的点击事件
     * @param view
     * @param position
     */
    @Override
    public void onItemClick(View view, int position) {
        Log.i(TAG,"点击项："+position);
    }


    /**
     * item的左滑设置
     * @param view
     * @param position
     */
    @Override
    public void onSetBtnCilck(View view, int position) {
        Toast.makeText(MainActivity.this,"请设置",Toast.LENGTH_LONG).show();
    }


    /**
     * item的左滑删除
     * @param view
     * @param position
     */
    @Override
    public void onDeleteBtnCilck(View view, int position) {
        Log.i(TAG,"删除项："+position);
        mAdapter.removeData(position);
    }


}
