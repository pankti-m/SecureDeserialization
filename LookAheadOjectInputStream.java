import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

class LookAheadObjectInputStream extends ObjectInputStream {
    
    LookAheadObjectInputStream(InputStream inputStream) throws IOException {
	super(inputStream);
    }

    @Override
    protected Class<?> resolveClass(ObjectStreamClass stream) throws IOException,
	ClassNotFoundException {
	if (!stream.getName().equals(Cycle.class.getName())) {
	    throw new InvalidClassException("Attempt to deserialize invalid class",
	        stream.getName());
	}
	return super.resolveClass(stream);
    }
}

