package one.tlph.stay;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class TagFileWriter {

    private TagCompound finalCompound;
    private final String filename;
    public TagFileWriter(String filename) {
        this.filename = filename;
    }

    public void AddTag(String name, Tag tag){
        finalCompound.Set(name, tag);
    }

    public void writeFile() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream outputStream = new GZIPOutputStream(out);
        finalCompound.Write(outputStream);
        outputStream.close();
        out.close();
        File file = new File(filename);
        FileOutputStream writer = new FileOutputStream(file);
        writer.write(out.toByteArray());
        writer.close();
    }
}
