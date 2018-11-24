# SecureDeserialization
This is an example showing a secure way to deserialize an object from a byte stream.

Object data is often transmitted over the wire in a serailized binary format and interpreted by the receiver/s by deserializing it.  It is often overlooked that the sender can create a byte stream of a different(unexpected and not mutually agreed upon) type and send it across to be deserialized.  If no checks are performed to validate the type of the byte stream, deserializing such corrupt input can cause the system to crash and may be regarded as a DoS attack.

I was recently exposed to such a scenario while refactoring a component in an industry-level software system.  Doing some research about it and the solutions, I came across this article which I have used as the basis of this example - https://www.ibm.com/developerworks/library/se-lookahead/index.html

While this problem is language-agnostic and should be safe-guarded against no matter the language your code was written in, this example shows a way to do so in Java. 


