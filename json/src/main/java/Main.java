import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class Main {

    private static URL url;

    static {
        try {
            url = new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Currency[] currency = mapper.readValue(url, Currency[].class);
        Arrays.stream(currency).forEach(System.out::println);
    }

}