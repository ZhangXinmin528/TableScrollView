package com.example.tablescrollview_master.model;

import java.io.Serializable;

/**
 * Created by ZhangXinmin on 2017/12/20.
 * Copyright (c) 2017 . All rights reserved.
 */

public class StockPositionEntity implements Serializable {
    private String stockName;//股票名称
    private String stockCode;//股票代码
    private String marketValue;//市值
    private String profit;//盈亏金额
    private String profitRatio;//盈亏比例
    private String position;//持仓
    private String positionAvai;//可用
    private String costPrice;//成本价
    private String currPrice;//现价
    private String currProfit;//当日盈亏
    private String currProfitRatio;//当日盈亏比例
    private String positionLevel;//个股仓位

    public StockPositionEntity() {
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(String marketValue) {
        this.marketValue = marketValue;
    }

    public String getProfitRatio() {
        return profitRatio;
    }

    public void setProfitRatio(String profitRatio) {
        this.profitRatio = profitRatio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPositionAvai() {
        return positionAvai;
    }

    public void setPositionAvai(String positionAvai) {
        this.positionAvai = positionAvai;
    }

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getCurrPrice() {
        return currPrice;
    }

    public void setCurrPrice(String currPrice) {
        this.currPrice = currPrice;
    }

    public String getCurrProfit() {
        return currProfit;
    }

    public void setCurrProfit(String currProfit) {
        this.currProfit = currProfit;
    }

    public String getCurrProfitRatio() {
        return currProfitRatio;
    }

    public void setCurrProfitRatio(String currProfitRatio) {
        this.currProfitRatio = currProfitRatio;
    }

    public String getPositionLevel() {
        return positionLevel;
    }

    public void setPositionLevel(String positionLevel) {
        this.positionLevel = positionLevel;
    }
}
