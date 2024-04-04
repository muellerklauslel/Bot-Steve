package main.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class commandPing  extends ListenerAdapter {

    public void onMessageReceived (MessageReceivedEvent event) {

        if (event.isFromGuild()) {

            if (event.getMessage().getContentStripped().equals("!ping")) {
                // schreibe Pong zurück
                event.getChannel().sendMessage("Pong").queue();

            }
        }
    }
}
