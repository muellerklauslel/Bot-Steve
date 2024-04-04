package main.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class commandUserJoin extends ListenerAdapter {

    public void onMessageReceived (MessageReceivedEvent event) {

        String username = event.getAuthor().getName();

        EmbedBuilder bauplan = new EmbedBuilder();

        bauplan.setTitle(username + ", herzlich Willkommen auf dem Server!");
        bauplan.setDescription("Schön, dass du da bist. Wir hoffen es gefällt dir hier.");
        bauplan.setThumbnail("https://c.tenor.com/yWSRmymbuBkAAAAC/waving-hi.gif");
        bauplan.setColor(0x23e5ef);

        //user.openPrivateChannel().complete().sendMessageEmbeds(bauplan.build()).queue();
        if(event.getMessage().getContentStripped().equals("!userJoinCommand")) {

            if (event.getMember().getPermissions().contains(Permission.ADMINISTRATOR)) {
                event.getGuild().getTextChannelById("959546598017343552").sendMessageEmbeds(bauplan.build()).queue();
            } else if (event.getMessage().getContentStripped().startsWith("!userJoinCommand")) {
                EmbedBuilder embed = new EmbedBuilder();

                embed.setColor(0x23e5ef);
                embed.setAuthor("Bot Steve");
                embed.setFooter("written by Bot Steve");

                embed.setTitle("Nein!");
                embed.setDescription("Es scheint, als hättest du nicht die Berechtigungen die zu tun. \n Bitte Wende dich an einen Admin!");
                embed.setThumbnail("https://c.tenor.com/647XVV2tSgIAAAAi/mario-smg4.gif");


                event.getChannel().sendMessageEmbeds(embed.build()).queue();
            }
        }
    }
}
