package ru.skillbench.tasks.basics.control;

public class ControlFlowStatements1Impl implements ControlFlowStatements1 {
    public static void main(String[] args) {
	    ControlFlowStatements1 object = new ControlFlowStatements1Impl();

	    float a = 2;
        System.out.println(object.getFunctionValue(a));

        int d = 5;
        System.out.println(object.decodeWeekday(d));

        int [][] arr = object.initArray();
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }

        int min = object.getMinValue(arr);
        System.out.println(min);

        double P = 15;
        System.out.println(object.calculateBankDeposit(P).toString());
    }

    @Override
    public float getFunctionValue(float x) {
        if(x > 0) {
            return (float) (2 * Math.sin((double)x));
        } else {
            return (6 - x);
        }
    }

    @Override
    public String decodeWeekday(int weekday) {
        String[] days = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };

        switch (weekday) {
            case 1:
                return days[0];
            case 2:
                return days[1];
            case 3:
                return days[2];
            case 4:
                return days[3];
            case 5:
                return days[4];
            case 6:
                return days[5];
            case 7:
                return days[6];
            default:
                return "Error";
        }
    }

    @Override
    public int[][] initArray() {
        int[][] arr = new int[8][5];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i*j;
            }
        }
        return arr;
    }

    @Override
    public int getMinValue(int[][] array) {
        int min = array[0][0];
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] < min) {
                    min = array[i][j];
                }
            }
        }
        return min;
    }

    @Override
    public BankDeposit calculateBankDeposit(double P) {
        ControlFlowStatements1.BankDeposit F = new BankDeposit();
        F.amount = 1000;
        do {
            F.amount *= (1 + (P/100));
            F.years += 1;
        }while(F.amount < 5000);
        return F;
    }
}

