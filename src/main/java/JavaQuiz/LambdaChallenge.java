package JavaQuiz;

public class LambdaChallenge {

    public static void main(String... doYourBest) {
        String vitoCorleoneShoot = useRevolver(() -> "BAMM!!");

        String michaelCorleoneShoot = useShotgun(() -> {
            return "POHHHH!!!";});

        System.out.println(vitoCorleoneShoot +
                michaelCorleoneShoot);
    }

    private static String useRevolver(Revolver revolver) {
        return revolver.shoot();
    }

    static String useShotgun(Shotgun shotgun) {
        return shotgun.shoot();
    }

    private interface Revolver {
        String shoot();
    }

    public interface Shotgun {
        String shoot();

        default String reload() {
            return "Reloading...";
        }
    }

}
/*
When we invoke this method:
    useRevolver(Revolver revolver)
We are basically overriding the shoot method from the Revolver interface.
As there is only one abstract method on this interface, it's possible to use lambdas.

Then, as we override this method like this:
    () -> "BAMM!!"

The first output will be: BAMM!!

When we invoke the other method:
    useShotgun(Shotgun shotgun)
We are doing the same as above, overriding the useShotgun method.
But there is a difference in the Shotgun interface, there are two methods.
But one of them is a default method, so the rule of having just one abstract method is still valid.
The second output will be then: POHHHH!!!
 */
