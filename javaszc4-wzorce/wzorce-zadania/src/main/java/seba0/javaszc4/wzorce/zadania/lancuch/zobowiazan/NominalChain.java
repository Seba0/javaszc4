package seba0.javaszc4.wzorce.zadania.lancuch.zobowiazan;

import java.util.Map;
import java.util.Optional;

/**
 *
 * @author sebastian
 */
public class NominalChain {

    private final Optional<NominalChain> suppervisor;
    private final Nominal nominal;
    private final Map<Nominal, Integer> bills;

    public NominalChain(Nominal[] nominaly, Map<Nominal, Integer> bills) {
        int last = nominaly.length - 1;
        this.bills = bills;
        this.nominal = nominaly[last];
        if (last > 0) {
            Nominal[] tmp = new Nominal[last];
            System.arraycopy(nominaly, 0, tmp, 0, last);
            this.suppervisor = Optional.of(new NominalChain(tmp, bills));
        } else {
            this.suppervisor = Optional.empty();
        }
    }

    public void handlePay(NominalRequest request) {
        int leftToPay = request.getLeftToPay();
        if (leftToPay > 0) {
            int count = 0;
            int bilsCount = bills.getOrDefault(nominal, 0);
            while (leftToPay >= nominal.getValue() && bilsCount > count) {
                leftToPay -= nominal.getValue();
                count++;
            }
            if (count > 0) {
                request.getBills()
                        .put(nominal, count);
                request.setLeftToPay(leftToPay);
            }
            if (leftToPay > 0) {
                suppervisor.ifPresent(chain -> chain.handlePay(request));
            }
        }
    }
}
