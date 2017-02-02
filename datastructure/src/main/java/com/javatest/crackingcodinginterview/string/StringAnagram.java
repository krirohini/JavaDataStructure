package com.javatest.crackingcodinginterview.string;

import java.util.Arrays;
import java.util.HashMap;

public class StringAnagram {

    static void isAnagram(String s1, String s2)
    {
        //Removing all white spaces from s1 and s2
 
        String copyOfs1 = s1.replaceAll("\\s", "");
 
        String copyOfs2 = s2.replaceAll("\\s", "");
 
        //Initially setting status as true
 
        boolean status = true;
 
        if(copyOfs1.length() != copyOfs2.length())
        {
            //Setting status as false if copyOfs1 and copyOfs2 doesn't have same length
 
            status = false;
        }
        else
        {
            //Changing the case of characters of both copyOfs1 and copyOfs2 and converting them to char array
 
            char[] s1Array = copyOfs1.toLowerCase().toCharArray();
 
            char[] s2Array = copyOfs2.toLowerCase().toCharArray();
 
            //Sorting both s1Array and s2Array
 
            Arrays.sort(s1Array);
 
            Arrays.sort(s2Array);
 
            //Checking whether s1Array and s2Array are equal
 
            status = Arrays.equals(s1Array, s2Array);
        }
 
        //Output
 
        if(status)
        {
            System.out.println(s1+" and "+s2+" are anagrams");
        }
        else
        {
            System.out.println(s1+" and "+s2+" are not anagrams");
        }
    }
 
   
        static void isAnagramUsingMap(String s1, String s2)
        {
            //Removing white spaces from s1 and s2 and converting case to lower case
     
            String copyOfs1 = s1.replaceAll("\\s", "").toLowerCase();
     
            String copyOfs2 = s2.replaceAll("\\s", "").toLowerCase();
     
            //Initially setting status as true
     
            boolean status = true;
     
            if(copyOfs1.length() != copyOfs2.length())
            {
                //Setting status as false if copyOfs1 and copyOfs2 doesn't have same length
     
                status = false;
            }
            else
            {
                //Constructing a map containing character as a key and character occurrences as a value
     
                HashMap<Character, Integer> map = new HashMap<Character, Integer>();
     
                for (int i = 0; i < copyOfs1.length(); i++)
                {
                    //Getting char from copyOfs1
     
                    char charAsKey = copyOfs1.charAt(i);
     
                    //Initializing char count to 0
     
                    int charCountAsValue = 0;
     
                    //Checking whether map contains this char
     
                    if(map.containsKey(charAsKey))
                    {
                        //If contains, retrieving it's count
     
                        charCountAsValue = map.get(charAsKey);
                    }
     
                    //Putting char and it's count to map with pre-incrementing char count
     
                    map.put(charAsKey, ++charCountAsValue);
     
                    //Getting char from copyOfs2
     
                    charAsKey = copyOfs2.charAt(i);
     
                    //Initializing char count to 0
     
                    charCountAsValue = 0;
     
                    //Checking whether map contains this char
     
                    if(map.containsKey(charAsKey))
                    {
                        //If contains, retrieving it's count
     
                        charCountAsValue = map.get(charAsKey);
                    }
     
                    //Putting char and it's count to map with pre-decrementing char count
     
                    map.put(charAsKey, --charCountAsValue);
                }
     
                //Checking each character and it's count
     
                for (int value : map.values())
                {
                    if(value != 0)
                    {
                        //If character count is not equal to 0, then setting status as false
     
                        status = false;
                    }
                }
     
            }
     
            //Output
     
            if(status)
            {
                System.out.println(s1+" and "+s2+" are anagrams");
            }
            else
            {
                System.out.println(s1+" and "+s2+" are not anagrams");
            }
        }
     
        
        public static boolean isAnagramEfficient(String s, String t) {
        	if (s.length() != t.length()) {
        		return false;
        	}
        	
        	int[] letters = new int[256];
        	int num_unique_chars = 0;
        	int num_completed_t = 0;
        	
        	char[] s_array = s.toCharArray();
        	for (char c : s_array) { // count number of each char in s.
        		if (letters[c] == 0) {
        			++num_unique_chars;
        		}
        		++letters[c];
        	}
        	
        	for (int i = 0; i < t.length(); ++i) {
        		int c = (int) t.charAt(i);
        		if (letters[c] == 0) { // Found more of char c in t than in s.
        			return false;
        		}
        		--letters[c];
        		if (letters[c] == 0) {
        			++num_completed_t;
        			if (num_completed_t == num_unique_chars) {
        				// it’s a match if t has been processed completely
        				return ( i == t.length() - 1);
        			}
        		}
        	}
        	return false;
        }
       
    public static void main(String[] args)
    {
        isAnagram("Mother In Law", "Hitler Woman");
 
        isAnagram("keEp", "peeK");
 
        isAnagram("SiLeNt CAT", "LisTen AcT");
 
        isAnagram("Debit Card", "Bad Credit");
 
        isAnagram("School MASTER", "The ClassROOM");
 
        isAnagram("DORMITORY", "Dirty Room");
 
        isAnagram("ASTRONOMERS", "NO MORE STARS");
 
        isAnagram("Toss", "Shot");
 
        isAnagram("joy", "enjoy");
    }
}
