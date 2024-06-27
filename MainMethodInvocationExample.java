import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MainMethodInvocationExample {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MainMethodInvocationExample.class, args);

        // Retrieve the ApiService bean from the context
        ApiService apiService = context.getBean(ApiService.class);

        // Define the API URL you want to invoke
        String apiUrl = "https://jsonplaceholder.typicode.com/posts/1";

        // Invoke the API using the ApiService
        String apiResponse = apiService.getDataFromApi(apiUrl);

        // Print the API response
        System.out.println("API Response:");
        System.out.println(apiResponse);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
