public class Exercise06_09 {
	public static void main(String[] args) {
		double ft = 0;
		double met = 15;
		System.out.printf("%-6s %-6s \t %-6s %-6s\n", "Feet", "Meters", "Meters", "Feet");
		System.out.println("-------------------------------");
		for (int x = 0; x < 10; x++) {
			ft += 1;
			met += 5;
			System.out.printf("%-6.1f %-6.3f \t %-6.1f %-6.3f \n", ft, footToMeter(ft), met,  meterToFoot(met));
			
		}
		
		
	}
	
	public static double meterToFoot(double meter) {
		double foot = 3.279 * meter;
		return foot;
	}
	
	public static double footToMeter(double foot) {
		double  meter = 0.305 * foot;
		return meter;
	}
}
