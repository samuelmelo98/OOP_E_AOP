package Entities;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Handler;

public class PerfomaceAspect  implements InvocationHandler {
    private final Object target;

    public PerfomaceAspect(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.nanoTime();

        Object result = method.invoke(target, args); // Chamando o método original

        long endTime = System.nanoTime();
        System.out.println("Tempo de execução do método " + method.getName() + ": " + (endTime - startTime) / 1_000_000.0 + " ms");

        return result;
    }

    // Método para criar um proxy dinâmico para qualquer objeto
    public static Object createProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new PerfomaceAspect(target)
        );
    }
}
