public class Usecase2_QuantityMeasurementApp {

    // 🔹 Base Class
    static abstract class Quantity {
        protected double value;

        public Quantity(double value) {
            this.value = value;
        }

        // Convert everything to inches
        public abstract double toInches();

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;          // same reference
            if (obj == null) return false;         // null check
            if (!(obj instanceof Quantity)) return false; // type check

            Quantity other = (Quantity) obj;

            // compare after conversion
            return Double.compare(this.toInches(), other.toInches()) == 0;
        }
    }

    // 🔹 Feet Class
    static class Feet extends Quantity {
        public Feet(double value) {
            super(value);
        }

        @Override
        public double toInches() {
            return value * 12;
        }
    }

    // 🔹 Inches Class
    static class Inches extends Quantity {
        public Inches(double value) {
            super(value);
        }

        @Override
        public double toInches() {
            return value;
        }
    }

    // 🔹 Methods for comparison
    public static boolean compareFeet(double a, double b) {
        return new Feet(a).equals(new Feet(b));
    }

    public static boolean compareInches(double a, double b) {
        return new Inches(a).equals(new Inches(b));
    }

    public static boolean compareFeetAndInches(double feet, double inches) {
        return new Feet(feet).equals(new Inches(inches));
    }

    // 🔹 Main Method
    public static void main(String[] args) {

        // Same value tests
        System.out.println("1.0 ft vs 1.0 ft: " + compareFeet(1.0, 1.0));
        System.out.println("1.0 inch vs 1.0 inch: " + compareInches(1.0, 1.0));

        // Different value test
        System.out.println("1.0 ft vs 2.0 ft: " + compareFeet(1.0, 2.0));

        // Cross comparison
        System.out.println("1.0 ft vs 12.0 inch: " + compareFeetAndInches(1.0, 12.0));
    }
}