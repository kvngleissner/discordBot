package me.kvngleissner;

import io.github.cdimascio.dotenv.Dotenv;
import me.kvngleissner.Listeners.UserInfo;
import me.kvngleissner.Listeners.ClearCommand;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class JavaBot {
    private final ShardManager shardManager;


    public JavaBot() throws LoginException {
        Dotenv dotenv = Dotenv.load();
        String botToken =  dotenv.get("Bot_Token");

        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(botToken);
        builder.enableIntents(GatewayIntent.GUILD_MEMBERS);
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.listening("To Music"));

        shardManager = builder.build();
        // Registering Commands
        shardManager.addEventListener(new ClearCommand());
        shardManager.addEventListener(new UserInfo());
    }

    public ShardManager getShardManager() {
        return shardManager;
    }
}
