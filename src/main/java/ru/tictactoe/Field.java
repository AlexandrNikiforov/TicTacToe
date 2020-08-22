package main.java.ru.tictactoe;

class Field {
    private String[] values = {"1","2","3","4","5","6","7","8","9"};

    public void setValue (int index, String value) {
        if (index >= 0 && index < 9) {
            this.values[index] = value;
        } else
            System.out.println("Invalid value!");
    }

    public void showField() {
        System.out.println(values[0] + " | " + values[1] + " | " + values[2]);
        System.out.println("---------");
        System.out.println(values[3] + " | " + values[4] + " | " + values[5]);
        System.out.println("---------");
        System.out.println(values[6] + " | " + values[7] + " | " + values[8]);

        }

    public String getValues(int index) {
        return values[index];
    }
}

