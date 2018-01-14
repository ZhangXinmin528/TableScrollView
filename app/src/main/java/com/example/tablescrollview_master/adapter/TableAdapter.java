package com.example.tablescrollview_master.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.tablescrollview_master.R;
import com.example.tablescrollview_master.model.StockPositionEntity;
import com.example.tablescrollview_master.view.TableScrollObserver;
import com.example.tablescrollview_master.view.TableScrollView;

import java.util.List;

/**
 * Created by ZhangXinmin on 2018/1/10.
 * Copyright (c) 2018 . All rights reserved.
 * 双向列表的适配器
 */

public class TableAdapter extends BaseAdapter {
    private Context mContext;
    private TableScrollView mHeadTableScrollView;
    private LayoutInflater mLayoutInflater;
    private List<StockPositionEntity> mDataList;

    public TableAdapter(Context context, TableScrollView headTableScrollView, List<StockPositionEntity> dataList) {
        this.mContext = context;
        this.mHeadTableScrollView = headTableScrollView;
        this.mDataList = dataList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public StockPositionEntity getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.layout_trade_table_item, null);
            holder.name = convertView.findViewById(R.id.tv_operation_table_name);
            holder.marketValue = convertView.findViewById(R.id.tv_operation_table_market);
            holder.profit = convertView.findViewById(R.id.tv_operation_table_total_profit);
            holder.profitRatio = convertView.findViewById(R.id.tv_operation_table_total_profit_ratio);
            holder.position = convertView.findViewById(R.id.tv_operation_table_position);
            holder.positionAvai = convertView.findViewById(R.id.tv_operation_table_position_avai);
            holder.costPrice = convertView.findViewById(R.id.tv_operation_table_cost);
            holder.currPrice = convertView.findViewById(R.id.tv_operation_table_curr_price);
            holder.currProfit = convertView.findViewById(R.id.tv_operation_table_curr_profit);
            holder.currProfitRatio = convertView.findViewById(R.id.tv_operation_table_curr_profit_ratio);
            holder.positionLevel = convertView.findViewById(R.id.tv_operation_table_position_level);

            holder.tableScrollView = convertView.findViewById(R.id.table_trade_operation_item);
            mHeadTableScrollView.registerHorizontalObserver(new TableScrollObserver() {
                @Override
                public void onScrollChanged(int l, int t, int oldl, int oldt) {
                    holder.tableScrollView.smoothScrollTo(l, t);
                }
            });

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        StockPositionEntity entity = getItem(position);
        holder.name.setText(entity.getStockName());
        holder.marketValue.setText(entity.getMarketValue());
        holder.profit.setText(entity.getProfit());
        holder.profitRatio.setText(entity.getProfitRatio());
        holder.position.setText(entity.getPosition());
        holder.positionAvai.setText(entity.getPositionAvai());
        holder.costPrice.setText(entity.getCostPrice());
        holder.currPrice.setText(entity.getCurrPrice());
        holder.currProfit.setText(entity.getCurrProfit());
        holder.currProfitRatio.setText(entity.getCurrProfitRatio());
        holder.positionLevel.setText(entity.getPositionLevel());

        return convertView;
    }

    private class ViewHolder {
        private TableScrollView tableScrollView;
        private TextView name;//股票名
        private TextView marketValue;//市值
        private TextView profit;//盈亏值
        private TextView profitRatio;//盈亏比例
        private TextView position;//持仓
        private TextView positionAvai;//可用
        private TextView costPrice;//成本价
        private TextView currPrice;//现价
        private TextView currProfit;//当日盈亏
        private TextView currProfitRatio;//当日盈亏比例
        private TextView positionLevel;//个股仓位

    }
}
