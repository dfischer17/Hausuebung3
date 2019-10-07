/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Daniel Fischer
 */
public interface Mapper<S, T> {

    T map(S source);

    default List<T> mapAll(List<S> source) {
        return source.stream().map(s1 -> map(s1)).collect(Collectors.toList()
        );
    }
}
