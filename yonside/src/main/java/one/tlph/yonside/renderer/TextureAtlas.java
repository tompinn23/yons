package one.tlph.yonside.renderer;

import java.util.HashMap;

import org.lwjgl.opengl.GL45;

import one.tlph.yonside.ResourceLocation;
import one.tlph.yonside.Block.Block;
import one.tlph.yonside.Block.BlockDefinition;

public class TextureAtlas {

    private final String name;
    private int textureID;
    private int capacity;
    
    private HashMap<String, Integer> texIDs;
    
    public TextureAtlas(String name, int size) {
        this.name = name;
        this.capacity = size;
        this.textureID = GL45.glCreateTextures(GL45.GL_TEXTURE_2D_ARRAY);
        this.texIDs = new HashMap<>();
        GL45.glTexImage3D(this.textureID, 0, GL45.GL_RGBA, 16 * 6, 16, this.capacity, 0, GL45.GL_RGBA, GL45.GL_UNSIGNED_BYTE, (long)0); // long 0 is null
    }
    
    // Add a block
    public void AddBlockTexture(Block def) {
    	ResourceLocation rc = def.getResourceLocation();
    	
    }

}
