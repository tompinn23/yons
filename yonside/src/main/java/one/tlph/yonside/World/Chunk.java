package one.tlph.yonside.World;


import one.tlph.stay.Tag;
import one.tlph.stay.TagCompound;
import one.tlph.yonside.Block.Block;
import one.tlph.yonside.Block.BlockPos;
import one.tlph.stay.IStaySerializable;

public class Chunk implements IStaySerializable {

    public static final int Width = 16;
    public static final int Height = 128;
    public static final int Depth = 16;

    public final World world;
    public final ChunkPos pos;
    private Block[] blocks;

    public Chunk(ChunkPos pos, World world) {
        this.world =world;
        this.pos = pos;
        this.blocks = new Block[Width * Depth * Height];
    }

    public Block getBlock(BlockPos pos) {
        return blocks[(int) (Height * Depth * Math.floorMod(pos.z, Depth) + Width * pos.y + Math.floorMod(pos.x, Width))];
    }

    public void setBlock(BlockPos pos, Block block) {
        blocks[(int) (Height * Depth * Math.floorMod(pos.z, Depth) + Width * pos.y + Math.floorMod(pos.x, Width))] = block;
    }

    @Override
    public Tag Write() {
        return new TagCompound();
    }

    @Override
    public void Read(Tag tag) {

    }
}
