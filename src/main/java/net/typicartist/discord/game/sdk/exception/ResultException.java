package net.typicartist.discord.game.sdk.exception;

import net.typicartist.discord.game.sdk.constants.Result;
import net.typicartist.discord.game.sdk.utils.EnumUtil;

public class ResultException extends RuntimeException {
    private final Result result;

    public ResultException(int result) {
        super("DiscordCreate failed: " + result);

        this.result = EnumUtil.fromCode(Result.class, result);
    }

    public Result getResult() {
        return this.result;
    }
}
