package one.tlph.stay;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class TagCompound extends Tag {
    protected HashMap<String, Tag> data;

    @Override
    public TagType getType() {
        return TagType.TagCompound;
    }

    public TagCompound() {
        data = new HashMap<>();
    }

    public void SetInt(String name, int value) {
        data.put(name, new TagInt(value));
    }

    public void SetLong(String name, long value) {
        data.put(name, new TagLong(value));
    }

    public void SetBool(String name, boolean value) {
        data.put(name, new TagBool(value));
    }

    public void SetString(String name, String value) {
        data.put(name, new TagString(value));
    }

    public void SetCompound(String name, TagCompound value) {
        data.put(name, value);
    }

    public void Set(String name, Tag tag) {
        data.put(name, tag);
    }

    @Override
    public void Write(OutputStream stream) throws IOException {
        stream.write(TagHeader.TagCompound);
        stream.write(data.size());
        for (Map.Entry<String, Tag> entry : data.entrySet()) {
            Tag tag = entry.getValue();
            tag.Write(stream);
        }

    }
}
