package main.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class commandUserLeft extends ListenerAdapter {

    public void onMessageReceived (MessageReceivedEvent event) {
        String usename = event.getAuthor().getName();

        EmbedBuilder embed = new EmbedBuilder();

        embed.setTitle("Tschüss" + usename);
        embed.setDescription("Wir hoffen, dass du hier eine schöne Zeit hattest. Du bist jederzeit wieder wilkommen.");
        embed.setImage("https://c.tenor.com/5UrK7rSTuscAAAAd/goodbye-bye-bye.gif");
        embed.setThumbnail("https://c.tenor.com/yWSRmymbuBkAAAAC/waving-hi.gif");
        embed.setAuthor("Bot Steve");
        embed.setColor(0x23e5ef);

        if(event.getMessage().getContentStripped().equals("!userLeftCommand")) {

            if (event.getMember().getPermissions().contains(Permission.ADMINISTRATOR)) {
                event.getGuild().getTextChannelById("959546598017343552").sendMessageEmbeds(embed.build()).queue();
            }  else if (event.getMessage().getContentStripped().equals("!userLeftCommand")) {

                EmbedBuilder embed2 = new EmbedBuilder();

                embed2.setColor(0x23e5ef);
                embed2.setAuthor("Bot Steve");
                embed2.setFooter("written by Bot Steve");

                embed2.setTitle("Nein!");
                embed2.setDescription("Es scheint, als hättest du nicht die Berechtigungen dies zu tun. \n bitte Wende dich an einen Admin!");
                embed2.setThumbnail("https://c.tenor.com/647XVV2tSgIAAAAi/mario-smg4.gif");


                event.getChannel().sendMessageEmbeds(embed2.build()).queue();
            }
        }
    }
}
