package me.kvngleissner.Listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ClearCommand extends ListenerAdapter {


    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] arguments = event.getMessage().getContentRaw().split("\\s+");
        // Checking for the Used Command
        if (arguments[0].equalsIgnoreCase("!clear")) {
            if (arguments.length < 2) {
                // Building the Embed
                EmbedBuilder commandEmbed = new EmbedBuilder();
                commandEmbed.setColor(Color.BLUE);
                commandEmbed.setTitle("Specify the Amount of Messages to Clear");
                commandEmbed.setDescription("Usage: !clear [# of Messages to Clear]");
                event.getChannel().sendMessageEmbeds(commandEmbed.build()).queue();
            } else {
                // Gets Specified Amount of Messages and Deletes them
                System.out.println("test");
                List<Message> messages = event.getChannel()
                        .getHistory().retrievePast(
                                Integer.parseInt(arguments[1]) + 1).complete();
                event.getChannel().purgeMessages(messages).clear();
                event.getChannel().sendMessage("Messages have been Deleted!")
                        // Deletes the Messages after 5 Seconds
                        .queue(m -> m.delete().queueAfter(5, TimeUnit.SECONDS));
            }
        }
    }
}