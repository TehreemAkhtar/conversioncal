
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.immutables.gson.Gson;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
//import org.json.simple.JSONObject; 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tehreem
 */
public class Driver {

    public static void main(String[] args) {
        try {
            //GUI g= new GUI();
            getCurrencyRates();
        } catch (IOException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void getCurrencyRates() throws IOException {
        try {
            String url_str = "https://api.exchangeratesapi.io/latest";
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();
            if (request.getResponseCode() == 200) {
                InputStream im = request.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(im));
                String line = br.readLine();
               System.out.println(line);
               JSONParser parser = new JSONParser();
                JSONObject json = (JSONObject) parser.parse(line);
                System.out.println(json);
                    
//                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
//                    JSONParser jp = new JSONParser();
//                    JsonElement je = (JsonElement) jp.parse(line);
//                    String prettyJsonString = gson.toJson(je);
//                    System.out.println(prettyJsonString);


//                    JSONParser parser = new JSONParser();
//                    JSONObject json = (JSONObject) parser.parse(line);
//                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
//                    String prettyJson = gson.tojson(json);
//                    
//                    System.out.println(prettyJson);

                

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        //JSONParser jp = new JSONParser();
//        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
//        JsonObject jsonobj = root.getAsJsonObject();
//
//        // Accessing object
//        String req_result = jsonobj.get("result").getAsString();
    }
}
