public class West extends Direction{
    West(int x,int y){
        this.x = x;
        this.y = y;
    }
    @Override
    Direction goLeft() {
        return new South(x,y);
    }

    @Override
    Direction goRight() {
        return new North(x,y);
    }

    @Override
    Direction goForward() {
        return new West(x-1,y);
    }

    @Override
    Direction goBackward() {
        return new West(x+1,y);
    }
    @Override
    void printState() {
        System.out.println(x + " " + y + " West");
    }
}
