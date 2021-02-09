package one.tlph.yonside.Block;

import one.tlph.yonside.ResourceLocation;

public class Block {

	private String block_name;
	private ResourceLocation location;
	private boolean isDirty;


	public Block(ResourceLocation rc) {
		this.location = rc;
	}

	public Block setRegistryName(String name) {
		block_name = name;
		return this;
	}

	public boolean isOpaque() {
		return true;
	}

	public void setDirty() {
		this.isDirty = true;
	}

	public void clearDirty() {
		this.isDirty = false;
	}

	public boolean isDirty() {
		return this.isDirty;
	}

	public ResourceLocation getResourceLocation() {
		// TODO Auto-generated method stub
		return null;
	}

}
