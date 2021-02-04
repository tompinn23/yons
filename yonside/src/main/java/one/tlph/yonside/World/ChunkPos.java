package one.tlph.yonside.World;

import one.tlph.yonside.BasicPos;
import one.tlph.yonside.BlockFacing;

public class ChunkPos extends BasicPos<Integer> {


    public ChunkPos(int x, int z) {
        super(x, 0, z);
    }


    @Override
    public ChunkPos add(BlockFacing facing, int amount) {
        switch(facing) {
            case Up:
            return new ChunkPos(x, z);
            case Down:
                return new ChunkPos(x, z);
            case North:
                return new ChunkPos(x, z + amount);
            case South:
                return new ChunkPos(x, z - amount);
            case East:
                return new ChunkPos(x - amount, z);
            case West:
                return new ChunkPos(x + amount, z);
        }
        return new ChunkPos(x, z);
    }

    @Override
    public ChunkPos add(BasicPos<Integer> other) {
        return new ChunkPos(x + other.x, z + other.z);
    }

}
