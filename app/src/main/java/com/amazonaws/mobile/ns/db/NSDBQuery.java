package com.amazonaws.mobile.ns.db;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.QueryResult;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ricardo on 3/20/17.
 */

public class NSDBQuery {
    protected String conditionExpression;
    protected String projection;
    protected String  filterExpression;
    protected Map<String, AttributeValue> expressionAttributeValues;
    protected String tableName;
    protected Integer limit;
    protected Map<String, AttributeValue> lastEvaluatedKey;

    public NSDBQuery(String tableName){
        this.tableName = tableName;
        this.expressionAttributeValues = new HashMap<>();
    }

    public NSDBQuery withConditionExpression(String expression){
        this.conditionExpression = expression;
        return  this;
    }
    public NSDBQuery withProjection(String projection){
        this.projection = projection;
        return  this;
    }

    public NSDBQuery withExpressionValue(String key, String value){
        AttributeValue attr = new AttributeValue();
        attr.setS(value);
        this.expressionAttributeValues.put(key, attr);
        return  this;
    }

    public NSDBQuery withExpressionValue(String key, AttributeValue value){
        this.expressionAttributeValues.put(key, value);
        return  this;
    }

    public NSDBQuery withLimit(Integer limit){
        this.limit = limit;
        return  this;
    }

    public NSDBQuery withLastEvaluatedKey(Map<String, AttributeValue> lastEvaluatedKey){
        this.lastEvaluatedKey = lastEvaluatedKey;
        return  this;
    }

    public NSDBQuery withLastEvaluatedKey(QueryResult result){
        this.lastEvaluatedKey = result.getLastEvaluatedKey();
        return  this;
    }
}
