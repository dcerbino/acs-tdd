public interface Unit {
    public double getRatio();

    Unit kmPerHour = new KmPerHour();
    Unit metersPerSecond = new MetersPerSecond();

    class MetersPerSecond implements Unit {
        private MetersPerSecond() {
        }

        public double getRatio() {
            return 1;
        }
    }

    class KmPerHour implements Unit {
        private KmPerHour() {
        }

        public double getRatio() {
            return 36d / 10d;
        }
    }
}
