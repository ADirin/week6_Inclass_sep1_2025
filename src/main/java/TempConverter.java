

public class TempConverter {

    public static double convertFahr(double f) {
        return (f - 32) * 5.0 / 9.0;
    }

    public static double convertCel(double c) {
        return (c * 9.0 / 5.0) + 32;
    }

    public static double kelvintoCel(double kel) {
        return kel - 273.15;
    }

    public static double kelvinToFah(double kel) {
        return (kel - 273.15) * 9.0 / 5.0 + 32;
    }

    public static void main(String[] args) {
        double fahrenheit = 212;
        double celsius = convertFahr(fahrenheit);
        System.out.println(fahrenheit + " Fahrenheit = " + celsius + " Celsius.");

        double cel = 100;
        double fahr = convertCel(cel);
        System.out.println(cel + " Celsius = " + fahr + " Fahrenheit.");

        double kelvin = 273;
        double celsiusFromKelvin = kelvintoCel(kelvin);
        System.out.println(kelvin + " Kelvin = " + celsiusFromKelvin + " Celsius.");

        double kel = 300.1;
        double far = kelvinToFah(kel);
        System.out.println(kel + " Kelvin = " + far + " Fahrenheit.");
    }
}
