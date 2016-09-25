import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

public class ZbioryZnakow {

	public static void main(String[] args) {
		
		Charset cset = Charset.forName("ISO-8859-1");
		Set<String> aliases = cset.aliases();
//		for(String alias : aliases)
//			System.out.println(alias);
//		
//		System.out.println();
//		
		Map<String, Charset> charsets = Charset.availableCharsets();
//		for(String name : charsets.keySet())
//			System.out.println(name);
		
		String str = "Przykładowy string";
		ByteBuffer buffer = cset.encode(str);
		byte[] bytes = buffer.array();
		
		for(byte name : bytes)
			System.out.println(name);
		
		ByteBuffer bbuf = ByteBuffer.wrap(bytes);
		CharBuffer cbuf = cset.decode(bbuf);
		String str1 = cbuf.toString();
		
		System.out.println("str1 = " + str1);
	}
}
