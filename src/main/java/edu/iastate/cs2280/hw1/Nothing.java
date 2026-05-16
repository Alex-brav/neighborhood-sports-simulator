package edu.iastate.cs2280.hw1;

public class Nothing extends Household {
    public Nothing(NeighborhoodGrid grid, int row, int column) {
        super(grid, row, column);
        members[Sports.NOTHING.ordinal()]++;
    }

    @Override
    public String toString(){
        return "N  ";
    }

    @Override
    public Sports getPreference() {
        return Sports.NOTHING;
    }
    
    @Override
    public Household next(NeighborhoodGrid newGrid, int month){
        int households[] = new int[Sports.values().length];
        this.survey(households);

       
        //1) if there are more than 5 soccer, become soccer level 5
        if(households[Sports.SOCCER.ordinal()] > 5){
            return new Soccer(newGrid, this.row, this.column, 5);
        
        // 2) if there are more than 4 football households, then become footbal 
        } else if(households[Sports.FOOTBALL.ordinal()] > 4){
            return new Football(newGrid, this.row, this.column, 0);
        
        //3) if there are more than 3 basketball households, become basketball
        } else if(households[Sports.BASKETBALL.ordinal()]  > 3){
            return new Basketball(newGrid, this.row, this.column, 0);
        
        //4) if there are more than 2 baseball then become baseball
        } else if( households[Sports.BASEBALL.ordinal()] > 2){
            return new Baseball(newGrid, this.row, this.column, 0);

        //5) if there is more than 1 rugby household, become rugby level 2
        } else if(households[Sports.RUGBY.ordinal()] > 1){
            return new Rugby(newGrid, this.row, this.column, 2);
        
        //6) if there is at least one eveything household, become eveything
        } else if(households[Sports.EVERYTHING.ordinal()] > 0){
            return new Everything(newGrid, this.row, this.column);
        }
        
        //7) otherwise, remain the same
        return new Nothing(newGrid, this.row, this.column);
    }
}
