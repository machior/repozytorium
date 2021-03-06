public enum enumer {
    GREY("142, 142, 147"),
    RED("255, 59, 48"),
    GREEN("76, 217, 100"),
    PURPLE("88, 86, 214"),
    LIGHTBLUE ("52, 170, 220");    //... etc, this is a shorted list

    enumer(final String string) {
        this.string = string;
    }

    private final String string;

    public String getRGB() {
        return string;
    }
    
    public static void main(String[] args) {

        String test = enumer.LIGHTBLUE.getRGB();
        System.out.println(test);

    }
}
//
//public class HelloWorld{
//    public static void main(String[] args) {
//
//        String test = enumer.LIGHTBLUE.getRGB();
//        System.out.println(test);
//
//    }
//}