package org.mvss.karta.utils.interfaces;

@FunctionalInterface
public interface Lookup<T> {
    T lookup(String name);
}
