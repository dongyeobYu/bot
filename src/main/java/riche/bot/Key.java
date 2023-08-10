package riche.bot;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Key {

    @Value("${API.token}")
    private String token;

    @Value("${GPT.GPTKey}")
    private String gptKey;

    @Value("${GPT.model}")
    private String model;

}
