package main.embeds;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class wellcomeEmbed extends ListenerAdapter {

    public void onGuildMemberJoin (GuildMemberJoinEvent event) {
        User user = event.getUser();

        EmbedBuilder bauplan = new EmbedBuilder();

        bauplan.setTitle(user.getName() + ", herzlich Willkommen auf dem Server!");
        bauplan.setDescription("Schön, dass du da bist. Wir hoffen es gefällt dir hier.");
        bauplan.setThumbnail("https://c.tenor.com/yWSRmymbuBkAAAAC/waving-hi.gif");
        bauplan.setColor(0x23e5ef);

        //user.openPrivateChannel().complete().sendMessageEmbeds(bauplan.build()).queue();
        event.getGuild().getTextChannelById("1010277824218800248").sendMessageEmbeds(bauplan.build()).queue();
    }
}
