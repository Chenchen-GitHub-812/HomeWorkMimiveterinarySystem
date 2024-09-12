package model;

public class IdGenerator {


		private static int currentMaxId = 0;
		
		public static String generateNewId(String prefix)
		{
			currentMaxId++;
			return String.format("%s%04d", prefix, currentMaxId);
		}
		
		
}
