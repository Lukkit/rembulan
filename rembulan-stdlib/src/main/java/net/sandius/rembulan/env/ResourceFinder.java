package net.sandius.rembulan.env;

import java.io.IOException;
import java.io.InputStream;

public interface ResourceFinder {
    
    public InputStream findResource(String fileName) throws IOException;

}
