package ru.alexnikiforov.tictactoe;

class Field {
    private int spaceNumber;
    private String[] values = {"1","2","3","4","5","6","7","8","9"};

    public void setValue (int index, String value) {
        if (index > 0 && index < 10) {
            this.values[index] = value;
        } else
            System.out.println("Invalid value!");
    }

    public  boolean checkIfSpaceIsFree (int index) {
        boolean spaceIsFree = false;
        if (values[index].equals("X") || values[index].equals("0")) {
            spaceIsFree = false;
        } else {
            spaceIsFree = true;
        }
        return spaceIsFree;
    }




    public void showField() {
        System.out.println(values[0] + " | " + values[1] + " | " + values[2]);
        System.out.println("---------");
        System.out.println(values[3] + " | " + values[4] + " | " + values[5]);
        System.out.println("---------");
        System.out.println(values[6] + " | " + values[7] + " | " + values[8]);

        }

    public String[] getValues() {
        return values;
    }

    public String getValues(int index) {
        return values[index];
    }
}

