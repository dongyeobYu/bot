package riche.bot;

import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
@Getter
@Slf4j
@AllArgsConstructor
public class chatGPT {

    private final Key key;

    public String callChatGPT(String prompt){

        OpenAiService aiService = new OpenAiService(key.getGptKey());
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(prompt)
                .maxTokens(1000)
                .echo(false)
                .model(key.getModel())
                .build();

        List<CompletionChoice> ai = aiService.createCompletion(completionRequest).getChoices();

        return ai.get(0).getText();
    }

    public Boolean isGPT(String contents){

        log.info("isGPT called. contents = " + contents);

        if(contents.length() < 5){
            return false;
        }

        return "!gpt ".equalsIgnoreCase(contents.substring(0, 5));
    }
}