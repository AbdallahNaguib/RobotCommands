public class ActionBackward implements Action{
    @Override
    public Direction doAction(Direction direction) {
        return direction.goBackward();
    }
}
