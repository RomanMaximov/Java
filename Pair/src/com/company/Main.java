package com.company;

public class Main {

    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.printf("first: %d  second: %s  equals: %b  hashcode: %b\n", i, s, mustBeTrue, mustAlsoBeTrue);
    }

    public static class Pair<I, S> {
        private I number;
        private S s;

        private Pair(){
            this.number = null;
            this.s = null;
        }

        private Pair(I number, S s) {
            this.number = number;
            this.s = s;
        }

        public static <I, S> Pair<I, S>	of(I number, S s) {
            return new Pair<>(number, s);
        }

        public I getFirst() {
            return number;
        }
        public S getSecond() {
            return s;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }
            Pair pair = (Pair) obj;
            return (number == pair.number || (number != null && number.equals(pair.number)))
                    && (s == pair.s || (s != null && s.equals(pair.s)));
        }

        @Override
        public int hashCode() {
            int result = 1;
            result = 37 * result + ((number == null) ? 0 : number.hashCode());
            result = 37 * result + ((s == null) ? 0 : s.hashCode());
            return result;
        }
    }
}
