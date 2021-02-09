package one.tlph.yonside;

public class ResourceLocation {
    private final String namespace;
    private final String location;

    public ResourceLocation(String namespace, String location) {
        this.namespace = namespace;
        this.location = location;
    }
    
    public ResourceLocation(String rc) {
    	String[] parts = rc.split(":");
    	if(parts.length != 2)
    		throw new IllegalArgumentException("Improperly formatted resource string");
    	this.namespace = parts[0];
    	this.location = parts[1];
    }
    

	@Override
	public String toString() {
		return namespace + ":" + location;
	}

    
    
}
