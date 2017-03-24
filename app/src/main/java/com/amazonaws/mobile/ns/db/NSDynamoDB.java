package com.amazonaws.mobile.ns.db;

import android.os.AsyncTask;
import android.util.Log;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.mobile.AWSMobileClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.DeleteItemResult;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.dynamodbv2.model.UpdateItemResult;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by ricardo on 3/18/17.
 */

public class NSDynamoDB{

    private static final String LOG_TAG = NSDynamoDB.class.getSimpleName();

    public void putItem(final NSDBItem item, NSDBCallback callback){

        NSDynamonDBTaskRunner runner = new NSDynamonDBTaskRunner(callback, new NSDynamonDBTaskRunner.NSDynamonDBTask() {
            @Override
            public Object execute() {
                // Fetch the default configured NSDynamoDB ObjectMapper
                final AmazonDynamoDBClient dynamoDBClient = AWSMobileClient.defaultMobileClient().getDynamoDBClient();
                //final DynamoDBMapper dynamoDBMapper = AWSMobileClient.defaultMobileClient().getDynamoDBMapper();

                if(item.keys.isEmpty()){
                    throw new NSDBException("table key not set.");
                }

                Map<String, AttributeValue> values = new HashMap<>();

                values.putAll(item.keys);
                values.putAll(item.values);

                try {
                    PutItemResult result = dynamoDBClient.putItem(item.getTableName(), values);
                    return  result;
                } catch (AmazonServiceException ex){
                    Log.e(LOG_TAG, "AmazonService - Failed saving item : " + ex.getMessage(), ex);
                    return ex;
                } catch (final AmazonClientException ex) {
                    Log.e(LOG_TAG, "AmazonClient - Failed saving item : " + ex.getMessage(), ex);
                    return  ex;
                }
            }
        });

        runner.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
    }

    public void updateItem(final NSDBItem item, NSDBCallback callback){

        NSDynamonDBTaskRunner runner = new NSDynamonDBTaskRunner(callback, new NSDynamonDBTaskRunner.NSDynamonDBTask() {
            @Override
            public Object execute() {
                // Fetch the default configured NSDynamoDB ObjectMapper
                final AmazonDynamoDBClient dynamoDBClient = AWSMobileClient.defaultMobileClient().getDynamoDBClient();
                //final DynamoDBMapper dynamoDBMapper = AWSMobileClient.defaultMobileClient().getDynamoDBMapper();

                if(item.keys.isEmpty()){
                    throw new NSDBException("table key not set.");
                }

                try {
                    UpdateItemResult result = dynamoDBClient.updateItem(item.getTableName(), item.keys, item.valuesUpdate);
                    return  result;
                } catch (AmazonServiceException ex){
                    Log.e(LOG_TAG, "AmazonService - Failed saving item : " + ex.getMessage(), ex);
                    return ex;
                } catch (final AmazonClientException ex) {
                    Log.e(LOG_TAG, "AmazonClient - Failed saving item : " + ex.getMessage(), ex);
                    return  ex;
                }
            }
        });

        runner.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
    }

    public void deleteItem(final NSDBItem item, NSDBCallback callback){

        NSDynamonDBTaskRunner runner = new NSDynamonDBTaskRunner(callback, new NSDynamonDBTaskRunner.NSDynamonDBTask() {
            @Override
            public Object execute() {
                // Fetch the default configured NSDynamoDB ObjectMapper
                final AmazonDynamoDBClient dynamoDBClient = AWSMobileClient.defaultMobileClient().getDynamoDBClient();
                //final DynamoDBMapper dynamoDBMapper = AWSMobileClient.defaultMobileClient().getDynamoDBMapper();

                if(item.keys.isEmpty()){
                    throw new NSDBException("table key not set.");
                }

                try {
                    DeleteItemResult result = dynamoDBClient.deleteItem(item.getTableName(), item.keys);
                    return  result;
                } catch (AmazonServiceException ex){
                    Log.e(LOG_TAG, "AmazonService - Failed saving item : " + ex.getMessage(), ex);
                    return ex;
                } catch (final AmazonClientException ex) {
                    Log.e(LOG_TAG, "AmazonClient - Failed saving item : " + ex.getMessage(), ex);
                    return  ex;
                }
            }
        });

        runner.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
    }

    public void getItem(final NSDBItem item, NSDBCallback callback){

        NSDynamonDBTaskRunner runner = new NSDynamonDBTaskRunner(callback, new NSDynamonDBTaskRunner.NSDynamonDBTask() {
            @Override
            public Object execute() {
                // Fetch the default configured NSDynamoDB ObjectMapper
                final AmazonDynamoDBClient dynamoDBClient = AWSMobileClient.defaultMobileClient().getDynamoDBClient();
                //final DynamoDBMapper dynamoDBMapper = AWSMobileClient.defaultMobileClient().getDynamoDBMapper();

                if(item.keys.isEmpty()){
                    throw new NSDBException("table key not set.");
                }

                try {
                    GetItemResult result = dynamoDBClient.getItem(item.getTableName(), item.keys);
                    return  result;
                } catch (AmazonServiceException ex){
                    Log.e(LOG_TAG, "AmazonService - Failed saving item : " + ex.getMessage(), ex);
                    return ex;
                } catch (final AmazonClientException ex) {
                    Log.e(LOG_TAG, "AmazonClient - Failed saving item : " + ex.getMessage(), ex);
                    return  ex;
                }
            }
        });

        runner.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
    }

    public void scan(NSDBScan dbScan, final NSDBCallback callback){

        ScanRequest request = new ScanRequest()
                .withTableName(dbScan.tableName)
                .withFilterExpression(dbScan.expression)
                .withProjectionExpression(dbScan.projection)
                .withExpressionAttributeValues(dbScan.expressionAttributeValues)
                .withLimit(dbScan.limit)
                .withExclusiveStartKey(dbScan.lastEvaluatedKey);


        this.scan(request, callback);
    }

    public void scan(final ScanRequest request, final NSDBCallback callback){

        NSDynamonDBTaskRunner runner = new NSDynamonDBTaskRunner(callback, new NSDynamonDBTaskRunner.NSDynamonDBTask() {
            @Override
            public Object execute() {
                // Fetch the default configured NSDynamoDB ObjectMapper
                final AmazonDynamoDBClient dynamoDBClient = AWSMobileClient.defaultMobileClient().getDynamoDBClient();
                //final DynamoDBMapper dynamoDBMapper = AWSMobileClient.defaultMobileClient().getDynamoDBMapper();



                try {
                    ScanResult result = dynamoDBClient.scan(request);

                    result.getItems().get(0).get("ky").
                    return  result;
                } catch (AmazonServiceException ex){
                    Log.e(LOG_TAG, "AmazonService - Failed saving item : " + ex.getMessage(), ex);
                    return ex;
                } catch (final AmazonClientException ex) {
                    Log.e(LOG_TAG, "AmazonClient - Failed saving item : " + ex.getMessage(), ex);
                    return  ex;
                }
            }
        });

        runner.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
    }

    public void query(NSDBQuery dbQuery, final NSDBCallback callback){

        QueryRequest request = new QueryRequest()
                .withTableName(dbQuery.tableName)
                .withKeyConditionExpression(dbQuery.conditionExpression)
                .withFilterExpression(dbQuery.filterExpression)
                .withProjectionExpression(dbQuery.projection)
                .withExpressionAttributeValues(dbQuery.expressionAttributeValues)
                .withLimit(dbQuery.limit)
                .withExclusiveStartKey(dbQuery.lastEvaluatedKey);

        this.query(request, callback);
    }

    public void query(final QueryRequest request, final NSDBCallback callback){

        NSDynamonDBTaskRunner runner = new NSDynamonDBTaskRunner(callback, new NSDynamonDBTaskRunner.NSDynamonDBTask() {
            @Override
            public Object execute() {
                // Fetch the default configured NSDynamoDB ObjectMapper
                final AmazonDynamoDBClient dynamoDBClient = AWSMobileClient.defaultMobileClient().getDynamoDBClient();
                //final DynamoDBMapper dynamoDBMapper = AWSMobileClient.defaultMobileClient().getDynamoDBMapper();



                try {
                    QueryResult result = dynamoDBClient.query(request);
                    return  result;
                } catch (AmazonServiceException ex){
                    Log.e(LOG_TAG, "AmazonService - Failed saving item : " + ex.getMessage(), ex);
                    return ex;
                } catch (final AmazonClientException ex) {
                    Log.e(LOG_TAG, "AmazonClient - Failed saving item : " + ex.getMessage(), ex);
                    return  ex;
                }
            }
        });

        runner.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
    }
}
