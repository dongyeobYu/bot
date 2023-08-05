package riche.bot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.intent.Intent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestBot implements ApplicationListener<ApplicationStartedEvent> {

    botToken botToken;

    @Autowired
    public void setBotToken(botToken botToken) {
        this.botToken = botToken;
    }

    public void testBot() {

        String token = botToken.getToken();

        DiscordApi api = new DiscordApiBuilder().addIntents(Intent.MESSAGE_CONTENT).setToken(token).login().join();

        api.addMessageCreateListener(event -> {
            if (event.getMessageContent().equalsIgnoreCase("메")){
                event.getChannel().sendMessage("롱");
            }

            if (event.getMessageContent().equalsIgnoreCase("토마토")){
                event.getChannel().sendMessage("퉤!");
            }

        });

        System.out.println("You can invite the bot by using the Following url: " + api.createBotInvite());
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        testBot();
    }
}
