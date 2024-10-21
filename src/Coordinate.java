public class Coordinate {
    // row and column are the source of truth
    private int row;
    private int col;


    //two constructors
    //both will throw exceptions if you give it bogus stuff
    public Coordinate(String value) throws Exception {
        this.row = rowFromHumanValue(value);
        this.col = columnFromHumanValue(value);
    }

    public Coordinate(int row, int col) throws Exception {
        if(row < 0 || row > 9){
            throw new Exception("Invalid row for shot.");
        }
        if(col < 0 || col > 9){
            throw new Exception("Invalid column for shot.");
        }
        this.row = row;
        this.col = col;
    }

    public static Coordinate randomCoordinate(){
        try {
            return new Coordinate((int)(Math.random()*10.0), (int)(Math.random()*10.0));
        }catch (Exception e){
            return null;
        }
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    @Override
    public String toString(){
        char firstletter = (char)(row + 97);
        String assembled = Character.toString(firstletter) + Integer.toString(col + 1);
        return assembled.toUpperCase();
    }

    private int rowFromHumanValue(String value) throws Exception {
        String normalizedValue = value.toLowerCase();
        char firstChar = normalizedValue.charAt(0);
        int asciiValue = ((int) firstChar);
        int row = asciiValue - 97;
        if (row < 0 || row > 9) {
            throw new Exception("Invalid row for shot.");
        }
        return row;
    }

    private int columnFromHumanValue(String value) throws Exception {
        String columnPortion = value.substring(1);
        int colNum = Integer.parseInt(columnPortion);
        colNum -= 1;
        if (colNum < 0 || colNum > 9) {
            throw new Exception("Invalid column for shot.");
        }
        return colNum;
    }
}
