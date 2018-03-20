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

		//Set F equal to fds

		List<String> f = new ArrayList <String>(fds.size()); //this will be our min cover

		List<String> temp = new ArrayList <String>(fds.size()); //we will manipulate this and remove variables

        //Step 1 of algorithm
		int z = 0;
		while (z < fds.size()) {
			f.add(fds.get(z));
			//temp.add(fds.get(z));
        z++;
		} 
        
        //Step 2 of algorithm
        for (int j = 0; j < fds.size(); j++) {
			
			String split_tokens[] = fds.get(j).split("->");
			
			String left_side = split_tokens[0] ;
			String right_side = split_tokens[1] ;
            
            if (right_side.length() > 1) {
                System.out.println( "The long funct dep is " + fds.get(j) + " and the right side of it is " + right_side  );
                
                //break the long ones into different fds
                
                f.remove(j); //remove the FD at index j and start splitting it into different fds
                
                int l = right_side.length() ;
                int iter = 0;
                while ( iter < l ) {
                    f.add( left_side + "->" + right_side.charAt(iter) ); //double check right_side.charAt(iter)  
                iter++;
                }
                
            } else { // else block exists for debugging purposes only 
                System.out.println( "The short funct dep is " + fds.get(j) + " and the right side of it is " + right_side  );
            }
            
        } 
        
        //populate temp with the values of our current f
        int c = 0;
        while (c < f.size()) {
            temp.add(f.get(c));
        c++;
        }
        
        //Step 3 of algorithm
        for (int i = 0; i < f.size(); i++) {
            System.out.println("The value at " + i + " is " + f.get(i));
            
            String split_tokens[] = f.get(i).split("->");
            String left_side = split_tokens[0];
            String right_side = split_tokens[1] ;
            
            //left_side length must be greater than 1, or else if we remove every attribute B (and theres only one), the left side would be null
            if (left_side.length() > 1) {
                System.out.println("left side is " + left_side + " and length is " + left_side.length() + " iteration number " + i);
                
                for (int j = 0; j < left_side.length(); j++) {
                    

                    System.out.println ( "entered for loop");
                    //save temp.get(i) as a string
                    
                    String s = temp.get(i); //s is our saved dependency
                    
                    //remove the funct dep i from temp
                    
                    temp.remove(i);
                    
                    for (int t = 0; t < temp.size(); t++) {
                        System.out.println( temp.get(t) + " is temps value at " + t  + "after removing i"); 
                    }
                    
                    System.out.println();
                    
                    //remove j from the left side , and create a funct dep of the new left side -> right side, and add the new one to temp
                    
                    String new_left = left_side.substring(0, j) + left_side.substring(j+1, left_side.length() );
                   // System.out.println(new_left + "iter " + j);
                    
                    temp.add( new_left + "->" + right_side );  //its now the value at i
                    
                    for (int t = 0; t < temp.size(); t++) {
                        System.out.println( temp.get(t) + " is temps value at " + t + "after adding our newleft and new right" ); 
                    }
                    
                     System.out.println();
                    
                                        
                    //find the closure of this new temp. 
                    
                    //since findClosure takes two params, attr and fds, we need to make attr string lists for both temp and for f
                    
                    
                    List<String> temp_attr = new ArrayList <String>();
                    List<String> f_attr = new ArrayList <String>();
                    
                    for (int e = 0; e < temp.size(); e++) {
                        String g = temp.get(e);
                        
                        for (int n = 0; n < g.length(); n++) {
                            if ( Character.isLetter(g.charAt(n)) ) {
                                System.out.println( " for temp The character is " + g.charAt(n) + " index n");
                                temp_attr.add(Character.toString(g.charAt(n)));
                            }
                        }
                    }
                    
                    System.out.println();
                    
                                        
                    for (int e = 0; e < f.size(); e++) {
                        String g = f.get(e);
                        
                        for (int n = 0; n < g.length(); n++) {
                            if ( Character.isLetter(g.charAt(n)) ) {
                                System.out.println( "for f The character is " + g.charAt(n) + " index n");
                                f_attr.add(Character.toString(g.charAt(n)));
                            }
                        }
                    }
                    
                    
                    //if it is the same as the original closure, we replace the old left side with the new left side in f
                    
                                        
                    //we re-add funct dep i to temp, to keep the size right so we dont run into array index out of bounds issues in the following iterations
            
                    temp.remove(i); //we need to again remove the new thing we changed to. at most, we are manipulating our final answer f
                    
                    for (int t = 0; t < temp.size(); t++) {
                        System.out.println( temp.get(t) + " is temps value at " + t + "after removing our newleft and new right" ); 
                    }
                    
                     System.out.println();
                    

                    temp.add(i, s);
                    
                    for (int t = 0; t < temp.size(); t++) {
                        System.out.println( temp.get(t) + " is temps value at " + t  + " after adding back s"); 
                    }
                    
                     System.out.println();
                    
                }
                
            }
            
            
        }
        
        //here is how we will save the strings in the above loop
         String tester = "Tedibear";
                for (int j = 0; j < tester.length(); j++ ) {
                   
                    String tester_left = tester.substring(0, j);
                    String tester_right = tester.substring(j+1, tester.length()  );
                    //String tester_remove = tester.substring(j,j+1);
                
                   // System.out.println ("tester left " + tester_left + " tester right " + tester_right + " remove " + tester_remove );
                    
                    String removed = tester_left + tester_right;
                    //System.out.println(removed + " " + j);
                }
        

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
		
		List<String> temp = new ArrayList <String>(attr.size());

		int z = 0;
		while ( z < attr.size()) {
			key.add(attr.get(z));
			temp.add(attr.get(z));
		z++;
		}

		//now key is equal to the original attributes
       		
	
		
		for (int x = 0; x < attr.size(); x++) {
			
			temp.remove(x);
            
			//if temp's closure is the same as key's closure, save the new key as temp.
            
            List<String> closure_attr = findClosure(attr,fds);
            List<String> closure_temp = findClosure(temp,fds);

            if (  closure_attr.equals(closure_temp) ){

                key.remove( attr.get(x) );

              
            }


            
            //reset temp for every iteration of x
			temp.add(x, attr.get(x));

		} 

	return key;
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
