package edu.iastate.cs2280.hw1;

import org.junit.jupiter.api.Test;

public class basketballTest {
    
    // Check for first rule
    @Test
    public void firstCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"N", "N", "N"},
                {"N", "B5", "N"},
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
                {"F3", "F1", "S4"},
                {"F2", "B3", "F2"},
                {"F1", "F5", "E"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);

        assert(testResult.toString().equals("F2 "));

    }
    
    // Check for Third rule
    @Test
    public void thirdCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"S3", "F1", "F1"},
                {"N", "B3", "E"},
                {"S2", "S5", "E"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);

        assert(testResult.toString().equals("S0 "));

    }

    // Check for Fourth rule
    @Test
    public void fourthCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"S3", "N", "N"},
                {"N", "B3", "N"},
                {"N", "N", "F1"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);

        assert(testResult instanceof Everything);
    }

    // Check for Fifth rule
    @Test
    public void fifthCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"F3", "B1", "A4"},
                {"N", "B3", "E"},
                {"A2", "B5", "F1"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);

        assert(testResult instanceof Everything);
    }

    // Check for Sixth rule
    @Test
    public void sixthCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"F3", "B1", "F4"},
                {"N", "B3", "E"},
                {"A2", "S5", "N"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);
        assert(testResult.toString().equals("B4 "));
    }
}
