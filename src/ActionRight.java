public class ActionRight implements Action{
    @Override
    public Direction doAction(Direction direction) {
        return direction.goRight();
    }
}
