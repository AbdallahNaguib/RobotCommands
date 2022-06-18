import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        solve("FLFFFRFLB",4,2,"East");
        solve("FFFFFL",1,5,"North");
    }
    static void solve(String commands,int x,int y,String initialDirection){
        Map<String,Direction> mp = new HashMap<>();
        mp.put("East",new East(x,y));
        mp.put("West",new West(x,y));
        mp.put("North",new North(x,y));
        mp.put("South",new South(x,y));
        Direction result = solve(commands,mp.get(initialDirection));
        result.printState();
    }
    static Direction solve(String commands,Direction robot){
        Map<Character,Action> mp = new HashMap<Character, Action>();
        mp.put('L',new ActionLeft());
        mp.put('R',new ActionRight());
        mp.put('F',new ActionForward());
        mp.put('B',new ActionBackward());
        for(int i=0 ; i<commands.length() ; i++){
            Character currentCommand = commands.charAt(i);
            robot = robot.doAction(mp.get(currentCommand));
        }
        return robot;
    }
}