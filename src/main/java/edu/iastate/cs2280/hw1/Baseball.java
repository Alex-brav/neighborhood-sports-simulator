package edu.iastate.cs2280.hw1;

public class Baseball extends SportsHouseholds  {

    public Baseball(NeighborhoodGrid grid, int row, int column, int interestLevel) {
        super(grid, row, column, interestLevel);
        members[Sports.BASEBALL.ordinal()]++;
    }

    @Override
    public String toString(){
        return "A" + this.getInterest() + " ";
    }
    
    @Override
    public Sports getPreference() {
        return Sports.BASEBALL;
    }

    @Override
    public Household next(NeighborhoodGrid newGrid, int month){
        int households[] = new int[Sports.values().length];
        this.survey(households);

        //1) if interest level is 5, then become nothing
        if(this.getInterest() == 5){
            return new Nothing(newGrid, this.row, this.column);
        
        //2) if there are more than 3 soccer households, become soccer
        } else if(households[Sports.SOCCER.ordinal()] > 3){
            return new Soccer(newGrid, this.row, this.column, 0);
        
        //3) if there are less than 2 baseball households, become rugby
        } else if(households[Sports.BASEBALL.ordinal()] < 2){
            return new Rugby(newGrid, this.row, this.column, 0);
        
        //4) if the combined number of baseball and soccer households is greater than 5, become nothing
        } else if((households[Sports.BASEBALL.ordinal()] + households[Sports.SOCCER.ordinal()]) > 5){
            return new Nothing(newGrid, this.row, this.column);
        
        //5) if there is more than twice football households than baseball, become football
        } else if(households[Sports.FOOTBALL.ordinal()] > 2* (households[Sports.BASEBALL.ordinal()])){
            return new Football(newGrid, this.row, this.column, 0);

        }

        //6) otherwise, increase interest level by 1
        return new Baseball(newGrid, this.row, this.column, this.getInterest() + 1);
    }
    
}
