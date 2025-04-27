package net.typicartist.discord.game.sdk.structure;

import java.util.List;
import com.sun.jna.Structure;
import net.typicartist.discord.game.sdk.enums.RelationshipType;

public class Relationship extends Structure {
    public RelationshipType type;
    public User user;
    public Presence presence;

    @Override
    protected List<String> getFieldOrder() {
        return List.of("type", "user", "presence");
    }
}
