package com.granjainteligente.patterns.behavioral.state.concretecontext;

import com.granjainteligente.patterns.behavioral.state.AnimalContext;

public class ContextGallina extends AnimalContext {
    public ContextGallina(String nombre) {
        super(nombre, 0.2);
    }
}
