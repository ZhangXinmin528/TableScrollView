package com.example.tablescrollview_master;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.tablescrollview_master.adapter.TableAdapter;
import com.example.tablescrollview_master.model.RowModel;
import com.example.tablescrollview_master.model.StockPositionEntity;
import com.example.tablescrollview_master.util.LogUtils;
import com.example.tablescrollview_master.view.TableScrollView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener,
        AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private Context mContext;
    private TableScrollView mHeadTableScrollView;
    private ListView mListView;
    private TableAdapter mTableAdapter;
    private List<StockPositionEntity> mDataList;

    private int mTouchSlop;
    private float lastX, lastY;
    private float endX, endY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initParamsAndValues();

        initViews();

        initTestData();
    }

    private void initParamsAndValues() {
        mContext = this;
        mDataList = new ArrayList<>();
        mTouchSlop = ViewConfiguration.get(mContext).getScaledTouchSlop();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initViews() {
        mHeadTableScrollView = findViewById(R.id.table_trade_operation_title);
        //加了之后没有惯性效果
        /*mHeadScrollView.registerHorizontalObserver(new TableScrollObserver() {
            @Override
            void onScrollChanged(int l, int t, int oldl, int oldt) {
                mHeadScrollView.smoothScrollTo(l, t);
            }
        });*/

        mListView = findViewById(R.id.listview);
        mTableAdapter = new TableAdapter(mContext, mHeadTableScrollView, mDataList);
        mListView.setAdapter(mTableAdapter);
        mListView.setOnTouchListener(this);
        mListView.setOnItemClickListener(this);
        mListView.setOnItemLongClickListener(this);

    }

    private void initTestData() {

        //股票列表
        for (int i = 0; i < 20; i++) {
            final StockPositionEntity entity = new StockPositionEntity();
            entity.setStockName("北方稀土:" + i);
            entity.setStockCode("600111");
            entity.setMarketValue("4560.000");
            entity.setCostPrice("15.477");
            entity.setCurrPrice("15.200");
            entity.setCurrProfit("-73.000");
            entity.setCurrProfitRatio("-1.576%");
            entity.setProfit("-83.090");
            entity.setProfitRatio("-1.790%");
            entity.setPosition("300");
            entity.setPositionAvai("0");
            entity.setPositionLevel("41.6%");
            mDataList.add(entity);
        }

        mTableAdapter.notifyDataSetChanged();
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = event.getRawX();
                lastY = event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                endX = event.getRawX();
                endY = event.getRawY();
                break;
            case MotionEvent.ACTION_UP:
                endX = event.getRawX();
                endY = event.getRawY();
                break;
            default:
                break;
        }

        final float changeX = Math.abs(endX - lastX);
        final float changeY = Math.abs(endY - lastY);
        if (changeX >= mTouchSlop && changeX > changeY) {
            mHeadTableScrollView.onTouchEvent(event);
            return true;
        }
        return false;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(mContext, "点击了：" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(mContext, "触发了长按：" + position, Toast.LENGTH_SHORT).show();
        return false;
    }
}
