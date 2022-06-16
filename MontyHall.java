import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

class MontyHall {
    public static void main(String[] args) {
        float montyStayAverage = 0;
        float montySwitchAverage = 0;
        
        for(int i = 0; i < 500; i++) {
            if(montyStay() == 0) {
                montyStayAverage++;
            }
        }

        for(int i = 0; i < 500; i++) {
            if(montySwitch() == 0) {
                montySwitchAverage++;
            }
        }

        montyStayAverage = (montyStayAverage / 500) * 100;
        montySwitchAverage = (montySwitchAverage / 500) * 100;
        System.out.printf("Average of monty stay: %.2f\n", montyStayAverage);
        System.out.printf("Average of monty switch: %.2f\n", montySwitchAverage);
    }

    public static int montyStay() {
        List<ArrayList<Integer>> scenarios = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<Integer> firstScenario = new ArrayList<>();
        firstScenario.add(0);
        firstScenario.add(1);
        firstScenario.add(1);

        ArrayList<Integer> secondScenario = new ArrayList<>();
        secondScenario.add(1);
        secondScenario.add(0);
        secondScenario.add(1);

        ArrayList<Integer> thirdScenario = new ArrayList<>();
        thirdScenario.add(1);
        thirdScenario.add(1);
        thirdScenario.add(0);

        scenarios.add(firstScenario);
        scenarios.add(secondScenario);
        scenarios.add(thirdScenario);

        int[] index = {0,1,2};

        Random rand = new Random();
        ArrayList<Integer> scenarioChosen = scenarios.get(rand.nextInt(scenarios.size()));

        int randomPickIndex = index[rand.nextInt(index.length)];
        int randomPick = scenarioChosen.get(randomPickIndex);


        for ( int i = 0; i < scenarioChosen.size(); i++ ) {
            if (scenarioChosen.get(i) == 1 && randomPickIndex != i) {
                scenarioChosen.remove(i);
                if(randomPickIndex >= i) randomPickIndex--;
                break;
            }
        }

        return randomPick;
    }

    public static int montySwitch() {
        List<ArrayList<Integer>> scenarios = new ArrayList<ArrayList<Integer>>();
        
        ArrayList<Integer> firstScenario = new ArrayList<>();
        firstScenario.add(0);
        firstScenario.add(1);
        firstScenario.add(1);

        ArrayList<Integer> secondScenario = new ArrayList<>();
        secondScenario.add(1);
        secondScenario.add(0);
        secondScenario.add(1);

        ArrayList<Integer> thirdScenario = new ArrayList<>();
        thirdScenario.add(1);
        thirdScenario.add(1);
        thirdScenario.add(0);

        scenarios.add(firstScenario);
        scenarios.add(secondScenario);
        scenarios.add(thirdScenario);

        int[] index = {0,1,2};

        Random rand = new Random();
        ArrayList<Integer> scenarioChosen = scenarios.get(rand.nextInt(scenarios.size()));

        int randomPickIndex = index[rand.nextInt(index.length)];
        int randomPick = scenarioChosen.get(randomPickIndex);


        for ( int i = 0; i < scenarioChosen.size(); i++ ) {
            if (scenarioChosen.get(i) == 1 && randomPickIndex != i) {
                scenarioChosen.remove(i);
                if(randomPickIndex >= i) randomPickIndex--;
                break;
            }
        }

        if(randomPickIndex == 0) {
            return scenarioChosen.get(1);
        }
        else {
            return scenarioChosen.get(0);
        }
    }
}