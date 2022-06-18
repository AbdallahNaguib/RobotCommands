class ActionForward implements Action{

    @Override
    public Direction doAction(Direction direction) {
        return direction.goForward();
    }
}
