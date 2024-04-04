package main.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.entities.emoji.EmojiUnion;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.awt.*;

public class commandCommands extends ListenerAdapter {

    public void onMessageReceived (MessageReceivedEvent event) {

        if(event.getMessage().getContentStripped().equals("!hilfe")) {

            EmbedBuilder embed = new EmbedBuilder();

            embed.setColor(0x23e5ef);
            embed.setAuthor("Bot Steve");
            embed.setFooter("written by Bot Steve");
            embed.setThumbnail("https://c.tenor.com/hxHmbBGAThcAAAAi/question.gif");
            embed.setImage("https://c.tenor.com/3onzf0VkJIgAAAAC/gameboyluke-please-help-me.gif");

            embed.addField("Wir helfen dir!", "Das ist die Liste aller Commands!", false);
            embed.addBlankField(false);
            embed.addField("!Hilfe", "hilft dir",false);
            embed.addField("!Ping", "pongt dich",false);
            embed.addField("!ban", "bannt Leute",false);
            embed.addField("!kick", "kickt Leute",false);
            embed.addField("!info", "gibt dir Infos über @user",false);


            Button buttonHilfreich = Button.success("btnHilfreich", "Das war hilfreich!").withEmoji(Emoji.fromFormatted("✅"));
            Button buttonNichtHilfreich = Button.link("https://www.youtube.com/watch?v=dQw4w9WgXcQ","Das hat mich nicht weitergebracht!").withEmoji(Emoji.fromFormatted("\uD83D\uDE2D"));

            event.getChannel().sendMessageEmbeds(embed.build()).setActionRow(buttonHilfreich,buttonNichtHilfreich).queue();

        }
    }

    public void onButtonInteraction (ButtonInteractionEvent event) {

        if(event.getButton().getId().equals("btnHilfreich")) {
            event.reply("Prima!").setEphemeral(true).queue();
        }
    }
}
