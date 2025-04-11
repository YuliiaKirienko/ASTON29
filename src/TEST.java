public class TEST {
    private static int animalCount = 0;
    protected String name;
    protected int maxRunDistance;
    protected int maxSwimDistance;
    protected boolean canSwim;

    public Animal(String name, int maxRunDistance, int maxSwimDistance, boolean canSwim) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.canSwim = canSwim;
        animalCount++;
    }
}
