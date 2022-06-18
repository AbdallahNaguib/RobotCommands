class East extends Direction{
    East(int x,int y){
        this.x = x;
        this.y = y;
    }
    @Override
    Direction goLeft() {
        return new North(x,y);
    }

    @Override
    Direction goRight() {
        return new South(x,y);
    }

    @Override
    Direction goForward() {
        return new East(x+1,y);
    }

    @Override
    Direction goBackward() {
        return new East(x-1,y);
    }

    @Override
    void printState() {
        System.out.println(x + " " + y + " East");
    }
}
