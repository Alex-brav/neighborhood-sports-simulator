package com.alexbrav.sportsim;

import org.junit.jupiter.api.Test;

public class rugbyTest {
    // Check for first rule
    @Test
    public void firstCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"N", "N", "N"},
                {"N", "R5", "N"},
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
                {"F1", "S3", "F2"},
                {"S4", "R1", "F1"},
                {"S2", "F3", "S1"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);

        assert(testResult.toString().equals("S2 "));
    }

    // Check for Third rule
    @Test
    public void thirdCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"B1", "A2", "A3"},
                {"B1", "R2", "N"},
                {"A2", "A4", "A1"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);
        assert(testResult.toString().equals("A4 "));
    }

    // Check for Fourth rule
    @Test
    public void fourthCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"N", "N", "N"},
                {"N", "R3", "N"},
                {"N", "F1", "N"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);

        assert(testResult.toString().equals("F0 "));
    }

    // Check for Fifth rule
    @Test
    public void fifthCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"N", "N", "S1"},
                {"N", "R2", "R2"},
                {"N", "N", "N"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);
        System.out.println(testResult.toString());

        assert(testResult.toString().equals("R3 "));
    }
}
