
    public class Phone {
        private int number;
        private String model;
        private double weight;
        public void setNumber(int number){
            this.number = number;
        }
        public void setWeight(double weight){
            this.weight = number;
        }
        public void setModel(String model){
            this.model = model;
        }
        public Phone(
                int number,
                String model,
                double weight) {
            this(number, model);
            this.weight = weight;
        }

        public Phone(
                int number,
                String model) {
            this.number = number;
            this.model = model;
        }

        public Phone() {
        }

        public void receiveCall(String name) {
            System.out.println(name + "call");
        }

        public int getNumber() {
            return number;
        }

        public void receiveCall(String name, int number) {
            System.out.println(name + "call" + number);
        }

        public void sendMessage(String... numbers) {
            for (String number : numbers) {
                System.out.println((number));
            }
        }

        public static void main(String[] args) {
            Phone iphone = new Phone(9, "Xs", 0.8);
            iphone.receiveCall("mike");
            iphone.getNumber();

            Phone samsung = new Phone(8, "Galaxy Note 9", 0.765);
            samsung.receiveCall("den");
            samsung.getNumber();

            Phone Xiaomi = new Phone(7, "super puper mega + max ", 0.654);
            Xiaomi.receiveCall("police");
            iphone.getNumber();
        }
    }