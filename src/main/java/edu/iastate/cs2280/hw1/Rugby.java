package edu.iastate.cs2280.hw1;

public class Rugby extends SportsHouseholds {
    public Rugby(NeighborhoodGrid grid, int row, int column, int interestLevel) {
        super(grid, row, column, interestLevel);
        members[Sports.RUGBY.ordinal()]++;
    }

    @Override
    public String toString(){
        return "R" + this.getInterest() + " ";
    }

    @Override
    public Sports getPreference() {
        return Sports.RUGBY;
    }

    @Override
    public Household next(NeighborhoodGrid newGrid, int month){
        int households[] = new int[Sports.values().length];
        this.survey(households);

        //1) if interest level is 5, then become nothing
        if(this.getInterest() == 5){
            return new Nothing(newGrid, this.row, this.column);
        
        //2) if the combined number of football and soccer is at least 8, become soccer level 2
        } else if((households[Sports.FOOTBALL.ordinal()] + households[Sports.SOCCER.ordinal()]) >= 8){
            return new Soccer(newGrid, this.row, this.column, 2);
        
        //3) if the number of baseball housholds is twice of that of basketball, then become baseball level 4
        } else if(households[Sports.BASEBALL.ordinal()] > (2 * households[Sports.BASKETBALL.ordinal()])){
            return new Baseball(newGrid, this.row, this.column, 4);
        
        //4) if there are less than 2 rugby households, become footbal
        } else if(households[Sports.RUGBY.ordinal()]  < 2){
            return new Football(newGrid, this.row, this.column, 0);
        
        }
        
        //5) otherwise, increase interest level by 1
        return new Rugby(newGrid, this.row, this.column, this.getInterest() + 1);
    }

}
