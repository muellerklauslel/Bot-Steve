package main.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.concurrent.TimeUnit;

public class commandBan extends ListenerAdapter {

    public void onMessageReceived (MessageReceivedEvent event) {


        if(event.getMessage().getContentStripped().startsWith("!ban")) {

            if (event.getMember().getPermissions().contains(Permission.BAN_MEMBERS)) {
                Member user = event.getMessage().getMentions().getMembers().get(0);

                user.ban(5, TimeUnit.DAYS).reason("Bitte wende dich bei genaueren Fragen an einen Admin des Servers!").queue();
            } else if (event.getMessage().getContentStripped().startsWith("!ban")) {
                EmbedBuilder embed = new EmbedBuilder();

                embed.setColor(0x23e5ef);
                embed.setAuthor("Bot Steve");
                embed.setFooter("written by Bot Steve");

                embed.setTitle("Nein!");
                embed.setDescription("Es scheint, als hättest du nicht die Berechtigungen Mitglieder bannen zu können. \n bitte Wende dich an einen Admin!");
                embed.setThumbnail("https://c.tenor.com/647XVV2tSgIAAAAi/mario-smg4.gif");


                event.getChannel().sendMessageEmbeds(embed.build()).queue();
            }
        }
    }
}
