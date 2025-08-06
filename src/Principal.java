import com.conversor.modelos.ExchangeRateResponse;
import com.conversor.modelos.Monedas;
import com.conversor.modelos.ServicioDeConversion;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        String apiKey = "cc21d622b5cb4fa6b73c9f69";
        ServicioDeConversion servicio = new ServicioDeConversion();
        ExchangeRateResponse exchangeRateResponse = servicio.obtenerTasas(apiKey);

        if (exchangeRateResponse == null || exchangeRateResponse.conversion_rates() == null) {
            System.out.println("No se pudieron obtener las tasas de conversión. Finalizando programa.");
            return;
        }

        Map<String, Double> tasas = exchangeRateResponse.conversion_rates();
        String baseCode = exchangeRateResponse.base_code();

        Monedas menu = new Monedas();

        try (Scanner lectura = new Scanner(System.in)) {
            while (true) {
                menu.mostrarMenu();
                String monedaOrigen = "";
                String monedaDestino = "";

                System.out.print("\nSeleccione la moneda de origen (ej. USD): ");
                monedaOrigen = lectura.next().toUpperCase();

                System.out.print("Seleccione la moneda de destino (ej. EUR): ");
                monedaDestino = lectura.next().toUpperCase();

                System.out.print("Ingrese la cantidad a convertir: ");
                double cantidad = lectura.nextDouble();

                if (tasas.containsKey(monedaOrigen) && tasas.containsKey(monedaDestino)) {
                    double tasaOrigen = tasas.get(monedaOrigen);
                    double tasaDestino = tasas.get(monedaDestino);
                    double valorConvertido = (cantidad / tasaOrigen) * tasaDestino;

                    System.out.printf("\nEl valor de %.2f %s corresponde al valor final de %.2f %s%n",
                            cantidad, monedaOrigen, valorConvertido, monedaDestino);
                } else {
                    System.out.println("Uno o ambos códigos de moneda no son válidos.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Valor de entrada inválido. Por favor, ingrese un número.");
        }
    }
}