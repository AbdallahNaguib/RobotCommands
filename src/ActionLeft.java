class ActionLeft implements Action{
    @Override
    public Direction doAction(Direction direction) {
        return direction.goLeft();
    }
}