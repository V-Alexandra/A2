package model.value;

import model.type.IType;

import java.util.Objects;

public record StringValue(String value) implements IValue {

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StringValue that)) return false;
        return Objects.equals(value, that.value);
    }


    @Override
    public IType getType() {
        return null;
    }

    @Override
    public IValue deepCopy() {
        return null;
    }

    @Override
    public String toString() {
        return value;
    }
}
