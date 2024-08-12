package com.webApp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebAppController {
	@GetMapping (value = "/getHelloWorld" )
	public String getHello() {
		return "Hello";
	}
	//url - http://localhost:8080/getHello
	

@GetMapping (value = "/getName/{name}")
	public String getName(@PathVariable String name) {
	return "Hello," + name;
	}
//url - http://localhost:8080/getName/Aswath

@GetMapping (value = "/getInt/{a}/{b}")
public int getInt(@PathVariable int a,@PathVariable int b) {
	return a/b;
}
//url - http://localhost:8080/getInt/10/5

@GetMapping (value = "getGreat")
public String findGreat (@RequestParam int a,@RequestParam int b) {
	if(a>b) {
		return a+" is Greater";
	}
	
	else {
		return b+" is Greater";
	}
	
}
//url - http://localhost:8080/getGreat?a=10&b=20


//@GetMapping("/getTriangle/{rows}")
//public String getTriangle(@PathVariable int rows) {
//    StringBuilder response = new StringBuilder();
//    for (int i = 1; i <= rows; i++) {
//        // Append spaces to align the triangle
//        for (int j = 1; j <= rows - i; j++) {
//            response.append(" ");
//        }
//        // Append numbers to form the triangle pattern
//        for (int j = 1; j <= i; j++) {
//            response.append(j).append(" ");
//        }
//        response.append("\n"); // Move to the next line after each row
//    }
//    return "<pre>" + response.toString() + "</pre>";
//}


//	@GetMapping(value = "/getTriangle/{rows}")
//	public String getTriangle(@PathVariable int rows) {
//		StringBuilder sbr = new StringBuilder();
//		for(int i=1 ; i<=rows ; i++) {
////			for(int j=1 ; j<=rows-1 ; j++) {
////				sbr.append(" ");
////			}
//			for(int k=1 ; k<=i ;k++) {
//				sbr.append(k).append(" ");
//			}
//			sbr.append("\n");
//		}
//		return "<pre>" + sbr.toString() + "</pre>";
//	}
	
//@GetMapping(value = "/getTriangle/{rows}")
//public String getTriangle(@PathVariable int rows) {
//	StringBuilder sbr = new StringBuilder();
//	for(int i=1 ; i<=rows ; j<=i , j++ , i++ )



	

//		@GetMapping(value = "/convert/{date}/{month}/{year}")
//		public String dateFormat(@PathVariable int date, @PathVariable String month , @PathVariable int year ) {
//		return year+"-"+month+"-"+date;
//		}
		
		@GetMapping("/convert2/{date}/{month}/{year}")
	    public String dateFormat(@PathVariable int date, @PathVariable String month, @PathVariable int year) {
	        // Construct the date string in "dd-MMMM-yyyy" format
	        String dateString = String.format("%02d-%s-%d", date, month, year);

	        // Define the formatter for the input string
	        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy", Locale.ENGLISH);

	        // Parse the string into a LocalDate object
	        LocalDate localDate = LocalDate.parse(dateString, inputFormatter);

	        // Define the formatter for the output string ("yyyy-MM-dd" format)
	        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	        // Format the LocalDate object into the desired output format
	        String formattedDate = localDate.format(outputFormatter);

	        return formattedDate;
	    }
		
		@GetMapping(value = "/convert/{dateString}")
		public String getDate(@PathVariable String dateString) {
			String[] ss = dateString.split(",");//09 April,1999
			String dateMonth = ss[0].trim();
			String year = ss[1];
			
			String[] ss1 = dateMonth.split(" ");
			String date = ss1[0];
			String monthName = ss1[1];
			
			String dateFormat = String.format("%s-%s-%s",year,getMonthNumber(monthName),date);
			return dateFormat;
		}
		
		
	public String getMonthNumber(String monthName) {
			switch(monthName.toLowerCase()) {
			case "january": return "01";
			case "february": return "02";
			case "march": return "03";
			case "april": return "04";
			case "may": return "05";
			case "june": return "06";
			case "july": return "07";
			case "august": return "08";
			case "september": return "09";
			case "october": return "10";
			case "november": return "11";
			case "december": return "12";
			default : return "Invalid";

			}
		}
		
	@GetMapping("/combine/{input}")
    public String combineCharacters(@PathVariable String input) {
        // Create maps to store counts of lowercase and unique uppercase characters
        Map<Character, Integer> lowercaseCounts = new HashMap<>();
        Map<Character, Character> uniqueUppercase = new HashMap<>();

        // Process each character in the input string
        for (char c : input.toCharArray()) {
            if (Character.isLowerCase(c)) {
                // Count lowercase characters
                lowercaseCounts.put(c, lowercaseCounts.getOrDefault(c, 0) + 1);
            } else if (Character.isUpperCase(c) && !uniqueUppercase.containsKey(Character.toLowerCase(c))) {
                // Store unique uppercase characters in lowercase form
                uniqueUppercase.put(Character.toLowerCase(c), c);
            }
        }

        // Build the result string
        StringBuilder result = new StringBuilder();

        // Append duplicate lowercase characters
        result.append("Duplicate lowercase characters: ");
        lowercaseCounts.forEach((key, value) -> {
            if (value > 1) {
                result.append(key).append(",");
            }
        });

        // Append unique uppercase characters
        result.append(" Unique uppercase characters: ");
        uniqueUppercase.forEach((key, value) -> result.append(value).append(","));

        return result.toString();
    }
		
	
	

	    @GetMapping("/process/{input}")
	    public String processString(@PathVariable String input) {
	        Set<Character> lowercaseDuplicates = new HashSet<>();
	        Set<Character> uppercaseUniques = new HashSet<>();

	        for (Character ch : input.toCharArray()) {
	            if (Character.isLowerCase(ch) && input.indexOf(ch) != input.lastIndexOf(ch)) {
	                lowercaseDuplicates.add(ch);
	            } else if (Character.isUpperCase(ch)) {
	                uppercaseUniques.add(ch);
	            }
	        }

	        return "Lowercase Duplicates: " + lowercaseDuplicates + 
	               ", Uppercase Uniques: " + uppercaseUniques;
	    }
		
		
		
		
		
		
		
		

@GetMapping (value = "/getEquals")
public String getEquals (@RequestParam String username,@RequestParam String password) {
	if(username.equals("aswath") && password.equals("1234")) {
		return "Successfully Logged In";
	}
	else {
		return "Wrong Username or Password";
	}
	//url - http://localhost:8080/getEquals?username=aswath&password=1234
	}



@GetMapping (value = "/getExcep")
public String getExcep (@RequestParam String username,@RequestParam String password) throws InvalidException {
	if(username.equals("aswath") && password.equals("1234")) {
		return "Successfully Logged In";
	}
	else {
		throw new InvalidException("Wrong Username or Password");
	}
	//url - http://localhost:8080/getExcep?username=aswath&password=1234
}

class InvalidException extends Exception {
	public InvalidException(String msg) {
		super(msg);
	}
}

@GetMapping(value = "/getAgeExcep/{a}")
public String getAgeExcep (@PathVariable int a) throws AgeException {
	if(a>=18) {
		return "Valid Age";
	}
	else {
		throw new AgeException("Not Valid Age");
	}
}



class AgeException extends Exception {
	public AgeException(String message) {
		super(message);
	}
}





}