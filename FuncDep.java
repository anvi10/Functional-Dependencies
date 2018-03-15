
import java.util.List;
import java.util.Map;
import java.util.Set;


public class FuncDep {

	/**
	 * Find the closure of attribute set attr under functional dependencies fds.
	 * Refer to Algorithm 16.1 (15.1 in edition 7) for more details
	 * 
	 * @param attr, list of attributes. Each attribute is an uppercase letter "A", "B", etc
	 * @param fds, list of functional dependencies of format "AB->XY"
	 * @return closure of attributes attr under fds
	 */
	public List<String> findClosure(List<String> attr, List<String> fds) {
		// TODO
		//
		System.out.println("attributes:");
		for (int i = 0; i < attr.size(); i++) {
			System.out.println( i + " " + attr.get(i)  );
		}
		
		System.out.println("fds:");
		for (int j = 0; j < fds.size(); j++) {
			System.out.println( j + " " + fds.get(j) );
		}

	return null;
	}
	
	/**
	 * Find the minimum cover of a set of functional dependencies fds
	 * Refer to Algorithm 16.2 (15.2 in edition 7)
	 * 
	 * @param fds, list of functional dependencies of format "AB->XY"
	 * @return minimum cover over set fds
	 */
	public List<String> findMinCover(List<String> fds) {
		// TODO
		return null;
	}
	
		/**
		 * Find the key of relation R defined by set of attribute set attr.
		 * Refer to Algorithm 16.2(a) (15.2(a) in edition 7) for more details
		 * 
		 * @param attr, complete list of attributes in relation R. Each attribute is an uppercase letter "A", "B", etc
		 * @param fds, list of functional dependencies of format "AB->XY"
		 * @return list of attributes that defines the key of relation R
		 */
		public List<String> findKey(List<String> attr, List<String> fds) {
		// TODO

		return null;
	}
	
	/**
	 * Synthesize the relation into 3NF with Dependency Preservation and Nonadditive Join Property
	 * Refer to Algorithm 16.6 (15.4 in edition 7) for more details
	 * 
	 * @param attr, complete list of attributes in relation R. Each attribute is an uppercase letter "A", "B", etc
	 * @param fds, list of functional dependencies of format "AB->XY"
	 * @return List of relations, where each relation is a list of attributes.
	 */
	public List<List<String>> get3NFForm(List<String> attr, List<String> fds) {
		//TODO
		return null;
	}
	
}
