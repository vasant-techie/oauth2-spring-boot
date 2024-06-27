import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    @Autowired
    private RestTemplate restTemplate;

    public String getProtectedResource() {
        String url = "https://example.com/protected/resource";
        return restTemplate.getForObject(url, String.class);
    }
}
