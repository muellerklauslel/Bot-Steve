package main;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class NachrichtenReaktion extends ListenerAdapter {

    public void onMessageReceived (MessageReceivedEvent ereignis) {

        if (ereignis.isFromGuild()) {

            String username = ereignis.getAuthor().getName();


            if (ereignis.getMessage().getContentStripped().equals("!hallo")) {
                //schreibt 'hallo' zurück
                ereignis.getChannel().sendMessage("Hallo " + username + "!").queue();

                //reaktion hinzufügen
                ereignis.getMessage().addReaction(Emoji.fromUnicode("\uD83D\uDC4B")).queue();
            }
        }
    }
}
