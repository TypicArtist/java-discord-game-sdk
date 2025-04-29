package net.typicartist.discord.game.sdk.constants;

public enum Result {
    Ok(0),
    ServiceUnavailable(1),
    InvalidVersion(2),
    LockFailed(3),
    InternalError(4),
    InvalidPayload(5),
    InvalidCommand(6),
    InvalidPermissions(7),
    NotFetched(8),
    NotFound(9),
    Conflict(10),
    InvalidSecret(11),
    InvalidJoinSecret(12),
    NoEligibleActivity(13),
    InvalidInvite(14),
    NotAuthenticated(15),
    InvalidAccessToken(16),
    ApplicationMismatch(17),
    InvalidDataUrl(18),
    InvalidBase64(19),
    NotFiltered(20),
    LobbyFull(21),
    InvalidLobbySecret(22),
    InvalidFilename(23),
    InvalidFileSize(24),
    InvalidEntitlement(25),
    NotInstalled(26),
    NotRunning(27),
    InsufficientBuffer(28),
    PurchaseCanceled(29),
    InvalidGuild(30),
    InvalidEvent(31),
    InvalidChannel(32),
    InvalidOrigin(33),
    RateLimited(34),
    OAuth2Error(35),
    SelectChannelTimeout(36),
    GetGuildTimeout(37),
    SelectVoiceForceRequired(38),
    CaptureShortcutAlreadyListening(39),
    UnauthorizedForAchievement(40),
    InvalidGiftCode(41),
    PurchaseError(42),
    TransactionAborted(43),
    DrawingInitFailed(44);

    private final int code;

    Result(int code) {
        this.code = code;
    }

    public static Result fromCode(int code) {
        for (Result result : Result.values()) {
            if (result.getCode() == code) {
                return result;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }
}
