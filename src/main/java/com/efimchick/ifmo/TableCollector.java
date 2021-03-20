package com.efimchick.ifmo;

import com.efimchick.ifmo.util.CourseResult;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class TableCollector implements Collector<CourseResult, Table, String> {
    @Override
    public Supplier<Table> supplier() {
        return Table::new;
    }

    @Override
    public BiConsumer<Table, CourseResult> accumulator() {
        return Table::addCourseResult;
    }

    @Override
    public BinaryOperator<Table> combiner() {
        return null;
    }

    @Override
    public Function<Table, String> finisher() {
        StringBuilder builder = new StringBuilder();
        return table -> {
            table.createTable(builder);
            return builder.toString();
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
