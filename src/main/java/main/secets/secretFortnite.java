package main.secets;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class secretFortnite extends ListenerAdapter {

    public void onMessageReceived (MessageReceivedEvent event) {

        String user = event.getAuthor().getAsMention();


        if(event.getMessage().getContentStripped().contains("fortnite")) {
            if (event.getAuthor().isBot()) {

            } else {
                event.getChannel().sendMessage("Halt Stop: " + user + " \nFortnite ist das letzte drecksspiel. Wenn du es spielst dann gehe auf ich-bin-ein-Fortnite-spieler.de und gehe dich löschen. \nLiebe Grüße").queue();
            }
        }
    }
}
