package main.verifySysthem;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class setupVerify extends ListenerAdapter {

    public void onMessageReceived (MessageReceivedEvent event) {

        if(event.getMessage().getContentStripped().equals("!setup verify")) {

            if (event.getMember().getPermissions().contains(Permission.ADMINISTRATOR)) {
                EmbedBuilder embed = new EmbedBuilder();

                embed.setColor(0x23e5ef);
                embed.setAuthor("Bot Steve");
                embed.setFooter("written by Bot Steve");
                embed.setThumbnail("https://c.tenor.com/PgHG_GnGQcMAAAAi/asd.gif");

                embed.setTitle("Verifiziere dich!");
                embed.setDescription("Bitte verifiziere dich, indem du auf den Button unten klickst. \n Das kriegst du hin ;)");

                Button buttonVerify = Button.success("btnverify", "Verifiziere dich!");

                event.getChannel().sendMessageEmbeds(embed.build()).setActionRow(buttonVerify).queue();
            }
        } else if (event.getMessage().getContentStripped().equals("!setup verify")) {

            EmbedBuilder embed = new EmbedBuilder();

            embed.setColor(0x23e5ef);
            embed.setAuthor("Bot Steve");
            embed.setFooter("written by Bot Steve");

            embed.setTitle("Nein!");
            embed.setDescription("Es scheint, als hättest du nicht die Berechtigungen dies zu tun. \n bitte Wende dich an einen Admin!");
            embed.setThumbnail("https://c.tenor.com/647XVV2tSgIAAAAi/mario-smg4.gif");


            event.getChannel().sendMessageEmbeds(embed.build()).queue();
        }
    }

    public  void onButtonInteraction (ButtonInteractionEvent event) {

        if (event.getButton().getId().equals("btnverify")) {

            Role roleVerify = event.getGuild().getRoleById("1009911674205114459");

            event.getGuild().addRoleToMember(event.getMember(), roleVerify).queue();
            event.reply("Du hast dich erfolgreich Verifiziert!").setEphemeral(true).queue();
        }
    }
}
