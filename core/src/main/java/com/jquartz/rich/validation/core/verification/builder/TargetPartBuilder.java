package com.jquartz.rich.validation.core.verification.builder;

import com.jquartz.rich.validation.core.api.FieldPointer;
import com.jquartz.rich.validation.core.api.LiteralPointer;
import com.jquartz.rich.validation.core.verification.builder.must.PartsJoinedByAndBuilder;
import com.jquartz.rich.validation.core.verification.expression.comparison.factory.ComparisonExpressionLogicFactory;
import com.jquartz.rich.validation.core.verification.expression.comparison.operator.ComparisonOperator;

import javax.annotation.Nonnull;
import java.util.Deque;
import java.util.LinkedList;

public class TargetPartBuilder<T> {

    private final Class<T> targetClass;
    private final FieldPointer<?, T> targetFieldPointer;
    private final Deque<PartsJoinedByAndBuilder> partsJoinedByOr = new LinkedList<>();
    private final FieldPointerFactory pointerFactory = new FieldPointerFactory();

    private final ComparisonExpressionLogicFactory logicFactory = new ComparisonExpressionLogicFactory();

    public TargetPartBuilder(Class<T> targetClass, @Nonnull FieldPointer<?, T> targetPointer) {
        this.targetClass = targetClass;
        this.targetFieldPointer = targetPointer;
        this.partsJoinedByOr.add(new PartsJoinedByAndBuilder());
    }

    public MustPartBuilder<T> isGreaterThanField(String fieldName) {
        return is(ComparisonOperator.GREATER_THAN, pointerFactory.createPointer(targetClass, fieldName));
    }

    public MustPartBuilder<T> isLessThanField(String fieldName) {
        return is(ComparisonOperator.LESS_THAN, pointerFactory.createPointer(targetClass, fieldName));
    }

    public <V> MustPartBuilder<T> isGreaterThan(V value) {
        return is(ComparisonOperator.GREATER_THAN, new LiteralPointer<>(value));
    }

    public <V> MustPartBuilder<T> isLessThan(V value) {
        return is(ComparisonOperator.LESS_THAN, new LiteralPointer<>(value));
    }
    //TODO GET BACK TO PREVIOUS VARIANT WITH TWO DIFFERENT POINTERS
    //CREATE SEPARATE CLASS TO RESOLVE ComparisonExpression and ensure type safety among two pointers

    private <S> MustPartBuilder<T> is(ComparisonOperator operator, LiteralPointer<?> pointer) {
        PartsJoinedByAndBuilder lastPart = this.partsJoinedByOr.peek();


//        Value<?> leftValue = targetFieldPointer.resolve(targetClass);
//        Value<?> rightValue = pointer.resolve(targetClass);
//        ComparisonExpression expression = new ComparisonExpression(leftValue,
//                operator,
//                rightValue);
//
//        MustPartBuilder<T> newMustPart = new MustPartBuilder<>(this, expression);
//        lastPart.addExpression(newMustPart);

        return null;
    }


    private <S> MustPartBuilder<T> is(ComparisonOperator operator, FieldPointer<?, T> pointer) {
        PartsJoinedByAndBuilder lastPart = this.partsJoinedByOr.peek();
//        Value<?> leftValue = targetFieldPointer.resolve(targetClass);
//        Value<?> rightValue = pointer.resolve(targetClass);
//        ComparisonExpression expression = new ComparisonExpression(leftValue,
//                operator,
//                rightValue);
//
//        MustPartBuilder<T> newMustPart = new MustPartBuilder<>(this, expression);
//        lastPart.addExpression(newMustPart);

        return null;
    }

    void newOrPart() {
        this.partsJoinedByOr.push(new PartsJoinedByAndBuilder());
    }
}
