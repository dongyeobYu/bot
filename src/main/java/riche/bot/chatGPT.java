package riche.bot;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Getter
@Slf4j
public class chatGPT {


    public String chatGPT(String contents){

            return "GPT 테스트! " + contents;
    }

    public Boolean isGPT(String contents){

        if(contents.length() < 5){
            log.info("isGPT/log/info = " + contents);
            return false;
        }

        return "!gpt ".equalsIgnoreCase(contents.substring(0, 5));
    }
}
