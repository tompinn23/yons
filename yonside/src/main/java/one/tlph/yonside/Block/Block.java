package one.tlph.yonside.Block;

public class Block {

	private String block_name;
	private boolean isDirty;


	public Block() {
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

}
