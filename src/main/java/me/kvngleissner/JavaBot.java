package me.kvngleissner;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class JavaBot {
    private final ShardManager shardManager;


    public JavaBot() throws LoginException {
        Dotenv dotenv = Dotenv.load();
        String botToken =  dotenv.get("Bot_Token");

        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(botToken);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.listening("To Music"));
        shardManager = builder.build();
    }

    public ShardManager getShardManager() {
        return shardManager;
    }
}
