package main.embeds;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class byeEmbed extends ListenerAdapter {

    public void onGuildMemberRemove(GuildMemberRemoveEvent event) {

        String usename = event.getUser().getName();

        EmbedBuilder embed = new EmbedBuilder();

        embed.setTitle("Tschüss" + usename);
        embed.setDescription("Wir hoffen, dass du hier eine schöne Zeit hattest. Du bist jederzeit wieder wilkommen.");
        embed.setImage("https://c.tenor.com/5UrK7rSTuscAAAAd/goodbye-bye-bye.gif");
        embed.setThumbnail("https://c.tenor.com/yWSRmymbuBkAAAAC/waving-hi.gif");
        embed.setAuthor("Bot Steve");
        embed.setColor(0x23e5ef);

        event.getGuild().getTextChannelById("1010277824218800248").sendMessageEmbeds(embed.build()).queue();
    }
}
