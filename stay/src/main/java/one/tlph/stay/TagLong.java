package one.tlph.stay;

import com.google.common.primitives.Longs;

import java.io.IOException;
import java.io.OutputStream;

public class TagLong extends TagData<Long> {

    public TagLong(Long data) {
        super(data);
    }
    @Override
    public TagType getType() {
        return TagType.TagLong;
    }

    @Override
    public void Write(OutputStream stream) throws IOException {
        stream.write(TagHeader.TagLong);
        stream.write(Longs.toByteArray(data));
    }
}
