package one.tlph.yonside;

public abstract class BasicPos<T> {

    public final T x;
    public final T y;
    public final T z;

    protected BasicPos(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public abstract BasicPos<T> add(BlockFacing facing, int amount);
    public abstract BasicPos<T> add(BasicPos<T> other);

}
