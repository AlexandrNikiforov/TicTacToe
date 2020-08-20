package main.java.ru.tictactoe;

class Field {
    private String[] values = {"1","2","3","4","5","6","7","8","9"};

    public void setValue (int index, String value) {
        if (index >= 0 && index < 9) {
            this.values[index] = value;
        } else
            System.out.println("Invalid value!");
    }

    private boolean isNumeric (String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean checkIfSpaceIsFree (int index) {
        boolean spaceIsFree = false;
        if (index <0 || index >8) {
            return false;
        }
          else if (isNumeric(values[index]) ) {
            spaceIsFree = true;
        } else {
            spaceIsFree = false;
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

