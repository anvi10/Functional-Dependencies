import static java.lang.Character.*;
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
		/*
		System.out.println("attributes:");
		for (int i = 0; i < attr.size(); i++) {
			System.out.println( i + " " + attr.get(i)  );
		}
		*/

		System.out.println("fds:");
		for (int j = 0; j < fds.size(); j++) {
			System.out.println( j + " " + fds.get(j) );
			
			String split_tokens[] = fds.get(j).split("->");
			
			String left_side = split_tokens[0] ;
			String right_side = split_tokens[1] ;

			
			//assume a match is found
			int found = 1;

			for (int i = 0; i < attr.size(); i++) {
			
				for (int m = 0; m < left_side.length(); m++) {
					System.out.println( m + " " + left_side.charAt(m) );
					
					//check for a match in every character of left_side.
					//if no match is found at the end, we exit this loop and do not union this FD
					//repeat for all FDs
					
					char c1 = attr.get(i).charAt(0);
					char c2 = left_side.charAt(m);

					if ( c1 == c2 ) {
						found = 1; //match is found
					} else {
						found = 0; 
					//there is a character in the left side of this FD that doesnt match with anything in the X+
					}

					if (found == 0) {
						System.out.println("No match for " + left_side.charAt(m)); 
						//break out this loop and do not union this FD
						break;
					}

					if (found == 1) {
						System.out.println("Found a match for " + left_side.charAt(m));
						//union the left side to our FD
					}
				}
			}
			
			/*

			for (int n = 0; n < right_side.length(); n++) {
				System.out.println( n + " " + right_side.charAt(n) );
			}

			*/

			/*
			int k = 0;
			while (k < split_tokens.length) {
				System.out.println( k + " " + split_tokens[k]);		
			k++;
			}
			*/	

		

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
