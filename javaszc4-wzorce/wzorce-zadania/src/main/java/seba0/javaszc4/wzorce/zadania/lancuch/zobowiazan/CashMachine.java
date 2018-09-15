package seba0.javaszc4.wzorce.zadania.lancuch.zobowiazan;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author sebastian
 */
public class CashMachine {

    private final Map<Nominal, Integer> bills = new EnumMap<>(Nominal.class);
    private final NominalChain chain = new NominalChain(Nominal.values(), bills);

    public boolean add(Nominal nominaly, int count) {
        if (nominaly == null || count < 1) {
            return false;
        }
        count += bills.getOrDefault(nominaly, 0);
        bills.put(nominaly, count);
        return true;
    }

    public Map<Nominal, Integer> pull(int money) {
        NominalRequest request = new NominalRequest(money);
        chain.handlePay(request);
        if (request.getLeftToPay() != 0) {
            return Collections.EMPTY_MAP;
        }
        Map<Nominal, Integer> result = request.getBills();
        result.entrySet().stream().forEach((entry) -> {
            Nominal key = entry.getKey();
            int value = entry.getValue();
            value = bills.getOrDefault(key, value) - value;
            bills.put(key, value);
        });
        return result;
    }
}
