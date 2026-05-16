package edu.iastate.cs2280.hw1;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Performs simulations over the neighborhood grid.
 *
 * @author
 */
public class Neighborhood {
    /**
     * Updates the grid by calculating the next state of each household in the grid.
     * Each household in the old grid determines its new state and updates the
     * corresponding position in the new grid.
     *
     * @param oldGrid      the current state of the neighborhood grid (old grid)
     * @param newGrid      the updated state of the neighborhood grid (new grid)
     * @param currentMonth the current month of the simulation, used for household updates
     */
    public static void updateGrid(NeighborhoodGrid oldGrid, NeighborhoodGrid newGrid, int currentMonth) {
        for (int i = 0; i < oldGrid.getSize(); i++) {
            for (int j = 0; j < oldGrid.getSize(); j++) {
                newGrid.grid[i][j] = oldGrid.grid[i][j].next(newGrid, currentMonth);
            }
        }
    }

    /**
     * The main method serves as the entry point for the simulation of neighborhood sports preferences.
     * It allows users to initialize grids (randomly or from a file), set the duration of the simulation,
     * and view the evolution of the grid over time.
     *
     * @param args command-line arguments passed to the application
     * @throws FileNotFoundException  if the specified file for grid input is not found
     * @throws ParseException         if there is an error in parsing the input file for the grid
     * @throws InputMismatchException if user input does not match the expected input type
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException, InputMismatchException {
        System.out.println("Neighborhood Sports Preferences");
        System.out.println("===============================");
        Scanner scan = new Scanner(System.in);
        int simulationCount = 1;

        // Main loop for multiple simulations
        while (true){
            System.out.println("\nKeys: 1 (random grid); 2 (file input); 3 (exit) \n");
            System.out.print("Simulation Number " + simulationCount + ": ");
            int simulationType = scan.nextInt();
            simulationCount++;
            int size;
            int months;
            NeighborhoodGrid grid;

            if (simulationType == 1){ 
                System.out.println("Random grid");
                System.out.print("Enter grid size: ");
                size = scan.nextInt();
                grid = new NeighborhoodGrid(size);
                grid.randomInit();

            } else if (simulationType == 2) {
                System.out.println("Grid input from a file");
                System.out.print("File name:");
                String fileName = scan.next();
                grid = new NeighborhoodGrid(fileName);

            }  else {
                System.out.println("Exiting...");
                break;

            }

            System.out.print("Enter the number of months: ");
            months = scan.nextInt();

            System.out.println("Initial grid:");
            System.out.println(grid.toString());

            // Run simulation for the specified number of months
            for(int i = 0; i < months; i++){
                System.out.println("Updated grid for " + (i + 1) + " month(s): \n");
                NeighborhoodGrid newGrid = new NeighborhoodGrid(grid.getSize());
                updateGrid(grid, newGrid, i + 1);
                
                grid = newGrid;
                System.out.println(grid.toString() + "\n");

            }

        } 

        scan.close();
        
        
        

    }
}
