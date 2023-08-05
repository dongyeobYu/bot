package riche.bot;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class botToken {

    @Value("${API.token}")
    private String token;

}
