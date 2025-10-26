package com.granjainteligente.patterns.behavioral.state.concretecontext;

import com.granjainteligente.patterns.behavioral.state.AnimalContext;

public class ContextVaca extends AnimalContext {
    public ContextVaca(String nombre) {
        super(nombre, 20.0);
    }
}
