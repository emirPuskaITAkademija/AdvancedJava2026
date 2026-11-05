package com.academy.one.io;

import java.io.Closeable;
import java.io.IOException;

public class Reader implements Closeable {
    @Override
    public void close()  throws IOException {
        System.out.println("Super je što se ovo predavanje bliži kraju..jer ništa ne kontam..");
    }
}
