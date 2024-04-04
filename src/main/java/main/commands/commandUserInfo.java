package main.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.DayOfWeek;

public class commandUserInfo extends ListenerAdapter {

    public void onMessageReceived (MessageReceivedEvent event) {

        if(event.getMessage().getContentStripped().startsWith("!info")) {

            Member user = event.getMessage().getMentions().getMembers().get(0);
            EmbedBuilder embed = new EmbedBuilder();

            embed.setTitle("Mehr Informationen zu:      '" + user.getEffectiveName() + "'");
            embed.setThumbnail(user.getEffectiveAvatar().getUrl());
            embed.setColor(0x23e5ef);
            embed.addField("Nutzer ID:", user.getId(), false);
            embed.addField("Online Status: ", user.getOnlineStatus().name(), false);

            if (user.getAvatarId() != null)
            embed.addField("Effectiv Avatar ID", user.getAvatarId(), false);

            if (user.getNickname() != null)
            embed.addField("Nickname : ", user.getNickname(), false);


            event.getChannel().sendMessageEmbeds(embed.build()).queue();

        }
    }
}
