package one.tlph.stay;

import java.io.IOException;
import java.io.OutputStream;

public class TagInt extends TagData<Integer> {
    public TagInt(int data) {
        super(data);
    }

    @Override
    public TagType getType() {
        return TagType.TagInt;
    }
    @Override
    public void Write(OutputStream stream) throws IOException {
        stream.write(TagHeader.TagInt);
        stream.write(data);
    }
}
