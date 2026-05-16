package edu.iastate.cs2280.hw1;

import org.junit.jupiter.api.Test;

public class baseballTest {
    
    // Check for first rule
    @Test
    public void firstCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"N", "N", "N"},
                {"N", "A5", "N"},
                {"N", "N", "N"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);

        assert(testResult instanceof Nothing);

    }

    // Check for Second rule
    @Test
    public void secondCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"S3", "F1", "S4"},
                {"N", "A3", "S2"},
                {"A1", "S5", "E"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);

        assert(testResult.toString().equals("S0 "));

    }
    
    // Check for Third rule
    @Test
    public void thirdCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"S3", "F1", "F1"},
                {"N", "A3", "E"},
                {"S2", "S5", "E"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);
        assert(testResult.toString().equals("R0 "));

    }

    // Check for Fourth rule
    @Test
    public void fourthCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"S3", "S1", "A1"},
                {"N", "A3", "E"},
                {"A2", "S5", "F1"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);
        assert(testResult instanceof Nothing);

    }

    // Check for Fifth rule
    @Test
    public void fifthCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"S3", "S1", "A1"},
                {"N", "A3", "E"},
                {"A2", "S5", "F1"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);
        assert(testResult instanceof Nothing);

    }
    
    // Check for Sixth rule
    @Test
    public void sixthCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"N", "N", "N"},
                {"N", "A0", "N"},
                {"A1", "N", "N"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);
        assert(testResult.toString().equals("A1 "));

    }
}
