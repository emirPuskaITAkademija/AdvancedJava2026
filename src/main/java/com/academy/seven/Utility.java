package com.academy.seven;

import java.util.Collection;
import java.util.function.Supplier;

public class Utility {

    //srcCollection, dstCollection
    // T bez ograničenja
    // S sa ograničenjima da to može biti neka kolekcija elemenata tipa T
    // D sa istim ograničenjem
    public static <T, S extends Collection<T>, D extends Collection<T>> D transferElements(S srcCollection, Supplier<D> dSupplier) {
        D result = dSupplier.get();
        for(T element: srcCollection) {
            result.add(element);
        }
        return result;
    }
}
