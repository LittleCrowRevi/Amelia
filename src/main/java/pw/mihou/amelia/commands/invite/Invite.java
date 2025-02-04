package pw.mihou.amelia.commands.invite;

import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.component.Button;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.interaction.SlashCommandCreateEvent;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.javacord.api.interaction.SlashCommandInteractionOption;
import org.javacord.api.interaction.callback.InteractionImmediateResponseBuilder;
import pw.mihou.amelia.templates.Embed;
import pw.mihou.velen.interfaces.VelenArguments;
import pw.mihou.velen.interfaces.VelenEvent;
import pw.mihou.velen.interfaces.VelenSlashEvent;

import java.util.List;

public class Invite implements VelenEvent, VelenSlashEvent {

    @Override
    public void onEvent(MessageCreateEvent event, Message message, User user, String[] args) {
        new MessageBuilder().setEmbed(new Embed().setTitle("Your Majesty wishes to invite me?")
                .setThumbnail(event.getApi().getYourself().getAvatar())
                .setDescription("You can invite me freely by pressing the button below!").build())
                .replyTo(message)
                .addActionRow(Button.link("https://discord.com/api/oauth2/authorize?client_id=786464598835986483&permissions=67488832&scope=bot%20applications.commands",
                        "Invite me", "\uD83D\uDC9D"))
                .send(event.getChannel());
    }

    @Override
    public void onEvent(SlashCommandCreateEvent slashCommandCreateEvent, SlashCommandInteraction slashCommandInteraction, User user, VelenArguments velenArguments, List<SlashCommandInteractionOption> list, InteractionImmediateResponseBuilder interactionImmediateResponseBuilder) {
        new MessageBuilder().setEmbed(new Embed().setTitle("Your Majesty wishes to invite me?")
                .setThumbnail(slashCommandCreateEvent.getApi().getYourself().getAvatar())
                .setDescription("You can invite me freely by pressing the button below!").build())
                .addActionRow(Button.link("https://discord.com/api/oauth2/authorize?client_id=786464598835986483&permissions=67488832&scope=bot%20applications.commands",
                        "Invite me", "\uD83D\uDC9D"))
                .send(slashCommandInteraction.getChannel().get());
    }
}
