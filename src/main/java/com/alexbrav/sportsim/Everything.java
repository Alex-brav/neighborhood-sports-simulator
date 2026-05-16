package com.alexbrav.sportsim;

public class Everything extends Household {
    public Everything(NeighborhoodGrid grid, int row, int column) {
        super(grid, row, column);
        for (int i = 0; i < members.length; i++) {
            members[i]++;
        }
    }

    @Override
    public String toString(){
        return "E  ";
    }

    @Override
    public Sports getPreference() {
        return Sports.EVERYTHING;
    }
    
    @Override
    public Household next(NeighborhoodGrid newGrid, int month){
        int households[] = new int[Sports.values().length];
        this.survey(households);

       
        //1) if the number of soccer housholds is at least 3 times the number of eveything households, become soccer level 3
        if(households[Sports.SOCCER.ordinal()] >= (3 * households[Sports.EVERYTHING.ordinal()])){
            return new Soccer(newGrid, this.row, this.column, 3);
        
        // 2) if there are more than 3 football households, then become football
        } else if(households[Sports.FOOTBALL.ordinal()] > 3){
            return new Football(newGrid, this.row, this.column, 0);
        
        //3) if the number of nothing households is less than the combined number of football and soccer households, then become basketball level 2
        } else if(households[Sports.NOTHING.ordinal()] < (households[Sports.FOOTBALL.ordinal()] + households[Sports.SOCCER.ordinal()])){
            return new Basketball(newGrid, this.row, this.column, 2);
        
        //4) if the number of rugby households is greater than everything households, then become rugby
        } else if( households[Sports.RUGBY.ordinal()] > households[Sports.EVERYTHING.ordinal()]){
            return new Rugby(newGrid, this.row, this.column, 0);

        }
        
        //5) otherwise, remain the same
        return new Everything(newGrid, this.row, this.column);
    }

}
