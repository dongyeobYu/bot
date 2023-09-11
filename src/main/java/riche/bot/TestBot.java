package riche.bot;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.intent.Intent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class TestBot implements ApplicationListener<ApplicationStartedEvent> {

    Key Key;
    chatGPT chatGPT;

    public void testBot() {

        String token = Key.getToken();

        DiscordApi api = new DiscordApiBuilder().addIntents(Intent.MESSAGE_CONTENT).setToken(token).login().join();

        api.addMessageCreateListener(event -> {

            String contents = event.getMessageContent();

            if(chatGPT.isGPT(contents)){
                try {
                    event.getChannel().sendMessage("chatGPT 결과 : " + chatGPT.callChatGPT(contents.substring(5)));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            if (event.getMessageContent().equalsIgnoreCase("토마토")){
                event.getChannel().sendMessage("퉤!");
            }

        });

        log.info("You can invite the bot by using the Following url: " + api.createBotInvite());
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        testBot();
    }
}
