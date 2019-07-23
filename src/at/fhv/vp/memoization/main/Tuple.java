package at.fhv.vp.memoization.main;

import java.util.Objects;

public class Tuple<T, R, U, V> {

    public final T par1;
    public final R par2;
    public final U par3;
    public final V par4;

    public Tuple(T t, R r, U u, V v) {
        par1 = Objects.requireNonNull(t);
        par2 = Objects.requireNonNull(r);
        par3 = Objects.requireNonNull(u);
        par4 = Objects.requireNonNull(v);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tuple)) return false;
        else {
            Tuple that = (Tuple) o;
            return par1.equals(that.par1) && par2.equals(that.par2) && par3.equals(that.par3) && par4.equals(that.par4);
        }
    }

    @Override
    public int hashCode() {
        return par1.hashCode() + par2.hashCode() + par3.hashCode() + par4.hashCode();
    }
}
