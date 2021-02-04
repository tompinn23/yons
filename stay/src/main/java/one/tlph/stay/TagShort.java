package one.tlph.stay;

import com.google.common.primitives.Shorts;

import java.io.IOException;
import java.io.OutputStream;

public class TagShort extends TagData<Short> {

    public TagShort(short value) {
        super(value);
    }
    @Override
    public TagType getType() {
        return TagType.TagShort;
    }

    @Override
    public void Write(OutputStream stream) throws IOException {
        stream.write(TagHeader.TagShort);
        stream.write(Shorts.toByteArray(data));
    }
}
