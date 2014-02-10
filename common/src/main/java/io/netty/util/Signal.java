/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.util;


/**
 * A special {@link Error} which is used to signal some state or request by throwing it.
 * {@link Signal} has an empty stack trace and has no cause to save the instantiation overhead.
 */
public final class Signal extends Error implements Constant<Signal> {

    private static final long serialVersionUID = -221145131122459977L;

    private static final ConstantPool<Signal> pool = new ConstantPool<Signal>() {
        @Override
        protected Signal newConstant(int id, String name) {
            return new Signal(id, name);
        }
    };

    /**
     * Returns the {@link Signal} of the specified name.
     */
    public static Signal valueOf(String name) {
        return pool.valueOf(name);
    }

    /**
     * Shortcut of {@link #valueOf(String) valueOf(firstNameComponent.getName() + "#" + secondNameComponent)}.
     */
    public static Signal valueOf(Class<?> firstNameComponent, String secondNameComponent) {
        return pool.valueOf(firstNameComponent, secondNameComponent);
    }

    private final int id;
    private final String name;

    /**
     * Create a new instance
     *
     * @param name      the name under which it is registered
     */
    private Signal(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Check if the given {@link Signal} is the same as this instance. If not an {@link IllegalStateException} will
     * be thrown.
     */
    public void expect(Signal signal) {
        if (this != signal) {
            throw new IllegalStateException("unexpected signal: " + signal);
        }
    }

    @Override
    public Throwable initCause(Throwable cause) {
        return this;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public int id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }

    @Override
    public int compareTo(Signal other) {
        if (this == other) {
            return 0;
        }

        int returnCode = name.compareTo(other.name());
        if (returnCode != 0) {
            return returnCode;
        }

        return ((Integer) id).compareTo(other.id());
    }

    @Override
    public String toString() {
        return name();
    }
}
