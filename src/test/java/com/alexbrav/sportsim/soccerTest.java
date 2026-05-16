package com.alexbrav.sportsim;

import org.junit.jupiter.api.Test;

public class soccerTest {
       
    // Check for first rule
    @Test
    public void firstCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"N", "N", "N"},
                {"N", "S5", "N"},
                {"N", "N", "N"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);

        assert(testResult instanceof Nothing);
    }

    // Check for second rule
    @Test
    public void secondCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"F1", "B1", "S2"},
                {"B2", "S2", "F3"},
                {"S1", "F1", "B3"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);

        assert(testResult instanceof Everything);
    }

    // Check for Third rule 
    @Test
    public void thirdCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"S1", "S2", "S3"},
                {"S2", "S1", "N"},
                {"S3", "S2", "S1"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);

        assert(testResult.toString().equals("S5 "));
    }

    // Check for Fourth rule
    @Test
    public void fourthCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"R1", "R2", "R3"},
                {"R4", "S2", "R5"},
                {"N",  "R1", "N"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);
        assert(testResult.toString().equals("R3 "));
    }

    // Check for fifth rule 
    @Test
    public void fifthCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"B1", "S1", "A2"},
                {"S2", "S2", "N"},
                {"N", "A1", "R2"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);

        assert(testResult instanceof Nothing);
    }

    // Check for sixth rule
    @Test
    public void sixthCheck(){
        NeighborhoodGrid grid = new NeighborhoodGrid(3);
        NeighborhoodGrid holderGrid = new NeighborhoodGrid(3);

        String[][] data = {
                {"N", "N", "R1"},
                {"N", "S2", "N"},
                {"N", "E", "R1"}
        };

        grid.initFromStrings(data);

        Household testResult = grid.grid[1][1].next(holderGrid, 1);
        System.out.println(testResult.toString());

        assert(testResult.toString().equals("S3 "));
    }

}
