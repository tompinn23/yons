package one.tlph.yonside.Block;

public class Block {
	
	private String block_name;
	private boolean opaque;
	
	
	public Block(boolean opaque) {
		this.opaque = opaque;
	}
	
	public Block setName(String name) {
		block_name = name;
		return this;
	}
}
