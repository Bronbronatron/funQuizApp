package com.bronwyn.movieRecommendation.choiceProcessorService;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class ChoiceProcessorService {
	
	
    public String findMostCommonString(String[] strings) {
        if (strings == null || strings.length == 0) {
            // Handle the case where the array is empty or null
            return null; // or throw an exception
        }
        
        //To store String (in this case 'answerChoice' and number of times it appears in list of Strings)
        Map<String, Integer> frequencyMap = new HashMap<>();

        
        //The role of this loop is to count the frequency of each unique string in the array and store it in a frequencyMap.
        for (String str : strings) {
        //If str is already a key in the map, it retrieves its current value using frequencyMap.get(str)
        //If the key is not present (OrDefault is used), it defaults to 0.
        //It then increments the value by 1 and puts the updated count back in the map.
        //	frequencyMap.put -Used  to update the map itself i.e. store updated value back in the map
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }

        // Find the maximum frequency
        int maxFrequency = 0;
        for (int frequency : frequencyMap.values()) {

          // For each frequency value (frequency), it compares it with the current maximum frequency (maxFrequency) using Math.max.
         // The result of Math.max is the larger of the two values, which is assigned back to maxFrequency.
            maxFrequency = Math.max(maxFrequency, frequency);
        }

        // Find the string(s) with the maximum frequency
        StringBuilder mostCommonStrings = new StringBuilder();
        
        //This is a for-each loop that iterates over the entries (key-value pairs) of the frequencyMap.
        //Map is not iteratable, so need frequencyMap.entrySet
        //Map.Entry<String, Integer> entry is a variable that represents each entry during the iteration.
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                mostCommonStrings.append(entry.getKey()).append(",");
            }
           
        }
        
        if (mostCommonStrings.length() > 0) {
            mostCommonStrings.deleteCharAt(mostCommonStrings.length() - 1);
        }

        // If there are multiple most common strings, return a random one
        //Convert from String builder to String
        //.split(",") method divides the String into substrings based on the specified delimiter (,)
        //Ex. if mostCommonStrings contains "A,B,C", mostCommonArray will be ["A", "B", "C"].
        String[] mostCommonArray = mostCommonStrings.toString().split(",");
        
       //Generates a random index within the bounds of the array, and the corresponding element is then returned.
        //Useful if there are 2 maxFrequency values (One is selected at random)
        return mostCommonArray[new Random().nextInt(mostCommonArray.length)];
    }

}
