public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(15000);

        try {
            while (true) {
                account.withDraw(6000);
                System.out.println("Снято 6000 сом. Остаток на счете: " + account.getAmount());
            }
        } catch (LimitException e) {
            System.out.println("Запрашиваемая сумма на снятие больше чем остаток. Остаток: " + e.getRemainingAmount());
            try {
                account.withDraw((int) e.getRemainingAmount());
                System.out.println("Снято " + e.getRemainingAmount() + " сом. Остаток на счете: " + account.getAmount());
            } catch (LimitException ex) {
                System.out.println("Не удалось снять оставшуюся сумму: " + ex.getMessage());
            }
        }
    }
}