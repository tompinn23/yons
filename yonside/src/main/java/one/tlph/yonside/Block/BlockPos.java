package one.tlph.yonside.Block;

import one.tlph.yonside.BasicPos;
import one.tlph.yonside.BlockFacing;

public class BlockPos extends BasicPos<Long> {
    public BlockPos(long x, long y, long z) {
        super(x, y, z);
    }

    @Override
    public BlockPos add(BlockFacing facing, int amount) {
        switch(facing) {
            case Up:
                return new BlockPos(x, y+ amount, z);
            case Down:
                return new BlockPos(x, y - amount, z);
            case North:
                return new BlockPos(x, y, z + amount);
            case South:
                return new BlockPos(x, y, z - amount);
            case East:
                return new BlockPos(x - amount, y, z);
            case West:
                return new BlockPos(x + amount, y, z);
        }
        return new BlockPos(x, y, z);
    }

    @Override
    public BlockPos add(BasicPos<Long> other) {
        return new BlockPos(x + other.x, y + other.y, z + other.z);
    }
}
