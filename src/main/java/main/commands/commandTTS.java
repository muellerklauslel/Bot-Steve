package main.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class commandTTS extends ListenerAdapter {

    public void onMessageReceived (MessageReceivedEvent event) {

        String message = event.getMessage().getContentStripped();
        boolean isfrombot = false;

        if(event.getMessage().getContentStripped().startsWith("!TTS")) {
            if (event.getAuthor().isBot()) {
                isfrombot = true;
            } else {
                event.getChannel().sendMessage(message).setTTS(true).queue();
            }
        }
    }
}

