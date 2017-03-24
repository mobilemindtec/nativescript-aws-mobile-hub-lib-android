package com.amazonaws.mobile.ns.db;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ricardo on 3/20/17.
 */

public class NSDBScan {
    protected String expression;
    protected String projection;
    protected Map<String, AttributeValue> expressionAttributeValues;
    protected String tableName;
    protected Integer limit;
    protected Map<String, AttributeValue> lastEvaluatedKey;

    public NSDBScan(String tableName){
        this.tableName = tableName;
        this.expressionAttributeValues = new HashMap<>();
    }

    public NSDBScan withExpression(String expression){
        this.expression = expression;
        return  this;
    }
    public NSDBScan withProjection(String projection){
        this.projection = projection;
        return  this;
    }

    public NSDBScan withExpressionValue(String key, String value){
        AttributeValue attr = new AttributeValue();
        attr.setS(value);
        this.expressionAttributeValues.put(key, attr);
        return  this;
    }

    public NSDBScan withExpressionValue(String key, AttributeValue value){
        this.expressionAttributeValues.put(key, value);
        return  this;
    }

    public NSDBScan withLimit(Integer limit){
        this.limit = limit;
        return  this;
    }

    public NSDBScan withLastEvaluatedKey(Map<String, AttributeValue> lastEvaluatedKey){
        this.lastEvaluatedKey = lastEvaluatedKey;
        return  this;
    }

    public NSDBScan withLastEvaluatedKey(ScanResult result){
        this.lastEvaluatedKey = result.getLastEvaluatedKey();
        return  this;
    }
}
