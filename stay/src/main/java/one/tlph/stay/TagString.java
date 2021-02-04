package one.tlph.stay;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class TagString extends TagData<String> {
    public TagString(String data) {
        super(data);
    }

    @Override
    public TagType getType() {
        return TagType.TagString;
    }
    @Override
    public void Write(OutputStream stream) throws IOException {
        stream.write(TagHeader.TagString);
        stream.write(data.getBytes(StandardCharsets.UTF_8));
    }
}
