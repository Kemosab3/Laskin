    import laskin.Laskin;

    public class Main {

        public static void main(String[] args) {
            Laskin laskin = new Laskin();

            laskin.currentON();
            System.out.println("...current On...");

            laskin.add(500);
            System.out.println("Add 500    = " + laskin.getResult());

            laskin.add(200);
            System.out.println("add 200    = " + laskin.getResult());

            laskin.subtract(100);
            System.out.println("deduct 100  = " + laskin.getResult());

            laskin.divide(2);
            System.out.println("divide to 2    = " + laskin.getResult());

            laskin.product(10);
            System.out.println("multiply 10 = " + laskin.getResult());

            System.out.println("...set to zero...");
            laskin.setZero();

            laskin.add(500);
            System.out.println("add 500    = " + laskin.getResult());

            laskin.currentOFF();
            System.out.println("...disconnect the current...");
        }
    }
