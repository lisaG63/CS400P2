
public class test {

	public static void main(String[] args) {
		System.out.println((double)6/(double)21);
		HashTableADT<Integer,String> ht = new HashTable<Integer, String>(20, 0.5);
		try {
			ht.insert(1, "1");
		} catch (IllegalNullKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
