package seba0.javaszc4.spring.frontend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import seba0.javaszc4.spring.frontend.config.URLConfig;
import seba0.javaszc4.spring.frontend.dto.LoginUser;
import seba0.javaszc4.spring.frontend.dto.UserDTO;

@Service
public class LoginUserService implements UserDetailsService {

    private RestTemplate template = new RestTemplate();

    @Autowired
    private URLConfig urlConfig;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        try {
            ResponseEntity<UserDTO> userEntity = template.getForEntity(urlConfig.getCustomer() + '/' + login, UserDTO.class);

            if (userEntity.hasBody()) {
                return new LoginUser(userEntity.getBody());
            }
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found.", e);
        }
        throw new UsernameNotFoundException("User not found.");
    }
}
