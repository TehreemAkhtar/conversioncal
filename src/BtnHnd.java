
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JFrame;
import jdk.nashorn.internal.parser.JSONParser;

//import org.json.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tehreem
 */

public class BtnHnd implements ActionListener {

    GUI refG;
    JFrame fr;
    //private static final String getURL = "https://api.exchangeratesapi.io/latest";
    String url_str = "https://api.exchangeratesapi.io/latest";

    public BtnHnd(GUI refG) {
        this.refG = refG;
        fr = new JFrame("Currencies");
    }

    private void setGet() throws Exception {
       // JSONParser jsonParser = new JSONParser();
//        HttpURLConnection conn = (HttpURLConnection) new URL(getURL).openConnection();
//        conn.setRequestProperty("User-Agent", "Mozilla/5.0");
//        
//        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
//        }
    }
    
    public void getCurrencyRates() {
        // Making Request
        try {
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();
            if(request.getResponseCode()==200)
            {
                InputStream im=request.getInputStream();
                StringBuffer sb=new StringBuffer();
                BufferedReader br= new BufferedReader(new InputStreamReader(im));
                String line = br.readLine();
                while(line!=null)
                {
                    System.out.println(line);
                    line=br.readLine();
                }
                
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

//        JSONParser jp = new JSONParser();
//        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
//        JsonObject jsonobj = root.getAsJsonObject();
//
//        // Accessing object
//        String req_result = jsonobj.get("result").getAsString();
    }

    private void setFrameLayout() {
        fr.setLayout(new FlowLayout());

        //addCurrencies();
        //getCurrencyRates();

        fr.setVisible(true);
        fr.setSize(500, 400);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);

        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addCurrencies() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Clear")) {
            refG.tf1.setText("");
            refG.tf2.setText("");
        }

        if (e.getActionCommand().equals("Currencies")) {
            setFrameLayout();
        }
    }

}
