package edu.iastate.cs2280.hw1;

import org.junit.jupiter.api.Test;

public class nothingTest {
    
    // Check for first rule
    @Test
    public void firstCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"S1", "S2", "S1"},
                {"S3", "N",  "S2"},
                {"S1", "S2", "S4"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);

        assert(testResult.toString().equals("S5 "));
    }

    // Check for Second rule
    @Test
    public void secondCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"F1", "F2", "F1"},
                {"F3", "N",  "F2"},
                {"F1", "N",  "F4"}
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
                {"B1", "B2", "N"},
                {"B3", "N",  "B4"},
                {"N",  "B1", "N"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);

        assert(testResult.toString().equals("B0 "));
    }

    // Check for Fourth rule
    @Test
    public void fourthCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"A1", "A2", "N"},
                {"A3", "N",  "A1"},
                {"N",  "A2", "N"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);

        assert(testResult.toString().equals("A0 "));
    }

    // Check for Fifth rule
    public void fifthCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"R1", "R2", "N"},
                {"N",  "N",  "R3"},
                {"N",  "R1", "N"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);

        assert(testResult.toString().equals("R2 "));
    }

    // Check for Sixth rule
    @Test
    public void sixthCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"E", "N", "N"},
                {"N", "N", "N"},
                {"N", "N", "E"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);

        assert(testResult instanceof Everything);
    }

    // Check for Seventh rule
    @Test
    public void seventhCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"N", "N", "N"},
                {"N", "N", "N"},
                {"N", "N", "N"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);

        assert(testResult instanceof Nothing);
    }



}
