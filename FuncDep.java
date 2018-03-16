import static java.lang.Character.*;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;


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
		
		List<String> closure = new ArrayList <String>(attr.size());

		int z = 0;
		while ( z < attr.size()) {
			closure.add(attr.get(z));
		z++;
		}

		System.out.println("fds:");
		for (int j = 0; j < fds.size(); j++) {
			System.out.println( j + " " + fds.get(j) );
			
			String split_tokens[] = fds.get(j).split("->");
			
			String left_side = split_tokens[0] ;
			String right_side = split_tokens[1] ;

	
			//initialize closure to the attributes we are given

			/*List<String> closure = new ArrayList<String>(attr.size());			
			

			int z = 0;
			while ( z < attr.size() ) {
				closure.add(attr.get(z));
			z++;
			} */			
			
	
			int not_found = 1;

			//for (int i = 0; i < attr.size(); i++) {
			
				//System.out.println(left_side.length() + "left side length");
				
				for (int m = 0; m < left_side.length(); m++) {
					System.out.println( m + " " + left_side.charAt(m) );
					
					//changing from attr to closure
					for (int i = 0; i < closure.size(); i++) {

					//check for a match in every character of left_side.
					//if no match is found at the end, we exit this loop and do not union this FD
					//repeat for all FDs
					
						//changing from attr to closure
						char c1 = closure.get(i).charAt(0);
						char c2 = left_side.charAt(m);
	
						if ( c1 == c2 ) {
							not_found = 0; //match is found
						} 
					//there is a character in the left side of this FD that doesnt match with anything in the X+

					} //closing for i loop
					if (not_found == 1) {
						System.out.println("No match for " + left_side.charAt(m)); 
						//break out this loop and do not union this FD
						break;

					}

					if (not_found == 0) {
						System.out.println("Found a match for " + left_side.charAt(m));
						//union the left side to our closure
					}
				}	
		System.out.println( "Left side is " + left_side); 
			
		
			String[] splitted = right_side.split("(?!^)");

			if (not_found == 0) {
				System.out.println("not found is 0");
				for ( int v = 0; v < splitted.length; v++  ) {
					closure.add( splitted[v] ) ;
				} //HERE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! only add if it isnt already in the closure
			}

		


			int y = 0;
			while (y < closure.size()) {
				System.out.println( "content of closure at " + y + "is " + closure.get(y));
			y++;
			}
			//System.out.println(closure);
		}
		closure = new ArrayList<String>(new HashSet<String>(closure));

	return closure;
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
