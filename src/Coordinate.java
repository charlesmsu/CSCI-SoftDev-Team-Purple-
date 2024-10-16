public class Coordinate {
    private int row;
    private int col;

    public Coordinate(String value) throws Exception {
        String normalized = value.toLowerCase();
        this.row = rowFromHumanValue(normalized);
        this.col = columnFromHumanValue(value);
    }

    // Getters
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    // Method to convert row and column to a letter-number location
    private int rowFromHumanValue(String value) throws Exception {
        // Gives the char at index
        char first = value.charAt(0);

        // Gives the ascii value
        int asciiValue = ((int) first);

        // ascii value of 'a' is 97
        int row = asciiValue - 97;
        if (row < 0 || row > 9) {
            throw new Exception("Invalid row");
        }
        return row;
    }

    // Expecting an int to be returned
    private int columnFromHumanValue(String value) throws Exception {
        // substring returns a string starting at given index to length
        int colNum = Integer.parseInt(value.substring(1)) - 1;

        if (colNum < 0 || col > 9) {
            throw new Exception("Invalid column");
        }
        return colNum;
    }

    public boolean isValidCoordinate(int row, int col) {
        return row >= 0 && row < 10 && col >= 0 && col < 10;
    }
}
