import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class Driver {
    
    public static void main(String[] args) {
	try {
	    Cycle cycle = new Cycle(2, "bicycle", "ladybird");
	    byte[] serializedCycle = serialize(cycle);
	    Cycle deserializedCycle = (Cycle)deserialize(serializedCycle);
	    System.out.println("Wheels " + deserializedCycle.getNumWheels() +
	        " Type " + deserializedCycle.getType() +
	        " Make " + deserializedCycle.getMake());

	    byte[] serializedFile = serialize(new File("Test File"));
	    Cycle deserializedInvalidCycle = (Cycle)deserialize(serializedFile);

        } catch (IOException | ClassNotFoundException e) {
	    e.printStackTrace(System.err);
	}
    }

    private static byte[] serialize(Object obj) {
	try {
	    ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
	    ObjectOutputStream stream = new ObjectOutputStream(byteStream);
	    stream.writeObject(obj);
	    byte[] buffer = byteStream.toByteArray();
	    stream.close();
	    byteStream.close();
	    return buffer;
    	} catch(IOException e) {
	    System.out.println("Exception caught");
	    e.printStackTrace(System.err);
        }
	return null;
    }


    private static Object deserialize(byte[] buffer) throws IOException,
	ClassNotFoundException {
	ByteArrayInputStream byteStream =
	    new ByteArrayInputStream(buffer);
	ObjectInputStream stream =
	    new LookAheadObjectInputStream(byteStream);
	Object obj = stream.readObject();
	stream.close();
	byteStream.close();
	return obj;
    }
}
