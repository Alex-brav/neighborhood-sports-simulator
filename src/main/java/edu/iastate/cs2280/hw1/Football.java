package edu.iastate.cs2280.hw1;

public class Football extends SportsHouseholds {
    public Football(NeighborhoodGrid grid, int row, int column, int interestLevel) {
        super(grid, row, column, interestLevel);
        members[Sports.FOOTBALL.ordinal()]++;
    }

    @Override
    public String toString(){
        return "F" + this.getInterest() + " ";
    }

    @Override
    public Sports getPreference() {
        return Sports.FOOTBALL;
    }

    @Override
    public Household next(NeighborhoodGrid newGrid, int month){
        int households[] = new int[Sports.values().length];
        this.survey(households);

        //0) speciial case for months 4-6
        if (month >= 4 && month <= 6) {
            // if there is at least one eveything or nothing households, and interest level less than max, then increase interest by 1
            if ((households[Sports.EVERYTHING.ordinal()] + households[Sports.NOTHING.ordinal()]) > 0  && this.getInterest() < 5) {
                return new Football(newGrid, this.row, this.column, this.getInterest() + 1);
            }
            // otherwise, stay the same
            return new Football(newGrid, this.row, this.column, this.getInterest());
        }

        //1) if interest level is 5, then become nothing
        if(this.getInterest() == 5){
            return new Nothing(newGrid, this.row, this.column);
        
        //2) if the combined number of football, baseball, and basketball households is greater than 7, become everything
        } else if((households[Sports.FOOTBALL.ordinal()] + households[Sports.BASEBALL.ordinal()] + households[Sports.BASKETBALL.ordinal()]) > 7){
            return new Everything(newGrid, this.row, this.column);
        
        //3) if there are more than 3 basketball households, then become basketball
        } else if(households[Sports.BASKETBALL.ordinal()] > 3){
            return new Basketball(newGrid, this.row, this.column, 0);
        
        //4) if there less than 2 footbal households, become baseball
        } else if(households[Sports.FOOTBALL.ordinal()]  < 2){
            return new Baseball(newGrid, this.row, this.column, 0);
        
        }
        
        //5) otherwise, increase interest level by 1
        return new Football(newGrid, this.row, this.column, this.getInterest() + 1);
    }

}
