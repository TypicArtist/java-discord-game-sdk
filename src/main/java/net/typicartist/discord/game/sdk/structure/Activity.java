package net.typicartist.discord.game.sdk.structure;

import com.sun.jna.Structure;
import java.util.List;

public class Activity extends Structure {
    public Timestamps timestamps;
    public byte[] state = new byte[128];
    public byte[] details = new byte[128];
    public Assets assets;
    public Party party;
    public Secrets secrets;

    @Override
    protected List<String> getFieldOrder() {
        return List.of("timestamps", "state", "details", "assets", "party", "secrets");
    }

    public static class Timestamps extends Structure {
        public long start;
        public long end;

        @Override
        protected List<String> getFieldOrder() {
            return List.of("start", "end");
        }
    }

    public static class Assets extends Structure {
        public byte[] large_image = new byte[128];
        public byte[] large_text = new byte[128];
        public byte[] small_image = new byte[128];
        public byte[] small_text = new byte[128];

        @Override
        protected List<String> getFieldOrder() {
            return List.of("large_image", "large_text", "small_image", "small_text");
        }
    }

    public static class Party extends Structure {
        public byte[] id = new byte[128];
        public PartySize size;

        @Override
        protected List<String> getFieldOrder() {
            return List.of("id", "size");
        }

        public static class PartySize extends Structure {
            public int current_size;
            public int max_size;

            @Override
            protected List<String> getFieldOrder() {
                return List.of("current_size", "max_size");
            }
        }
    }

    public static class Secrets extends Structure {
        public byte[] match = new byte[128];
        public byte[] join = new byte[128];
        public byte[] spectate = new byte[128];

        @Override
        protected List<String> getFieldOrder() {
            return List.of("match", "join", "spectate");
        }
    }
}
