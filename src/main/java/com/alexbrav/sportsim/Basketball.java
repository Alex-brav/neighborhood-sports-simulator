package com.alexbrav.sportsim;

public class Basketball extends SportsHouseholds {

    public Basketball(NeighborhoodGrid grid, int row, int column, int interestLevel) {
        super(grid, row, column, interestLevel);
        members[Sports.BASKETBALL.ordinal()]++;
    }

    @Override
    public String toString(){
        return "B" + this.getInterest() + " ";
    }
    

    @Override
    public Sports getPreference() {
        return Sports.BASKETBALL;
    }

    @Override
    public Household next(NeighborhoodGrid newGrid, int month){
        int households[] = new int[Sports.values().length];
        this.survey(households);

        //1) if interest level is 5, then become nothing
        if(this.getInterest() == 5){
            return new Nothing(newGrid, this.row, this.column);
        
        //2) if there are more than 5 football households, become football level 2
        } else if(households[Sports.FOOTBALL.ordinal()] > 5){
            return new Football(newGrid, this.row, this.column, 2);
        
        //3) if there are at least 2 soccer households, then become soccer
        } else if(households[Sports.SOCCER.ordinal()] >= 2){
            return new Soccer(newGrid, this.row, this.column, 0);
        
        //4) if there are less than 2 basketball households, become everything
        } else if(households[Sports.BASKETBALL.ordinal()]  < 2){
            return new Everything(newGrid, this.row, this.column);
        
        //5) if the combined number of baseball, basketball, and football households is greater than 6, become everything
        } else if(households[Sports.FOOTBALL.ordinal()] + households[Sports.BASKETBALL.ordinal()] + households[Sports.BASEBALL.ordinal()] > 6){
            return new Everything(newGrid, this.row, this.column);

        }
        
        //6) otherwise, increase interest level by 1
        return new Basketball(newGrid, this.row, this.column, this.getInterest() + 1);
    }
}
