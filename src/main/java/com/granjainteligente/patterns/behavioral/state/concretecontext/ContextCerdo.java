package com.granjainteligente.patterns.behavioral.state.concretecontext;

import com.granjainteligente.patterns.behavioral.state.AnimalContext;

public class ContextCerdo extends AnimalContext {
    public ContextCerdo(String nombre) {
        super(nombre, 50.0);
    }
}
