package FindChauffør;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RickshawService {
        private String[][] districts = {
                {"Christiania", "Operaen", "Havnebad Islands Brygge"},
                {"Tivoli", "Rådhuspladsen", "Christiansborg"},
                {"Amalienborg", "Strøget", "Nyhavn"}
        };

        private List<Driver> drivers = new ArrayList<>();

        public void createDriver(String name, int[] districtCoverage) {
            drivers.add(new Driver(name, districtCoverage));
        }

    public void bookDriver() {

        System.out.println("Pick a destination:");
        int counter = 1;
        for (String[] district : districts) {
            for (String destination : district) {
                System.out.println(counter + ") " + destination);
                counter++;
            }
        }

        Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Type a number for your destination: ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > 9) {
            System.out.println("Invalid choice try again.");
            bookDriver();
            return;
        }

        int districtRow = (choice - 1) / 3; // Find række (distrikt)
        int districtColumn = (choice - 1) % 3; // Find kolonne (destination)


        String selectedDestination = districts[districtRow][districtColumn];
        System.out.println("You have chosen: " + selectedDestination);


        Driver driver = findDriver(districtRow);
        if (driver != null) {
            System.out.println("Driver found: " + driver.getName());
            driver.setBooked(true);
        } else {
            System.out.println("No available driver found for this district.");
        }
    }
    public Driver findDriver(int districtNumber) {
        for (Driver driver : drivers) {
            if (!driver.isBooked() && driver.coversDistrict(districtNumber)) {
                return driver;
            }
        }
        return null;
    }
}
