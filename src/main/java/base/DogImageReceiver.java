package base;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class DogImageReceiver {

    public static String getDogImage(String breed) {
        String dogUrl = "https://dog.ceo/api/breed/" + breed.toLowerCase() + "/images/random";

        // Стандартные настройки
        CloseableHttpClient client = HttpClients.createDefault();

        try {
            HttpGet request = new HttpGet(dogUrl);
            CloseableHttpResponse response = client.execute(request);

            ObjectMapper mapper = new ObjectMapper();

            DogObject dogObject = mapper.readValue(response.getEntity().getContent(), DogObject.class);

            System.out.println(dogObject);
            String imageUrlString = dogObject.message;

            if (dogObject.status.equals("success")) {
                return imageUrlString;

                //request = new HttpGet(imageUrlString);
                //CloseableHttpResponse imageResponse = client.execute(request);

                //FileOutputStream fos = new FileOutputStream("images/" + fileName);
                //imageResponse.getEntity().writeTo(fos);
            } else {
                return "Такой породы нет";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Сервер не отвечает";
        }
    }

    private static String getFileName(String imageUrlString) {
        URL imageUrl = null;
        try {
            imageUrl = new URL(imageUrlString);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Malformed URL: " + imageUrlString, e);
        }

        return Paths.get(imageUrl.getPath()).getFileName().toString();
    }
}
