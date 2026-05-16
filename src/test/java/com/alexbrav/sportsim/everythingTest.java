package com.alexbrav.sportsim;

import org.junit.jupiter.api.Test;

public class everythingTest {
    
    // Check for first rule
    @Test
    public void firstCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"N", "N", "S3"},
                {"N", "E", "S1"},
                {"N", "S5", "N"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);

        assert(testResult.toString().equals("S3 "));

    }

    // Check for Second rule
    @Test
    public void secondCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"F3", "F1", "F1"},
                {"N", "E", "E"},
                {"S2", "F5", "E"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);

        assert(testResult.toString().equals("F0 "));

    }

    // Check for Third rule
    @Test
    public void thirdCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"F3", "N", "N"},
                {"N", "E", "N"},
                {"N", "N", "S3"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);

        assert(testResult.toString().equals("B2 "));
    }

    // Check for Fourth rule
    @Test
    public void fourthCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"S3", "N", "E"},
                {"N", "E", "F2"},
                {"R3", "R2", "R1"}
        };

        grid.initFromStrings(data);
       

        Household testResult = grid.grid[1][1].next(holderGrid, 1);
        assert(testResult.toString().equals("R0 "));
    }

    // Check for Fifth rule
    @Test
    public void fifthCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"S3", "N", "E"},
                {"N", "E", "F2"},
                {"E", "R2", "E"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);
        assert(testResult instanceof Everything);

    }

}
