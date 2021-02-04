package one.tlph.stay;

import java.io.IOException;
import java.io.OutputStream;

public class TagBool extends TagData<Boolean> {
    public TagBool(Boolean data) {
        super(data);
    }
    @Override
    public TagType getType() {
        return TagType.TagBool;
    }
    @Override
    public void Write(OutputStream stream) throws IOException {
        stream.write(TagHeader.TagBool);
        if(data)
            stream.write(1);
        else
            stream.write(0);
    }
}
