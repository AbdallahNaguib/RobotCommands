class North extends Direction{
    int x,y;
    North(int x,int y){
        this.x = x;
        this.y = y;
    }
    @Override
    Direction goLeft() {
        return new West(x,y);
    }

    @Override
    Direction goRight() {
        return new East(x,y);
    }

    @Override
    Direction goForward() {
        return new North(x,y+1);
    }

    @Override
    Direction goBackward() {
        return new North(x,y-1);
    }
    @Override
    void printState() {
        System.out.println(x + " " + y + " North");
    }
}
