package net.typicartist.discord.game.sdk.constants;

public enum InputModeType {
    VoiceActivity(0),
    PushToTalk(1);

    private final int code;

    InputModeType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}