package net.typicartist.discord.game.sdk.structure.application;

import java.util.List;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import net.typicartist.discord.game.sdk.structure.OAuth2Token;

public class FFIMethods extends Structure {
    public static class ByReference extends FFIMethods implements Structure.ByReference {}

    public interface ValidateOrExitCallback extends Callback {
        void invoke(Pointer ptr, int result);
    }

    public interface ValidateOrExitMethod extends Callback {
        void invoke(Pointer methodPtr, Pointer callbackData, ValidateOrExitCallback callback);
    }

    public interface GetCurrentLocaleMethod extends Callback {
        void invoke(Pointer methodsPtr, byte[] locale);
    }

    public interface GetCurrentBranchMethod extends Callback {
        void invoke(Pointer methodsPtr, byte[] branch);
    }

    public interface GetOAuth2TokenCallback extends Callback {
        void invoke(Pointer ptr, int result, OAuth2Token.ByReference oauth2Token);
    }

    public interface GetOAuth2TokenMethod {
        void invoke(Pointer methodsPtr, Pointer callbackData, GetOAuth2TokenCallback callback);
    }

    public interface GetTicketCallback {
        void invoke(Pointer ptr, int result, String data);
    }

    public interface GetTicketMethod {
        void invoke(Pointer methodsPtr, Pointer callbackData, GetTicketCallback callback);
    }

    public ValidateOrExitMethod validateOrExit;
    public GetCurrentLocaleMethod getCurrentLocale;
    public GetCurrentBranchMethod getCurrentBranch;
    public GetOAuth2TokenMethod getOAuth2Token;
    public GetTicketMethod getTicket;

    public FFIMethods() {

    }

    public FFIMethods(Pointer methodPtr) {
        super(methodPtr);
        
        read();
    }

    @Override
    protected List<String> getFieldOrder() {
        return List.of(
            "validateOrExit", 
            "getCurrentLocale", 
            "getCurrentBranch", 
            "getOAuth2Token", 
            "getTicket"
        );
    }
}
