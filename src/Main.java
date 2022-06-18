import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Pair> bs = new ArrayList<>();
        bs.add(new Pair(5,3));
        solve("FLFFFRFLB",4,2,"East",bs);
      //  solve("FFFFFL",1,5,"North",bs);
    }
    static void solve(String commands, int x, int y, String initialDirection, List<Pair> barriers){
        Map<String,Direction> mp = new HashMap<>();
        mp.put("East",new East(x,y));
        mp.put("West",new West(x,y));
        mp.put("North",new North(x,y));
        mp.put("South",new South(x,y));
        Direction result = solve(commands,mp.get(initialDirection),barriers);
        result.printState();
    }
    static Direction solve(String commands,Direction robot, List<Pair> barriers){
        Map<Character,Action> mp = new HashMap<Character, Action>();
        mp.put('L',new ActionLeft());
        mp.put('R',new ActionRight());
        mp.put('F',new ActionForward());
        mp.put('B',new ActionBackward());

        // handle barriers
        Map<Pair,Exception> exceptionMap = new HashMap<>();
        for(Pair b:barriers){
            exceptionMap.put(b,new BarrierException());
        }

        for(int i=0 ; i<commands.length() ; i++){
            Character currentCommand = commands.charAt(i);
            Direction previousState = robot;
            robot = robot.doAction(mp.get(currentCommand));

            // stopping for barriers
            try {
                throw exceptionMap.getOrDefault(new Pair(robot.x,robot.y),new Okay());
            }catch (BarrierException e){
                robot = previousState;
              //  System.out.println("BarrierException");
                break;
            }catch (Okay e){
                //System.out.println("okay");
            }catch (Exception e){
                System.out.println("this shouldn't happen");
            }
        }
        return robot;
    }
}
class BarrierException extends Exception{

}
class Okay extends Exception{

}

class Pair{
    int x,y;
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}