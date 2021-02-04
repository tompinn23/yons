package one.tlph.stay;

import java.io.IOException;
import java.io.OutputStream;

public class TagBinary extends TagData<byte[]> {

    @Override
    public TagType getType() {
        return TagType.TagBinary;
    }

    public TagBinary(byte[] data) {
        super(data);
    }

    @Override
    public void Write(OutputStream stream) throws IOException {
        stream.write(TagHeader.TagBinary);
        stream.write(data.length);
        stream.write(data);
    }
}
