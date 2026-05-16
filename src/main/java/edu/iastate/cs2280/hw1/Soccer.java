package edu.iastate.cs2280.hw1;

public class Soccer extends SportsHouseholds {  
    public Soccer(NeighborhoodGrid grid, int row, int column, int interestLevel) {
        super(grid, row, column, interestLevel);
        members[Sports.SOCCER.ordinal()]++;
    }

    @Override
    public String toString(){
        return "S" + this.getInterest() + " ";
    }
    
    @Override
    public Sports getPreference() {
        return Sports.SOCCER;
    }

    @Override
    public Household next(NeighborhoodGrid newGrid, int month){
        int households[] = new int[Sports.values().length];
        this.survey(households);

        //1) if interest level is 5, then become nothing
        if(this.getInterest() == 5){
            return new Nothing(newGrid, this.row, this.column);
        
        //2) if the combined number of football and basketball more than or equal to soccer, then become eveything
        } else if((households[Sports.FOOTBALL.ordinal()] + households[Sports.BASKETBALL.ordinal()]) >= households[Sports.SOCCER.ordinal()]){
            return new Everything(newGrid, this.row, this.column);
        
        //3) if there are more soccer than combined number of baseball, basketball, football, and rugby, then become soccer level 5
        } else if(households[Sports.SOCCER.ordinal()] > (households[Sports.BASEBALL.ordinal()] + households[Sports.BASKETBALL.ordinal()] + households[Sports.FOOTBALL.ordinal()] + households[Sports.RUGBY.ordinal()])){
            return new Soccer(newGrid, this.row, this.column, 5);
        
        //4) if there are more than 4 rugby households, become rugby level 3
        } else if(households[Sports.RUGBY.ordinal()]  > 4){
            return new Rugby(newGrid, this.row, this.column, 3);
        
        //5) if there are not eveything households, become nothing
        } else if( households[Sports.EVERYTHING.ordinal()] == 0){
            return new Nothing(newGrid, this.row, this.column);

        }
        
        //6) otherwise, increase interest level by 1
        return new Soccer(newGrid, this.row, this.column, this.getInterest() + 1);
    }

}
