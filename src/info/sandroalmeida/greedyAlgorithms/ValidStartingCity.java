package info.sandroalmeida.greedyAlgorithms;

public class ValidStartingCity {

    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int numberOfCities = distances.length;
        int milesRemaining = 0;

        int indexOfStartingCandidate = 0;
        int milesRemainingAtStartingCandidate = 0;

        for(int cityIndex = 1; cityIndex < numberOfCities; cityIndex++){
            int distanceFromPreviousCity = distances[cityIndex - 1];
            int fuelFromPreviousCity = fuel[cityIndex - 1];
            milesRemaining += fuelFromPreviousCity * mpg - distanceFromPreviousCity;

            if(milesRemaining < milesRemainingAtStartingCandidate){
                milesRemainingAtStartingCandidate = milesRemaining;
                indexOfStartingCandidate = cityIndex;
            }
        }
        return indexOfStartingCandidate;
    }


    public static void main(String[] args) {
        int[] distances = new int[] {30, 40, 10, 10, 17, 13, 50, 30, 10, 40};
        int[] fuel = new int[] {1, 2, 0, 1, 1, 0, 3, 1, 0, 1};
        int mpg = 25;
        System.out.println(validStartingCity(distances, fuel, mpg));
    }
}
