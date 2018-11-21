package workingWithStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WorkingWithStreams 
{
	public static List<String> allToCaps(String[] strings)
	{
		List<String> oldStrings = Arrays.asList(strings);
		List<String> capsStrings = new ArrayList<>();
		
		capsStrings = oldStrings.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
		
		return capsStrings;
	}
	
	public static List<Integer> onlyPrimes(int[] numbers)
	{
		List<Integer> primes = new ArrayList<Integer>();
		
		List<Integer> oldNumbers = new ArrayList<>();
		for(int i : numbers)
		{
			oldNumbers.add(i);
		}
		
		primes = (List<Integer>) oldNumbers.stream().filter(num -> isPrime(num)).sorted().collect(Collectors.toList());
		
		return primes;
	}
	
	public static String concatToSingleString(String[] words)
	{
		List<String> wordInList = Arrays.asList(words);
		String singleString = "";
		
		singleString = wordInList.stream().reduce("", (a,b) -> a + " " + b);
		
		return singleString;
	}
	
	public static int sumOfEvens(int[] numbers)
	{
		int sum = 0;
		List<Integer> oldNumbers = new ArrayList<>();
		for(int i : numbers)
		{
			oldNumbers.add(i);
		}
		
		sum = oldNumbers.stream().filter(x -> x%2 == 0).reduce(0, (a,b) -> a + b);
		
		return sum;
	}
	
	public static boolean isPrime(int x)
	{
		boolean isNumPrime = true;
		for(int i = 2; i < x/2; i++)
		{
			if(x % i == 0)
			{
				isNumPrime = false;
			}
		}
		return isNumPrime;
	}
	
	public static void main(String[] args)
	{
		//Test 1 (All to caps)
		String[] strings1 = {"Hello","it's","Dale"};
		List<String> newStrings = allToCaps(strings1);
		for(String s : newStrings){System.out.print(s + " ");}
		System.out.println("");
		
		//Test 2 (Only Primes)
		int[] numbers2 = {10,7,3,9,11};
		List<Integer> primeNumbers = onlyPrimes(numbers2);
		for(int i : primeNumbers){System.out.print(i + ",");}
		System.out.println("");
		
		//Test 3 (Single String)
		String[] strings3 = {"Hello", "it's", "Dale"};
		String singleString = concatToSingleString(strings3);
		System.out.println(singleString);
		
		//Test 4 (Sum of evens)
		int[] numbers4 = {1,2,3,4,5};
		int sum = sumOfEvens(numbers4);
		System.out.println(sum);
	}
}
