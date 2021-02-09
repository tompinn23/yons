package one.tlph.yonside.registry;

import one.tlph.yonside.ResourceLocation;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class ObjectHolderRef implements Consumer<Predicate<ResourceLocation>> {


    @Override
    public void accept(Predicate<ResourceLocation> resourceLocationPredicate) {

    }

    @Override
    public Consumer<Predicate<ResourceLocation>> andThen(Consumer<? super Predicate<ResourceLocation>> after) {
        return null;
    }
}
