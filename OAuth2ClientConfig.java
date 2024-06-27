import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class OAuth2ClientConfig {

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new CustomClientRegistrationRepository();
    }

    private class CustomClientRegistrationRepository implements ClientRegistrationRepository {
        @Override
        public ClientRegistration findByRegistrationId(String registrationId) {
            return registrationId.equals("my-client") ? customClientRegistration() : null;
        }

        @Override
        public Iterable<ClientRegistration> findAll() {
            return null;
        }
    }

    private ClientRegistration customClientRegistration() {
        Map<String, Object> providerMetadata = new HashMap<>();
        providerMetadata.put("token_uri", "https://example.com/oauth/token");

        return ClientRegistration.withRegistrationId("my-client")
                .clientName("My Client")
                .clientId("your-client-id")
                .clientSecret("your-client-secret")
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .scope("read")
                .providerConfigurationMetadata(providerMetadata)
                .build();
    }
}
