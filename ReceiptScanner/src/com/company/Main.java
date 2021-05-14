package com.company;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Product> productList;
        ArrayList<Product> domesticProductList = new ArrayList<>();
        ArrayList<Product> importedProductList = new ArrayList<>();
        double domesticCost = 0.0;
        double importedCost = 0.0;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://interview-task-api.mca.dev/qr-scanner-codes/alpha-qr-gFpwhsQ8fkY1")).build();
        productList = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(Main::parse)
                .join();
        for (Product pro : productList) {
            if (pro.getDomestic()) {
                domesticProductList.add(pro);
                domesticCost += pro.getPrice();
            } else {
                importedProductList.add(pro);
                importedCost += pro.getPrice();
            }
        }
        domesticProductList.sort(new NameSorter());
        importedProductList.sort(new NameSorter());
        System.out.println(".Domestic \n" + listFormater(domesticProductList));
        System.out.println(".Imported \n" + listFormater(importedProductList));
        System.out.println("Domestic Cost: $" + domesticCost);
        System.out.println("Imported Cost: $" + importedCost);
        System.out.println("Domestic Count: " + domesticProductList.size());
        System.out.println("Imported Count: " + importedProductList.size());

        //so that the console windows stays open
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static ArrayList<Product> parse(String responseBody) {
        ArrayList<Product> productList = new ArrayList<>();
        try {
            JSONArray products = new JSONArray(responseBody);
            for (int i = 0; i < products.length(); i++) {
                JSONObject product = products.getJSONObject(i);
                String name = product.getString("name");
                Boolean domestic = product.getBoolean("domestic");
                Double price = product.getDouble("price");
                String weight = product.optString("weight", "N/A");
                String description = product.getString("description");
                //truncate the string if longer than 30
                description = description.substring(0, Math.min(description.length(), 30));
                Product newProduct = new Product(name, domestic, price, weight, description);
                productList.add(newProduct);

            }
        } catch (JSONException e) {
            System.out.println(e);
        }
        return productList;
    }

    private static String listFormater(ArrayList<Product> list) {
        return list.toString()
                .replace(",", "")
                .replace("[", "")
                .replace("]", "")
                .trim();
    }

}

