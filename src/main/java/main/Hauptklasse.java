package main;

import main.commands.*;
import main.secets.secretFortnite;
import main.embeds.byeEmbed;
import main.embeds.wellcomeEmbed;
import main.verifySysthem.setupVerify;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;

public class Hauptklasse {

    public static void main(String[] args) throws LoginException {
        String token = "<API Token>";
        String prefix = "!";
        String status = "!hilfe für Hilfe";

        JDABuilder bauplan = JDABuilder.createDefault(token);

        bauplan.setStatus(OnlineStatus.ONLINE);
        bauplan.setActivity(Activity.playing(status));

        bauplan.addEventListeners(new NachrichtenReaktion());
        bauplan.addEventListeners(new commandPing());
        bauplan.addEventListeners(new wellcomeEmbed());
        bauplan.addEventListeners(new byeEmbed());
        bauplan.addEventListeners(new commandUserJoin());
        bauplan.addEventListeners(new commandUserLeft());
        bauplan.addEventListeners(new commandUserInfo());
        bauplan.addEventListeners(new commandBan());
        bauplan.addEventListeners(new commandKick());
        bauplan.addEventListeners(new commandCommands());
        bauplan.addEventListeners(new setupVerify());
        bauplan.addEventListeners(new secretFortnite());
        bauplan.addEventListeners(new commandTTS());

        bauplan.setChunkingFilter(ChunkingFilter.ALL);
        bauplan.setMemberCachePolicy(MemberCachePolicy.ALL);
        bauplan.enableIntents(GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_PRESENCES,
                GatewayIntent.MESSAGE_CONTENT,
                GatewayIntent.GUILD_EMOJIS_AND_STICKERS,
                GatewayIntent.GUILD_VOICE_STATES,
                GatewayIntent.DIRECT_MESSAGE_TYPING,
                GatewayIntent.DIRECT_MESSAGES,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.GUILD_MESSAGE_REACTIONS,
                GatewayIntent.GUILD_MESSAGE_TYPING,
                GatewayIntent.GUILD_PRESENCES);

        JDA bot = bauplan.build();
        System.out.println("Der Bot ist nun online!");
        System.out.println("Das Prefix ist '" + prefix + "'");

        bauplan.setStatus(OnlineStatus.ONLINE);
    }
}
