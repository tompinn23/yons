package one.tlph.yonside.renderer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.*;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class RenderManager {

    private static short[] indexBufferArray;

    static {
        indexBufferArray = new short[196608];
        for(int i = 0; i < 32768; i++) {
            //0, 1, 2, 2, 3, 0
            indexBufferArray[i * 6] = 0;
            indexBufferArray[i * 6 + 1] = 1;
            indexBufferArray[i * 6 + 2] = 2;
            indexBufferArray[i * 6 + 3] = 2;
            indexBufferArray[i * 6 + 4] = 3;
            indexBufferArray[i * 6 + 5] = 0;
        }
    }


    private static RenderManager instance = null;

    private int vertexArray;
    private int elementArray;
    private BlockingQueue<Integer> availableVertexBuffers;
    private BlockingQueue<Integer> vertexBufferToDraw;

    private RenderManager() {
        availableVertexBuffers = new ArrayBlockingQueue<>(9);
        for(int i = 0; i < 9; i++) {
            int vbo = GL45.glCreateBuffers();
            GL45.glNamedBufferData(vbo, 1179648, GL20.GL_DYNAMIC_DRAW);
            availableVertexBuffers.add(vbo);
        }
        elementArray = GL45.glCreateBuffers();
        GL45.glNamedBufferData(elementArray, indexBufferArray, GL15.GL_STATIC_DRAW);
        vertexArray = GL45.glCreateVertexArrays();
        GL45.glBindVertexArray(vertexArray);
        GL45.glVertexAttribPointer(0, 3, GL45.GL_FLOAT, false, 6, 0);
        GL45.glEnableVertexArrayAttrib(vertexArray, 0);
        GL45.glVertexAttribPointer(1, 2, GL45.GL_FLOAT, false, 6, 3);
        GL45.glEnableVertexArrayAttrib(vertexArray, 1);
        GL45.glVertexAttribPointer(2, 1, GL45.GL_FLOAT, false, 6, 5);
        GL45.glEnableVertexArrayAttrib(vertexArray, 2);
    }

    public static RenderManager initialise() {
        instance = new RenderManager();
        return instance;
    }

    public static RenderManager getInstance() {
        return instance;
    }


    public void drawBuffer(FloatBuffer buff) throws InterruptedException {
        int vbo = availableVertexBuffers.take();
        int size = buff.remaining();
        if(size <= GL45.glGetBufferParameteri(vbo, GL20.GL_BUFFER_SIZE)) {
            GL45.glNamedBufferSubData(vbo, 0, buff);
        } else {
            GL45.glNamedBufferData(vbo, buff, GL15.GL_DYNAMIC_DRAW);
        }
        GL45.glBindVertexArray(vertexArray);
        GL45.glBindBuffer(GL15.GL_ARRAY_BUFFER, vbo);
        GL45.glBindBuffer(GL45.GL_ELEMENT_ARRAY_BUFFER, elementArray);
        GL45.glDrawArrays(GL11.GL_TRIANGLES, 0, size / 6);
    }

    public void renderChunks() {

    }
}
