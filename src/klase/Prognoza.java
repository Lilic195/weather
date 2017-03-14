package klase;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Aleksa on 13-Jan-17.
 */
public class Prognoza {
    private String city;
    private String countryCode;

    public Prognoza(String city, String countryCode) {
        this.city = city;
        this.countryCode = countryCode;
    }

    public String request() {

        String url = "http://api.openweathermap.org/data/2.5/weather?q="+ city +","+ countryCode +"&appid=4863eee4923210407eece72fe9edb3e4";
        URL obj = null;
        try {
            obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            Response odgovor = new Gson().fromJson(response.toString(), Response.class);
            NumberFormat formatter = new DecimalFormat("#0.0");

            double temp = Double.parseDouble(odgovor.getMain().getTemp()) - 273;

            return "" + odgovor.getName() + " " + formatter.format(temp) + " °C";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
