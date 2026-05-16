package com.alexbrav.sportsim;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Random;
import java.util.Scanner;

/**
 * NeighborhoodGrid refers to the households' layout for each simulation.
 * It is a square grid [size X size].
 *
 * @author
 */
public class NeighborhoodGrid {
    /**
     * Represents the size of the neighborhood grid.
     */
    private final int size;
    /**
     * A 2D grid representing a neighborhood where each cell is occupied by a household.
     * Each the rows and columns define the position of a household within the neighborhood.
     */
    public Household[][] grid;

    /**
     * Constructs a NeighborhoodGrid by reading household data from an input file.
     * Each square in the grid corresponds to a household defined by a specific letter
     * and (if applicable) a passion level.
     *
     * @param inputFileName the name of the file that contains the household data
     *                      used to populate the grid
     * @throws FileNotFoundException if the specified file does not exist or cannot be opened
     * @throws ParseException        if the data in the file is not in the expected format or
     *                               contains invalid household specifications
     */
    public NeighborhoodGrid(String inputFileName) throws FileNotFoundException, ParseException {
        int size = 0;
       
        try {
            Scanner fileScanner = new Scanner(new File(inputFileName)); 
            
            // Determine size of the grid
            while(fileScanner.hasNextLine()){
                size++;
                fileScanner.nextLine();
            }
            fileScanner.close();
            this.size = size;

            // Initialize the grid
            if (size > 0 ){
                grid = new Household[size][size];
            } else {
                throw new IllegalArgumentException("Width must be > 0");
            }

            Scanner reOpenedFileScanner = new Scanner(new File(inputFileName)); 

            // Populate the grid with households based on file data
            for (int i = 0; i < size; i++) {
                String line = reOpenedFileScanner.nextLine();
                String[] items = line.split("\\s+"); 
                
                for (int j = 0; j < size; j++) {
                    char sPassion = items[j].charAt(0);
                    
                    if (items[j].length() > 1) {
                        int level = Character.getNumericValue(items[j].charAt(1));
                        
                        switch (sPassion) {
                            case 'B' -> grid[i][j] = new Basketball(this, i, j, level);
                            case 'F' -> grid[i][j] = new Football(this, i, j, level);
                            case 'A' -> grid[i][j] = new Baseball(this, i, j, level);
                            case 'S' -> grid[i][j] = new Soccer(this, i, j, level);
                            case 'R' -> grid[i][j] = new Rugby(this, i, j, level);
                            default -> throw new ParseException("Invalid household type with passion", j);

                        }
                    } else {
                        switch (sPassion) {
                            case 'E' -> grid[i][j] = new Everything(this, i, j);
                            case 'N' -> grid[i][j] = new Nothing(this, i, j);
                            default -> throw new ParseException("Invalid household type without passion", j);
                        }
                    }

                }

            }
            reOpenedFileScanner.close();

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found: " + inputFileName);
        } catch (ParseException e) {
            throw new ParseException("Error parsing file: " + inputFileName, e.getErrorOffset());
        }   
            
    }

    /**
     * Constructs a NeighborhoodGrid of a specified size.
     * If the provided size is greater than zero, it initializes an empty grid of the
     * specified dimensions. Otherwise, it throws an IllegalArgumentException.
     *
     * @param size the size of the grid (number of rows and columns). Must be greater than 0.
     * @throws IllegalArgumentException if the size is not greater than 0.
     */
    public NeighborhoodGrid(int size) {
        this.size = size;
        if (size > 0) {
            grid = new Household[size][size];
        } else {
            throw new IllegalArgumentException("Width must be > 0");
        }
    }

    /**
     * Retrieves the size of the neighborhood grid.
     *
     * @return the size of the grid, representing the number of rows and columns.
     */
    public int getSize() {
        return size;
    }


    /**
     * Randomly initializes the grid of the NeighborhoodGrid instance with various household types.
     * Each cell in the grid is assigned one of the household types (Basketball, Football, Baseball,
     * Soccer, Everything, Nothing, or Rugby) based on a random selection.
     */
    public void randomInit() {
        for (int i = 0; i < size; i++) {
            
            for (int j = 0; j < size; j++) {
                Random rand = new Random();
                int randomNum = rand.nextInt(7);
                int interestLevel = rand.nextInt(Household.MAX_INTEREST) + 1;
                
                switch (randomNum) {
                    case 0 -> grid[i][j] = new Basketball(this, i, j, interestLevel);
                    case 1 -> grid[i][j] = new Football(this, i, j, interestLevel);
                    case 2 -> grid[i][j] = new Baseball(this, i, j, interestLevel);
                    case 3 -> grid[i][j] = new Soccer(this, i, j, interestLevel);
                    case 4 -> grid[i][j] = new Everything(this, i, j);
                    case 5 -> grid[i][j] = new Nothing(this, i, j);
                    case 6 -> grid[i][j] = new Rugby(this, i, j, interestLevel);
                }
            }
        }
    }

    /**
     * Initiates a grid from a given array of strings representing household types.
     * Each string in the array corresponds to a row in the grid, and each character
     * in the string represents a specific household type.
     * 
     * @param rows
     * 
     */
    public void initFromStrings(String[][] rows){
        for (int i = 0; i < this.getSize(); i++) {
            for (int j = 0; j < this.getSize(); j++) {
                char sPassion = rows[i][j].charAt(0);
                
                if (rows[i][j].length() > 1) {
                    int level = Character.getNumericValue(rows[i][j].charAt(1));
                    
                    switch (sPassion) {
                        case 'B' -> grid[i][j] = new Basketball(this, i, j, level);
                        case 'F' -> grid[i][j] = new Football(this, i, j, level);
                        case 'A' -> grid[i][j] = new Baseball(this, i, j, level);
                        case 'S' -> grid[i][j] = new Soccer(this, i, j, level);
                        case 'R' -> grid[i][j] = new Rugby(this, i, j, level);
                        default -> throw new IllegalArgumentException("Invalid household type with passion");

                    }
                } else {
                    switch (sPassion) {
                        case 'E' -> grid[i][j] = new Everything(this, i, j);
                        case 'N' -> grid[i][j] = new Nothing(this, i, j);
                        default -> throw new IllegalArgumentException("Invalid household type without passion");
                    }
                }

            }

        }
    }

    /**
     * Output the Neighborhood grid.
     * For each square, output the letter associated with the household occupying the square.
     * If the household is interested in a sport, output the interest level in that sport followed
     * by a blank space. Otherwise, output two blank spaces after the letter. One of the blank space
     * is part of toString() implementation of the households
     *
     * @return String
     */
    public String toString() {
        String everything = "";

        for (Household[] households : grid) {
            for (Household household : households) {
                everything += household.toString() + " ";
            }
            everything += "\n";
        }
        return everything;
    }

    /**
     * Write the Neighborhood grid to a file.
     *
     * @param outputFileName
     * @throws FileNotFoundException
     */
    public void write(String outputFileName) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(new File(outputFileName))) {
            writer.print(this.toString());
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found: " + outputFileName);
        }

    }
        
}
