public class TestAccount {
    public static void main(String[] args){
        Account a= new Account(1000);
        Account b= new Account();
        System.out.printf("A's balance: %d\n", a.checkBalance());
        System.out.printf("B's balance: %d\n", b.checkBalance());
        
        a.transfer(500, b);
        System.out.printf("A's balance: %d\n", a.checkBalance());
        System.out.printf("B's balance: %d\n", b.checkBalance());

        a.withdraw(300);
        System.out.printf("A's balance: %d\n", a.checkBalance());

        a.deposit(100);
        System.out.printf("A's balance: %d\n", a.checkBalance());

        a.withdraw(500);
        System.out.printf("A's balance: %d\n", a.checkBalance());
    }
}
