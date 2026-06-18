public class FinancialForecasting {
    
    /**
     * Calculates the future value using a recursive approach.
     * 
     * @param presentValue The initial amount.
     * @param growthRate The expected growth rate per period (e.g., 0.05 for 5%).
     * @param periods The number of periods (e.g., years) to forecast.
     * @return The calculated future value.
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base Case: If there are no more periods, the value is just the present value
        if (periods == 0) {
            return presentValue;
        }
        
        // Recursive Step: Calculate the value for the next period
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; // Initial investment of $1000
        double growthRate = 0.05;     // 5% annual growth rate
        int periods = 10;             // Forecast for 10 years

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        
        System.out.printf("Present Value: $%.2f%n", presentValue);
        System.out.printf("Growth Rate: %.2f%%%n", growthRate * 100);
        System.out.printf("Periods: %d years%n", periods);
        System.out.printf("Predicted Future Value: $%.2f%n", futureValue);
    }
}
