package one.tlph.stay;

import java.io.IOException;
import java.io.OutputStream;




public abstract class Tag {
    public abstract void Write(OutputStream stream) throws IOException;

    public abstract TagType getType();

    public enum TagType {
        Tag,
        TagBinary,
        TagBool,
        TagCompound,
        TagInt,
        TagLong,
        TagShort,
        TagString
    }
}
