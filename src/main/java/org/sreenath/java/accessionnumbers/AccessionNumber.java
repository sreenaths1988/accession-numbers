package org.sreenath.java.accessionnumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccessionNumber {

	public static List<String> getOrderedList(String inputArgs) {
		
		/*
		 * regex which defines 3 groups
		 * 	group 1 corresponds to L..L part
		 * 	group 2 is occurence of left padded zeroes
		 * 	group 3 is N..N part
		 */
		final String REGEX = "^([A-Za-z]+)(0*)([0-9]*)$";
        
    	Pattern pattern = Pattern.compile(REGEX);
    	TreeMap<String, List<Integer>> lPartMap = new TreeMap<String, List<Integer>>();
        List<String> inputList = new ArrayList<String>();
        inputList = Arrays.asList(inputArgs.split(","));
        
        for(String accessionNumber : inputList) {

        	accessionNumber = accessionNumber.replaceAll(" ", "");
        	Matcher matcher = pattern.matcher(accessionNumber);
        	
        	if(matcher.find()) {
        		
        		String key = matcher.group(1) + matcher.group(2); // unique key is combination of L..L and left padded zeroes
        		String dynamicPart = matcher.group(3); // N..N digits
        		
        		List<Integer> tempList = null;
        		
        		if(lPartMap.get(key) == null) {
        			
        			tempList = new ArrayList<Integer>();
        			
        		} else {
        			
        			tempList = lPartMap.get(key);
        			
        		}

        		try {
        			
        			tempList.add(Integer.parseInt(dynamicPart));
        			
        		} catch(NumberFormatException ne) { // when accession number becomes the key
        			
        			tempList.add(0);
        			
        		}
        		
        		lPartMap.put(key, tempList);
        	
        	}
        	
        }
        
        List<String> finalList = new ArrayList<String>();

        for(String key : lPartMap.keySet()) {
        
        	finalList.addAll(arrangeValues(key, lPartMap.get(key)));
        	
        }
        
        Collections.sort(finalList);
 
        return finalList;
		
	}
	
	private static List<String> arrangeValues(String key, List<Integer> inputList) {
    	
    	List<String> resultList = new ArrayList<String>();
    	List<Integer> tempList = new ArrayList<Integer>();
    	
    	Collections.sort(inputList); // sorting the list so as to check for consecutive numbers and arrange in range
    	
    	for(int iter = 0; iter < inputList.size(); iter++) {
    		
    		int tempValueOne = (Integer) inputList.get(iter);
    		
    		if(iter == inputList.size() -  1) {
    			
    			if(!tempList.isEmpty()) {
    				
    				String tempString = key + tempList.get(0) + "-" + key + tempList.get(tempList.size() - 1);
        			resultList.add(tempString);
        			tempList.clear();
        			
    			} else {
    				
    				if(tempValueOne == 0) { // handling value = 0, when accession number becomes key itself
    					
    					resultList.add(key);
    					
    				} else {
    					
    					resultList.add(key + tempValueOne);
    					
    				}
    			}
    			
    			break;
    		}
    		
    		int tempValueTwo = (Integer) inputList.get(iter + 1);
    		
    		if(tempValueOne == tempValueTwo) { // remove duplicate
    			continue;
    			
    			
    		}
    		else if(tempValueTwo == tempValueOne + 1) { // check if numbers are consecutive
    			
    			if(tempList.isEmpty()) {
    				
    				tempList.add(tempValueOne);
    				
    			} else if(!tempList.isEmpty() && tempList.get(tempList.size() - 1) != tempValueOne) {
    				
    				tempList.add(tempValueOne);
    				
    			}
    			
    			tempList.add(tempValueTwo);
    			
    		} else if(!tempList.isEmpty()) {
    			
    			String tempString = key + tempList.get(0) + "-" + key + tempList.get(tempList.size() - 1);
    			resultList.add(tempString);
    			tempList.clear();
    			
    		} else {
    			
    			resultList.add(key + tempValueOne);
    			
    		}
    	}
    	
    	return resultList;
   
    }
	
}
