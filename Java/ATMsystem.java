class BankAccount{
    int balance;
    BankAccount(){
        this.balance = 0;
    }

    void deposit(int amount){
        this.balance += amount;
    }

    void withdraw(int amount) throws InsufficientFundsException{
        if(amount<0){
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero");
        }
        else if(this.balance<amount) {
            throw new InsufficientFundsException(amount, this.balance);
        }
        else {
            this.balance -= amount;
            System.out.println(amount + " withdrawn\nRemaining Balance: " + this.balance);
        }
    }
}

class InsufficientFundsException extends Exception{
    static int getMissingAmount(int amount, int balance){
        return amount-balance;
    }
    InsufficientFundsException(int amount, int balance){
        super("Insufficient balance. Need " + getMissingAmount(amount, balance) + " more");
    }
}

class ATMSystem{
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();

        b1.deposit(10000);
        try{
            b1.withdraw(11000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());;
        } catch (InsufficientFundsException e){
            System.out.println(e.getMessage());
        }
    }
}
