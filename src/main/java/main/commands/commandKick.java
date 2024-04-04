package main.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class commandKick extends ListenerAdapter {

    public void onMessageReceived (MessageReceivedEvent event) {


        if(event.getMessage().getContentStripped().startsWith("!kick")) {

            if(event.getMember().getPermissions().contains(Permission.KICK_MEMBERS)) {
                Member user = event.getMessage().getMentions().getMembers().get(0);
                String username = event.getAuthor().getName();

                user.kick("Weil!").queue();

                EmbedBuilder embed = new EmbedBuilder();

                embed.setThumbnail("https://c.tenor.com/POPKh_t04c0AAAAC/bad-mom-grandma.gif");
                embed.setTitle("Der Nutzer '" + username + "' wurde gekickt");
                embed.setColor(0x23e5ef);
                embed.setAuthor("Bot Steve");
                embed.setDescription("Der Nutzer '" + username + "' wure auf grund von Gründen von diesem Server gekickt. \n Wir sagen alle gemeinsam \n TSCHÜSS!");

                event.getChannel().sendMessageEmbeds(embed.build()).queue();
            } else if (event.getMessage().getContentStripped().startsWith("!kick")){

                EmbedBuilder embed = new EmbedBuilder();

                embed.setColor(0x23e5ef);
                embed.setAuthor("Bot Steve");
                embed.setFooter("written by Bot Steve");

                embed.setTitle("Nein!");
                embed.setDescription("Es scheint, als hättest du nicht die Berechtigungen Mitglieder kicken zu können. \n Bitte Wende dich an einen Admin!");
                embed.setThumbnail("https://c.tenor.com/647XVV2tSgIAAAAi/mario-smg4.gif");


                event.getChannel().sendMessageEmbeds(embed.build()).queue();
            }
        }
    }
}
