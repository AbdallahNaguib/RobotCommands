public class South extends Direction{
    int x,y;
    South(int x,int y){
        this.x = x;
        this.y = y;
    }
    @Override
    Direction goLeft() {
        return new East(x,y);
    }

    @Override
    Direction goRight() {
        return new West(x,y);
    }

    @Override
    Direction goForward() {
        return new South(x,y-1);
    }

    @Override
    Direction goBackward() {
        return new South(x,y+1);
    }
    @Override
    void printState() {
        System.out.println(x + " " + y + " South");
    }
}
