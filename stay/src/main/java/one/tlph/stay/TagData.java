package one.tlph.stay;

import java.io.IOException;
import java.io.OutputStream;

public abstract  class TagData<T> extends Tag  {
    protected final T data;
    public TagData(T data) {
        this.data = data;
    }

    public T get() {
        return data;
    }


}
