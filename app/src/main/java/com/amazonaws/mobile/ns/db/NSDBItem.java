package com.amazonaws.mobile.ns.db;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.AttributeValueUpdate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ricardo on 3/18/17.
 */

public class NSDBItem {

    private String tableName;
    protected Map<String, AttributeValue> values;
    protected Map<String, AttributeValueUpdate> valuesUpdate;
    protected Map<String, AttributeValue> keys;

    public NSDBItem(String tableName){
        this.tableName = tableName;
        this.values = new HashMap<>();
        this.keys = new HashMap<>();
    }

    public Map<String, AttributeValue> getValues() {
        return values;
    }

    public String getTableName() {
        return tableName;
    }

    public AttributeValue createAtributeValue(String name){
        AttributeValue value = new AttributeValue();
        this.values.put(name, value);
        return value;
    }

    public AttributeValueUpdate createAtributeValueUpdate(String name){
        AttributeValue attributeValue = createAtributeValue(name);
        AttributeValueUpdate value = new AttributeValueUpdate(attributeValue, "PUT");
        this.valuesUpdate.put(name, value);
        return value;
    }

    public AttributeValue createAtributeValueKey(String name){
        AttributeValue value = new AttributeValue();
        this.keys.put(name, value);
        return value;
    }
}
