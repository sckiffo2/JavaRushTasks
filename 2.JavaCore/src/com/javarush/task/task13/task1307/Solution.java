package com.javarush.task.task13.task1307;

/* 
Параметризованый интерфейс
*/

import sun.java2d.pipe.SpanShapeRenderer;

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }

    class StringObject implements SimpleObject<String> {
		@Override
		public StringObject getInstance() {
			return new StringObject();

		}
	}
}