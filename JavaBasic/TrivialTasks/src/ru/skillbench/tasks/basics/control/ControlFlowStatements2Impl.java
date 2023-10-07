package ru.skillbench.tasks.basics.control;

public class ControlFlowStatements2Impl implements ControlFlowStatements2 {
    public static void main(String[] args) {
        float a = (float) 12.5;
        ControlFlowStatements2.Sportsman TEST = new ControlFlowStatements2Impl().calculateSportsman(a);
        System.out.println(TEST.getTrainingDays());
    }

    @Override
    public int getFunctionValue(int x) {
        if(x < -2 || x > 2) {
            return 2*x;
        } else {
            return (-3*x);
        }
    }

    @Override
    public String decodeMark(int mark) {
        String[] marks = {
                "Fail",
                "Poor",
                "Satisfactory",
                "Good",
                "Excellent",
        };

        switch (mark) {
            case 1:
                return marks[0];
            case 2:
                return marks[1];
            case 3:
                return marks[2];
            case 4:
                return marks[3];
            case 5:
                return marks[4];
            default:
                return "Error";
        }
    }

    @Override
    public double[][] initArray() {
        double[][] arr = new double[5][8];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Math.pow(i,4) - Math.sqrt((double) j);
            }
        }
        return arr;
    }

    @Override
    public double getMaxValue(double[][] array) {
        double max = array[0][0];
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        return max;
    }

    @Override
    public Sportsman calculateSportsman(float P) {
        Sportsman sm = new Sportsman();

        sm.addDay(10);
        int max = 200;

        float predday = 10;

        while (sm.getTotalDistance() <= max) {
            predday += predday * (P / 100);
            sm.addDay(predday);
        }

        return sm;
    }
}
