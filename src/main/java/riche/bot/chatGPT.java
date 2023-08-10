package riche.bot;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@Getter
@Slf4j
@AllArgsConstructor
public class chatGPT {

    Key key;

    public String callChatGPT(String prompt){

        HashMap<String, String> hs = new HashMap<>();
        hs.put("prompt", prompt);
        hs.put("model", key.getModel());

        Gson gson = new Gson();
        String json = gson.toJson(hs);

        return prompt;
    }

    public Boolean isGPT(String contents){

        if(contents.length() < 5){
            log.info("isGPT/log/info = " + contents);
            return false;
        }

        return "!gpt ".equalsIgnoreCase(contents.substring(0, 5));
    }
}
