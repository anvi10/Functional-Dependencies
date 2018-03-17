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

		for (int j = 0; j < fds.size(); j++) {
			
			String split_tokens[] = fds.get(j).split("->");
			
			String left_side = split_tokens[0] ;
			String right_side = split_tokens[1] ;

	
			//initialize closure to the attributes we are given

			
	
			int not_found = 1;

			
				
				for (int m = 0; m < left_side.length(); m++) {
					
					for (int i = 0; i < closure.size(); i++) {

					//check for a match in every character of left_side.
					//if no match is found at the end, we exit this loop and do not union this FD
					//repeat for all FDs
					
						char c1 = closure.get(i).charAt(0);
						char c2 = left_side.charAt(m);
	
						if ( c1 == c2 ) {
							not_found = 0; //match is found
						} 
					//there is a character in the left side of this FD that doesnt match with anything in the X+

					} //closing for i loop
					if (not_found == 1) {
						//break out this loop and do not union this FD
						break;

					}

				}	
			
		
			String[] splitted = right_side.split("(?!^)");

			if (not_found == 0) {
				for ( int v = 0; v < splitted.length; v++  ) {
					closure.add( splitted[v] ) ;
				} 
			}
		}

		//converting from a list to a set and back will remove all the duplicate attributes
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
        	List<String> key = new ArrayList <String>(attr.size());
		
		List<String> temp = new ArrayList <String>();

		int z = 0;
		while ( z < attr.size()) {
			key.add(attr.get(z));
			System.out.println( key.get(z) );
		z++;
		}
        
		/*

		for (int x = 0; x < key.size(); x++) {
		
		//reset temp for every iteration of x

			int i = 0;
			while (i < key.size()) {
				temp.add(attr.get(z));
			i++;	
			}

			temp.remove(x);

			for (int g = 0; g < temp.size(); g++) {
				System.out.println( g + " value " + temp.get(g));
			}	

			//if temp's closure is the same as key's closure, save the new key as temp.

		} */

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
