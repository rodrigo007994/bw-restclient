/*
 * Copyright (c) 2001-2006 OFFIS, Tammo Freese.
 * This program is made available under the terms of the MIT License.
 */
package org.easymock.internal.matchers;

import org.easymock.IArgumentMatcher;

public class GreaterThan implements IArgumentMatcher {
    private final Number expected;

    public GreaterThan(Number value) {
        this.expected = value;
    }

    public boolean matches(Object actual) {
        return (actual instanceof Number)
                && ((Number) actual).longValue() > expected.longValue();
    }

    public void appendTo(StringBuffer buffer) {
        buffer.append("gt(" + expected + ")");
    }
}
