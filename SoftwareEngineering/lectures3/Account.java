public class Account {
    private int balance;
    public Account(){
        balance= 0;
    }
    public Account(int balance){
        this.balance= balance;
    }
    public int checkBalance(){
        return balance;
    }
    public void deposit(int amount){
        balance+= amount;
    }
    public void withdraw(int amount){
        if (amount > balance){
            throw new UnsupportedOperationException("Withdrawn amount must be less than your balance");
        }
        else{
            balance-= amount;
        }
    }
    public void transfer(int amount, Account transferee){
        if (amount > balance){
            throw new UnsupportedOperationException("Transferred amount must be less than your balance");
        }
        else{
            balance-= amount;
            transferee.deposit(amount);
        }
    }
}
