abstract class Direction {
    int x,y;
    abstract Direction goLeft();
    abstract Direction goRight();
    abstract Direction goForward();
    abstract Direction goBackward();
    abstract void printState();
    Direction doAction(Action action) {
        return action.doAction(this);
    }
}