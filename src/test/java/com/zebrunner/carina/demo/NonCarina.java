package com.zebrunner.carina.demo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class NonCarina {

    private static final String BASE_URL = "https://dummyjson.com/";

    @Test
    public void testGetRandomUser() throws IOException {
        String endpoint = "user";
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(BASE_URL + endpoint);

        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(statusCode, 200, "Status code is not 200.");

        HttpEntity entity = response.getEntity();
        String responseJson = EntityUtils.toString(entity);
        System.out.println("Response JSON: " + responseJson);

        // Add further assertions based on the responseJson if needed
    }

    @Test
    public void testGetRandomPost() throws IOException {
        String endpoint = "post";
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(BASE_URL + endpoint);

        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(statusCode, 200, "Status code is not 200.");

        HttpEntity entity = response.getEntity();
        String responseJson = EntityUtils.toString(entity);
        System.out.println("Response JSON: " + responseJson);

        // Add further assertions based on the responseJson if needed
    }

    @Test
    public void testGetRandomComment() throws IOException {
        String endpoint = "comment";
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(BASE_URL + endpoint);

        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(statusCode, 200, "Status code is not 200.");

        HttpEntity entity = response.getEntity();
        String responseJson = EntityUtils.toString(entity);
        System.out.println("Response JSON: " + responseJson);

        // Add further assertions based on the responseJson if needed
    }

    @Test
    public void testGetRandomAlbum() throws IOException {
        String endpoint = "album";
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(BASE_URL + endpoint);

        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(statusCode, 200, "Status code is not 200.");

        HttpEntity entity = response.getEntity();
        String responseJson = EntityUtils.toString(entity);
        System.out.println("Response JSON: " + responseJson);

        // Add further assertions based on the responseJson if needed
    }
}
