package net.typicartist.discord.game.sdk.exception;

import net.typicartist.discord.game.sdk.constants.Result;

public class ResultException extends RuntimeException {
    private final Result result;

    public ResultException(Result result) {
        super("DiscordCreate failed: " + result);

        this.result = result;
    }

    public Result getResult() {
        return this.result;
    }
}
