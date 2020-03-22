package JavaQuiz;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class InvocationHandlerChallenge1 implements InvocationHandler {

    private final List proxied;

    InvocationHandlerChallenge1(List proxied) { // Pass in a raw list to proxy
        this.proxied = proxied;
    }

    // All List method calls go through the invoke() method
    // where you can pre process the request
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("remove")) {
            return false;
        }

        if (method.getName().startsWith(""+(char)99) || method.getName().startsWith(""+(char)101)) {
            return false;
        }

        return method.invoke(proxied, args);
    }

    public static void main(String... doYourBest) {
        // Create proxy
        var proxy = (List) Proxy.newProxyInstance(
                InvocationHandlerChallenge1.class.getClassLoader(),
                new Class[] { List.class },
                new InvocationHandlerChallenge1(new ArrayList()));

        proxy.add("Barney");
        proxy.add("Homer");
        proxy.add("Moe");
        proxy.remove("Homer");
        proxy.remove("Moe");
        proxy.add(proxy.contains("Homer")); // Line 38
        proxy.add(proxy.equals(proxy));

        System.out.println(proxy);
    }

}
/*

Summary
You will learn how to intercept a method in Java with Reflections.

Background
The very first thing to analyze in the code is that we are using the interface InvocationHandler. Take a look:

    public class InvocationHandlerChallenge implements InvocationHandler {

This is a Reflection interface enables a method to be intercepted. The object that methods will be intercepted is:

    private final List proxied; InvocationHandlerChallenge(List proxied) {
        this.proxied = proxied;
    }

Now let's analyze what methods will not be invoked in the List:

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().startsWith("remove")) {
                return false;
            }

            if (method.getName().startsWith(""+(char)99) || method.getName().startsWith(""+(char)101)) {
                return false;
            }

            return method.invoke(proxied, args);
        }

 Note that when the method starts with "remove" we are returning false, which makes this method not be invoked by the List interface.

Also, we are using characters from the ASCII table in the second condition, 99 means 'c' and 101 means 'e'.
We are basically asking if invoked methods that start with 'c' or 'e' which makes the method 'contains' and 'equals'
both match this condition so they won't be invoked.

Knowing what will happen in the interception of the invoked methods, let's see now what will happen when invoking methods from the List interface:

    proxy.add("Barney");
    proxy.add("Homer");
    proxy.add("Moe");

Since the add method is not being blocked by the interceptor, they will be invoked normally.

Then, the methods remove will be invoked but they are blocked by the interceptor, so they won't be invoked:
  proxy.remove("Homer");
  proxy.remove("Moe");

Finally, the methods 'contains; and 'equals' will also be blocked as it was explained before:
 proxy.add(proxy.contains("Homer"));
 proxy.add(proxy.equals(proxy));

By conclusion, the output will be:
[Barney, Homer, Moe, false, false]
 */
