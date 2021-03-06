package com.github.yz.entity;

/**
 * 指示器位置
 * Left左
 * center中
 * Right右
 */
public enum IndicatorLocation {
    Left(1),
    center(0),
    Right(2);

    private int value;

    IndicatorLocation(int idx) {
        this.value = idx;
    }

    public int getValue() {
        return value;
    }
}
