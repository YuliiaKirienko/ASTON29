public class Park {
    private String name;

    public Park(String name) {
        this.name = name;
    }

    public class Attraction {
        private final String name;
        private final String workingHours;
        private final double price;

        public Attraction(String name, String workingHours, double price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void printAttractionInfo() {
            System.out.println("Информация об аттракционе: ");
            System.out.println("Название: " + this.name);
            System.out.println("Часы работы: " + this.workingHours);
            System.out.println("Стоимость: " + this.price);
        }


    }


}